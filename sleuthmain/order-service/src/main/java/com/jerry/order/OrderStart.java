package com.jerry.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderStart extends WebMvcConfigurationSupport {
    public static void main(String[] args) {
        SpringApplication.run(OrderStart.class, args);
    }



}
