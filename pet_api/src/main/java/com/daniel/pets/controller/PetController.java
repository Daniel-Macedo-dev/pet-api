package com.daniel.pets.controller;


import com.daniel.pets.business.PetService;
import com.daniel.pets.client.PlayerClient;
import com.daniel.pets.infrastructure.entities.Pet;
import com.daniel.pets.infrastructure.entities.PetComPlayerDTO;
import com.daniel.pets.infrastructure.entities.PlayerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;
    private final PlayerClient playerClient;

    public PetController(PetService petService, PlayerClient playerClient) {
        this.petService = petService;
        this.playerClient = playerClient;
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

    @GetMapping("/{id}/com-player")
    public ResponseEntity<PetComPlayerDTO> getPetComPlayer(@PathVariable Integer id,
                                                           @RequestParam String playerId) {
        Pet pet = petService.buscarPetPorId(id);
        PlayerDTO player = playerClient.buscarPlayer(playerId);

        PetComPlayerDTO dto = new PetComPlayerDTO();
        dto.setId(pet.getId());
        dto.setNome(pet.getNome());
        dto.setIdade(pet.getIdade());
        dto.setPeso(pet.getPeso());
        dto.setSexo(pet.getSexo() != null ? pet.getSexo().name() : null);
        dto.setPlayer(player);

        return ResponseEntity.ok(dto);
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
