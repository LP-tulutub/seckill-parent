package com.seckill.feign.fallback;

import com.seckill.feign.MessageFeign;
import com.seckill.pojo.MessageUser;
import com.seckill.result.ResultGeekQ;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MessageFeignFallback implements MessageFeign {
    @Override
    public ResultGeekQ<List<MessageUser>> selByUserId(long id) {
        return null;
    }
}
