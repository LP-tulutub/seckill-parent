package com.seckill.mapper;

import com.seckill.pojo.OrderInfoGoods;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface GoodsOrderInfoMapper {

    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "goodsId", column = "goods_id"),
            @Result(property = "goods", column = "goods_id", one = @One(select = "com.seckill.mapper.GoodsMapper.selectByPrimaryKey"))
    })
    @Select("select * from order_info where user_id=#{id}")
    List<OrderInfoGoods> selGoodsOrderInfoByUserId(long id);

}
