package com.schmogel.emailsapi.application.client;

import com.schmogel.emailsapi.application.dto.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${feign.rest.eventosfull.name}", url = "${feign.rest.eventosfull.url}", configuration = CustomFeignInterceptor.class)
@Component
public interface ApiClient {

    @PostMapping(value = "/emails")
    void enviarEmail(@RequestBody EmailRequest emailRequest, @RequestHeader("username") String username);
}
