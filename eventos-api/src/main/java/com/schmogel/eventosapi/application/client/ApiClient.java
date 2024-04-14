package com.schmogel.eventosapi.application.client;

import com.schmogel.eventosapi.application.dto.EventoRequest;
import com.schmogel.eventosapi.application.dto.EventoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "${feign.rest.eventosfull.name}", url = "${feign.rest.eventosfull.url}", configuration = CustomFeignInterceptor.class)
@Component
public interface ApiClient {

    @GetMapping(value = "/eventos")
    List<EventoResponse> listarEventos(@RequestHeader("username") String username);

    @PostMapping(value = "/eventos", consumes = MediaType.APPLICATION_JSON_VALUE)
    EventoResponse criarEvento(@RequestBody EventoRequest eventoRequest, @RequestHeader("username") String username);

    @GetMapping(value = "/eventos/{eventoId}")
    EventoResponse recuperarEvento(@PathVariable UUID eventoId, @RequestHeader("username") String username);
}
