package com.daniel.pets.business;

import com.daniel.pets.infrastructure.entities.Dono;
import com.daniel.pets.infrastructure.repository.DonoReposository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonoService {

    private final DonoReposository donoReposository;

    public DonoService(DonoReposository donoReposository) {this.donoReposository = donoReposository;}

    public Dono salvarDono(Dono dono){return donoReposository.saveAndFlush(dono);}

    public List<Dono> listarDonos(){return donoReposository.findAll();}

    public Dono buscarDonoPorId(Integer id){
        return donoReposository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado")
        );
    }


    public Dono substituirDono(Integer id, Dono novoDono){
        Dono donoExistente = donoReposository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado")
        );
        donoExistente.setNome(novoDono.getNome());
        donoExistente.setEmail(novoDono.getEmail());
        donoExistente.setTelefone(novoDono.getTelefone());

        return donoReposository.saveAndFlush(donoExistente);
    }

    public Dono atualizarDono(Integer id, Dono novoDono){
        Dono donoExistente = donoReposository.findById(id).orElseThrow(
                () -> new RuntimeException("id não encontrado")
        );
        donoExistente.setEmail(novoDono.getEmail());
        donoExistente.setTelefone(novoDono.getTelefone());

        return donoReposository.saveAndFlush(donoExistente);
    }

    public void deletarDonoPorId(Integer id){donoReposository.deleteById(id);}



}
