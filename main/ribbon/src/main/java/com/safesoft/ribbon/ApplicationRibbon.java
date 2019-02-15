package com.safesoft.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaClient表明这是一个服务提供者
//@EnableDiscoveryClient表示向服务中心注册
//@LoadBalanced表明RestTemplate工具类将会负载均衡

// 在启动类上增加@EnableHystrix注解，以开启熔断功能

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
public class ApplicationRibbon {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRibbon.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
