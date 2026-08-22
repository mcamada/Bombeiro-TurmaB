package br.edu.ifc.treinoecapacitacao.model;

public class Participacao {
    private Bombeiro bombeiro;
    private Treinamento treinamento;
    private String status;
    private int frequencia;
    private int nota;

    public Participacao(Bombeiro bombeiro, Treinamento treinamento, String status,
            int frequencia, int nota) {
        this.bombeiro = bombeiro;
        this.treinamento = treinamento;
        this.status = status;
        this.frequencia = frequencia;
        this.nota = nota;
    }

    public Bombeiro getBombeiro() { return bombeiro; }
    public Treinamento getTreinamento() { return treinamento; }
    public String getStatus() { return status; }
    public int getFrequencia() { return frequencia; }
    public int getNota() { return nota; }
    public void setStatus(String status) { this.status = status; }
    public void setFrequencia(int frequencia) { this.frequencia = frequencia; }
    public void setNota(int nota) { this.nota = nota; }

    @Override
    public String toString() {
        return bombeiro.getNome() + " - " + treinamento.getNome() + " - " + status
                + " - Frequência: " + frequencia + "% - Nota: " + nota;
    }
}
