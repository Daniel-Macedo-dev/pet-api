package com.daniel.pets.controller;


import com.daniel.pets.business.PetService;
import com.daniel.pets.infrastructure.entities.Pet;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Void> save(@RequestBody Pet pet){
        petService.salvarPet(pet);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable Integer id){
        return ResponseEntity.ok(petService.buscarPetPorId(id));
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
        petService.substituirPet(id, novoPet);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Integer id,
                                         @RequestBody Pet novoPet){
        petService.atualizarPet(id, novoPet);
        return ResponseEntity.ok().build();
    }
}
