package com.schmogel.inscricoesapi.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${feign.rest.auth.name}", url = "${feign.rest.auth.url}")
@Component
public interface AuthClient {

    @GetMapping(value = "/validate")
    String validarToken(@RequestHeader("Authorization") String token);
}
