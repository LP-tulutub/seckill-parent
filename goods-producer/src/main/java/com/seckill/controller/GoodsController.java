package com.seckill.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seckill.enums.ResultStatus;
import com.seckill.mapper.GoodsMapper;
import com.seckill.mapper.GoodsSecKillMapper;
import com.seckill.pojo.Goods;
import com.seckill.pojo.GoodsExample;
import com.seckill.pojo.GoodsSecKill;
import com.seckill.result.ResultGeekQ;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsSecKillMapper goodsSecKillMapper;

    @RequestMapping("/selAllByPage/{page}/{rows}")
    public ResultGeekQ<List<Goods>> selAllByPage(@PathVariable int page, @PathVariable int rows){
        // 设置分页
        PageHelper.startPage(page, rows);
        List<Goods> goodsList = this.goodsMapper.selectByExample(new GoodsExample());
        // 放入实体类
        PageInfo<Goods> pi = new PageInfo<>(goodsList);
        ResultGeekQ<List<Goods>> resultSelAll = ResultGeekQ.build(ResultStatus.SUCCESS.getMessage());
        resultSelAll.setData(pi.getList());
        resultSelAll.setCount(Integer.valueOf((int)pi.getTotal()));

        return resultSelAll;
    }


    @RequestMapping("/selGoodsSecKillByPage/{page}/{rows}")
    public ResultGeekQ<List<GoodsSecKill>> selGoodsSecKillByPage(@PathVariable int page, @PathVariable int rows){
        // 设置分页
        PageHelper.startPage(page, rows);
        List<GoodsSecKill> list = this.goodsSecKillMapper.selAllByUnite();
        // 放入实体类
        PageInfo<GoodsSecKill> pi = new PageInfo<>(list);
        ResultGeekQ<List<GoodsSecKill>> result = ResultGeekQ.build(ResultStatus.SUCCESS.getMessage());
        result.setData(pi.getList());
        result.setCount(Integer.valueOf((int)pi.getTotal()));

        return result;
    }

    @RequestMapping("/selGoodsSecKillById/{id}")
    public ResultGeekQ<GoodsSecKill> selGoodsSecKillById(@PathVariable int id){

        GoodsSecKill secKill = this.goodsSecKillMapper.selAllByUniteOne(id);
        // 放入实体类
        ResultGeekQ<GoodsSecKill> result = ResultGeekQ.build(ResultStatus.SUCCESS.getMessage());
        result.setData(secKill);

        return result;
    }

}
