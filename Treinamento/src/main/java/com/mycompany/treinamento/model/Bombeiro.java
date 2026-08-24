package com.mycompany.treinamento.model;

public class Bombeiro {

    private String nome;
    private String matricula;
    private String patente;
    private String especialidade;
    private String status;

    public Bombeiro(String nome, String matricula, String patente, String especialidade, String status) {
        this.nome = nome;
        this.matricula = matricula;
        this.patente = patente;
        this.especialidade = especialidade;
        this.status = status;
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getPatente() { return patente; }
    public String getEspecialidade() { return especialidade; }
    public String getStatus() { return status; }
}
