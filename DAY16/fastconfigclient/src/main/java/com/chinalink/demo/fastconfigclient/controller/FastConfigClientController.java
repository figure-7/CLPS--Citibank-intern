package com.chinalink.demo.fastconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/native")
public class FastConfigClientController {

    @Value("${message}")
    private String message;

    @GetMapping("/message")
    public String message(){
        return message;
    }
}
