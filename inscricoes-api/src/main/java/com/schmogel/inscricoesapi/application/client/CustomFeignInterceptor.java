package com.schmogel.inscricoesapi.application.client;

import com.schmogel.inscricoesapi.application.security.AuthManager;
import feign.RequestInterceptor;
import feign.RequestTemplate;
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