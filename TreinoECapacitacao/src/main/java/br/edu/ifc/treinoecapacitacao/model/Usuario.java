package br.edu.ifc.treinoecapacitacao.model;

public class Usuario {
    private String login;
    private String senha;
    private String perfil;

    public Usuario(String login, String senha, String perfil) {
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public String getPerfil() { return perfil; }

    @Override
    public String toString() {
        return login + " - " + perfil;
    }
}
