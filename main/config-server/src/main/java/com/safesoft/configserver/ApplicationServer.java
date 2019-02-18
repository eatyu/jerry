package com.safesoft.configserver;

/**
 * SpringBoot的核心思想就是约定优于配置，所以仓库中的配置文件会被转换成web接口，访问可以参照以下的规则
 *
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 *
 * 访问http://localhost:8001/config-test.properties
 * 符合第四条
 *
 *  application = config
 *  profile = dev
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//使用@EnableConfigServer开启配置中心

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ApplicationServer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class,args);
    }
}

/**
 * 访问下面 可以看到效果
 * http://localhost:8001/config/dev
 * http://localhost:8001/config-test.properties
 *
 *
 * 我放置的3个文件是
 * config-dev.properties
 * config-pro.properties
 * config-test.properties
 *
 * http://localhost:8001/config/dev 中的config，dev分别对应config-dev
 *
 * 如果是
 * jerry-config-dev.properties
 * 访问路径为
 * http://localhost:8001/jerry-config/dev
 *
 *
 */