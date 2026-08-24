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
    private boolean ativo;

    public Treinamento(
            String nome,
            String tipo,
            String descricao,
            int cargaHoraria,
            String dataInicio,
            String dataFim,
            String instrutor,
            String instituicao,
            String local
    ) {
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
        this.ativo = true;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        String situacao;

        if (ativo) {
            situacao = status;
        } else {
            situacao = "Inativo";
        }

        return nome + " - " + tipo + " - " + dataInicio + " - " + situacao;
    }
}
