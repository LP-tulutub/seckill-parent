package com.seckill.pojo;

import java.io.Serializable;

public class OrderInfoGoods extends OrderInfo implements Serializable {

    private Goods goods;

    public OrderInfoGoods() {
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
