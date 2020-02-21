package com.seckill.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seckill.enums.ResultStatus;
import com.seckill.mapper.GoodsOrderInfoMapper;
import com.seckill.mapper.OrderInfoMapper;
import com.seckill.pojo.OrderInfoGoods;
import com.seckill.pojo.OrderInfo;
import com.seckill.pojo.OrderInfoExample;
import com.seckill.result.ResultGeekQ;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Resource
    private GoodsOrderInfoMapper goodsOrderInfoMapper;

    @RequestMapping("/test")
    public List<OrderInfo> test(){
        return this.orderInfoMapper.selectByExample(new OrderInfoExample());
    }

    @RequestMapping("/selByUserId/{page}/{rows}/{id}")
    public ResultGeekQ<List<OrderInfo>> selByUserId(@PathVariable int page, @PathVariable int rows, @PathVariable long id){
        // 设置分页
        PageHelper.startPage(page, rows);
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        orderInfoExample.createCriteria()
                .andUserIdEqualTo(id);
        List<OrderInfo> list = this.orderInfoMapper.selectByExample(orderInfoExample);
        // 放入到实例
        PageInfo<OrderInfo> pi = new PageInfo<>(list);
        ResultGeekQ<List<OrderInfo>> result = ResultGeekQ.build(ResultStatus.SUCCESS.getMessage());
        result.setData(pi.getList());
        result.setCount((int)pi.getTotal());

        return result;
    }

    @RequestMapping("/selGoodsOrderInfoByUserId/{page}/{rows}/{id}")
    public ResultGeekQ<List<OrderInfoGoods>> selGoodsOrderInfoByUserId(@PathVariable int page, @PathVariable int rows, @PathVariable long id){
        // 设置分页
        PageHelper.startPage(page, rows);
        List<OrderInfoGoods> list = this.goodsOrderInfoMapper.selGoodsOrderInfoByUserId(id);
        // 放入到实例
        PageInfo<OrderInfoGoods> pi = new PageInfo<>(list);
        ResultGeekQ<List<OrderInfoGoods>> result = ResultGeekQ.build(ResultStatus.SUCCESS.getMessage());
        result.setData(pi.getList());
        result.setCount((int)pi.getTotal());

        return result;
    }

}
