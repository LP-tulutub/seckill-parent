package com.seckill.controller;

import com.seckill.feign.GoodsFeign;
import com.seckill.pojo.GoodsSecKill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsFeign goodsFeign;

    /**
     * 商品列表页面
     * @param model
     * @param req
     * @return
     */
    @RequestMapping("/to_list")
    public String to_list(Model model, HttpServletRequest req){
        Object username = req.getAttribute("username");
        Object userId = req.getAttribute("userId");
        model.addAttribute("username", username);
        model.addAttribute("userId", userId);
        // 查询秒杀的商品
        List<GoodsSecKill> goodsList = this.goodsFeign.selGoodsSecKillByPage(0, 100).getData();
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }

    /**
     * 秒杀页面
     * @param model
     * @param id 当前商品id
     * @param req
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id, HttpServletRequest req){
        Object username = req.getAttribute("username");
        model.addAttribute("username", username);
        // 查询详细
        GoodsSecKill goodsSecKill = this.goodsFeign.selGoodsSecKillById(id).getData();
        model.addAttribute("goods", goodsSecKill);
        model.addAttribute("secKillGoods", goodsSecKill.getMiaoshaGoods());
        // 秒杀状态
        long startAt = goodsSecKill.getMiaoshaGoods().getStartDate().getTime();
        long endAt = goodsSecKill.getMiaoshaGoods().getEndDate().getTime();
        long now = System.currentTimeMillis();
        int miaoshaStatus = 0;
        int remainSeconds = 0;
        if(now < startAt ) {//秒杀还没开始，倒计时
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt - now )/1000);
        }else  if(now > endAt){//秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else {//秒杀进行中
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
    }



}
