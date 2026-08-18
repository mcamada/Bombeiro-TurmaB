package br.edu.ifc.treinoecapacitacao.model;

public class Treinamento {

    private String nome;
    private String tipo;
    private String descricao;
    private int cargaHoraria;
    private String dataInicio;
    private String dataFim;
    private String instrutor;
    private String instituicao;
    private String local;
    private String status;

    public Treinamento(String nome, String tipo, String descricao, int cargaHoraria,
            String dataInicio, String dataFim, String instrutor,
            String instituicao, String local) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.instrutor = instrutor;
        this.instituicao = instituicao;
        this.local = local;
        this.status = "Planejado";
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public String getLocal() {
        return local;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return nome + " - " + tipo + " - " + dataInicio + " - " + status;
    }
}
