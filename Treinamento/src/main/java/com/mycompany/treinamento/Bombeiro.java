package com.mycompany.treinamento;

public class Bombeiro {
    
   
    private String nome;
    private String professor;
    private String dia;
    private String tipo;
    private String local;

    public Bombeiro(String nome, String professor, String dia, String tipo, String local) {
        this.nome = nome;
        this.professor = professor;
        this.dia = dia;
        this.tipo = tipo;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public String getProfessor() {
        return professor;
    }

    public String getDia() {
        return dia;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLocal() {
        return local;
    }
}