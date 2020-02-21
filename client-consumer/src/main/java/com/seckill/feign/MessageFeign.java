package com.seckill.feign;

import com.seckill.feign.fallback.MessageFeignFallback;
import com.seckill.pojo.MessageUser;
import com.seckill.result.ResultGeekQ;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "seckill-message-producer", fallback = MessageFeignFallback.class)
public interface MessageFeign {

    @RequestMapping("/message/selByUserId/{id}")
    ResultGeekQ<List<MessageUser>> selByUserId(@PathVariable long id);

}
