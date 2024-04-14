package com.schmogel.inscricoesapi.application.dto;

import java.util.UUID;

public record PresencaRequest(
        UUID inscricaoId
) {
}
