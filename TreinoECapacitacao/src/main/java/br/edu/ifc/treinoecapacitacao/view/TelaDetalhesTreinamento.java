package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Certificado;
import br.edu.ifc.treinoecapacitacao.model.Participacao;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaDetalhesTreinamento {

    private Stage stage;
    private Treinamento treinamento;

    public TelaDetalhesTreinamento(Stage stage, Treinamento treinamento) {
        this.stage = stage;
        this.treinamento = treinamento;
    }

    public Scene criarCena() {
        Label titulo = new Label("Detalhes do treinamento");
        titulo.setId("tituloTreinamentos");

        Label nome = new Label("Nome: " + treinamento.getNome());
        Label tipo = new Label("Tipo: " + treinamento.getTipo());
        Label descricao = new Label("Descrição: " + treinamento.getDescricao());
        Label carga = new Label("Carga horária: " + treinamento.getCargaHoraria() + "h");
        Label periodo = new Label(
                "Período: "
                + treinamento.getDataInicio()
                + " até "
                + treinamento.getDataFim()
        );
        Label instrutor = new Label("Instrutor: " + treinamento.getInstrutor());
        Label instituicao = new Label("Instituição: " + treinamento.getInstituicao());
        Label local = new Label("Local: " + treinamento.getLocal());
        Label status = new Label("Status: " + treinamento.getStatus());

        String textoAtivo = "Não";

        if (treinamento.isAtivo()) {
            textoAtivo = "Sim";
        }

        Label ativo = new Label("Ativo: " + textoAtivo);

        VBox informacoes = new VBox(7);
        informacoes.getStyleClass().add("formulario");
        informacoes.getChildren().addAll(
                nome,
                tipo,
                descricao,
                carga,
                periodo,
                instrutor,
                instituicao,
                local,
                status,
                ativo
        );

        ObservableList<String> participantes = FXCollections.observableArrayList();

        for (Participacao participacao : App.participacoes) {
            if (participacao.getTreinamento() == treinamento) {
                participantes.add(participacao.toString());
            }
        }

        ObservableList<String> certificados = FXCollections.observableArrayList();

        for (Certificado certificado : App.certificados) {
            Treinamento treinamentoCertificado = certificado
                    .getParticipacao()
                    .getTreinamento();

            if (treinamentoCertificado == treinamento) {
                certificados.add(certificado.toString());
            }
        }

        ListView<String> listaParticipantes = new ListView<String>(participantes);
        listaParticipantes.setPrefHeight(120);

        ListView<String> listaCertificados = new ListView<String>(certificados);
        listaCertificados.setPrefHeight(100);

        Button editar = new Button("Editar");
        editar.getStyleClass().add("botao-principal");

        Button voltar = new Button("Voltar");

        HBox botoes = new HBox(10);
        botoes.getChildren().addAll(editar, voltar);

        VBox painel = new VBox(12);
        painel.getStyleClass().add("painel-pagina");
        painel.getChildren().addAll(
                informacoes,
                new Label("Participantes"),
                listaParticipantes,
                new Label("Certificados"),
                listaCertificados,
                botoes
        );

        VBox raiz = new VBox(12);
        raiz.getStyleClass().add("pagina");
        raiz.setPadding(new Insets(24));
        raiz.getChildren().addAll(titulo, painel);

        editar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TelaEditarTreinamento tela = new TelaEditarTreinamento(
                        stage,
                        treinamento
                );

                stage.setScene(tela.criarCena());
                stage.setTitle("Editar Treinamento");
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TelaConsultaTreinamentos tela = new TelaConsultaTreinamentos(stage);

                stage.setScene(tela.criarCena());
                stage.setTitle("Consultar Treinamentos");
            }
        });

        Scene scene = new Scene(raiz, 780, 700);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }
}
