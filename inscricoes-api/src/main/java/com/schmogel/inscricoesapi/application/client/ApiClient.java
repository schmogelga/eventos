package com.schmogel.inscricoesapi.application.client;

import com.schmogel.inscricoesapi.application.dto.InscricaoRequest;
import com.schmogel.inscricoesapi.application.dto.InscricaoResponse;
import com.schmogel.inscricoesapi.application.dto.PresencaRequest;
import com.schmogel.inscricoesapi.application.dto.PresencaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "${feign.rest.eventosfull.name}", url = "${feign.rest.eventosfull.url}", configuration = CustomFeignInterceptor.class)
@Component
public interface ApiClient {

    @GetMapping(value = "/inscricoes")
    List<InscricaoResponse> listarInscricoesPorUsuario(@RequestParam(required = false) UUID usuarioId, @RequestHeader("username") String username);

    @PostMapping(value = "/inscricoes", consumes = MediaType.APPLICATION_JSON_VALUE)
    InscricaoResponse criarInscricao(@RequestBody InscricaoRequest inscricaoRequest, @RequestHeader("username") String username);

    @GetMapping(value = "/inscricoes/{inscricaoId}")
    InscricaoResponse recuperarInscricao(@PathVariable UUID inscricaoId, @RequestHeader("username") String username);

    @DeleteMapping("/inscricoes/{inscricaoId}")
    void deletarInscricao(@PathVariable UUID inscricaoId, @RequestHeader("username") String username);

    @PostMapping("/inscricoes/presenca")
    PresencaResponse criarPresenca(@RequestBody PresencaRequest presencaRequest, @RequestHeader("username") String username);
}
