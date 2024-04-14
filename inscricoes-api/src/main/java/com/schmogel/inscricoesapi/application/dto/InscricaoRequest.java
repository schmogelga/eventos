package com.schmogel.inscricoesapi.application.dto;

import java.util.UUID;

public record InscricaoRequest(
        UUID usuarioId,
        UUID eventoId
) {
}
