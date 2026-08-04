package com.mycompany.sistemadeocorrencias;

import javafx.application.Application;
import static javafx.application.Application.launch;
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


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        VBox menu = new VBox(15);
        menu.setPrefWidth(250);
        menu.setStyle("-fx-background-color:#5B1A1F; -fx-padding;30;");

        Label titulo = new Label("Sistema de \nOcorrencia");
        titulo.setStyle("-fx-text-fill:white; -fx-font-size:28px");

        Button btOcorencias = new Button("Ocorrências");
        Button btComunicacao = new Button("Comunicação");
        Button btDespachos = new Button("Despachos");
        Button btViaturas = new Button("Viatura");
        Button btLocalizacao = new Button("Localização");
        Button btEquipe = new Button("Equipe");

        menu.getChildren().addAll(
                titulo,
                btOcorencias,
                btComunicacao,
                btDespachos,
                btViaturas,
                btLocalizacao,
                btEquipe
        );

        VBox login = new VBox(15);
        login.setStyle("-fx-padding; 40;");
        login.setAlignment(Pos.CENTER);

        Label lblLogin = new Label("SISTEMA DE DESPACHO E COMUNICAÇÃO");
        
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
        
        Scene scene = new Scene(root,900,500);
    }

    public static void main(String[] args) {
        launch();
    }

}
