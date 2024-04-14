package com.schmogel.eventosapi.application.dto;

import java.time.LocalDate;

public record EventoRequest(
        String nome,
        LocalDate data
) {}