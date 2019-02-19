package com.safesoft.zipkinhi;

import brave.sampler.Sampler;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

// 添加@EnableCircuitBreaker或@EnableHystrix注解，开启断路器功能
// @EnableHystrixDashboard 开启面板显示
// @EnableDiscoveryClient 或 @EnableEurekaClient   服务注册

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableEurekaClient
public class ZipkinHi {


    public static void main(String[] args) {
        SpringApplication.run(ZipkinHi.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ZipkinHi.class.getName());


    /**
     * 下面是演示链路追踪的
     */

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "thisError")
    public String callHome() {
        LOG.log(Level.INFO, "calling trace service-hi  ");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    public String thisError() {
        return "错误，与miya的访问断开";
    }

    @RequestMapping("/info")
    public String info() {
        LOG.log(Level.INFO, "calling trace service-hi ");

        return "i'm service-hi";

    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }


    /**
     * spring cloud2 hystrix没有/actuator/hystrix.stream路径解决方式
     * 加上下面这个bean
     * 也可以在配置文件中添加配置 management.endpoints.web.exposure.include=hystrix.stream
     *
     *
     * 参考下面演示效果
     * https://blog.csdn.net/forezp/article/details/81041113
     * https://blog.csdn.net/dangshushu/article/details/80416042
     *
     *
     */
//    @Bean
//    public ServletRegistrationBean getServlet(){
//
//        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//
//        registrationBean.setLoadOnStartup(1);
//
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//
//        registrationBean.setName("HystrixMetricsStreamServlet");
//
//
//        return registrationBean;
//    }

}
