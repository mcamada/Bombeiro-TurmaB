package com.cad.despacho;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaConsultarOcorrencias {

    public VBox criar() {

        VBox raiz = new VBox();
        raiz.getChildren().add(new Label("CONSULTA DE OCORRENCIAS"));

        VBox tabela = new VBox();

        HBox cabecalho = new HBox();
        Label colId = new Label("ID");
        Label colTipo = new Label("TIPO DE OCORRENCIA");
        Label colLocal = new Label("LOCAL");
        Label colData = new Label("DATA/HORA");
        Label colPrioridade = new Label("PRIORIDADE");
        Label colStatus = new Label("STATUS");
        Label colViaturas = new Label("VIATURAS");
        cabecalho.getChildren().add(colId);
        cabecalho.getChildren().add(colTipo);
        cabecalho.getChildren().add(colLocal);
        cabecalho.getChildren().add(colData);
        cabecalho.getChildren().add(colPrioridade);
        cabecalho.getChildren().add(colStatus);
        cabecalho.getChildren().add(colViaturas);

        HBox linha1 = new HBox();
        Label l1a = new Label("#2026-0312");
        Label l1b = new Label("Incendio Florestal");
        Label l1c = new Label("Av. Santos Dumont, Km 4");
        Label l1d = new Label("09/05 - 14:15");
        Label l1e = new Label("ALTA");
        Label l1f = new Label("EM ATENDIMENTO");
        Label l1g = new Label("ABTR-05, ASU-12");
        linha1.getChildren().add(l1a);
        linha1.getChildren().add(l1b);
        linha1.getChildren().add(l1c);
        linha1.getChildren().add(l1d);
        linha1.getChildren().add(l1e);
        linha1.getChildren().add(l1f);
        linha1.getChildren().add(l1g);

        HBox linha2 = new HBox();
        Label l2a = new Label("#2026-0311");
        Label l2b = new Label("Colisao de Veiculos");
        Label l2c = new Label("Rua Blumenau, 482");
        Label l2d = new Label("09/05 - 13:58");
        Label l2e = new Label("MEDIA");
        Label l2f = new Label("EM ATENDIMENTO");
        Label l2g = new Label("UR-03, ASU-03");
        linha2.getChildren().add(l2a);
        linha2.getChildren().add(l2b);
        linha2.getChildren().add(l2c);
        linha2.getChildren().add(l2d);
        linha2.getChildren().add(l2e);
        linha2.getChildren().add(l2f);
        linha2.getChildren().add(l2g);

        HBox linha3 = new HBox();
        Label l3a = new Label("#2026-0310");
        Label l3b = new Label("Atendimento Clinico");
        Label l3c = new Label("Rua Copacabana, 12");
        Label l3d = new Label("09/05 - 13:40");
        Label l3e = new Label("MEDIA");
        Label l3f = new Label("CONCLUIDA");
        Label l3g = new Label("ASU-01");
        linha3.getChildren().add(l3a);
        linha3.getChildren().add(l3b);
        linha3.getChildren().add(l3c);
        linha3.getChildren().add(l3d);
        linha3.getChildren().add(l3e);
        linha3.getChildren().add(l3f);
        linha3.getChildren().add(l3g);

        HBox linha4 = new HBox();
        Label l4a = new Label("#2026-0309");
        Label l4b = new Label("Incendio Residencial");
        Label l4c = new Label("Rua XV de Novembro, 1024");
        Label l4d = new Label("09/05 - 13:12");
        Label l4e = new Label("ALTA");
        Label l4f = new Label("CONCLUIDA");
        Label l4g = new Label("ABTR-05, ABTR-02");
        linha4.getChildren().add(l4a);
        linha4.getChildren().add(l4b);
        linha4.getChildren().add(l4c);
        linha4.getChildren().add(l4d);
        linha4.getChildren().add(l4e);
        linha4.getChildren().add(l4f);
        linha4.getChildren().add(l4g);

        HBox linha5 = new HBox();
        Label l5a = new Label("#2026-0308");
        Label l5b = new Label("Resgate de Animal");
        Label l5c = new Label("Parque da Cidade");
        Label l5d = new Label("09/05 - 12:45");
        Label l5e = new Label("BAIXA");
        Label l5f = new Label("CONCLUIDA");
        Label l5g = new Label("M-04");
        linha5.getChildren().add(l5a);
        linha5.getChildren().add(l5b);
        linha5.getChildren().add(l5c);
        linha5.getChildren().add(l5d);
        linha5.getChildren().add(l5e);
        linha5.getChildren().add(l5f);
        linha5.getChildren().add(l5g);

        tabela.getChildren().add(cabecalho);
        tabela.getChildren().add(linha1);
        tabela.getChildren().add(linha2);
        tabela.getChildren().add(linha3);
        tabela.getChildren().add(linha4);
        tabela.getChildren().add(linha5);

        raiz.getChildren().add(tabela);

        return raiz;
    }
}
