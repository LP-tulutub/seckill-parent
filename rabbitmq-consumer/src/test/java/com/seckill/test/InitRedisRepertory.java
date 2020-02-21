package com.seckill.test;

import com.seckill.AppRabbitMQConsumer;
import com.seckill.mapper.MiaoshaGoodsMapper;
import com.seckill.pojo.MiaoshaGoods;
import com.seckill.pojo.MiaoshaGoodsExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppRabbitMQConsumer.class)
public class InitRedisRepertory {

    @Value("${redis.key.goodsRepertory}")
    private String goodsRepertoryKey;
    @Resource
    private MiaoshaGoodsMapper miaoshaGoodsMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void init(){
        List<MiaoshaGoods> miaoshaGoods = this.miaoshaGoodsMapper.selectByExample(new MiaoshaGoodsExample());
        for (MiaoshaGoods g : miaoshaGoods){
            this.redisTemplate.opsForValue().set(goodsRepertoryKey + g.getGoodsId(), g.getStockCount());
        }
    }

}
