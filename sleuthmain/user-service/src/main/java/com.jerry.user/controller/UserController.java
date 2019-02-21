package com.jerry.user.controller;

import com.alibaba.fastjson.JSON;
import com.jerry.user.vo.UserVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class UserController {

    @RequestMapping("/testId")
    public UserVo testId() {
        UserVo user = new UserVo();
        user.setUserId(new BigInteger("1902052024000000001"));
        user.setTapId("xy255");
        user.setTa("123456");
        System.out.println(JSON.toJSONString(user));
        return user;
    }

}
