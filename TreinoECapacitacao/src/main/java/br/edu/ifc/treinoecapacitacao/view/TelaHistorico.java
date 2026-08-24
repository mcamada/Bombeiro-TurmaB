package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
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

public class TelaHistorico {

    private Stage stage;

    public TelaHistorico(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Histórico");
        titulo.setId("tituloTreinamentos");

        Label subtitulo = new Label("Operações realizadas no sistema");
        subtitulo.getStyleClass().add("subtitulo");

        ListView<String> lista = new ListView<String>(App.historico);
        lista.setPrefHeight(380);

        Button voltar = new Button("Voltar");

        VBox painel = new VBox(12);
        painel.getStyleClass().add("painel-pagina");
        painel.getChildren().addAll(lista, voltar);

        VBox raiz = new VBox(10);
        raiz.getStyleClass().add("pagina");
        raiz.setPadding(new Insets(25));
        raiz.setAlignment(Pos.TOP_CENTER);
        raiz.getChildren().addAll(titulo, subtitulo, painel);

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TelaDashboard tela = new TelaDashboard(stage);

                stage.setScene(tela.criarCena());
                stage.setTitle("Painel - Treinamento e Capacitação");
            }
        });

        Scene scene = new Scene(raiz, 760, 560);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }
}
