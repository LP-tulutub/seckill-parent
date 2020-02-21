package com.seckill.feign.fallback;

import com.seckill.feign.GoodsFeign;
import com.seckill.pojo.Goods;
import com.seckill.pojo.GoodsSecKill;
import com.seckill.result.ResultGeekQ;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsFeignFallback implements GoodsFeign {
    @Override
    public ResultGeekQ<List<Goods>> selAllByPage(int page, int rows) {
        return null;
    }

    @Override
    public ResultGeekQ<List<GoodsSecKill>> selGoodsSecKillByPage(int page, int rows) {
        return null;
    }

    @Override
    public ResultGeekQ<GoodsSecKill> selGoodsSecKillById(int id) {
        return null;
    }
}
