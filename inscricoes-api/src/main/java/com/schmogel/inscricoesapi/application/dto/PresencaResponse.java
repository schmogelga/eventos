package com.schmogel.inscricoesapi.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PresencaResponse(
        UUID id,
        LocalDateTime dataHoraCheckin,
        UUID inscricaoId
) {
}
