package com.seckill.controller;

import com.seckill.feign.AccountFeign;
import com.seckill.pojo.Account;
import com.seckill.redis.RedisTime;
import com.seckill.service.LoginService;
import com.seckill.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountFeign accountFeign;
    @Autowired
    private LoginService loginService;

    /**
     * 登陆
     * @param account
     * @param req
     * @param rep
     * @return
     */
    @RequestMapping("/login")
    public String login(Account account, HttpServletRequest req, HttpServletResponse rep){
        Object obj = this.accountFeign.login(account);
        if (obj!=null && !obj.equals("")){
            String cookiesId = this.loginService.setLoginInRedis(obj);
            CookieUtils.setCookie(req, rep, "TT_TOKEN", cookiesId, (int) RedisTime.LOGIN_TIME);

            return "redirect:/goods/to_list";
        }
        return "error";
    }
}
