package br.edu.ifc.treinoecapacitacao.model;

public class Certificado {
    private Participacao participacao;
    private String dataEmissao;
    private int cargaHoraria;

    public Certificado(Participacao participacao, String dataEmissao, int cargaHoraria) {
        this.participacao = participacao;
        this.dataEmissao = dataEmissao;
        this.cargaHoraria = cargaHoraria;
    }

    public Participacao getParticipacao() { return participacao; }
    public String getDataEmissao() { return dataEmissao; }
    public int getCargaHoraria() { return cargaHoraria; }

    @Override
    public String toString() {
        return participacao.getBombeiro().getNome() + " - "
                + participacao.getTreinamento().getNome() + " - "
                + dataEmissao + " - " + cargaHoraria + "h";
    }
}
