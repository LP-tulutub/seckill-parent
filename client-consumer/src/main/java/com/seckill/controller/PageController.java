package com.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String welcome(){
        return "index";
    }

    @RequestMapping("/page/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    /**
     * 注册页面
     * @return
     */
    @RequestMapping("/registerHome")
    public String registerHome(){
        return "register";
    }

}
