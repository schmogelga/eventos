package com.schmogel.eventosapi.application.dto;

import java.util.UUID;

public record InscricaoResponse(
        UUID id,
        UUID usuarioId,
        UUID eventoId
) {
}

