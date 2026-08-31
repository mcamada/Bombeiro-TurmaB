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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class TelaLocalizacao {
    int id = 1;
    public void mostrar(Stage stage) {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #C8A4A0;");

        Label titulo = new Label("Localização");

        titulo.setStyle("-fx-text-fill: white;" + "-fx-font-size: 52px;");

        HBox painelTitulo = new HBox();

        painelTitulo.setAlignment(Pos.CENTER_LEFT);
        painelTitulo.setPadding(new Insets(35, 0, 10, 75));
        painelTitulo.getChildren().add(titulo);

        Button btVoltar = new Button("Voltar ao início");

        btVoltar.setPrefWidth(170);
        btVoltar.setPrefHeight(45);

        btVoltar.setStyle("-fx-background-color: #5B171F;" + "-fx-text-fill: white;" + "-fx-font-size: 15px;" + "-fx-background-radius: 20;");
        btVoltar.setOnAction(e -> {App tela = new App(); tela.start(stage);});

        HBox painelBotao = new HBox();

        painelBotao.setAlignment(Pos.CENTER_RIGHT);
        painelBotao.setPadding(new Insets(0, 80, 20, 0));
        painelBotao.getChildren().add(btVoltar);

        BorderPane topo = new BorderPane();

        topo.setLeft(painelTitulo);
        topo.setRight(painelBotao);
        root.setTop(topo);

        VBox novaLocalizacao = new VBox(8);

        novaLocalizacao.setPrefWidth(450);
        novaLocalizacao.setPrefHeight(570);

        novaLocalizacao.setPadding(new Insets(30));

        novaLocalizacao.setStyle("-fx-background-color: #F2E8DC;" + "-fx-border-color: #5B171F;" + "-fx-border-width: 8;"
                + "-fx-border-radius: 35;" + "-fx-background-radius: 35;");

        Label tituloLocalizacao = new Label("Nova localização");

        tituloLocalizacao.setStyle("-fx-text-fill: #3E2023;" + "-fx-font-size: 27px;" + "-fx-font-weight: bold;");

        Label labelLatitude = new Label("Latitude");

        labelLatitude.setStyle("-fx-text-fill: #3E2023;" + "-fx-font-size: 16px;");

        TextField txtLatitude = new TextField();

        txtLatitude.setPrefHeight(38);
        txtLatitude.setPromptText("Latitude");

        Label labelLongitude = new Label("Longitude");

        labelLongitude.setStyle("-fx-text-fill: #3E2023;" + "-fx-font-size: 16px;");

        TextField txtLongitude = new TextField();

        txtLongitude.setPrefHeight(38);
        txtLongitude.setPromptText("Longitude");

        Label labelEndereco = new Label("Endereço");

        labelEndereco.setStyle("-fx-text-fill: #3E2023;" + "-fx-font-size: 16px;");

        TextArea txtEndereco = new TextArea();

        txtEndereco.setPrefHeight(110);
        txtEndereco.setPromptText("Endereço");
        txtEndereco.setWrapText(true);

        Button btAtualizar = new Button("Atualizar");

        btAtualizar.setPrefWidth(370);
        btAtualizar.setPrefHeight(38);

        btAtualizar.setStyle("-fx-background-color: #D8B5B1;" + "-fx-text-fill: #5B171F;" + "-fx-font-size: 16px;" + "-fx-background-radius: 20;");

        novaLocalizacao.getChildren().addAll(tituloLocalizacao, labelLatitude, txtLatitude, labelLongitude, txtLongitude,
                labelEndereco, txtEndereco, btAtualizar);

        VBox areaDireita = new VBox();

        areaDireita.setPrefWidth(850);
        areaDireita.setPrefHeight(570);

        areaDireita.setPadding(new Insets(30));

        areaDireita.setStyle("-fx-background-color: #F2E8DC;" + "-fx-background-radius: 35;");

        VBox painelHistorico = new VBox(15);

        painelHistorico.setPrefWidth(780);
        painelHistorico.setPrefHeight(500);

        painelHistorico.setPadding(new Insets(25));

        painelHistorico.setStyle("-fx-background-color: #5B171F;" + "-fx-background-radius: 35;");

        Label tituloHistorico = new Label("Histórico de localização");

        tituloHistorico.setStyle("-fx-text-fill: white;" + "-fx-font-size: 27px;" + "-fx-font-weight: bold;");

        TextField campoPesquisa = new TextField();

        campoPesquisa.setPrefHeight(38);
        campoPesquisa.setPromptText("Pesquisar localização");

        HBox cabecalho = new HBox();

        cabecalho.setPrefHeight(38);

        cabecalho.setAlignment(Pos.CENTER);

        cabecalho.setStyle("-fx-background-color: #F2E8DC;" + "-fx-background-radius: 20;");

        Label idLabel = new Label("ID");
        Label latitudeLabel = new Label("Latitude");
        Label longitudeLabel = new Label("Longitude");
        Label enderecoLabel = new Label("Endereço");

        idLabel.setPrefWidth(70);
        latitudeLabel.setPrefWidth(170);
        longitudeLabel.setPrefWidth(170);
        enderecoLabel.setPrefWidth(300);

        idLabel.setAlignment(Pos.CENTER);
        latitudeLabel.setAlignment(Pos.CENTER);
        longitudeLabel.setAlignment(Pos.CENTER);
        enderecoLabel.setAlignment(Pos.CENTER);

        idLabel.setStyle("-fx-text-fill: #3E2023; -fx-font-weight: bold;");
        latitudeLabel.setStyle("-fx-text-fill: #3E2023; -fx-font-weight: bold;");
        longitudeLabel.setStyle("-fx-text-fill: #3E2023; -fx-font-weight: bold;");
        enderecoLabel.setStyle("-fx-text-fill: #3E2023; -fx-font-weight: bold;");

        cabecalho.getChildren().addAll(idLabel, latitudeLabel, longitudeLabel, enderecoLabel);

        VBox listaHistorico = new VBox(8);

        listaHistorico.setPrefWidth(730);

        painelHistorico.getChildren().addAll(tituloHistorico, campoPesquisa, cabecalho, listaHistorico);

        areaDireita.setAlignment(Pos.CENTER);

        areaDireita.getChildren().add(painelHistorico);

        HBox centro = new HBox(25);

        centro.setAlignment(Pos.CENTER);

        centro.setPadding(new Insets(0, 70, 30, 70));

        centro.getChildren().addAll(novaLocalizacao, areaDireita);

        root.setCenter(centro);

        btAtualizar.setOnAction(e -> {

            String latitude = txtLatitude.getText();
            String longitude = txtLongitude.getText();
            String endereco = txtEndereco.getText();

            HBox linha = new HBox();

            linha.setPrefHeight(38);

            linha.setAlignment(Pos.CENTER);

            linha.setStyle("-fx-background-color: #F2E8DC;" + "-fx-background-radius: 20;");

            Label novoId = new Label(String.valueOf(id));

            Label novaLatitude = new Label(latitude);

            Label novaLongitude = new Label(longitude);

            Label novoEndereco = new Label(endereco);

            novoId.setPrefWidth(70);
            novaLatitude.setPrefWidth(170);
            novaLongitude.setPrefWidth(170);
            novoEndereco.setPrefWidth(300);

            novoId.setAlignment(Pos.CENTER);
            novaLatitude.setAlignment(Pos.CENTER);
            novaLongitude.setAlignment(Pos.CENTER);
            novoEndereco.setAlignment(Pos.CENTER);

            novoId.setStyle("-fx-text-fill: #3E2023;");

            novaLatitude.setStyle("-fx-text-fill: #3E2023;");

            novaLongitude.setStyle("-fx-text-fill: #3E2023;");

            novoEndereco.setStyle("-fx-text-fill: #3E2023;");

            linha.getChildren().addAll(novoId, novaLatitude, novaLongitude, novoEndereco);

            listaHistorico.getChildren().add(linha);

            id++;

            txtLatitude.clear();
            txtLongitude.clear();
            txtEndereco.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Localização");
            alert.setHeaderText("Localização atualizada!");
            alert.show();

        });

        Scene scene = new Scene(root, 1536, 850 );

        stage.setTitle("Localização");
        stage.setScene(scene);
        stage.show();
    }
}



