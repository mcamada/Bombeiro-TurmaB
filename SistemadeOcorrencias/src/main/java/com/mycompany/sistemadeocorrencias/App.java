package com.mycompany.sistemadeocorrencias;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        VBox menu = new VBox(15);
        menu.setPrefWidth(250);
        menu.setStyle(
                "-fx-background-color:#5B1A1F; "
                + "-fx-padding;30;"
        );
        Label titulo = new Label("Sistema de \nOcorrencia");
        titulo.setStyle("-fx-text-fill:white; -fx-font-size:28px");

        Button btOcorencias = new Button("Ocorrências");
        Button btComunicacao = new Button("Comunicação");
        Button btDespachos = new Button("Despachos");
        Button btViaturas = new Button("Viatura");
        Button btLocalizacao = new Button("Localização");
        Button btEquipe = new Button("Equipe");

        Button[] botoes = {
            btOcorencias,
            btComunicacao,
            btDespachos,
            btViaturas,
            btLocalizacao,
            btEquipe
        };

        for (Button botao : botoes) {
            botao.setPrefWidth(270);
            botao.setPrefHeight(45);

            botao.setStyle(
                    "-fx-background-color:F4E9DD;"
                    + "-fx-text-fill: #5B171F;"
                    + "-fx-font-size: 17px;"
                    + "-fx-font-weight: bold;"
                    + "-fx-background-radius: 20;"
            );
}
            menu.getChildren().addAll(
                    titulo,
                    btOcorencias,
                    btComunicacao,
                    btDespachos,
                    btViaturas,
                    btLocalizacao,
                    btEquipe
            );


        VBox login = new VBox(18);
        
        login.setAlignment(Pos.CENTER);
        login.setMaxWidth(650);
        
        login.setStyle(
                "-fx-background-color: #FE9DD;" +
                "-fx-border-color: #5B171F;" +
               "-fx-border-width: 9;" +
                        "-fx-border-radius: 30;" +
                        "-fx-background-radius: 30;" +
                        "-fx-padding 40;"
        );
        Label lblLogin = new Label("SISTEMA DE DESPACHO E COMUNICAÇÃO");
        
        tituloLogin.setStyle(
        "-fx-text-fill: #5B171F;" +
                "-fx-font-size: 21px;" +
                "-fx-"
        );
        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome");

        PasswordField txtSenha = new PasswordField();
        txtSenha.setPromptText("Senha");

        CheckBox Lembrar = new CheckBox("Lembrar-me");

        Button btEntrar = new Button("Entrar");

        login.getChildren().addAll(
                lblLogin,
                txtNome,
                txtSenha,
                Lembrar,
                btEntrar
        );

        root.setLeft(menu);
        root.setCenter(login);

        Scene scene = new Scene(root, 900, 500);
    }

    public static void main(String[] args) {
        launch();
    }

}
