package com.schmogel.eventosapi.application.web;

import com.schmogel.eventosapi.application.client.ApiClient;
import com.schmogel.eventosapi.application.dto.EventoRequest;
import com.schmogel.eventosapi.application.dto.EventoResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/eventos")
public class GatewayController {

    private final ApiClient apiClient;

    @GetMapping
    List<EventoResponse> listarEventos(HttpServletRequest request){
        return apiClient.listarEventos((String) request.getAttribute("username"));
    }

    @PostMapping
    EventoResponse criarEvento(@RequestBody EventoRequest eventoRequest, HttpServletRequest request){
        return apiClient.criarEvento(eventoRequest, (String) request.getAttribute("username"));
    }

    @GetMapping("/{eventoId}")
    EventoResponse recuperarEvento(@PathVariable UUID eventoId, HttpServletRequest request){
        return apiClient.recuperarEvento(eventoId, (String) request.getAttribute("username"));
    }
}
