package com.seckill.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SecKillService {

    @Value("${redis.key.seckillid}")
    private String redisUGId;
    @Value("${redis.key.goodsRepertory}")
    private String goodsRepertoryKey;
    @Resource
    private RedisTemplate redisTemplate;

    public boolean checkSecKill(String secKillId){
        Object obj = this.redisTemplate.opsForValue().get(redisUGId+secKillId);
        if (obj==null || obj.equals("")){
            return false;
        }
        return true;
    }

    public boolean checkRepertory(long goodsId){
        int obj = (int)this.redisTemplate.opsForValue().get(goodsRepertoryKey + goodsId);
        if (obj==0 || obj<0){
            return false;
        }
        return true;
    }

}
