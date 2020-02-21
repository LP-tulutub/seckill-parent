package com.seckill.service;

import com.seckill.mapper.*;
import com.seckill.pojo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service
@Transactional
public class SecKillService {
    @Resource
    private MiaoshaMessageUserMapper miaoshaMessageUserMapper;
    @Resource
    private MiaoshaMessageMapper miaoshaMessageMapper;
    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private MiaoshaGoodsMapper miaoshaGoodsMapper;
    @Resource
    private MiaoshaOrderMapper miaoshaOrderMapper;

    public int successSecKill(SecKillMessage msg, String secKillId){
        Date date = new Date();
        //查询商品信息
        Goods goods = this.goodsMapper.selectByPrimaryKey(msg.getGoodsId());
        MiaoshaGoods miaoshaGoods = this.miaoshaGoodsMapper.selectByPrimaryKey(msg.getGoodsId());
        long orderId = Long.parseLong(secKillId + System.currentTimeMillis());
        //插入订单信息表
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(orderId);
        orderInfo.setUserId(msg.getUserId());
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsPrice(miaoshaGoods.getMiaoshaPrice());
        orderInfo.setCreateDate(date);
        int insOrderInfo = this.orderInfoMapper.insertSelective(orderInfo);
        //插入秒杀信息表
        MiaoshaMessage miaoshaMessage = new MiaoshaMessage();
        miaoshaMessage.setMessageid(orderId);
        miaoshaMessage.setContent("已成功秒杀");
        miaoshaMessage.setCreateTime(date);
        miaoshaMessage.setStatus(0);
        miaoshaMessage.setMessageType(0);
        miaoshaMessage.setSendType(0);
        miaoshaMessage.setPrice(miaoshaGoods.getMiaoshaPrice());
        int insSecKillMessage = this.miaoshaMessageMapper.insertSelective(miaoshaMessage);
        //插入秒杀用户表
        MiaoshaMessageUser miaoshaMessageUser = new MiaoshaMessageUser();
        miaoshaMessageUser.setUserid(msg.getUserId());
        miaoshaMessageUser.setMessageid(orderId);
        miaoshaMessageUser.setGoodid((int)msg.getGoodsId());
        //miaoshaMessageUser.setOrderid((int)orderId);
        int insSecKillUser = this.miaoshaMessageUserMapper.insertSelective(miaoshaMessageUser);
        //插入秒杀订单表
        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setOrderId(orderId);
        miaoshaOrder.setUserId(msg.getUserId());
        miaoshaOrder.setGoodsId(msg.getGoodsId());
        int insSeckillOrder = this.miaoshaOrderMapper.insertSelective(miaoshaOrder);
        //返回是否成功
        return (insOrderInfo + insSecKillMessage + insSecKillUser + insSeckillOrder);
    }

    public int failedSecKill(SecKillMessage msg, String secKillId){
        Date date = new Date();
        long messageId = Long.parseLong("0" + secKillId + System.currentTimeMillis());
        //插入秒杀信息表
        MiaoshaMessage miaoshaMessage = new MiaoshaMessage();
        miaoshaMessage.setMessageid(messageId);
        miaoshaMessage.setContent("秒杀失败");
        miaoshaMessage.setCreateTime(date);
        miaoshaMessage.setStatus(0);
        miaoshaMessage.setMessageType(2);
        miaoshaMessage.setSendType(0);
        int insSecKillMessage = this.miaoshaMessageMapper.insertSelective(miaoshaMessage);
        //插入秒杀用户表
        MiaoshaMessageUser miaoshaMessageUser = new MiaoshaMessageUser();
        miaoshaMessageUser.setUserid(msg.getUserId());
        miaoshaMessageUser.setMessageid(messageId);
        int insSecKillUser = this.miaoshaMessageUserMapper.insertSelective(miaoshaMessageUser);
        return (insSecKillMessage + insSecKillUser);
    }



}
