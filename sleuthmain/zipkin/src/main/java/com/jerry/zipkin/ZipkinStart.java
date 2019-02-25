package com.jerry.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinStart {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinStart.class, args);
    }
}
