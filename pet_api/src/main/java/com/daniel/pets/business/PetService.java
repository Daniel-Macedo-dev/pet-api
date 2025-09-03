package com.daniel.pets.business;

import com.daniel.pets.infrastructure.entities.Pet;
import com.daniel.pets.infrastructure.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {this.petRepository = petRepository;}

    public Pet salvarPet(Pet pet){
        return petRepository.saveAndFlush(pet);
    }

    public List<Pet> listarPets(){
        return petRepository.findAll();
    }

    public Pet buscarPetPorId(Integer id){
        return petRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado")
        );
    }

    public Pet substituirPet(Integer id, Pet novoPet){
        Pet petBusca = petRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado"));
        petBusca.setNome(novoPet.getNome());
        petBusca.setIdade(novoPet.getIdade());
        petBusca.setPeso(novoPet.getPeso());
        petBusca.setSexo(novoPet.getSexo());

        return petRepository.saveAndFlush(petBusca);
    }

    public Pet atualizarPet(Integer id, Pet novoPet){
        Pet petBusca = petRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado"));
        if (novoPet.getPeso() != null) {
            petBusca.setPeso(novoPet.getPeso());
        }
        if (novoPet.getIdade() != null) {
            petBusca.setIdade(novoPet.getIdade());
        }

        return petRepository.saveAndFlush(petBusca);
    }

    public void deletarPetPorId(Integer id){
        petRepository.deleteById(id);
    }

}
