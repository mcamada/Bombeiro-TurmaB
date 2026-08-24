package br.edu.ifc.treinoecapacitacao.model;

public class Bombeiro {

    private String nome;
    private String cpf;
    private String matricula;
    private String dataNascimento;
    private String patente;
    private String especialidade;
    private String contato;
    private String status;

    public Bombeiro(
            String nome,
            String cpf,
            String matricula,
            String dataNascimento,
            String patente,
            String especialidade,
            String contato,
            String status
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.patente = patente;
        this.especialidade = especialidade;
        this.contato = contato;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getPatente() {
        return patente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getContato() {
        return contato;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return nome + " - " + matricula + " - " + patente + " - " + status;
    }
}
