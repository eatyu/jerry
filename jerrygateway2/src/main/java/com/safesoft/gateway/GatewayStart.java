package com.safesoft.gateway;

import com.safesoft.gateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GatewayStart {
    public static void main(String[] args) {
        SpringApplication.run(GatewayStart.class, args);
    }


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .build();
    }


    // 全局过滤器 GlobalFilter
    // 不需要在配置文件中配置，作用在所有的路由上
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}
