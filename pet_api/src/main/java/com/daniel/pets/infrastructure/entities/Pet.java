package com.daniel.pets.infrastructure.entities;

import jakarta.persistence.*;

@Table(name = "pet_table")
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;
    private Float peso;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @ManyToOne
    @JoinColumn(name = "dono_id")
    private Dono dono;

    public Pet() {}

    public Pet(Integer id, String nome, Integer idade, Float peso, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.sexo = sexo;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public Float getPeso() { return peso; }
    public void setPeso(Float peso) { this.peso = peso; }

    public Sexo getSexo() { return sexo; }
    public void setSexo(Sexo sexo) { this.sexo = sexo; }

    public Dono getDono() { return dono; }
    public void setDono(Dono dono) { this.dono = dono; }

    public enum Sexo {
        MASCULINO,
        FEMININO
    }
}
