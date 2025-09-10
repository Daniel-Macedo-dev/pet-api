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
    public ResponseEntity<?> save(@RequestBody Pet pet){
        Pet savedPet = petService.salvarPet(pet);
        return ResponseEntity.ok(new CustomResponse("Pet salvo com sucesso", savedPet));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Pet pet = petService.buscarPetPorId(id);
        return ResponseEntity.ok(new CustomResponse("Pet encontrado", pet));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Pet> pets = petService.listarPets();
        return ResponseEntity.ok(new CustomResponse("Total de pets cadastrados: " + pets.size(), pets));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        petService.deletarPetPorId(id);
        return ResponseEntity.ok(new CustomResponse("Pet deletado com sucesso", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replacePet (@PathVariable Integer id,
                                         @RequestBody Pet novoPet){
        Pet pet = petService.substituirPet(id, novoPet);
        return ResponseEntity.ok(new CustomResponse("Pet substituído com sucesso", pet));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePet(@PathVariable Integer id,
                                       @RequestBody Pet novoPet){
        Pet pet = petService.atualizarPet(id, novoPet);
        return ResponseEntity.ok(new CustomResponse("Pet atualizado com sucesso", pet));
    }

    public record CustomResponse(String message, Object data) {

    }
}
