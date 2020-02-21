package com.seckill.feign.fallback;

import com.seckill.feign.AccountFeign;
import com.seckill.pojo.Account;
import com.seckill.pojo.MiaoshaUser;
import org.springframework.stereotype.Component;

@Component
public class AccountFeignFallback implements AccountFeign {
    @Override
    public Object login(Account account) {
        return null;
    }

    @Override
    public int register(MiaoshaUser user) {
        return 0;
    }
}
