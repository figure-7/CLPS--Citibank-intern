package com.chinalink.demo.fastserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FastServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(FastServerApplication.class, args);
	}

}
