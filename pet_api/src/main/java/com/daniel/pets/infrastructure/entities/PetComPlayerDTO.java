package com.daniel.pets.infrastructure.entities;

public class PetComPlayerDTO {
    private Integer id;
    private String nome;
    private Integer idade;
    private Float peso;
    private String sexo;
    private PlayerDTO player;

    public PetComPlayerDTO() {}

    public PetComPlayerDTO(Integer id, String nome, Integer idade, Float peso, String sexo, PlayerDTO player) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.sexo = sexo;
        this.player = player;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public Float getPeso() { return peso; }
    public void setPeso(Float peso) { this.peso = peso; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public PlayerDTO getPlayer() { return player; }
    public void setPlayer(PlayerDTO player) { this.player = player; }
}
