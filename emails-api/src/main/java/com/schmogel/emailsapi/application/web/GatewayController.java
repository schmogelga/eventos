package com.schmogel.emailsapi.application.web;

import com.schmogel.emailsapi.application.client.ApiClient;
import com.schmogel.emailsapi.application.dto.EmailRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/emails")
public class GatewayController {

    private final ApiClient apiClient;

    @PostMapping
    void criarEvento(@RequestBody EmailRequest emailRequest, HttpServletRequest request){
        apiClient.enviarEmail(emailRequest, (String) request.getAttribute("username"));
    }
}
