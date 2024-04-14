package com.schmogel.emailsapi.application.dto;

import java.util.UUID;

public record EmailRequest(
        UUID eventoId
) {
}
