package com.jerry.user.controller;

import com.inter.user.api.UserApi;
import com.inter.user.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class UserApiController implements UserApi {

    @Override
    @RequestMapping("/hi")
    public String sayHi(@RequestParam("name") String name) {
        return "hello this is user-service";
    }

    @Override
    @RequestMapping("/getInfobyId")
    public UserDto getInfobyId(@RequestParam("userId") BigInteger userId) {
        UserDto user = new UserDto();
        user.setName("jerry");
        user.setUserId(new BigInteger("1"));
        return null;
    }

}
