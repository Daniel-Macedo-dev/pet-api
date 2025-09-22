package com.daniel.pets.controller;

import com.daniel.pets.business.DonoService;
import com.daniel.pets.infrastructure.entities.Dono;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dono")
public class DonoController {

    private final DonoService donoService;

    public DonoController(DonoService donoService) {this.donoService = donoService;}

    @PostMapping
    public ResponseEntity<Dono> save(@RequestBody Dono dono){
        Dono novoDono = donoService.salvarDono(dono);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDono);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dono> findById(@PathVariable Integer id){
        Dono dono = donoService.buscarDonoPorId(id);
        return ResponseEntity.ok(dono);
    }

    @GetMapping
    public ResponseEntity<List<Dono>> findAll(Integer id){
        return ResponseEntity.ok(donoService.listarDonos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Integer id){
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dono> replaceDono (@PathVariable Integer id,
                                             @RequestBody Dono novoDono){
        Dono substituido = donoService.substituirDono(id, novoDono);
        return ResponseEntity.ok(substituido);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Dono> updateDono(@PathVariable Integer id,
                                           @RequestBody Dono novoDono){
        Dono atualizado = donoService.atualizarDono(id, novoDono);
        return ResponseEntity.ok(atualizado);
    }
}
