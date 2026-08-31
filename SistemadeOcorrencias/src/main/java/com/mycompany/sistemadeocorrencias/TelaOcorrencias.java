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
import javafx.scene.layout.GridPane;
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
        root.setStyle("-fx-backGround-color: #C9A6A6;"+ "-fx-padding: 40;");
        HBox topo = new HBox();

        Label titulo = new Label("Ocorrências");
        titulo.setStyle("-fx-text-fill: white;"+ "-fx-font-size: 48px;");
       
        Button btVoltar = new Button("Voltar ao início");

        btVoltar.setPrefWidth(120);
        btVoltar.setPrefHeight(40);
        btVoltar.setStyle("-fx-background-color: #5B171F;"+"-fx-text-fill: white;"+"-fx-font-size: 15px;"+"-fx-background-radius: 20;");
        btVoltar.setOnAction(e -> {App tela = new App();tela.start(stage);});
       
        topo.setAlignment(Pos.CENTER_LEFT);
        topo.setSpacing(500);
        topo.getChildren().addAll(titulo,btVoltar);

        VBox formulario = new VBox(8);
        formulario.setPrefWidth(430);
        formulario.setPrefHeight(540);
       
        formulario.setStyle("-fx-background-color:#F4E9DD;" + "-fx-border-color:#5B171F;"+ "-fx-border-width:9;"+"-fx-border-radius:30;"+ "-fx-background-radius: 30;"+ "-fx-padding:25;");

        Label tituloForm = new Label("Nova ocorrência");

        tituloForm.setStyle("-fx-text-fill:#5B171F;"+ "-fx-font-size: 27px;"+ "-fx-font-weight: bold;");

        Label Tipo = new Label("Tipo");
        TextField txtTipo = new TextField();

        Label Data = new Label("Data");
        TextField txtData = new TextField();

        Label Hora = new Label("Hora");
        TextField txtHora = new TextField();

        Label Local = new Label("Local");
        TextField txtLocal = new TextField();

        Label Descricao = new Label("Descrição");
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
       
        txtTipo.setPrefHeight(32);
        txtLocal.setPrefHeight(32);
        txtDescricao.setPrefHeight(32);
        txtStatus.setPrefHeight(32);

        HBox botoes = new HBox(25);
        botoes.getChildren().addAll(btLimpar,btSalvar);
        formulario.getChildren().addAll(tituloForm,Tipo,txtTipo,Data,txtData,Hora,txtHora,Local,txtLocal,Descricao,txtDescricao,Status,txtStatus,Sinistro,txtSinistro,Prioridade,txtPrioridade,botoes);

        VBox lista = new VBox(12);
       
        lista.setPrefWidth(800);
        lista.setPrefHeight(570);
        lista.setStyle("-fx-background-color: #5A1720;"+ "-fx-background-radius: 30;"+ "fx-padding:25;");

        Label tituloLista = new Label("Lista de Ocorrências");

        tituloLista.setStyle("-fx-text-fill:white;"+ "-fx-font-size:28px;"+ "-fx-font-weight:bold;");
       
        TextField pesquisar = new TextField();
        pesquisar.setPromptText("Pesquisar...");
        pesquisar.setPrefHeight(38);

        GridPane cabecalho = new GridPane ();
        cabecalho.setStyle("-fx-backgraud-color:#F4E9DD;"+"-fx-backgroud-radius:20;");
        cabecalho.setPrefWidth(650);
        cabecalho.setPrefHeight(40);

        cabecalho.setStyle("-fx-background-color: #F4E9DD;"+"-fx-background-radius: 20;");

        Label id = new Label("ID");
        Label tipo = new Label("Tipo");
        Label prioridade = new Label("Prioridade");
        Label status = new Label("Status");
        Label dataHora = new Label("Data/Hora");

        id.setPrefWidth(130);
        tipo.setPrefWidth(130);
        prioridade.setPrefWidth(130);
        status.setPrefWidth(130);
        dataHora.setPrefWidth(130);

        id.setAlignment(Pos.CENTER);
        tipo.setAlignment(Pos.CENTER);
        prioridade.setAlignment(Pos.CENTER);
        status.setAlignment(Pos.CENTER);
        dataHora.setAlignment(Pos.CENTER);

        id.setStyle("-fx-text-fill: #5A1720; -fx-font-weight: bold;");
        tipo.setStyle("-fx-text-fill: #5A1720; -fx-font-weight: bold;");
        prioridade.setStyle("-fx-text-fill: #5A1720; -fx-font-weight: bold;");
        status.setStyle("-fx-text-fill: #5A1720; -fx-font-weight: bold;");
        dataHora.setStyle("-fx-text-fill: #5A1720; -fx-font-weight: bold;");

        cabecalho.add(id, 0, 0);
        cabecalho.add(tipo, 1, 0);
        cabecalho.add(prioridade, 2, 0);
        cabecalho.add(status, 3, 0);
        cabecalho.add(dataHora, 4, 0);
       
        GridPane tabela = new GridPane();
        lista.getChildren().addAll(tituloLista,pesquisar,cabecalho,tabela);
        tabela.setPrefWidth(650);
        tabela.setVgap(10);
       
        int[] numero = {1};
        btSalvar.setOnAction(e -> {

            Label novoId = new Label("" + numero[0]);
            Label novoTipo = new Label(txtTipo.getText());
            Label novaPrioridade = new Label(txtPrioridade.getText());
            Label novoStatus = new Label(txtStatus.getText());
            Label novaDataHora = new Label(txtData.getText() + " " + txtHora.getText());

            novoId.setPrefWidth(130);
            novoTipo.setPrefWidth(130);
            novaPrioridade.setPrefWidth(130);
            novoStatus.setPrefWidth(130);
            novaDataHora.setPrefWidth(130);

            novoId.setAlignment(Pos.CENTER);
            novoTipo.setAlignment(Pos.CENTER);
            novaPrioridade.setAlignment(Pos.CENTER);
            novoStatus.setAlignment(Pos.CENTER);
            novaDataHora.setAlignment(Pos.CENTER);
           
            novoId.setStyle("-fx-background-color: #F4E9DD;");
            novoTipo.setStyle("-fx-background-color: #F4E9DD;");
            novaPrioridade.setStyle("-fx-background-color: #F4E9DD;");
            novoStatus.setStyle("-fx-background-color: #F4E9DD;");
            novaDataHora.setStyle("-fx-background-color: #F4E9DD;");

            int linha = numero[0] - 1;

            tabela.add(novoId, 0, linha);
            tabela.add(novoTipo, 1, linha);
            tabela.add(novaPrioridade, 2, linha);
            tabela.add(novoStatus, 3, linha);
            tabela.add(novaDataHora, 4, linha);

            numero[0]++;
        });
       
        btLimpar.setOnAction(e -> {txtTipo.clear();txtHora.clear();txtData.clear();txtLocal.clear();txtDescricao.clear();txtStatus.clear();txtSinistro.clear();txtPrioridade.clear();});   
        HBox conteudo = new HBox (25);
        conteudo.getChildren().addAll(formulario,lista);
        root.getChildren().addAll(topo, conteudo);

        Scene scene = new Scene(root, 1200, 700);
        stage.setScene(scene);
        stage.setTitle("Ocorrencias");
        stage.show();

    }
}

