package com.safesoft.zipkinhi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @Value("${eureka.client.serviceUrl.defaultZone}")
    String defaultZone;

    @RequestMapping("/seeme")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(value = "name", defaultValue = "eatyu") String name) {
        return "hi " + name + " ,the defaultZone is :" + defaultZone;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
