package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Bombeiro;
import br.edu.ifc.treinoecapacitacao.model.Participacao;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaParticipacoes {

    private Stage stage;
    private ListView<Treinamento> listaTreinamentos;
    private ListView<Bombeiro> listaBombeiros;
    private ListView<Participacao> listaParticipacoes;
    private RadioButton inscrito;
    private RadioButton concluido;
    private RadioButton reprovado;
    private Spinner<Integer> frequencia;
    private Spinner<Integer> nota;

    public TelaParticipacoes(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Participações");
        titulo.setId("tituloTreinamentos");

        Label subtitulo = new Label("Associe bombeiros aos treinamentos e atualize os resultados.");
        subtitulo.getStyleClass().add("subtitulo");

        listaTreinamentos = new ListView<Treinamento>(App.treinamentos);
        listaTreinamentos.setPrefHeight(130);

        listaBombeiros = new ListView<Bombeiro>(App.bombeiros);
        listaBombeiros.setPrefHeight(130);

        listaParticipacoes = new ListView<Participacao>(App.participacoes);
        listaParticipacoes.setPrefHeight(170);

        inscrito = new RadioButton("Inscrito");
        concluido = new RadioButton("Concluído");
        reprovado = new RadioButton("Reprovado");

        ToggleGroup grupoStatus = new ToggleGroup();
        inscrito.setToggleGroup(grupoStatus);
        concluido.setToggleGroup(grupoStatus);
        reprovado.setToggleGroup(grupoStatus);
        inscrito.setSelected(true);

        frequencia = new Spinner<Integer>(0, 100, 0, 5);
        nota = new Spinner<Integer>(0, 10, 0, 1);

        HBox status = new HBox(8);
        status.getChildren().addAll(
                inscrito,
                concluido,
                reprovado
        );

        GridPane dados = new GridPane();
        dados.getStyleClass().add("formulario");
        dados.setHgap(10);
        dados.setVgap(8);
        dados.add(new Label("Status:"), 0, 0);
        dados.add(status, 1, 0);
        dados.add(new Label("Frequência:"), 0, 1);
        dados.add(frequencia, 1, 1);
        dados.add(new Label("Nota:"), 0, 2);
        dados.add(nota, 1, 2);

        Button associar = new Button("Associar participante");
        associar.getStyleClass().add("botao-principal");

        Button atualizar = new Button("Atualizar participação");
        Button voltar = new Button("Voltar");

        HBox botoes = new HBox(8);
        botoes.getChildren().addAll(
                associar,
                atualizar,
                voltar
        );

        VBox painel = new VBox(10);
        painel.getStyleClass().add("painel-pagina");
        painel.getChildren().addAll(
                new Label("Selecione o treinamento"),
                listaTreinamentos,
                new Label("Selecione o bombeiro"),
                listaBombeiros,
                dados,
                botoes,
                new Label("Participações registradas"),
                listaParticipacoes
        );

        VBox raiz = new VBox(10);
        raiz.getStyleClass().add("pagina");
        raiz.setPadding(new Insets(18));
        raiz.getChildren().addAll(titulo, subtitulo, painel);

        associar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                associarParticipante();
            }
        });

        atualizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                atualizarParticipacao();
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                voltarDashboard();
            }
        });

        Scene scene = new Scene(raiz, 900, 840);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private void associarParticipante() {
        Treinamento treinamento = listaTreinamentos
                .getSelectionModel()
                .getSelectedItem();

        Bombeiro bombeiro = listaBombeiros
                .getSelectionModel()
                .getSelectedItem();

        if (treinamento == null || bombeiro == null) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Selecione treinamento e bombeiro."
            );

            alerta.show();
            return;
        }

        if (!bombeiro.getStatus().equals("Ativo")) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Apenas bombeiros ativos podem participar."
            );

            alerta.show();
            return;
        }

        for (Participacao participacao : App.participacoes) {
            boolean mesmoTreinamento = participacao.getTreinamento() == treinamento;
            boolean mesmoBombeiro = participacao.getBombeiro() == bombeiro;

            if (mesmoTreinamento && mesmoBombeiro) {
                Alert alerta = new Alert(
                        Alert.AlertType.WARNING,
                        "Bombeiro já está neste treinamento."
                );

                alerta.show();
                return;
            }
        }

        String status = obterStatusSelecionado();

        Participacao participacao = new Participacao(
                bombeiro,
                treinamento,
                status,
                frequencia.getValue(),
                nota.getValue()
        );

        App.participacoes.add(participacao);
        App.historico.add(
                "Participação registrada: "
                + bombeiro.getNome()
                + " / "
                + treinamento.getNome()
        );
    }

    private void atualizarParticipacao() {
        Participacao participacao = listaParticipacoes
                .getSelectionModel()
                .getSelectedItem();

        if (participacao == null) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Selecione uma participação."
            );

            alerta.show();
            return;
        }

        participacao.setStatus(obterStatusSelecionado());
        participacao.setFrequencia(frequencia.getValue());
        participacao.setNota(nota.getValue());

        listaParticipacoes.refresh();

        App.historico.add(
                "Participação atualizada: "
                + participacao.getBombeiro().getNome()
        );
    }

    private String obterStatusSelecionado() {
        String status = "Inscrito";

        if (concluido.isSelected()) {
            status = "Concluído";
        }

        if (reprovado.isSelected()) {
            status = "Reprovado";
        }

        return status;
    }

    private void voltarDashboard() {
        TelaDashboard tela = new TelaDashboard(stage);

        stage.setScene(tela.criarCena());
        stage.setTitle("Painel - Treinamento e Capacitação");
    }
}
