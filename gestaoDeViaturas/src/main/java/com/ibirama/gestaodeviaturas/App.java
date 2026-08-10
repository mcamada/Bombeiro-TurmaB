package com.ibirama.gestaodeviaturas;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        //Primeira Tela
        VBox root = new VBox();
        
        ButtonBar buttons = new ButtonBar();
        Button registerBt = new Button("Registrar");
        registerBt.setOnAction(event -> {
            register();
        });
        
        Button loginBt = new Button("Login");
        buttons.getButtons().addAll(registerBt, loginBt);
        
        Label titleHome = new Label("Gestão de Viaturas");
        
        root.getChildren().addAll(buttons, titleHome);
        
        Scene scene = new Scene(root, 480, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    public void register() {
        Stage registerWindow = new Stage();
        VBox root = new VBox();
        
        Label title = new Label("Cadastrar");
        
        Label lbLogin = new Label("Senha:");
        TextField login = new TextField();
        Label lbPassword = new Label("Senha:");
        PasswordField password = new PasswordField();
        Label lbPerfil = new Label("Perfil:");
        ComboBox<String> perfil = new ComboBox<>(FXCollections.observableArrayList("Operador", "Supervisor"));
        
        root.getChildren().addAll(title, lbLogin, login, lbPassword, password, lbPerfil);
    }

    public static void main(String[] args) {
        launch();
    }

}