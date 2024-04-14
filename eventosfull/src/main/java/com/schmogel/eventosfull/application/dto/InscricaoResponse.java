package com.schmogel.eventosfull.application.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record InscricaoResponse(
    UUID id,
    UUID usuarioId,
    UUID eventoId
) {
}
