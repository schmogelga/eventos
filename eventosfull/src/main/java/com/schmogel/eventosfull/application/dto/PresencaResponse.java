package com.schmogel.eventosfull.application.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record PresencaResponse(
  UUID id,
  LocalDateTime dataHoraCheckin,
  UUID inscricaoId
) {
}
