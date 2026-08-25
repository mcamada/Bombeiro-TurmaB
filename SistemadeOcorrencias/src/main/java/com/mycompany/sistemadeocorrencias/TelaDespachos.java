/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeocorrencias;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class TelaDespachos {

    private VBox historico;

    private TextField txOcorencia;
    private TextField txData;
    private TextField txHora;
    private TextField txStatus;
    private TextField txViatura;
    private TextField txObservacao;

    public void mostrar(Stage stage) {

        VBox root = new VBox(25);

        root.setPadding(new Insets(35));

        root.setStyle("-fx-background-color: #C9A5A5;");

        HBox topo = new HBox();

        topo.setAlignment(Pos.CENTER_LEFT);

        Label titulo = new Label("Despachos");

        titulo.setStyle("-fx-text-fill: white;" + "-fx-font-size: 50px;" + "-fx-font-family: 'Georgia'");

        Button btNovo = new Button("+ Novo despacho");

        btNovo.setPrefWidth(220);
        btNovo.setPrefHeight(50);

        btNovo.setStyle("-fx-background-color: #5B171F;" + "-fx-text-fill: white;" + "-fx-font-size: 17px;" + "-fx-background-radius: 25;");

        HBox.setMargin(btNovo, new Insets(10, 0, 0, 650));

        topo.getChildren().addAll(titulo, btNovo);
        VBox formulario = new VBox(7);

        formulario.setPrefWidth(430);
        formulario.setPrefHeight(570);

        formulario.setPadding(new Insets(30));

        formulario.setStyle("-fx-background-color: #F4E9DD;" + "-fx-border-color: #5B171F;" + "-fx-border-width: 9;" + "-fx-border-radius: 30;" + "-fx-background-radius: 30;");

        Label tituloForm = new Label("Novo Despacho");

        tituloForm.setStyle("-fx-text-fill: #5B171F;" + "-fx-font-size: 28px;" + "-fx-font-weight: bold;");

        Label lblOcorrencia = new Label("Ocorrência");

        TextField Ocorrencia = new TextField();

        Ocorrencia.setPrefHeight(35);

        Label lblData = new Label("Data Despacho");
        Label lblHora = new Label("Hora Despacho");

        TextField Data = new TextField();

        TextField Hora = new TextField();

        Data.setPrefWidth(180);
        Hora.setPrefWidth(180);

        HBox dataHora = new HBox(25);

        VBox campoData = new VBox(5);
        VBox campoHora = new VBox(5);

        campoData.getChildren().addAll(lblData, Data);

        campoHora.getChildren().addAll(
                lblHora,
                Hora
        );

        dataHora.getChildren().addAll(
                campoData,
                campoHora
        );
        Label lblStatus = new Label("Status");

        TextField Status = new TextField();

        Status.setPrefHeight(35);

        Label lblViatura = new Label("Viatura");

        TextField Viatura = new TextField();

        Viatura.setPrefHeight(35);

        Label lblObservacao = new Label("Observação");

        TextField Observacao = new TextField();

        Observacao.setPrefHeight(35);

        Button btLimpar = new Button("Limpar");

        Button btDespachar = new Button("Despachar");

        btLimpar.setPrefWidth(170);
        btDespachar.setPrefWidth(170);

        btLimpar.setPrefHeight(40);
        btDespachar.setPrefHeight(40);

        btLimpar.setStyle("-fx-background-color: #D9BEBE;" + "-fx-text-fill: #5B171F;" + "-fx-font-size: 15px;" + "-fx-background-radius: 20;");

        btDespachar.setStyle("-fx-background-color: #D2AAAA;" + "-fx-text-fill: #5B171F;" + "-fx-font-size: 15px;" + "-fx-background-radius: 20;");

        HBox botoes = new HBox(25);

        botoes.setAlignment(Pos.CENTER);

        botoes.getChildren().addAll(btLimpar, btDespachar);

        formulario.getChildren().addAll(tituloForm, lblOcorrencia, Ocorrencia, dataHora, lblStatus, Status, lblViatura, Viatura, lblObservacao, Observacao, botoes);

        VBox painelHistorico = new VBox(15);

        painelHistorico.setPrefWidth(850);
        painelHistorico.setPrefHeight(570);

        painelHistorico.setPadding(new Insets(25));

        painelHistorico.setStyle("-fx-background-color: #F4E9DD;" + "-fx-background-radius: 30;");

        Label tituloHistorico = new Label("Histórico de despachos");

        tituloHistorico.setStyle("-fx-text-fill: white;" + "-fx-font-size: 28px;" + "-fx-font-weight: bold;");

        HBox tituloHistoricoBox = new HBox();

        tituloHistoricoBox.setPadding(new Insets(15));

        tituloHistoricoBox.setStyle("-fx-background-color: #5B171F;" + "-fx-background-radius: 25;");

        tituloHistoricoBox.getChildren().add(tituloHistorico);
               
        TextField txtPesquisar = new TextField();

        txtPesquisar.setPromptText("Pesquisar...");

        txtPesquisar.setPrefHeight(40);

        HBox cabecalho = new HBox();

        cabecalho.setAlignment(Pos.CENTER);

        cabecalho.setPrefHeight(40);

        cabecalho.setStyle("-fx-background-color: #F4E9DD;" + "-fx-background-radius: 20;");

        Label id = new Label("ID");

        Label ocorrencia = new Label("Ocorrência");

        Label viatura = new Label("Viatura");

        Label status = new Label("Status");

        Label dataHoraLabel = new Label("Data/Hora");

        id.setPrefWidth(70);
        ocorrencia.setPrefWidth(180);
        viatura.setPrefWidth(150);
        status.setPrefWidth(150);
        dataHoraLabel.setPrefWidth(150);

        cabecalho.getChildren().addAll(id, ocorrencia, viatura, status, dataHoraLabel);

        historico = new VBox(5);

        historico.setPadding(new Insets(10));

        historico.setStyle("-fx-background-color: #5B171F;" + "-fx-background-radius: 25;");

        historico.setPrefHeight(300);

        CheckBox excluir = new CheckBox("Selecione o despacho que você deseja excluir");

        excluir.setStyle("-fx-text-fill: #5B171F;" + "-fx-font-size: 14px;");

        painelHistorico.getChildren().addAll(tituloHistoricoBox, txtPesquisar, cabecalho, historico, excluir);

          btLimpar.setOnAction(e -> {
            Ocorrencia.clear();
            Status.clear();
            Viatura.clear();
            Observacao.clear();
        });
       
        HBox conteudo = new HBox(25);

        conteudo.setAlignment(Pos.CENTER);

        conteudo.getChildren().addAll(formulario, painelHistorico);
        root.getChildren().addAll(topo, conteudo);
        Scene scene = new Scene(root, 1450, 850);
        stage.setTitle("Sistema de Ocorrências - Despachos");
        stage.setScene(scene);
        stage.show();
    }
}
