package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class TelaConsultaTreinamentos {

    private Stage stage;
    private TextField nome;
    private TextField instrutor;
    private TextField periodoInicio;
    private TextField periodoFim;
    private RadioButton todos;
    private RadioButton interno;
    private RadioButton externo;
    private ListView<Treinamento> lista;

    public TelaConsultaTreinamentos(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Consultar treinamentos");
        titulo.setId("tituloTreinamentos");

        Label subtitulo = new Label("Use os filtros para localizar os registros.");
        subtitulo.getStyleClass().add("subtitulo");

        nome = new TextField();
        nome.setPromptText("Nome");

        instrutor = new TextField();
        instrutor.setPromptText("Instrutor");

        periodoInicio = new TextField();
        periodoInicio.setPromptText("Início dd/mm/aaaa");

        periodoFim = new TextField();
        periodoFim.setPromptText("Fim dd/mm/aaaa");

        todos = new RadioButton("Todos");
        interno = new RadioButton("Interno");
        externo = new RadioButton("Externo");

        ToggleGroup grupo = new ToggleGroup();
        todos.setToggleGroup(grupo);
        interno.setToggleGroup(grupo);
        externo.setToggleGroup(grupo);
        todos.setSelected(true);

        HBox tipos = new HBox(10);
        tipos.getChildren().addAll(todos, interno, externo);

        Button filtrar = new Button("Filtrar");
        filtrar.getStyleClass().add("botao-principal");

        Button limpar = new Button("Limpar filtros");

        HBox periodo = new HBox(5);
        periodo.getChildren().addAll(periodoInicio, periodoFim);

        HBox botoesFiltro = new HBox(8);
        botoesFiltro.getChildren().addAll(filtrar, limpar);

        GridPane filtros = new GridPane();
        filtros.getStyleClass().add("formulario");
        filtros.setHgap(8);
        filtros.setVgap(8);
        filtros.add(new Label("Nome:"), 0, 0);
        filtros.add(nome, 1, 0);
        filtros.add(new Label("Instrutor:"), 2, 0);
        filtros.add(instrutor, 3, 0);
        filtros.add(new Label("Tipo:"), 0, 1);
        filtros.add(tipos, 1, 1);
        filtros.add(new Label("Período:"), 2, 1);
        filtros.add(periodo, 3, 1);
        filtros.add(botoesFiltro, 1, 2);

        lista = new ListView<Treinamento>(App.treinamentos);
        lista.setPrefHeight(300);
        lista.getStyleClass().add("lista-treinamentos");

        Button detalhes = new Button("Detalhes");
        Button editar = new Button("Editar");
        Button inativar = new Button("Inativar");
        Button voltar = new Button("Voltar");

        HBox botoes = new HBox(10);
        botoes.setAlignment(Pos.CENTER);
        botoes.getChildren().addAll(
                detalhes,
                editar,
                inativar,
                voltar
        );

        VBox painel = new VBox(12);
        painel.getStyleClass().add("painel-pagina");
        painel.getChildren().addAll(filtros, lista, botoes);

        VBox raiz = new VBox(10);
        raiz.getStyleClass().add("pagina");
        raiz.setPadding(new Insets(24));
        raiz.setAlignment(Pos.TOP_CENTER);
        raiz.getChildren().addAll(titulo, subtitulo, painel);

        filtrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filtrar();
            }
        });

        limpar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                limparFiltros();
            }
        });

        detalhes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirSelecionado(false);
            }
        });

        editar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirSelecionado(true);
            }
        });

        inativar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inativar();
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

        Scene scene = new Scene(raiz, 980, 650);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private void filtrar() {
        ObservableList<Treinamento> resultado = FXCollections.observableArrayList();

        for (Treinamento treinamento : App.treinamentos) {
            boolean podeAdicionar = true;

            if (!nome.getText().isBlank()) {
                String nomeTreinamento = treinamento.getNome().toLowerCase();
                String nomeDigitado = nome.getText().toLowerCase();

                if (!nomeTreinamento.contains(nomeDigitado)) {
                    podeAdicionar = false;
                }
            }

            if (!instrutor.getText().isBlank()) {
                String nomeInstrutor = treinamento.getInstrutor().toLowerCase();
                String instrutorDigitado = instrutor.getText().toLowerCase();

                if (!nomeInstrutor.contains(instrutorDigitado)) {
                    podeAdicionar = false;
                }
            }

            if (interno.isSelected()) {
                if (!treinamento.getTipo().equals("Interno")) {
                    podeAdicionar = false;
                }
            }

            if (externo.isSelected()) {
                if (!treinamento.getTipo().equals("Externo")) {
                    podeAdicionar = false;
                }
            }

            if (!periodoInicio.getText().isBlank()) {
                if (!treinamento.getDataInicio().equals(periodoInicio.getText())) {
                    podeAdicionar = false;
                }
            }

            if (!periodoFim.getText().isBlank()) {
                if (!treinamento.getDataFim().equals(periodoFim.getText())) {
                    podeAdicionar = false;
                }
            }

            if (podeAdicionar) {
                resultado.add(treinamento);
            }
        }

        lista.setItems(resultado);
    }

    private void limparFiltros() {
        nome.clear();
        instrutor.clear();
        periodoInicio.clear();
        periodoFim.clear();
        todos.setSelected(true);
        lista.setItems(App.treinamentos);
    }

    private void abrirSelecionado(boolean edicao) {
        Treinamento treinamento = lista.getSelectionModel().getSelectedItem();

        if (treinamento == null) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Selecione um treinamento."
            );

            alerta.show();
            return;
        }

        if (edicao) {
            TelaEditarTreinamento tela = new TelaEditarTreinamento(
                    stage,
                    treinamento
            );

            stage.setScene(tela.criarCena());
            stage.setTitle("Editar Treinamento");
        } else {
            TelaDetalhesTreinamento tela = new TelaDetalhesTreinamento(
                    stage,
                    treinamento
            );

            stage.setScene(tela.criarCena());
            stage.setTitle("Detalhes do Treinamento");
        }
    }

    private void inativar() {
        Treinamento treinamento = lista.getSelectionModel().getSelectedItem();

        if (treinamento == null) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Selecione um treinamento."
            );

            alerta.show();
            return;
        }

        treinamento.setAtivo(false);
        App.historico.add("Treinamento inativado: " + treinamento.getNome());
        lista.refresh();

        Alert alerta = new Alert(
                Alert.AlertType.INFORMATION,
                "Treinamento inativado."
        );

        alerta.show();
    }
}
