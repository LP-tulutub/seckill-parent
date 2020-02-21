package com.seckill.rabbitmq;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface SecKillSendService {
    @Output("secKillOutput")
    SubscribableChannel sendMessage();
}
