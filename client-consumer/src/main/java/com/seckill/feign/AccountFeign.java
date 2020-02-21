package com.seckill.feign;

import com.seckill.feign.fallback.AccountFeignFallback;
import com.seckill.pojo.Account;
import com.seckill.pojo.MiaoshaUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "seckill-account-producer", fallback = AccountFeignFallback.class)
public interface AccountFeign {

    @RequestMapping("/account/login")
    Object login(@RequestBody Account account);

    @RequestMapping("/account/register")
    int register(@RequestBody MiaoshaUser user);
}
