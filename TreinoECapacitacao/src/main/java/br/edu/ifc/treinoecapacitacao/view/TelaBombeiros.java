package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Bombeiro;
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

public class TelaBombeiros {

    private Stage stage;
    private TextField nome;
    private TextField cpf;
    private TextField matricula;
    private TextField nascimento;
    private TextField patente;
    private TextField especialidade;
    private TextField contato;
    private RadioButton ativo;
    private RadioButton afastado;
    private RadioButton inativo;

    public TelaBombeiros(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Bombeiros");
        titulo.setId("tituloTreinamentos");

        Label subtitulo = new Label("Cadastre e consulte os bombeiros disponíveis.");
        subtitulo.getStyleClass().add("subtitulo");

        criarCampos();

        GridPane formulario = criarFormulario();

        Button cadastrar = new Button("Cadastrar");
        cadastrar.getStyleClass().add("botao-principal");

        Button voltar = new Button("Voltar");

        HBox botoes = new HBox(8);
        botoes.getChildren().addAll(cadastrar, voltar);

        ListView<Bombeiro> lista = new ListView<Bombeiro>(App.bombeiros);
        lista.setPrefHeight(220);

        VBox painel = new VBox(12);
        painel.getStyleClass().add("painel-pagina");
        painel.getChildren().addAll(
                formulario,
                botoes,
                new Label("Bombeiros cadastrados"),
                lista
        );

        VBox raiz = new VBox(10);
        raiz.getStyleClass().add("pagina");
        raiz.setPadding(new Insets(24));
        raiz.setAlignment(Pos.TOP_CENTER);
        raiz.getChildren().addAll(titulo, subtitulo, painel);

        cadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cadastrarBombeiro();
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TelaDashboard tela = new TelaDashboard(stage);

                stage.setScene(tela.criarCena());
                stage.setTitle("Painel - Treinamento e Capacitação");
            }
        });

        Scene scene = new Scene(raiz, 780, 720);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private void criarCampos() {
        nome = new TextField();
        nome.setPromptText("Nome");

        cpf = new TextField();
        cpf.setPromptText("CPF");

        matricula = new TextField();
        matricula.setPromptText("Matrícula");

        nascimento = new TextField();
        nascimento.setPromptText("dd/mm/aaaa");

        patente = new TextField();
        patente.setPromptText("Patente");

        especialidade = new TextField();
        especialidade.setPromptText("Especialidade");

        contato = new TextField();
        contato.setPromptText("Contato");

        ativo = new RadioButton("Ativo");
        afastado = new RadioButton("Afastado");
        inativo = new RadioButton("Inativo");

        ToggleGroup grupo = new ToggleGroup();
        ativo.setToggleGroup(grupo);
        afastado.setToggleGroup(grupo);
        inativo.setToggleGroup(grupo);
        ativo.setSelected(true);
    }

    private GridPane criarFormulario() {
        HBox status = new HBox(8);
        status.getChildren().addAll(ativo, afastado, inativo);

        GridPane formulario = new GridPane();
        formulario.getStyleClass().add("formulario");
        formulario.setHgap(10);
        formulario.setVgap(9);
        formulario.add(new Label("Nome:"), 0, 0);
        formulario.add(nome, 1, 0);
        formulario.add(new Label("CPF:"), 0, 1);
        formulario.add(cpf, 1, 1);
        formulario.add(new Label("Matrícula:"), 0, 2);
        formulario.add(matricula, 1, 2);
        formulario.add(new Label("Nascimento:"), 0, 3);
        formulario.add(nascimento, 1, 3);
        formulario.add(new Label("Patente:"), 0, 4);
        formulario.add(patente, 1, 4);
        formulario.add(new Label("Especialidade:"), 0, 5);
        formulario.add(especialidade, 1, 5);
        formulario.add(new Label("Contato:"), 0, 6);
        formulario.add(contato, 1, 6);
        formulario.add(new Label("Status:"), 0, 7);
        formulario.add(status, 1, 7);

        return formulario;
    }

    private void cadastrarBombeiro() {
        if (nome.getText().isBlank() || matricula.getText().isBlank()) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Informe nome e matrícula."
            );

            alerta.show();
            return;
        }

        String status = "Ativo";

        if (afastado.isSelected()) {
            status = "Afastado";
        }

        if (inativo.isSelected()) {
            status = "Inativo";
        }

        Bombeiro bombeiro = new Bombeiro(
                nome.getText(),
                cpf.getText(),
                matricula.getText(),
                nascimento.getText(),
                patente.getText(),
                especialidade.getText(),
                contato.getText(),
                status
        );

        App.bombeiros.add(bombeiro);
        App.historico.add("Bombeiro cadastrado: " + bombeiro.getNome());

        limparCampos();
    }

    private void limparCampos() {
        nome.clear();
        cpf.clear();
        matricula.clear();
        nascimento.clear();
        patente.clear();
        especialidade.clear();
        contato.clear();
        ativo.setSelected(true);
    }
}
