package com.seckill;

import com.seckill.rabbitmq.SecKillSendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@ServletComponentScan
@EnableBinding(SecKillSendService.class)
public class AppClientConsumer {

	public static void main(String[] args) {
		SpringApplication.run(AppClientConsumer.class, args);
	}
}
