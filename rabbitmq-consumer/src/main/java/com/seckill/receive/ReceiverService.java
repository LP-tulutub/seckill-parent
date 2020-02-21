package com.seckill.receive;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ReceiverService {
    @Input("secKillInput")
    SubscribableChannel SecKillInput();
}
