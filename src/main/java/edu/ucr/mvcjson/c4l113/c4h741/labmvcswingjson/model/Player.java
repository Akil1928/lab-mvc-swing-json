package edu.ucr.mvcjson.c4l113.c4h741.labmvcswingjson.model;


import java.util.Objects;

public record Player(String name, Sport sport, String position, int shirtNumber) {
    public Player {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        Objects.requireNonNull(sport, "El deporte es obligatorio");
        if (shirtNumber <= 0) {
            throw new IllegalArgumentException("El número de camiseta debe ser mayor a 0");
        }
    }

}