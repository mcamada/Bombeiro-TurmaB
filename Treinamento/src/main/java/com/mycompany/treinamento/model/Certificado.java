package com.mycompany.treinamento.model;

public class Certificado {

    private String bombeiro;
    private String treinamento;
    private String data;
    private String carga;

    public Certificado(String bombeiro, String treinamento, String data, String carga) {
        this.bombeiro = bombeiro;
        this.treinamento = treinamento;
        this.data = data;
        this.carga = carga;
    }

    public String getBombeiro() { return bombeiro; }
    public String getTreinamento() { return treinamento; }
    public String getData() { return data; }
    public String getCarga() { return carga; }
}

