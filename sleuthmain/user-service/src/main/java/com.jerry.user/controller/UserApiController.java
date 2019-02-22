package com.jerry.user.controller;

import com.inter.user.api.UserApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController implements UserApi {

    @Override
    @RequestMapping("/hi")
    public String sayHi(@RequestParam("name") String name) {
        return "hello this is user-service";
    }

}
