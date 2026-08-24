package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Instituicao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaInstituicoes {

    private Stage stage;
    private TextField nome;
    private TextField cnpj;
    private TextField contato;

    public TelaInstituicoes(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Instituições");
        titulo.setId("tituloTreinamentos");

        Label subtitulo = new Label("Cadastre instituições responsáveis por treinamentos externos.");
        subtitulo.getStyleClass().add("subtitulo");

        nome = new TextField();
        nome.setPromptText("Nome");

        cnpj = new TextField();
        cnpj.setPromptText("CNPJ");

        contato = new TextField();
        contato.setPromptText("Contato");

        GridPane formulario = new GridPane();
        formulario.getStyleClass().add("formulario");
        formulario.setHgap(10);
        formulario.setVgap(10);
        formulario.add(new Label("Nome:"), 0, 0);
        formulario.add(nome, 1, 0);
        formulario.add(new Label("CNPJ:"), 0, 1);
        formulario.add(cnpj, 1, 1);
        formulario.add(new Label("Contato:"), 0, 2);
        formulario.add(contato, 1, 2);

        ListView<Instituicao> lista = new ListView<Instituicao>(App.instituicoes);
        lista.setPrefHeight(240);

        Button cadastrar = new Button("Cadastrar");
        cadastrar.getStyleClass().add("botao-principal");

        Button voltar = new Button("Voltar");

        HBox botoes = new HBox(8);
        botoes.getChildren().addAll(cadastrar, voltar);

        VBox painel = new VBox(12);
        painel.getStyleClass().add("painel-pagina");
        painel.getChildren().addAll(formulario, botoes, lista);

        VBox raiz = new VBox(10);
        raiz.getStyleClass().add("pagina");
        raiz.setPadding(new Insets(25));
        raiz.setAlignment(Pos.TOP_CENTER);
        raiz.getChildren().addAll(titulo, subtitulo, painel);

        cadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cadastrarInstituicao();
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                voltarDashboard();
            }
        });

        Scene scene = new Scene(raiz, 700, 560);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private void cadastrarInstituicao() {
        if (nome.getText().isBlank()) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Informe o nome da instituição."
            );

            alerta.show();
            return;
        }

        Instituicao instituicao = new Instituicao(
                nome.getText(),
                cnpj.getText(),
                contato.getText()
        );

        App.instituicoes.add(instituicao);
        App.historico.add("Instituição cadastrada: " + instituicao.getNome());

        nome.clear();
        cnpj.clear();
        contato.clear();
    }

    private void voltarDashboard() {
        TelaDashboard tela = new TelaDashboard(stage);

        stage.setScene(tela.criarCena());
        stage.setTitle("Painel - Treinamento e Capacitação");
    }
}
