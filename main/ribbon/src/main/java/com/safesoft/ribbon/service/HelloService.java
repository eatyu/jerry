package com.safesoft.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    /**
     * 将IOC容器中的负载均衡RestTemplate工具注入进来
     */
    @Autowired
    RestTemplate restTemplate;

    /**
     * 因为ribbon采用的是RestTemplate来调用其它微服务的接口，所以需要修改方法，在方法上增加@HystrixCommand注解。
     * 并指明如果请求不到指定的服务器数据，则执行fallbackMethod指定的方法
     */

    @HystrixCommand(fallbackMethod = "obtainFailure")
    public String obtainOtherServiceData(String name) {
        //尝试调用其它微服务接口，访问的是SERVICE-CLIENT这个服务器的/hi 接口
        return restTemplate.getForObject("http://SERVICE-CLIENT/hi?name=" + name, String.class);
    }


    public String obtainFailure(String name) {
        return "sorry " + name + " , server internal error";
    }

}
