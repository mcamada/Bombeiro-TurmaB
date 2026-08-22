package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Certificado;
import br.edu.ifc.treinoecapacitacao.model.Participacao;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TelaDetalhesTreinamento {
    private Stage stage; private Treinamento treinamento;
    public TelaDetalhesTreinamento(Stage stage, Treinamento treinamento) { this.stage=stage; this.treinamento=treinamento; }
    public Scene criarCena() {
        Label titulo = new Label("Detalhes do treinamento"); titulo.setId("tituloTreinamentos");
        VBox info = new VBox(6,
            new Label("Nome: " + treinamento.getNome()), new Label("Tipo: " + treinamento.getTipo()),
            new Label("Descrição: " + treinamento.getDescricao()), new Label("Carga horária: " + treinamento.getCargaHoraria() + "h"),
            new Label("Período: " + treinamento.getDataInicio() + " até " + treinamento.getDataFim()),
            new Label("Instrutor: " + treinamento.getInstrutor()), new Label("Instituição: " + treinamento.getInstituicao()),
            new Label("Local: " + treinamento.getLocal()), new Label("Status: " + treinamento.getStatus()),
            new Label("Ativo: " + (treinamento.isAtivo() ? "Sim" : "Não")));
        info.getStyleClass().add("formulario");
        ObservableList<String> partes = FXCollections.observableArrayList();
        for (Participacao p : App.participacoes) if (p.getTreinamento() == treinamento) partes.add(p.toString());
        ObservableList<String> certs = FXCollections.observableArrayList();
        for (Certificado c : App.certificados) if (c.getParticipacao().getTreinamento() == treinamento) certs.add(c.toString());
        ListView<String> listaP = new ListView<String>(partes); listaP.setPrefHeight(120);
        ListView<String> listaC = new ListView<String>(certs); listaC.setPrefHeight(100);
        Button editar = new Button("Editar"); Button voltar = new Button("Voltar");
        editar.setOnAction(e -> { stage.setScene(new TelaEditarTreinamento(stage, treinamento).criarCena()); stage.setTitle("Editar Treinamento"); });
        voltar.setOnAction(e -> { stage.setScene(new TelaConsultaTreinamentos(stage).criarCena()); stage.setTitle("Consultar Treinamentos"); });
        VBox raiz = new VBox(12, titulo, info, new Label("Participantes"), listaP, new Label("Certificados"), listaC, new HBox(10, editar, voltar));
        raiz.setPadding(new Insets(20)); Scene scene = new Scene(raiz, 750, 650); scene.getStylesheets().add("/css/style.css"); return scene;
    }
}
