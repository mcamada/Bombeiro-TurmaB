package br.edu.ifc.treinoecapacitacao.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaTreinamentos {

    private Stage stage;

    public TelaTreinamentos(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Treinamentos");
        titulo.setId("tituloTreinamentos");

        Label descricao = new Label("Gerenciamento de treinamentos e capacitações");
        descricao.getStyleClass().add("texto-secundario");

        Button botaoCadastrar = new Button("Cadastrar treinamento");
        Button botaoConsultar = new Button("Consultar treinamentos");
        Button botaoVoltar = new Button("Voltar");

        botaoCadastrar.getStyleClass().add("botao-principal");
        botaoConsultar.getStyleClass().add("botao-principal");

        botaoVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TelaDashboard dashboard = new TelaDashboard(stage);
                stage.setScene(dashboard.criarCena());
                stage.setTitle("Painel - Treinamento e Capacitação");
            }
        });

        VBox raiz = new VBox(15);
        raiz.setAlignment(Pos.CENTER);
        raiz.setPadding(new Insets(30));
        raiz.getChildren().addAll(
                titulo,
                descricao,
                botaoCadastrar,
                botaoConsultar,
                botaoVoltar
        );

        Scene scene = new Scene(raiz, 600, 420);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }
}
