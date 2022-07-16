package com.example.seckillsystemdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.seckillsystemdemo.mapper")
public class SeckillSystemDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeckillSystemDemoApplication.class, args);
	}

}
