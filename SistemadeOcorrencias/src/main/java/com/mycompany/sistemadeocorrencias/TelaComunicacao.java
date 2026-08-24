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
        VBox principal = new VBox(20);

        principal.setStyle( "-fx-background-color: #C9A6A6;"+ "-fx-padding: 40;");

        HBox topo = new HBox();

        Label titulo = new Label("Comunicacao");

        titulo.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 48px;"
        );
        Button novaComunicacao = new Button("+ Nova Comunicacao");
        novaComunicacao.setPrefWidth(240);
        novaComunicacao.setPrefHeight(45);

        novaComunicacao.setStyle(
        "-fx-backgroud-color: #5B171F;" + "-fx-text-fill:White;" + "-fx-font-size:16px" + "-fx-backgroud-radius:20;"
        );
        topo.setAlignment(Pos.CENTER_LEFT);
        topo.setSpacing(500);
        topo.getChildren().addAll(titulo, novaComunicacao);
        
        VBox formulario = new VBox(10);
        formulario.setStyle("-fx-backgroud-color: #F4E9DD;" + "-fx-border-color: #5B171F;" + "-fx-border-width:9;" + "-fx-border-radius: 30;" + "-fx-backgroud-rdius: 30;" + "-fx-padding: 25;");
        
        Label tituloForm = new Label ("Nova Comunicação");
        tituloForm.setStyle("-fx-text-fill: #5B171F;" + "-fx-font-size:27px;"+"-fx-font-weight:bold;");
        
        Label Tipo = new Label("Tipo");
        TextField txTipo = new TextField();
        Label Data = new Label("Data");
        TextField txData = new TextField();
        Label Hora = new Label ("Hora");
        TextField txHora = new TextField();
        Label Mensagem = new Label ("Mensage");
        TextField txMensagem = new TextField();
        Label Remetente = new Label ("Rementente");
        TextField txRemetente = new TextField();
        Label Destinatario = new Label ("Destinatario");
        TextField txDestinatario = new TextField();
        
        Button btLimpar = new Button("Limpar");
        Button btSalvar = new Button("Salvar");
        
        btLimpar.setPrefWidth(170);
        btSalvar.setPrefWidth(140);
        
        HBox botoes = new HBox(25);
        
        botoes.getChildren().addAll( btLimpar, btSalvar);
        
        formulario.getChildren().addAll(
        tituloForm,
        Tipo, txTipo,
        Data, txData,
        Hora, txHora,
        Mensagem, txMensagem,
        Remetente, txRemetente,
        Destinatario, txDestinatario,
        botoes,
        );
        
        VBox historico = new VBox (15);
        historico.setPrefWidth(700);
        
        historico.setStyle("-fx-backgroud-color: #5B171F;" + "=fx-backgroud-radius:30;"+ "-fx-padding: 30;");
        Label tituloHistorico = new Label("Historico de Comunicação");
        
        tituloHistorico.setStyle("-fx-text-fill: White;" + "-fx-font-size: 27px;" + "-fx-weight: bold");
        
        
        TextField pesquisar = new TextField();
        pesquisar.setPromptText("Pesquisar...");
        
        Label cabecalho = new Label("ID Tipo Remetente Destinatário Data/Hora");
        
        cabecalho.setMaxWidth(
                Double.MAX_VALUE
        );
        cabecalho.setStyle(
                "-fx-background-color:#F4E9DD;" + "-fx-text-fill:#5B171F;" + "-fx-padding:10;" + "-fx-bacjkground-radius:20;" + "-fx-font-weight:bold;");
        
        historico.getChildren().addAll(
                tituloHistorico,
                pesquisar,
                cabecalho
        );

        HBox conteudo = new HBox(25);

        conteudo.getChildren().addAll(formulario, historico);
                
        BordePane root.setTop(topo);
        root.setCenter(conteudo);
        Scene scene = new Scene(root, 1200, 700);

        stage.setTitle("Comunicacao");
        stage.setScene(scene);
        stage.show();
    }
    
}
