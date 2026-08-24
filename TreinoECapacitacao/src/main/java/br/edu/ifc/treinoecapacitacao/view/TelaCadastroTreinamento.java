package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCadastroTreinamento {

    private Stage stage;
    private TextField nome;
    private TextField inicio;
    private TextField fim;
    private TextField instrutor;
    private TextField instituicao;
    private TextField local;
    private TextArea descricao;
    private Spinner<Integer> carga;
    private RadioButton interno;
    private RadioButton externo;

    public TelaCadastroTreinamento(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Cadastrar treinamento");
        titulo.setId("tituloTreinamentos");

        Label subtitulo = new Label("Preencha as informações da capacitação.");
        subtitulo.getStyleClass().add("subtitulo");

        nome = new TextField();
        nome.setPromptText("Nome do treinamento");

        descricao = new TextArea();
        descricao.setPromptText("Objetivo e conteúdo do treinamento");
        descricao.setPrefRowCount(3);
        descricao.setWrapText(true);

        interno = new RadioButton("Interno");
        externo = new RadioButton("Externo");

        ToggleGroup grupoTipo = new ToggleGroup();
        interno.setToggleGroup(grupoTipo);
        externo.setToggleGroup(grupoTipo);
        interno.setSelected(true);

        HBox tipos = new HBox(10);
        tipos.getChildren().addAll(interno, externo);

        carga = new Spinner<Integer>(1, 300, 1);

        inicio = new TextField();
        inicio.setPromptText("dd/mm/aaaa");

        fim = new TextField();
        fim.setPromptText("dd/mm/aaaa");

        instrutor = new TextField();
        instrutor.setPromptText("Nome do instrutor");

        instituicao = new TextField();
        instituicao.setPromptText("Instituição responsável");
        instituicao.setDisable(true);

        local = new TextField();
        local.setPromptText("Local de realização");

        GridPane formulario = new GridPane();
        formulario.getStyleClass().add("formulario");
        formulario.setHgap(12);
        formulario.setVgap(10);
        formulario.setAlignment(Pos.CENTER);

        formulario.add(new Label("Nome:"), 0, 0);
        formulario.add(nome, 1, 0);
        formulario.add(new Label("Tipo:"), 0, 1);
        formulario.add(tipos, 1, 1);
        formulario.add(new Label("Descrição:"), 0, 2);
        formulario.add(descricao, 1, 2);
        formulario.add(new Label("Carga horária:"), 0, 3);
        formulario.add(carga, 1, 3);
        formulario.add(new Label("Data início:"), 0, 4);
        formulario.add(inicio, 1, 4);
        formulario.add(new Label("Data fim:"), 0, 5);
        formulario.add(fim, 1, 5);
        formulario.add(new Label("Instrutor:"), 0, 6);
        formulario.add(instrutor, 1, 6);
        formulario.add(new Label("Instituição:"), 0, 7);
        formulario.add(instituicao, 1, 7);
        formulario.add(new Label("Local:"), 0, 8);
        formulario.add(local, 1, 8);

        Button cadastrar = new Button("Cadastrar");
        cadastrar.getStyleClass().add("botao-principal");

        Button limpar = new Button("Limpar");
        Button voltar = new Button("Voltar");

        ButtonBar barra = new ButtonBar();
        barra.getButtons().addAll(voltar, limpar, cadastrar);

        VBox painel = new VBox(14);
        painel.getStyleClass().add("painel-pagina");
        painel.getChildren().addAll(formulario, barra);

        VBox raiz = new VBox(10);
        raiz.getStyleClass().add("pagina");
        raiz.setAlignment(Pos.TOP_CENTER);
        raiz.setPadding(new Insets(28));
        raiz.getChildren().addAll(titulo, subtitulo, painel);

        interno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                instituicao.clear();
                instituicao.setDisable(true);
            }
        });

        externo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                instituicao.setDisable(false);
            }
        });

        cadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cadastrar();
            }
        });

        limpar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                limpar();
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TelaTreinamentos tela = new TelaTreinamentos(stage);

                stage.setScene(tela.criarCena());
                stage.setTitle("Treinamentos");
            }
        });

        Scene scene = new Scene(raiz, 720, 720);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private void cadastrar() {
        boolean nomeVazio = nome.getText().isBlank();
        boolean inicioVazio = inicio.getText().isBlank();
        boolean fimVazio = fim.getText().isBlank();
        boolean instrutorVazio = instrutor.getText().isBlank();
        boolean localVazio = local.getText().isBlank();

        if (nomeVazio || inicioVazio || fimVazio || instrutorVazio || localVazio) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Preencha os campos obrigatórios."
            );

            alerta.show();
            return;
        }

        if (externo.isSelected() && instituicao.getText().isBlank()) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Treinamento externo precisa de instituição."
            );

            alerta.show();
            return;
        }

        String tipo = "Interno";
        String nomeInstituicao = "";

        if (externo.isSelected()) {
            tipo = "Externo";
            nomeInstituicao = instituicao.getText();
        }

        Treinamento treinamento = new Treinamento(
                nome.getText(),
                tipo,
                descricao.getText(),
                carga.getValue(),
                inicio.getText(),
                fim.getText(),
                instrutor.getText(),
                nomeInstituicao,
                local.getText()
        );

        App.treinamentos.add(treinamento);
        App.historico.add("Treinamento cadastrado: " + treinamento.getNome());

        Alert alerta = new Alert(
                Alert.AlertType.INFORMATION,
                "Treinamento cadastrado."
        );

        alerta.show();
        limpar();
    }

    private void limpar() {
        nome.clear();
        descricao.clear();
        carga.getValueFactory().setValue(1);
        inicio.clear();
        fim.clear();
        instrutor.clear();
        instituicao.clear();
        local.clear();
        interno.setSelected(true);
        instituicao.setDisable(true);
    }
}
