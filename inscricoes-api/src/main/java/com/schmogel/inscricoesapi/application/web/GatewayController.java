package com.schmogel.inscricoesapi.application.web;

import com.schmogel.inscricoesapi.application.client.ApiClient;
import com.schmogel.inscricoesapi.application.dto.InscricaoRequest;
import com.schmogel.inscricoesapi.application.dto.InscricaoResponse;
import com.schmogel.inscricoesapi.application.dto.PresencaRequest;
import com.schmogel.inscricoesapi.application.dto.PresencaResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/inscricoes")
public class GatewayController {

    private final ApiClient apiClient;

    @GetMapping
    List<InscricaoResponse> listarInscricoesPorUsuario(@RequestParam(required = false) UUID usuarioId, HttpServletRequest request){
        return apiClient.listarInscricoesPorUsuario(usuarioId, (String) request.getAttribute("username"));
    }

    @PostMapping
    InscricaoResponse criarInscricao(@RequestBody InscricaoRequest inscricaoRequest, HttpServletRequest request){
        return apiClient.criarInscricao(inscricaoRequest, (String) request.getAttribute("username"));
    }

    @GetMapping("/{inscricaoId}")
    InscricaoResponse recuperarInscricao(@PathVariable UUID inscricaoId, HttpServletRequest request){
        return apiClient.recuperarInscricao(inscricaoId, (String) request.getAttribute("username"));
    }

    @DeleteMapping("/{inscricaoId}")
    void deletarInscricao(@PathVariable UUID inscricaoId, HttpServletRequest request){
        apiClient.deletarInscricao(inscricaoId, (String) request.getAttribute("username"));
    }

    @PostMapping("/presenca")
    PresencaResponse criarPresenca(@RequestBody PresencaRequest presencaRequest, HttpServletRequest request){
        return apiClient.criarPresenca(presencaRequest, (String) request.getAttribute("username"));
    }
}
