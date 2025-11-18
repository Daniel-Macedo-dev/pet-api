package com.daniel.pets.dto;

public record PetComPlayerDTO(
        Integer id,
        String nome,
        Integer idade,
        Float peso,
        String sexo,
        PlayerDTO player
) {}
