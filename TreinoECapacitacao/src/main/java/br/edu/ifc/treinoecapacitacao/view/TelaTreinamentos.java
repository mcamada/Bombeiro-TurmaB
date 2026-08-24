package br.edu.ifc.treinoecapacitacao.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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

        Label subtitulo = new Label("Gerenciamento de treinamentos e capacitações");
        subtitulo.getStyleClass().add("subtitulo");

        Button cadastrar = new Button("Cadastrar treinamento");
        cadastrar.getStyleClass().add("botao-principal");
        cadastrar.getStyleClass().add("botao-grande");

        Button consultar = new Button("Consultar treinamentos");
        consultar.getStyleClass().add("botao-grande");

        Button participacoes = new Button("Participações");
        participacoes.getStyleClass().add("botao-grande");

        Button certificados = new Button("Certificados");
        certificados.getStyleClass().add("botao-grande");

        GridPane acoes = new GridPane();
        acoes.getStyleClass().add("painel");
        acoes.setHgap(12);
        acoes.setVgap(12);
        acoes.setAlignment(Pos.CENTER);
        acoes.add(cadastrar, 0, 0);
        acoes.add(consultar, 1, 0);
        acoes.add(participacoes, 0, 1);
        acoes.add(certificados, 1, 1);

        Button voltar = new Button("Voltar ao painel");

        VBox raiz = new VBox(15);
        raiz.getStyleClass().add("pagina");
        raiz.setAlignment(Pos.TOP_CENTER);
        raiz.setPadding(new Insets(35));
        raiz.getChildren().addAll(
                titulo,
                subtitulo,
                acoes,
                voltar
        );

        cadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaCadastroTreinamento(stage).criarCena(),
                        "Cadastrar Treinamento"
                );
            }
        });

        consultar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaConsultaTreinamentos(stage).criarCena(),
                        "Consultar Treinamentos"
                );
            }
        });

        participacoes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaParticipacoes(stage).criarCena(),
                        "Participações"
                );
            }
        });

        certificados.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaCertificados(stage).criarCena(),
                        "Certificados"
                );
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaDashboard(stage).criarCena(),
                        "Painel - Treinamento e Capacitação"
                );
            }
        });

        Scene scene = new Scene(raiz, 760, 520);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private void abrirTela(Scene scene, String titulo) {
        stage.setScene(scene);
        stage.setTitle(titulo);
    }
}
