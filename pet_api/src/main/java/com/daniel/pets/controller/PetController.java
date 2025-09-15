package com.daniel.pets.controller;


import com.daniel.pets.business.PetService;
import com.daniel.pets.infrastructure.entities.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet pet){
        Pet novoPet = petService.salvarPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable Integer id){
        Pet pet = petService.buscarPetPorId(id);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> findAll(){
        return ResponseEntity.ok(petService.listarPets());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        petService.deletarPetPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> replacePet (@PathVariable Integer id,
                                           @RequestBody Pet novoPet){
        Pet atualizado = petService.substituirPet(id, novoPet);
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Integer id,
                                         @RequestBody Pet novoPet){
        Pet atualizado = petService.atualizarPet(id, novoPet);
        return ResponseEntity.ok(atualizado);
    }
}
