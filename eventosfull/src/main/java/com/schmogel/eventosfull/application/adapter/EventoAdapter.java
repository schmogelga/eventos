package com.schmogel.eventosfull.application.adapter;

import com.schmogel.eventosfull.application.dto.EventoResponse;
import com.schmogel.eventosfull.domain.model.Evento;

import java.util.Optional;

public class EventoAdapter {

  public static EventoResponse entityToDto(Evento evento){
    return EventoResponse.builder()
      .id(evento.getId())
      .nome(evento.getNome())
      .data(evento.getData())
      .inscricoes(Optional.ofNullable(evento.getInscricoes())
          .map(inscricoes -> inscricoes.stream()
          .map(InscricaoAdapter::entityToDTO)
          .toList())
        .orElse(null))
      .build();
  }
}
