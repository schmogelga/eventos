package com.schmogel.eventosfull.infrastructure.logs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Logger {

  private final LogRepository logRepository;

  public void saveLog(LogInfo log){
    logRepository.save(log);
  }
}
