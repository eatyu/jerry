package com.safesoft.outclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String hi() {
        return "out client" + port;
    }

}
