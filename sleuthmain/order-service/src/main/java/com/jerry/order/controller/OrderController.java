package com.jerry.order.controller;

import com.inter.user.api.UserApi;
import com.jerry.order.service.feign.UserRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private UserRemoteService userRemoteService;

    @RequestMapping("/testId")
    public String test() {
        return "order service";
    }


    @RequestMapping("/testNee")
    public String testNee() {
        return userRemoteService.sayHi("nee");
    }
}
