package com.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/userHome")
    @ResponseBody
    public String userHome(){
        return "userHome";
    }

    @RequestMapping("/adminHome")
    @ResponseBody
    public String adminHome(){
        return "adminHome";
    }

}
