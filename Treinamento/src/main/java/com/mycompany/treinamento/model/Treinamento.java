package com.mycompany.treinamento.model;

public class Treinamento {

    private String nome;
    private String tipo;
    private String data;
    private String carga;
    private String instrutor;
    private String local;

    public Treinamento(String nome, String tipo, String data, String carga, String instrutor, String local) {
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.carga = carga;
        this.instrutor = instrutor;
        this.local = local;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public String getData() { return data; }
    public String getCarga() { return carga; }
    public String getInstrutor() { return instrutor; }
    public String getLocal() { return local; }
}
