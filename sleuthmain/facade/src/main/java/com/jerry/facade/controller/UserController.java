package com.jerry.facade.controller;

import com.jerry.facade.service.UserService;
import com.jerry.facade.vo.UserOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserOrders")
    public UserOrders getUserOrders(@RequestParam("userId") BigInteger userId) {
        return userService.getUserOrders(userId);
    }
}
