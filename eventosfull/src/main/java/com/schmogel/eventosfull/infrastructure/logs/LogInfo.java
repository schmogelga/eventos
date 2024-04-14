package com.schmogel.eventosfull.infrastructure.logs;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "logs")
public class LogInfo {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column(updatable = false)
    private String rota;

    @Column(updatable = false)
    private String metodo;

    @Column(updatable = false)
    private String usuario;

    @Column(updatable = false)
    private int response;

    @Column(updatable = false)
    private LocalDateTime dataHoraCheckin;
}
