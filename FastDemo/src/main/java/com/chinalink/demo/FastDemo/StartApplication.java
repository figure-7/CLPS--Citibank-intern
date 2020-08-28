package com.chinalink.demo.FastDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chinalink.demo.FastDemo.repository")
public class StartApplication {

	public static void main(String[] args) {

		SpringApplication.run(StartApplication.class, args);
	}

}
