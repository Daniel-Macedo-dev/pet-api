package com.daniel.pets.infrastructure.repository;

import com.daniel.pets.infrastructure.entities.Dono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonoReposository extends JpaRepository<Dono, Integer> {
}
