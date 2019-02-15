package com.safesoft.outclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OutClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(OutClientApplication.class,args);
    }
}
