package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaConsultaTreinamentos {

    private Stage stage;

    public TelaConsultaTreinamentos(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Consultar treinamentos");
        titulo.setId("tituloTreinamentos");

        Label descricao = new Label("Treinamentos cadastrados no sistema");
        descricao.getStyleClass().add("texto-secundario");

        ListView<Treinamento> listaTreinamentos
                = new ListView<Treinamento>(App.treinamentos);
        listaTreinamentos.setPrefHeight(260);
        listaTreinamentos.getStyleClass().add("lista-treinamentos");

        Button botaoVoltar = new Button("Voltar");

        botaoVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TelaTreinamentos telaTreinamentos = new TelaTreinamentos(stage);
                stage.setScene(telaTreinamentos.criarCena());
                stage.setTitle("Treinamentos");
            }
        });

        VBox raiz = new VBox(15);
        raiz.setAlignment(Pos.TOP_CENTER);
        raiz.setPadding(new Insets(30));
        raiz.getChildren().addAll(
                titulo,
                descricao,
                listaTreinamentos,
                botaoVoltar
        );

        Scene scene = new Scene(raiz, 650, 450);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }
}
