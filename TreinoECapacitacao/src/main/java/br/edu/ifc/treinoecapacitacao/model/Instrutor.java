package br.edu.ifc.treinoecapacitacao.model;

public class Instrutor {

    private String nome;
    private String especialidade;
    private String tipo;

    public Instrutor(String nome, String especialidade, String tipo) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nome + " - " + especialidade + " - " + tipo;
    }
}
