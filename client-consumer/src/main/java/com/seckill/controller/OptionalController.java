package com.seckill.controller;


import com.seckill.redis.RedisTime;
import com.seckill.result.ResultGeekQ;
import com.seckill.service.VerifyImageService;
import com.seckill.utils.CookieUtils;
import com.seckill.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

import static com.seckill.enums.ResultStatus.EXCEPTION;

@Controller
@RequestMapping("/optional")
public class OptionalController {

    @Value("${redis.key.image}")
    private String imageKey;
    @Autowired
    private VerifyImageService verifyImageService;

    /**
     * 验证码
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/verifyCodeRegister")
    @ResponseBody
    public ResultGeekQ<String> verifyCodeRegister(HttpServletRequest request, HttpServletResponse response){

        ResultGeekQ<String> result = ResultGeekQ.build();
        String imageId = this.imageKey + IDUtils.getRandomUUId();
        CookieUtils.setCookie(request, response, "image", imageId, (int)RedisTime.VERIFICATION_TIME);
        try {
            BufferedImage image = this.verifyImageService.createVerifyCode(imageId);
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "JPEG", out);
            out.flush();
            out.close();
            return result;
        } catch (Exception e) {
            //40003 秒杀失败
            result.withError(EXCEPTION.getCode(), EXCEPTION.getMessage());
            return result;
        }
    }
}
