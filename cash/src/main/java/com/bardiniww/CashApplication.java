package com.bardiniww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashApplication {
    public static void main(String[] args) {
        SpringApplication.run(CashApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(CashAgentJdbcRepository cashAgentJdbcRepository) {
//        return args -> {
//            CashAgent save = cashAgentJdbcRepository.save(new CashAgent(
//                    null,
//                    3L,
//                    21
//            ));
//            System.out.println("hi");
//        };
//    }
}