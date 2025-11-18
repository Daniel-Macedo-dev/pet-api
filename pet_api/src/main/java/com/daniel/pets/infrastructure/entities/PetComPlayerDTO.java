package com.daniel.pets.infrastructure.entities;

public record PetComPlayerDTO(
        Integer id,
        String nome,
        Integer idade,
        Float peso,
        String sexo,
        PlayerDTO player
) {}
