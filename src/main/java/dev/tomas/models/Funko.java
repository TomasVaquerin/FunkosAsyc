package dev.tomas.models;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Funko {
    private final UUID cod;
    private final Long myId;
    private String nombre;
    private Modelo modelo;
    private double precio;
    private final LocalDate fecha_lanzamiento;
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();
}