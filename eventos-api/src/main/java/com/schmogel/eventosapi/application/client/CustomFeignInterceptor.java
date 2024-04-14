package com.schmogel.eventosapi.application.client;

import com.schmogel.eventosapi.application.security.AuthManager;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomFeignInterceptor implements RequestInterceptor {

    @Value("${feign.rest.eventosfull.auth.client}")
    private String client;

    @Value("${feign.rest.eventosfull.auth.secret}")
    private String secret;

    @Autowired
    private AuthManager authManager;

    @Override
    public void apply(RequestTemplate template) {
        template.header("client", client);
        template.header("Authorization", authManager.generateHash(client, secret));
    }
}