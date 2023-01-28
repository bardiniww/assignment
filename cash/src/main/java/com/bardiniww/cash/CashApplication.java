package com.bardiniww.cash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.bardiniww.cash",
                "com.bardiniww.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.bardiniww.clients"
)
public class CashApplication {
    public static void main(String[] args) {
        SpringApplication.run(CashApplication.class, args);
    }
}