package com.seckill.controller;

import com.seckill.feign.AccountFeign;
import com.seckill.pojo.Account;
import com.seckill.pojo.MiaoshaUser;
import com.seckill.result.ResultGeekQ;
import com.seckill.service.VerifyImageService;
import com.seckill.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.seckill.enums.ResultStatus.CODE_FAIL;
import static com.seckill.enums.ResultStatus.RESIGETER_FAIL;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private VerifyImageService verifyImageService;
    @Resource
    private AccountFeign accountFeign;

    /**
     * 注册请求
     * @param req
     * @param account 注册用户信息
     * @param salt 加密字段
     * @param verifyCode 注册码信息
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public ResultGeekQ<String> register(HttpServletRequest req, Account account,String salt, int verifyCode){
        ResultGeekQ<String> result = ResultGeekQ.build();
        String imageIdU = CookieUtils.getCookieValue(req, "image");
        boolean checkCode = this.verifyImageService.checkVerifyCodeRegister(verifyCode, imageIdU);

        if (!checkCode){
            //200002 验证码不正确
            result.withError(CODE_FAIL.getCode(),CODE_FAIL.getMessage());
            return result;
        }
        MiaoshaUser user = new MiaoshaUser();
        user.setNickname(account.getUsername());
        user.setPassword(account.getPassword());
        user.setSalt(salt);
        int insI = this.accountFeign.register(user);

        if(insI!=1 || insI==2){
            result.withError(RESIGETER_FAIL.getCode(),RESIGETER_FAIL.getMessage());
            return result;
        }
        return result;
    }

}
