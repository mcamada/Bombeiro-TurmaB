package br.edu.ifc.treinoecapacitacao.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaTreinamentos {
    private Stage stage;
    public TelaTreinamentos(Stage stage) { this.stage = stage; }
    public Scene criarCena() {
        Label titulo = new Label("Treinamentos"); titulo.setId("tituloTreinamentos");
        Button cadastrar = new Button("Cadastrar treinamento"); cadastrar.getStyleClass().add("botao-principal");
        Button consultar = new Button("Consultar treinamentos"); consultar.getStyleClass().add("botao-principal");
        Button participacoes = new Button("Participações");
        Button certificados = new Button("Certificados");
        Button voltar = new Button("Voltar");
        cadastrar.setOnAction(e -> abrir(new TelaCadastroTreinamento(stage).criarCena(), "Cadastrar Treinamento"));
        consultar.setOnAction(e -> abrir(new TelaConsultaTreinamentos(stage).criarCena(), "Consultar Treinamentos"));
        participacoes.setOnAction(e -> abrir(new TelaParticipacoes(stage).criarCena(), "Participações"));
        certificados.setOnAction(e -> abrir(new TelaCertificados(stage).criarCena(), "Certificados"));
        voltar.setOnAction(e -> abrir(new TelaDashboard(stage).criarCena(), "Painel - Treinamento e Capacitação"));
        VBox raiz = new VBox(15, titulo, new Label("Gerenciamento de treinamentos e capacitações"), cadastrar, consultar, participacoes, certificados, voltar);
        raiz.setAlignment(Pos.CENTER); raiz.setPadding(new Insets(30));
        Scene scene = new Scene(raiz, 600, 450); scene.getStylesheets().add("/css/style.css"); return scene;
    }
    private void abrir(Scene s, String titulo) { stage.setScene(s); stage.setTitle(titulo); }
}
