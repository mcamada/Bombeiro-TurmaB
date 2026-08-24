package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Instrutor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaInstrutores {

    private Stage stage;
    private TextField nome;
    private TextField especialidade;
    private RadioButton interno;
    private RadioButton externo;

    public TelaInstrutores(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Instrutores");
        titulo.setId("tituloTreinamentos");

        Label subtitulo = new Label("Cadastre instrutores internos e externos.");
        subtitulo.getStyleClass().add("subtitulo");

        nome = new TextField();
        nome.setPromptText("Nome");

        especialidade = new TextField();
        especialidade.setPromptText("Especialidade");

        interno = new RadioButton("Interno");
        externo = new RadioButton("Externo");

        ToggleGroup grupo = new ToggleGroup();
        interno.setToggleGroup(grupo);
        externo.setToggleGroup(grupo);
        interno.setSelected(true);

        HBox tipos = new HBox(10);
        tipos.getChildren().addAll(interno, externo);

        GridPane formulario = new GridPane();
        formulario.getStyleClass().add("formulario");
        formulario.setHgap(10);
        formulario.setVgap(10);
        formulario.add(new Label("Nome:"), 0, 0);
        formulario.add(nome, 1, 0);
        formulario.add(new Label("Especialidade:"), 0, 1);
        formulario.add(especialidade, 1, 1);
        formulario.add(new Label("Tipo:"), 0, 2);
        formulario.add(tipos, 1, 2);

        ListView<Instrutor> lista = new ListView<Instrutor>(App.instrutores);
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
                cadastrarInstrutor();
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

    private void cadastrarInstrutor() {
        if (nome.getText().isBlank()) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Informe o nome."
            );

            alerta.show();
            return;
        }

        String tipo = "Interno";

        if (externo.isSelected()) {
            tipo = "Externo";
        }

        Instrutor instrutor = new Instrutor(
                nome.getText(),
                especialidade.getText(),
                tipo
        );

        App.instrutores.add(instrutor);
        App.historico.add("Instrutor cadastrado: " + instrutor.getNome());

        nome.clear();
        especialidade.clear();
        interno.setSelected(true);
    }

    private void voltarDashboard() {
        TelaDashboard tela = new TelaDashboard(stage);

        stage.setScene(tela.criarCena());
        stage.setTitle("Painel - Treinamento e Capacitação");
    }
}
