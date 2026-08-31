/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeocorrencias;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class TelaEquipe {
     public void mostrar (Stage stage) {

        BorderPane root = new BorderPane();

        root.setStyle("-fx-background-color: #C8A4A0;");

        Label titulo = new Label("Equipe");
        titulo.setStyle("-fx-text-fill: white;"+"-fx-font-size: 52px;");

        HBox painelTitulo = new HBox();
        painelTitulo.setAlignment(Pos.CENTER_LEFT);
        painelTitulo.setPadding(new Insets(35, 0, 10, 75));

        painelTitulo.getChildren().add(titulo);
        root.setTop(painelTitulo);
       
        Button btVoltar = new Button("Voltar ao início");

        btVoltar.setPrefWidth(120);
        btVoltar.setPrefHeight(40);
        btVoltar.setStyle("-fx-background-color: #5B171F;"+"-fx-text-fill: white;"+"-fx-font-size: 15px;"+"-fx-background-radius: 20;");
        btVoltar.setOnAction(e -> {
            App tela = new App();
            tela.start(stage);
        });
       
        HBox painelBotao = new HBox(btVoltar);

        painelBotao.setAlignment(Pos.CENTER_RIGHT);
        painelBotao.setPadding(new Insets(35, 80, 10, 0));
       
        BorderPane topo = new BorderPane();

        topo.setLeft(painelTitulo);
        topo.setRight(painelBotao);
        root.setTop(topo);
               
        VBox dadosEquipe = new VBox(8);

        dadosEquipe.setPrefWidth(430);
        dadosEquipe.setPrefHeight(570);

        dadosEquipe.setPadding(new Insets(30));
        dadosEquipe.setStyle("-fx-background-color: #F2E8DC;"+"-fx-border-color: #5B171F;"+"-fx-border-width: 8;"+"-fx-border-radius: 35;"+"-fx-background-radius: 35;");

        Label tituloDados = new Label("Dados da equipe");

        tituloDados.setStyle("-fx-text-fill: #3E2023;"+"-fx-font-size: 26px;"+"-fx-font-weight: bold;");

        Label labelNome = new Label("Nome da equipe");

        TextField txtNome = new TextField();
        txtNome.setPrefHeight(35);
        txtNome.setPromptText("Nome da equipe");

        Label labelLider = new Label("Líder");

        TextField txtLider = new TextField();
        txtLider.setPrefHeight(35);
        txtLider.setPromptText("Líder");

        Label labelTipo = new Label("Tipo");

        TextField txtTipo = new TextField();
        txtTipo.setPrefHeight(35);
        txtTipo.setPromptText("Tipo");

        Button btLimpar = new Button("Limpar");
        Button btSalvar = new Button("Salvar");

        btLimpar.setPrefWidth(170);
        btLimpar.setPrefHeight(38);
        btSalvar.setPrefWidth(170);
        btSalvar.setPrefHeight(38);

        btLimpar.setStyle("-fx-background-color: #D8C1C0;"+"-fx-text-fill: #5B171F;" +"-fx-font-size: 16px;"+"-fx-background-radius: 20;");

        btSalvar.setStyle("-fx-background-color: #D8B5B1;" +"-fx-text-fill: #5B171F;" +"-fx-font-size: 16px;" + "-fx-background-radius: 20;");

        HBox botoes = new HBox(20);

        botoes.setAlignment(Pos.CENTER);
        botoes.getChildren().addAll(btLimpar, btSalvar);

        dadosEquipe.getChildren().addAll(tituloDados,labelNome,txtNome,labelLider,txtLider,labelTipo,txtTipo,botoes);

        VBox listaEquipe = new VBox(10);

        listaEquipe.setPrefWidth(850);
        listaEquipe.setPrefHeight(570);
        listaEquipe.setPadding(new Insets(30));
        listaEquipe.setStyle("-fx-background-color: #F2E8DC;" +"-fx-background-radius: 35;");

        Label tituloLista = new Label("Lista de Equipes");

        tituloLista.setStyle("-fx-text-fill: white;" +"-fx-font-size: 28px;" +"-fx-font-weight: bold;");

        VBox areaLista = new VBox(12);

        areaLista.setPrefHeight(500);
        areaLista.setPadding(new Insets(20));

        areaLista.setStyle("-fx-background-color: #5B171F;"+"-fx-background-radius: 35;");

        TextField txtPesquisar = new TextField();

        txtPesquisar.setPromptText("Pesquisar...");
        txtPesquisar.setPrefHeight(38);
        txtPesquisar.setStyle("-fx-background-color: #FFFDF8;"+"-fx-background-radius: 20;"+"-fx-font-size: 15px;");

        GridPane cabecalho = new GridPane();

        cabecalho.setPrefHeight(40);
        cabecalho.setPrefWidth(650);

        Label id = new Label("ID");
        Label nomeEquipe = new Label("Nome da equipe");
        Label lider = new Label("Líder");
        Label tipo = new Label("Tipo");

        id.setPrefWidth(160);
        nomeEquipe.setPrefWidth(160);
        lider.setPrefWidth(160);
        tipo.setPrefWidth(160);

        id.setAlignment(Pos.CENTER);
        nomeEquipe.setAlignment(Pos.CENTER);
        lider.setAlignment(Pos.CENTER);
        tipo.setAlignment(Pos.CENTER);

        id.setStyle("-fx-text-fill: #3E2023;"+"-fx-font-size: 15px;"+"-fx-font-weight: bold;");

        nomeEquipe.setStyle("-fx-text-fill: #3E2023;"+"-fx-font-size: 15px;"+ "-fx-font-weight: bold;");

        lider.setStyle("-fx-text-fill: #3E2023;"+"-fx-font-size: 15px;"+"-fx-font-weight: bold;");

        tipo.setStyle("-fx-text-fill: #3E2023;"+"-fx-font-size: 15px;"+"-fx-font-weight: bold;");

        cabecalho.add(id, 0, 0);
        cabecalho.add(nomeEquipe, 1, 0);
        cabecalho.add(lider, 2, 0);
        cabecalho.add(tipo, 3, 0);

        cabecalho.setStyle("-fx-background-color: #FFFDF8;"+"-fx-background-radius: 20;");
       
        GridPane tabela = new GridPane();

        tabela.setPrefWidth(810);
        tabela.setVgap(10);

        areaLista.getChildren().addAll(tituloLista,txtPesquisar,cabecalho,tabela);
        listaEquipe.getChildren().add(areaLista);
       
        int[] numero = {1};

        btSalvar.setOnAction(e -> {

            Label novoId = new Label("" + numero[0]);
            Label novoNomeEquipe = new Label(txtNome.getText());
            Label novoLider = new Label(txtLider.getText());
            Label novoTipo = new Label(txtTipo.getText());

            novoId.setPrefWidth(160);
            novoNomeEquipe.setPrefWidth(160);
            novoLider.setPrefWidth(160);
            novoTipo.setPrefWidth(160);

            novoId.setAlignment(Pos.CENTER);
            novoNomeEquipe.setAlignment(Pos.CENTER);
            novoLider.setAlignment(Pos.CENTER);
            novoTipo.setAlignment(Pos.CENTER);

            novoId.setStyle("-fx-background-color: #F4E9DD;");
            novoNomeEquipe.setStyle("-fx-background-color: #F4E9DD;");
            novoLider.setStyle("-fx-background-color: #F4E9DD;");
            novoTipo.setStyle("-fx-background-color: #F4E9DD;");

            int linha = numero[0] - 1;

            tabela.add(novoId, 0, linha);
            tabela.add(novoNomeEquipe, 1, linha);
            tabela.add(novoLider, 2, linha);
            tabela.add(novoTipo, 3, linha);

            numero[0]++;
        });

        HBox centro = new HBox(25);
        centro.setAlignment(Pos.CENTER);
        centro.setPadding(new Insets(0, 70, 30, 70));

        centro.getChildren().addAll( dadosEquipe, listaEquipe);
        root.setCenter(centro);

        btLimpar.setOnAction(e -> {
            txtNome.clear();
            txtLider.clear();
            txtTipo.clear();
        });
       
        Scene scene = new Scene(root, 1536, 850);

        stage.setTitle("Equipe");
        stage.setScene(scene);
        stage.show();
    }

}


