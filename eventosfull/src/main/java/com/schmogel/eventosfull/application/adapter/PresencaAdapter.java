package com.schmogel.eventosfull.application.adapter;

import com.schmogel.eventosfull.application.dto.PresencaResponse;
import com.schmogel.eventosfull.domain.model.Inscricao;
import com.schmogel.eventosfull.domain.model.Presenca;

import java.util.Optional;

public class PresencaAdapter {

 public static PresencaResponse entityToDto(Presenca presenca){
   return PresencaResponse.builder()
     .id(presenca.getId())
     .dataHoraCheckin(presenca.getDataHoraCheckin())
     .inscricaoId(Optional.ofNullable(presenca.getInscricao())
       .map(Inscricao::getId)
       .orElse(null))
     .build();
 }

}
