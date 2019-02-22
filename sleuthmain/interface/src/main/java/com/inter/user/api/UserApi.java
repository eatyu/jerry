package com.inter.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @FeignClient 这个注解不是必需的，这里加上为了表明其实现server的aplication name

@FeignClient(value = "SERVICE-USER")
public interface UserApi {

    @RequestMapping("/hi")
    String sayHi(@RequestParam("name") String name);
}

