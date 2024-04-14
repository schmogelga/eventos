package com.schmogel.eventosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EventosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventosApiApplication.class, args);
    }

}
