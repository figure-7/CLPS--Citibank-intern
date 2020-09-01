package com.chinalink.demo.fastremoteconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FastRemoteConfigApplication {

	public static void main(String[] args) {

		SpringApplication.run(FastRemoteConfigApplication.class, args);
	}

}
