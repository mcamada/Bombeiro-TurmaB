package br.edu.ifc.treinoecapacitacao.model;

public class Instituicao {
    private String nome;
    private String cnpj;
    private String contato;

    public Instituicao(String nome, String cnpj, String contato) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
    }

    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }
    public String getContato() { return contato; }

    @Override
    public String toString() {
        return nome + " - " + cnpj + " - " + contato;
    }
}
