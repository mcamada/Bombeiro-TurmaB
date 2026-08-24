package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Certificado;
import br.edu.ifc.treinoecapacitacao.model.Participacao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCertificados {

    private Stage stage;
    private ListView<Participacao> listaParticipacoes;
    private ListView<Certificado> listaCertificados;

    public TelaCertificados(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Certificados");
        titulo.setId("tituloTreinamentos");

        Label subtitulo = new Label("Emita certificados para participações concluídas.");
        subtitulo.getStyleClass().add("subtitulo");

        listaParticipacoes = new ListView<Participacao>(App.participacoes);
        listaParticipacoes.setPrefHeight(230);

        listaCertificados = new ListView<Certificado>(App.certificados);
        listaCertificados.setPrefHeight(190);

        Button emitir = new Button("Emitir certificado");
        emitir.getStyleClass().add("botao-principal");

        Button voltar = new Button("Voltar");

        HBox botoes = new HBox(8);
        botoes.getChildren().addAll(emitir, voltar);

        VBox painel = new VBox(12);
        painel.getStyleClass().add("painel-pagina");
        painel.getChildren().addAll(
                new Label("Participações"),
                listaParticipacoes,
                botoes,
                new Label("Certificados emitidos"),
                listaCertificados
        );

        VBox raiz = new VBox(10);
        raiz.getStyleClass().add("pagina");
        raiz.setPadding(new Insets(22));
        raiz.setAlignment(Pos.TOP_CENTER);
        raiz.getChildren().addAll(titulo, subtitulo, painel);

        emitir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                emitirCertificado();
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                voltarDashboard();
            }
        });

        Scene scene = new Scene(raiz, 830, 650);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private void emitirCertificado() {
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

        if (!participacao.getStatus().equals("Concluído")) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "O participante precisa estar concluído."
            );

            alerta.show();
            return;
        }

        for (Certificado certificado : App.certificados) {
            if (certificado.getParticipacao() == participacao) {
                Alert alerta = new Alert(
                        Alert.AlertType.WARNING,
                        "Já existe certificado para esta participação."
                );

                alerta.show();
                return;
            }
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = LocalDate.now().format(formato);
        int cargaHoraria = participacao.getTreinamento().getCargaHoraria();

        Certificado certificado = new Certificado(
                participacao,
                data,
                cargaHoraria
        );

        App.certificados.add(certificado);
        App.historico.add(
                "Certificado emitido: "
                + participacao.getBombeiro().getNome()
        );
    }

    private void voltarDashboard() {
        TelaDashboard tela = new TelaDashboard(stage);

        stage.setScene(tela.criarCena());
        stage.setTitle("Painel - Treinamento e Capacitação");
    }
}
