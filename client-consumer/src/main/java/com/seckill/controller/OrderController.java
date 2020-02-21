package com.seckill.controller;

import com.seckill.feign.OrderFeign;
import com.seckill.pojo.OrderInfoGoods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderFeign orderFeign;

    @RequestMapping("/list/{id}")
    public String detail(Model model, @PathVariable long id){
        List<OrderInfoGoods> list = this.orderFeign.selGoodsOrderInfoByUserId(0, 100, id).getData();
        model.addAttribute("list", list);
        return "order_list";
    }


}
