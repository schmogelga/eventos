package com.schmogel.eventosfull.application.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
public record EventoResponse(
        UUID id,
        String nome,
        List<InscricaoResponse> inscricoes,
        LocalDate data
) {
}
