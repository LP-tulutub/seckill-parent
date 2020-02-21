package com.seckill.listener;

import com.seckill.pojo.*;
import com.seckill.service.SecKillService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class ReceiverServiceListener {

    @Value("${redis.key.seckillid}")
    private String redisUGId;
    @Value("${redis.key.goodsRepertory}")
    private String goodsRepertoryKey;
    @Value("${redis.key.goodsLock}")
    private String goodsLockKey;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private SecKillService secKillService;

    @StreamListener("secKillInput")
    public void receive(SecKillMessage msg){
        System.out.println("接收到的消息：" + msg.getUserId());
        System.out.println("接收到的消息：" + msg.getGoodsId());
    }

    /**
     * 秒杀后生成订单信息
     * 秒杀后记录到redis中
     */
    @StreamListener("secKillInput")
    @Transactional
    public void redisSecKillId(SecKillMessage msg){
        String secKillId = String.valueOf(msg.getUserId()) + msg.getGoodsId();
        //创建公平锁
        RLock lock = redissonClient.getFairLock(goodsLockKey + msg.getGoodsId());
        //加锁
        lock.lock();
        try {
            //检查是否已经秒杀过了
            int obj = (int)this.redisTemplate.opsForValue().get(redisUGId + secKillId);
            if (obj==1){
                return;
            }
            //查看还有没有商品
            int repertory = (int) this.redisTemplate.opsForValue().get(goodsRepertoryKey + msg.getGoodsId());
            if (repertory>0){
                //有的话Redis商品库存减1
                this.redisTemplate.opsForValue().set(goodsRepertoryKey + msg.getGoodsId(), repertory-1);
            }else {
                //没有商品则给用户返回秒杀失败信息
                this.secKillService.failedSecKill(msg, secKillId);
                return;
            }
            //有商品则开始提交订单，订单提交失败不用再把redis库存加回去，对这个活动影响不大
            int sql = this.secKillService.successSecKill(msg, secKillId);
            if (sql==4){
                //订单提交成功，防止用户多次秒杀
                this.redisTemplate.opsForValue().set(redisUGId + secKillId, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }


}
