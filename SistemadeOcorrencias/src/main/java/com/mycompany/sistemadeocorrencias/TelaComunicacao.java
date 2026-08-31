/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeocorrencias;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class TelaComunicacao {
    
 public void mostrar(Stage stage) {

        BorderPane root = new BorderPane();

        root.setStyle("-fx-background-color: #C9A6A6;" + "-fx-padding: 35px;");

        HBox topo = new HBox();

        topo.setAlignment(Pos.CENTER_LEFT);
        topo.setSpacing(500);

        Label titulo = new Label("Comunicação");

        titulo.setStyle("-fx-text-fill: white;" + "-fx-font-size: 48px;" + "-fx-font-family: Georgia;");

        Button btVoltar = new Button("Voltar ao início");

        btVoltar.setPrefWidth(255);
        btVoltar.setPrefHeight(55);
        btVoltar.setStyle("-fx-background-color: #5B171F;" + "-fx-text-fill: white;" + "-fx-font-size: 18px;" + "-fx-background-radius: 25px;");
        btVoltar.setOnAction(e -> {App tela = new App();tela.start(stage);});

        topo.getChildren().addAll(titulo, btVoltar);

        VBox formulario = new VBox(7);

        formulario.setPrefWidth(450);
        formulario.setPrefHeight(590);

        formulario.setStyle("-fx-background-color: #F4E9DD;" + "-fx-border-color: #5B171F;" + "-fx-border-width: 9px;"
                + "-fx-border-radius: 30px;" + "-fx-background-radius: 30px;" + "-fx-padding: 30px;");

        Label tituloForm = new Label("Nova Comunicação");

        tituloForm.setStyle("-fx-text-fill: #5B171F;" + "-fx-font-size: 27px;" + "-fx-font-weight: bold;");

        Label lblTipo = new Label("Tipo");

        TextField txTipo = new TextField();
        txTipo.setPrefHeight(35);

        Label lblData = new Label("Data");

        TextField txData = new TextField();
        txData.setPrefHeight(35);

        Label lblHora = new Label("Hora");

        TextField txHora = new TextField();
        txHora.setPrefHeight(35);

        Label lblMensagem = new Label("Mensagem");

        TextField txMensagem = new TextField();
        txMensagem.setPrefHeight(35);

        Label lblRemetente = new Label("Remetente");

        TextField txRemetente = new TextField();
        txRemetente.setPrefHeight(35);

        Label lblDestinatario = new Label("Destinatário");

        TextField txDestinatario = new TextField();
        txDestinatario.setPrefHeight(35);

        Button btLimpar = new Button("Limpar");

        Button btSalvar = new Button("Salvar");

        btLimpar.setPrefWidth(170);
        btLimpar.setPrefHeight(40);

        btSalvar.setPrefWidth(170);
        btSalvar.setPrefHeight(40);

        btLimpar.setStyle("-fx-background-color: #D5BABA;" + "-fx-text-fill: #5B171F;" + "-fx-font-size: 15px;" + "-fx-background-radius: 20px;");
        btSalvar.setStyle("-fx-background-color: #D2AAAA;" + "-fx-text-fill: #5B171F;" + "-fx-font-size: 15px;" + "-fx-background-radius: 20px;");

        HBox botoes = new HBox(25);

        botoes.setAlignment(Pos.CENTER);

        botoes.getChildren().addAll(btLimpar, btSalvar);

        formulario.getChildren().addAll(tituloForm, lblTipo, txTipo, lblData, txData, lblHora, txHora, lblMensagem, txMensagem,
                lblRemetente, txRemetente, lblDestinatario, txDestinatario, botoes);

        VBox historico = new VBox(15);

        historico.setPrefWidth(900);
        historico.setPrefHeight(590);

        historico.setStyle("-fx-background-color: #F4E9DD;" + "-fx-background-radius: 30px;" + "-fx-padding: 25px;");

        Label tituloHistorico = new Label("Histórico de Comunicação");

        tituloHistorico.setStyle("-fx-background-color: #5B171F;" + "-fx-text-fill: white;" + "-fx-font-size: 25px;"
                + "-fx-font-weight: bold;" + "-fx-padding: 10px;" + "-fx-background-radius: 20px;");

        TextField pesquisar = new TextField();

        pesquisar.setPromptText("Pesquisar...");

        pesquisar.setPrefHeight(40);

        pesquisar.setStyle("-fx-background-color: #FFFDF5;" + "-fx-background-radius: 20px;");

        HBox cabecalho = new HBox();
        
        cabecalho.setPrefHeight(40);

        cabecalho.setStyle("-fx-background-color: #FFFDF5;" + "-fx-background-radius: 20px;");

        Label id = new Label("ID");
        Label tipo = new Label("Tipo");
        Label remetente = new Label("Remetente");
        Label destinatario = new Label("Destinatário");
        Label dataHora = new Label("Data/Hora");

        id.setPrefWidth(70);
        tipo.setPrefWidth(130);
        remetente.setPrefWidth(170);
        destinatario.setPrefWidth(170);
        dataHora.setPrefWidth(130);

        id.setAlignment(Pos.CENTER);
        tipo.setAlignment(Pos.CENTER);
        remetente.setAlignment(Pos.CENTER);
        destinatario.setAlignment(Pos.CENTER);
        dataHora.setAlignment(Pos.CENTER);

        cabecalho.getChildren().addAll(id, tipo, remetente, destinatario, dataHora);

        VBox lista = new VBox(5);

        lista.setPrefHeight(350);

        lista.setStyle("-fx-background-color: #5B171F;" + "-fx-background-radius: 0px 0px 30px 30px;" + "-fx-padding: 10px;");

        historico.getChildren().addAll(tituloHistorico, pesquisar, cabecalho, lista);

        btLimpar.setOnAction(e -> {txTipo.clear();txData.clear(); txHora.clear();txMensagem.clear();txRemetente.clear();txDestinatario.clear();});

        btSalvar.setOnAction(e -> {

            int numero = lista.getChildren().size() + 1;

            HBox registro = new HBox();

            registro.setPrefHeight(35);

            Label valorId = new Label(String.valueOf(numero));

            Label valorTipo = new Label(txTipo.getText());

            Label valorRemetente = new Label(txRemetente.getText());

            Label valorDestinatario = new Label(txDestinatario.getText());

            Label valorDataHora = new Label(txData.getText() + " " + txHora.getText());

            valorId.setPrefWidth(70);
            valorTipo.setPrefWidth(130);
            valorRemetente.setPrefWidth(170);
            valorDestinatario.setPrefWidth(170);
            valorDataHora.setPrefWidth(130);

            valorId.setTextFill(javafx.scene.paint.Color.WHITE);

            valorTipo.setTextFill(javafx.scene.paint.Color.WHITE);

            valorRemetente.setTextFill(javafx.scene.paint.Color.WHITE);

            valorDestinatario.setTextFill(javafx.scene.paint.Color.WHITE);

            valorDataHora.setTextFill(javafx.scene.paint.Color.WHITE);

            valorId.setAlignment(Pos.CENTER);
            valorTipo.setAlignment(Pos.CENTER);
            valorRemetente.setAlignment(Pos.CENTER);
            valorDestinatario.setAlignment(Pos.CENTER);
            valorDataHora.setAlignment(Pos.CENTER);

            registro.getChildren().addAll(valorId, valorTipo, valorRemetente, valorDestinatario, valorDataHora);
            lista.getChildren().add(registro);
            txTipo.clear();
            txData.clear();
            txHora.clear();
            txMensagem.clear();
            txRemetente.clear();
            txDestinatario.clear();
        });


        HBox conteudo = new HBox(25);

        conteudo.setAlignment(Pos.CENTER);

        conteudo.getChildren().addAll(formulario, historico);

        root.setTop(topo);
        root.setCenter(conteudo);

        Scene scene = new Scene(root, 1536, 850);
        stage.setScene(scene);
        stage.setTitle("Comunicação");
        stage.show();
    }
}



