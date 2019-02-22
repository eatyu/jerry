package com.inter.user.api;

import com.inter.user.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

// @FeignClient 这个注解不是必需的，这里加上为了表明其实现server的aplication name

@FeignClient(value = "SERVICE-USER")
public interface UserApi {

    @RequestMapping("/hi")
    String sayHi(@RequestParam("name") String name);

    @RequestMapping("/getInfobyId")
    UserDto getInfobyId(@RequestParam("userId") BigInteger userId);

}

