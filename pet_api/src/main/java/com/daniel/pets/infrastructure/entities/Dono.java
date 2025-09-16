package com.daniel.pets.infrastructure.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "dono")
    private List<Pet> pets;

    public Dono(){}

    public Dono(Integer id, String nome, String email, String telefone, List<Pet> pets) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.pets = pets;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public List<Pet> getPets() {return pets;}
    public void setPets(List<Pet> pets) {this.pets = pets;}
}
