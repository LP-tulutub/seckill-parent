package com.seckill.mapper;

import com.seckill.pojo.GoodsSecKill;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsSecKillMapper {

    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "miaoshaGoods", column = "id", one = @One(select = "com.seckill.mapper.MiaoshaGoodsMapper.selectByPrimaryKey"))
    })
    @Select("select * from goods")
    List<GoodsSecKill> selAllByUnite();

    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "miaoshaGoods", column = "id", one = @One(select = "com.seckill.mapper.MiaoshaGoodsMapper.selectByPrimaryKey"))
    })
    @Select("select * from goods where id=#{id}")
    GoodsSecKill selAllByUniteOne(int id);
}
