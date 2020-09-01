package com.chinalink.demo.fastremoteconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/remoteconfig")
@RestController
@RefreshScope
public class FastRemoteConfigClientController {

	@Value("${message}")
    private String message;

    @GetMapping("/message")
    public String message(){
        return message;
    }
}
