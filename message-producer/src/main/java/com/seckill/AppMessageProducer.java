package com.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.seckill.mapper") //@MapperScan 用户扫描MyBatis的Mapper接口
public class AppMessageProducer {

	public static void main(String[] args) {
		SpringApplication.run(AppMessageProducer.class, args);
	}
}
