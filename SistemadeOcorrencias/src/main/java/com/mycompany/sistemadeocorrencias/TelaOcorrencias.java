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
public class TelaOcorrencias {

    public void mostrar(Stage stage) {

        VBox root = new VBox(20);

        root.setStyle("-fx-backGround-color: #C9A6A6;"   + "-fx-padding: 40;");

        HBox topo = new HBox();

        Label titulo = new Label("Ocorrências");

        titulo.setStyle("-fx-text-fill: white;"+ "-fx-font-size: 48px;");

        Button btNova = new Button("+ Nova Ocorrencia");

        btNova.setPrefWidth(220);
        btNova.setPrefHeight(45);

        btNova.setStyle( "-fx-background-color: #5B171F;"  + "-fx-text-fill: white;" + "-fx-font size: 16px;" + "-fx-background-radius: 20;");
        
        topo.setAlignment(Pos.CENTER_LEFT);
        topo.setSpacing(500);

        topo.getChildren().addAll(titulo,btNova);

        VBox formulario = new VBox(8);

        formulario.setPrefWidth(430);

        formulario.setStyle("-fx-background-color: 3F4E9DD;" + "-fx-border-color: #5B171F;"+ "-fx-border-width: 9;"+ "-fx-border-radius: 30;"+ "-fx-background-radius: 30;"+ "-fx-padding: 25;");

        Label tituloForm = new Label("Nova ocorrencia");

        tituloForm.setStyle("-fx-text-fill: 35B171F;"+ "-fx-font-size: 27px;"+ "-fx-font-weight: bold;");

        Label Tipo = new Label("Tipo");
        TextField txtTipo = new TextField();

        Label Data = new Label("Data");
        TextField txtData = new TextField();

        Label Hora = new Label("Hora");
        TextField txtHora = new TextField();

        Label Local = new Label("Local");
        TextField txtLocal = new TextField();

        Label Descricao = new Label("Descricao");
        TextField txtDescricao = new TextField();

        Label Status = new Label("Status");
        TextField txtStatus = new TextField();

        Label Sinistro = new Label("Sinistro");
        TextField txtSinistro = new TextField();

        Label Prioridade = new Label("Prioridade");
        TextField txtPrioridade = new TextField();

        Button btLimpar = new Button("Limpar");
        Button btSalvar = new Button("Salvar");

        btLimpar.setPrefWidth(170);
        btSalvar.setPrefWidth(170);

        HBox botoes = new HBox(25);

        botoes.getChildren().addAll(btLimpar,btSalvar);

        formulario.getChildren().addAll(tituloForm,Tipo,txtTipo,Data,txtData,Hora,txtHora,Local,txtLocal,Descricao,txtDescricao,Status,txtStatus,Sinistro,txtSinistro,Prioridade,txtPrioridade,botoes);

        VBox lista = new VBox(15);

        lista.setStyle("-fx-background-color: #5A1720;"+ "-fx-background-radius: 30;"+ "fx-padding:30;");

        Label tituloLista = new Label("Lista de Ocorrencia");

        tituloLista.setStyle("-fx-text-fill:white;"+ "-fx-font-size: 28px;"+ "-fx-font-weight:bold;");
        
        TextField pesquisar = new TextField();
        pesquisar.setPromptText("Pesquisar...");

        Label cabecalho = new Label("ID Tipo Prioridade Status Data/Hora");

        cabecalho.setStyle( "-fx-background-color: #F4E9DD;"+ "-fx-text-fill: #5A1720;"+ "-fx-background-radius: 20;");
        lista.getChildren().addAll(tituloLista,pesquisar,cabecalho);
        HBox conteudo = new HBox (25);
        
        conteudo.getChildren().addAll(formulario,lista);
        root.getChildren().addAll(topo,conteudo);
        
        Scene scene = new Scene(root, 1200, 700);
        stage.setScene(scene);
        stage.setTitle("Ocorrencias");
        stage.show();
        
    }
    
}
