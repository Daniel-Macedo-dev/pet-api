package com.daniel.pets.controller;

import com.daniel.pets.business.PetService;
import com.daniel.pets.infrastructure.entities.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Pet pet){
        Pet savedPet = petService.salvarPet(pet);
        return ResponseEntity.ok("Pet " + savedPet.getNome() + "salvo com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Integer id){
        Pet pet = petService.buscarPetPorId(id);
        return ResponseEntity.ok("Pet encontrado: " + pet.getNome());
    }

    @GetMapping
    public ResponseEntity<String> findAll(){
        List<Pet> pets = petService.listarPets();
        return ResponseEntity.ok("Total de pets cadastrados " + pets.size());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        petService.deletarPetPorId(id);
        return ResponseEntity.ok("Pet deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> replacePet (@PathVariable Integer id,
                                             @RequestBody Pet novoPet){
        Pet pet = petService.substituirPet(id, novoPet);
        return ResponseEntity.ok("Pet " + pet.getNome() + " substituído com sucesso");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePet(@PathVariable Integer id,
                                         @RequestBody Pet novoPet){
        Pet pet = petService.atualizarPet(id, novoPet);
        return ResponseEntity.ok("Pet " + pet.getNome() + " atualizado com sucesso");
    }
}
