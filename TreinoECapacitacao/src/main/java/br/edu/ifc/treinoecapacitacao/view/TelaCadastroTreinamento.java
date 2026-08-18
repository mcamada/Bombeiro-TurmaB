package br.edu.ifc.treinoecapacitacao.view;

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

    private TextField campoNome;
    private TextArea campoDescricao;
    private Spinner<Integer> campoCargaHoraria;
    private TextField campoDataInicio;
    private TextField campoDataFim;
    private TextField campoInstrutor;
    private TextField campoInstituicao;
    private TextField campoLocal;

    private RadioButton tipoInterno;
    private RadioButton tipoExterno;

    public TelaCadastroTreinamento(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Cadastrar treinamento");
        titulo.setId("tituloTreinamentos");

        Label subtitulo = new Label("Informe os dados básicos do treinamento");
        subtitulo.getStyleClass().add("texto-secundario");

        campoNome = new TextField();
        campoNome.setPromptText("Nome do treinamento");

        campoDescricao = new TextArea();
        campoDescricao.setPromptText("Descrição");
        campoDescricao.setPrefRowCount(3);
        campoDescricao.setWrapText(true);

        tipoInterno = new RadioButton("Interno");
        tipoExterno = new RadioButton("Externo");

        ToggleGroup grupoTipo = new ToggleGroup();
        tipoInterno.setToggleGroup(grupoTipo);
        tipoExterno.setToggleGroup(grupoTipo);
        tipoInterno.setSelected(true);

        HBox tipos = new HBox(10);
        tipos.getChildren().addAll(tipoInterno, tipoExterno);

        campoCargaHoraria = new Spinner<Integer>(1, 300, 1);

        campoDataInicio = new TextField();
        campoDataInicio.setPromptText("dd/mm/aaaa");

        campoDataFim = new TextField();
        campoDataFim.setPromptText("dd/mm/aaaa");

        campoInstrutor = new TextField();
        campoInstrutor.setPromptText("Nome do instrutor");

        campoInstituicao = new TextField();
        campoInstituicao.setPromptText("Instituição responsável");
        campoInstituicao.setDisable(true);

        campoLocal = new TextField();
        campoLocal.setPromptText("Local de realização");

        GridPane formulario = new GridPane();
        formulario.setHgap(12);
        formulario.setVgap(10);
        formulario.setAlignment(Pos.CENTER);
        formulario.getStyleClass().add("formulario");

        formulario.add(new Label("Nome:"), 0, 0);
        formulario.add(campoNome, 1, 0);

        formulario.add(new Label("Tipo:"), 0, 1);
        formulario.add(tipos, 1, 1);

        formulario.add(new Label("Descrição:"), 0, 2);
        formulario.add(campoDescricao, 1, 2);

        formulario.add(new Label("Carga horária:"), 0, 3);
        formulario.add(campoCargaHoraria, 1, 3);

        formulario.add(new Label("Data de início:"), 0, 4);
        formulario.add(campoDataInicio, 1, 4);

        formulario.add(new Label("Data de fim:"), 0, 5);
        formulario.add(campoDataFim, 1, 5);

        formulario.add(new Label("Instrutor:"), 0, 6);
        formulario.add(campoInstrutor, 1, 6);

        formulario.add(new Label("Instituição:"), 0, 7);
        formulario.add(campoInstituicao, 1, 7);

        formulario.add(new Label("Local:"), 0, 8);
        formulario.add(campoLocal, 1, 8);

        Button botaoCadastrar = new Button("Cadastrar");
        botaoCadastrar.getStyleClass().add("botao-principal");

        Button botaoLimpar = new Button("Limpar");
        Button botaoVoltar = new Button("Voltar");

        ButtonBar botoes = new ButtonBar();
        botoes.getButtons().addAll(botaoVoltar, botaoLimpar, botaoCadastrar);

        tipoInterno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                campoInstituicao.clear();
                campoInstituicao.setDisable(true);
            }
        });

        tipoExterno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                campoInstituicao.setDisable(false);
            }
        });

        botaoCadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cadastrar();
            }
        });

        botaoLimpar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                limparCampos();
            }
        });

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
        raiz.setPadding(new Insets(25));
        raiz.getChildren().addAll(titulo, subtitulo, formulario, botoes);

        Scene scene = new Scene(raiz, 650, 650);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private void cadastrar() {
        if (campoNome.getText().isBlank()
                || campoDataInicio.getText().isBlank()
                || campoDataFim.getText().isBlank()
                || campoInstrutor.getText().isBlank()
                || campoLocal.getText().isBlank()) {

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos obrigatórios");
            alerta.setHeaderText("Preencha os campos obrigatórios.");
            alerta.show();
            return;
        }

        if (tipoExterno.isSelected() && campoInstituicao.getText().isBlank()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Instituição obrigatória");
            alerta.setHeaderText("Informe a instituição do treinamento externo.");
            alerta.show();
            return;
        }

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Cadastro");
        alerta.setHeaderText("Dados do treinamento preenchidos.");
        alerta.setContentText("O armazenamento dos dados ainda não foi implementado.");
        alerta.show();
    }

    private void limparCampos() {
        campoNome.clear();
        campoDescricao.clear();
        campoCargaHoraria.getValueFactory().setValue(1);
        campoDataInicio.clear();
        campoDataFim.clear();
        campoInstrutor.clear();
        campoInstituicao.clear();
        campoLocal.clear();

        tipoInterno.setSelected(true);
        campoInstituicao.setDisable(true);
        campoNome.requestFocus();
    }
}
