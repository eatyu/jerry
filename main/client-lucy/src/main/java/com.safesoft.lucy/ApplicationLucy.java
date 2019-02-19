package com.safesoft.lucy;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@RestController
public class ApplicationLucy {

    private static final Logger LOG = Logger.getLogger(ApplicationLucy.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ApplicationLucy.class, args);
    }

    @HystrixCommand(fallbackMethod = "thisError")
    @RequestMapping("/info")
    public String info() {
        LOG.log(Level.INFO, "calling trace service-hi ");

        return "i'm service-lucy";

    }

    public String thisError() {
        return "error this time";
    }

}
