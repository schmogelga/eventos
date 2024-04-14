package com.schmogel.inscricoesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InscricoesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(InscricoesApiApplication.class, args);
    }

}
