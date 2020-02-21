package com.seckill.pojo;

import java.io.Serializable;

public class GoodsSecKill extends Goods implements Serializable {

    private MiaoshaGoods miaoshaGoods;

    public GoodsSecKill() {
    }

    public GoodsSecKill(MiaoshaGoods miaoshaGoods) {
        this.miaoshaGoods = miaoshaGoods;
    }

    public MiaoshaGoods getMiaoshaGoods() {
        return miaoshaGoods;
    }

    public void setMiaoshaGoods(MiaoshaGoods miaoshaGoods) {
        this.miaoshaGoods = miaoshaGoods;
    }
}
