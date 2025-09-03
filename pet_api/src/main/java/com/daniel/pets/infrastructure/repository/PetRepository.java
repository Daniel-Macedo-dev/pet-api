package com.daniel.pets.infrastructure.repository;

import com.daniel.pets.infrastructure.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
