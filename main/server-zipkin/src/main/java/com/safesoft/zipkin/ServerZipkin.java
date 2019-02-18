package com.safesoft.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ServerZipkin {


    public static void main(String[] args) {
        SpringApplication.run(ServerZipkin.class, args);
    }
}
