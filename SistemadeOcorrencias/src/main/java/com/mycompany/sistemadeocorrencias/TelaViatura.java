/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeocorrencias;

import javafx.geometry.Insets;
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
public class TelaViatura {

     private Scene TelaInicio;

    public TelaViatura(Scene TelaInicio) {
        this.TelaInicio = TelaInicio;
    }

    public void mostrar(Stage stage) {
   
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #C8A4A0;" + "-fx-padding: 35px;");
        Label titulo = new Label("Viaturas");

        titulo.setStyle("-fx-text-fill: white;" + "-fx-font-size: 52px;" + "-fx-font-family: Georgia;");
        Button btVoltar = new Button("Voltar ao início");

        btVoltar.setPrefWidth(255);
        btVoltar.setPrefHeight(55);

        btVoltar.setStyle("-fx-background-color: #5B151E;" + "-fx-text-fill: white;" + "-fx-font-size: 18px;" + "-fx-background-radius: 25px;");

        HBox topo = new HBox();

        topo.setAlignment(Pos.CENTER);
        HBox.setMargin(titulo, new Insets(0, 500, 0, 0));
        HBox.setMargin(btVoltar, new Insets(0, 0, 0, 500));
        topo.getChildren().addAll(titulo, btVoltar);

        VBox formulario = new VBox(7);

        formulario.setPrefWidth(450);
        formulario.setPrefHeight(590);
        formulario.setStyle("-fx-background-color: #F4E9DD;" + "-fx-border-color: #5B151E;" + "-fx-border-width: 9px;"
                + "-fx-border-radius: 30px;" + "-fx-background-radius: 30px;" + "-fx-padding: 30px;");

        Label tituloFormulario = new Label("Dados da Viatura");
        tituloFormulario.setStyle("-fx-text-fill: #5B151E;" + "-fx-font-size: 28px;" + "-fx-font-weight: bold;");

        Label lblTipo = new Label("Tipo");
        TextField txtTipo = new TextField();
        txtTipo.setPrefHeight(35);
        Label lblPrefixo = new Label("Prefixo");
        TextField txtPrefixo = new TextField();
        txtPrefixo.setPrefHeight(35);
        Label lblPlaca = new Label("Placa");
        TextField txtPlaca = new TextField();
        txtPlaca.setPrefHeight(35);
        Label lblStatus = new Label("Status");
        TextField txtStatus = new TextField();
        txtStatus.setPrefHeight(35);
        Label lblLocalizacao = new Label("Localização Atual ou última localização");

        TextField txtLocalizacao = new TextField();

        txtLocalizacao.setPrefHeight(35);

        Button btLimpar = new Button("Limpar");

        Button btSalvar = new Button("Salvar");

        btLimpar.setPrefWidth(170);
        btLimpar.setPrefHeight(40);

        btSalvar.setPrefWidth(170);
        btSalvar.setPrefHeight(40);

        btLimpar.setStyle("-fx-background-color: #D5BABA;" + "-fx-text-fill: #5B151E;"+"-fx-font-size: 15px;" + "-fx-background-radius: 20px;");
        btSalvar.setStyle("-fx-background-color: #D2AAAA;" + "-fx-text-fill: #5B151E;" + "-fx-font-size: 15px;"+"-fx-background-radius: 20px;");          

        HBox botoes = new HBox(25);

        botoes.setAlignment(Pos.CENTER);
        botoes.getChildren().addAll(btLimpar, btSalvar);

        formulario.getChildren().addAll(tituloFormulario, lblTipo, txtTipo, lblPrefixo, txtPrefixo,
                lblPlaca, txtPlaca, lblStatus, txtStatus, lblLocalizacao, txtLocalizacao, botoes);

        VBox historico = new VBox(15);

        historico.setPrefWidth(900);
        historico.setPrefHeight(590);

        historico.setStyle("-fx-background-color: #F4E9DD;" + "-fx-background-radius: 30px;" + "-fx-padding: 25px;");
        Label tituloHistorico = new Label("Histórico de viaturas");
        tituloHistorico.setStyle("-fx-background-color: #5B151E;" + "-fx-text-fill: white;" + "-fx-font-size: 25px;"
                +"-fx-font-weight: bold;" + "-fx-padding: 10px;" + "-fx-background-radius: 20px;");

        TextField txtPesquisar = new TextField();

        txtPesquisar.setPromptText("Pesquisar...");
        txtPesquisar.setPrefHeight(40);
        txtPesquisar.setStyle("-fx-background-color: #FFFDF5;" + "-fx-background-radius: 20px;");

        HBox cabecalho = new HBox();
        cabecalho.setPrefHeight(40);
        cabecalho.setStyle("-fx-background-color: #FFFDF5;" + "-fx-background-radius: 20px;");

        Label id = new Label("ID");
        Label prefixo = new Label("Prefixo");
        Label placa = new Label("Placa");
        Label tipo = new Label("Tipo");
        Label status = new Label("Status");
        Label localizacao = new Label("Localização atual");

        id.setPrefWidth(80);
        prefixo.setPrefWidth(130);
        placa.setPrefWidth(130);
        tipo.setPrefWidth(130);
        status.setPrefWidth(130);
        localizacao.setPrefWidth(250);

        id.setAlignment(Pos.CENTER);
        prefixo.setAlignment(Pos.CENTER);
        placa.setAlignment(Pos.CENTER);
        tipo.setAlignment(Pos.CENTER);
        status.setAlignment(Pos.CENTER);
        localizacao.setAlignment(Pos.CENTER);

        cabecalho.getChildren().addAll(id, prefixo, placa, tipo, status, localizacao);

        VBox lista = new VBox(5);
        lista.setPrefHeight(350);
        lista.setStyle("-fx-background-color: #5B151E;" + "-fx-background-radius: 0px 0px 30px 30px;" + "-fx-padding: 10px;");

        historico.getChildren().addAll(tituloHistorico, txtPesquisar, cabecalho, lista);

        HBox conteudo = new HBox(25);
        conteudo.setAlignment(Pos.CENTER);
        conteudo.getChildren().addAll(formulario, historico);
        btLimpar.setOnAction(e -> {txtTipo.clear();txtPrefixo.clear();txtPlaca.clear();txtStatus.clear();txtLocalizacao.clear();});

        btSalvar.setOnAction(e -> {

            int numero = lista.getChildren().size() + 1;

            HBox registro = new HBox();
            registro.setPrefHeight(35);
            Label valorId = new Label("" + numero);
            Label valorPrefixo = new Label(txtPrefixo.getText());
            Label valorPlaca = new Label(txtPlaca.getText());
            Label valorTipo = new Label(txtTipo.getText());
            Label valorStatus = new Label(txtStatus.getText());
            Label valorLocalizacao = new Label(txtLocalizacao.getText());

            valorId.setPrefWidth(80);
            valorPrefixo.setPrefWidth(130);
            valorPlaca.setPrefWidth(130);
            valorTipo.setPrefWidth(130);
            valorStatus.setPrefWidth(130);
            valorLocalizacao.setPrefWidth(250);

            valorId.setTextFill(javafx.scene.paint.Color.WHITE);

            valorPrefixo.setTextFill(javafx.scene.paint.Color.WHITE);

            valorPlaca.setTextFill(javafx.scene.paint.Color.WHITE);

            valorTipo.setTextFill(javafx.scene.paint.Color.WHITE);

            valorStatus.setTextFill(javafx.scene.paint.Color.WHITE);

            valorLocalizacao.setTextFill(javafx.scene.paint.Color.WHITE);

            valorId.setAlignment(Pos.CENTER);
            valorPrefixo.setAlignment(Pos.CENTER);
            valorPlaca.setAlignment(Pos.CENTER);
            valorTipo.setAlignment(Pos.CENTER);
            valorStatus.setAlignment(Pos.CENTER);
            valorLocalizacao.setAlignment(Pos.CENTER);

            registro.getChildren().addAll(valorId, valorPrefixo, valorPlaca, valorTipo, valorStatus, valorLocalizacao);

            lista.getChildren().add(registro);

            txtTipo.clear();
            txtPrefixo.clear();
            txtPlaca.clear();
            txtStatus.clear();
            txtLocalizacao.clear();
        });

        btVoltar.setOnAction(e -> {stage.setScene(TelaInicio);});
        root.setTop(topo);
        root.setCenter(conteudo);

        Scene scene = new Scene(root, 1536, 850);

        stage.setScene(scene);
        stage.setTitle("Viaturas");
        stage.show();
    }
}

