package com.cad.despacho;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaComunicacao {

    public VBox criar() {

        VBox raiz = new VBox();
        raiz.getChildren().add(new Label("CENTRAL DE RADIO E TEXTO COBOM"));

        VBox painelViaturas = new VBox();

        Label tituloViaturas = new Label("VIATURAS ATIVAS");
        VBox listaViaturas = new VBox();
        listaViaturas.getChildren().add(new Label("ABTR-05"));
        listaViaturas.getChildren().add(new Label("ASU-12"));
        listaViaturas.getChildren().add(new Label("UR-03"));

        painelViaturas.getChildren().add(tituloViaturas);
        painelViaturas.getChildren().add(listaViaturas);

        VBox painelRecursos = new VBox();

        Label tituloRecursos = new Label("DISPOSICAO DE RECURSOS");

        Label labelCanais = new Label("CANAIS DE RADIO ATIVOS");
        VBox canais = new VBox();
        canais.getChildren().add(new Label("A-2"));
        canais.getChildren().add(new Label("B-1"));
        canais.getChildren().add(new Label("C-4"));
        canais.getChildren().add(new Label("F-12"));

        Label labelUnidades = new Label("UNIDADES ALOCADAS");
        VBox unidades = new VBox();
        unidades.getChildren().add(new Label("ASU-01"));
        unidades.getChildren().add(new Label("ABTR-02"));
        unidades.getChildren().add(new Label("ASU-03"));
        unidades.getChildren().add(new Label("M-04"));

        painelRecursos.getChildren().add(tituloRecursos);
        painelRecursos.getChildren().add(labelCanais);
        painelRecursos.getChildren().add(canais);
        painelRecursos.getChildren().add(labelUnidades);
        painelRecursos.getChildren().add(unidades);

        HBox area = new HBox(painelViaturas, painelRecursos);

        raiz.getChildren().add(area);

        return raiz;
    }
}
