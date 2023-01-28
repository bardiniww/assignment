package com.bardiniww.cash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CashApplication {
    public static void main(String[] args) {
        SpringApplication.run(CashApplication.class, args);
    }
}