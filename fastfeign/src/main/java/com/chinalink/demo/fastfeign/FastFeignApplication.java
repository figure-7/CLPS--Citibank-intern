package com.chinalink.demo.fastfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FastFeignApplication {

	public static void main(String[] args) {

		SpringApplication.run(FastFeignApplication.class, args);
	}

}
