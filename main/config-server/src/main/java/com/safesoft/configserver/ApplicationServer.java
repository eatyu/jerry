package com.safesoft.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//使用@EnableConfigServer开启配置中心

@SpringBootApplication
@EnableConfigServer
public class ApplicationServer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class,args);
    }
}
