package com.seckill.feign.fallback;

import com.seckill.feign.OrderFeign;
import com.seckill.pojo.OrderInfo;
import com.seckill.pojo.OrderInfoGoods;
import com.seckill.result.ResultGeekQ;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFeignFallback implements OrderFeign {
    @Override
    public ResultGeekQ<List<OrderInfo>> selByUserId(int page, int rows, long id) {
        return null;
    }

    @Override
    public ResultGeekQ<List<OrderInfoGoods>> selGoodsOrderInfoByUserId(int page, int rows, long id) {
        return null;
    }
}
