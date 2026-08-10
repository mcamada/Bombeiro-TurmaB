package com.mycompany.telabombeiro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Font fTitulo = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
        Font fCampos = Font.font("Verdana", FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fInput = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20);
        
        Label titulo = new Label("                                    Login");
        
        GridPane campos = new GridPane();
        
        Label usuario = new Label("Nome de Guerra:");
        Label senha = new Label("Senha:");
        campos.add(usuario, 0, 0);
        campos.add(senha, 0, 1);
        
        TextField campoUsuario = new TextField();
        campoUsuario.setFont(fInput);
        campos.add(campoUsuario, 1, 0);
        
        PasswordField campoSenha = new PasswordField();
        campoSenha.setFont(fInput);
        campos.add(campoSenha, 1, 1);
        
        titulo.setFont(fTitulo);
        usuario.setFont(fCampos);
        senha.setFont(fCampos);
        
        
        VBox root = new VBox();
        
        root.getChildren().add(titulo);
        root.getChildren().add(campos);
        
        
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Systema e teste do JavaFX");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}