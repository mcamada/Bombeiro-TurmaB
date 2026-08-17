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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        firstWindow(stage);
        stage.show();
    }
    
    public void firstWindow(Stage stage) {
        VBox root = new VBox();
        
        ButtonBar buttons = new ButtonBar();
        Button registerBt = new Button("Registrar");
        registerBt.setOnAction(event -> {
            register(stage);
        });
        
        Button loginBt = new Button("Login");
        buttons.getButtons().addAll(registerBt, loginBt);
        loginBt.setOnAction(eh -> {
            login(stage);
        });
        
        Label titleHome = new Label("Gestão de Viaturas");
        
        root.getChildren().addAll(buttons, titleHome);
        
        Scene scene = new Scene(root, 480, 480);
        stage.setScene(scene);
    }
    
    public void register(Stage stage) {
        VBox root = new VBox();
        
        Label title = new Label("Cadastrar");
        
        Label lbLogin = new Label("Login:");
        TextField login = new TextField();
        Label lbPassword = new Label("Senha:");
        PasswordField password = new PasswordField();
        Label lbPerfil = new Label("Perfil:");
        ComboBox<String> perfil = new ComboBox<>(FXCollections.observableArrayList("Operador", "Supervisor"));
        
        ButtonBar buttons = new ButtonBar();
        
        Button registrar = new Button("Regitrar");
        Button voltar = new Button("Voltar");
        voltar.setOnAction(event -> {
            firstWindow(stage);
        });
        registrar.setOnAction(eh -> {
            firstWindow(stage);
        });
        
        buttons.getButtons().addAll(voltar, registrar);
        
        root.getChildren().addAll(title, lbLogin, login, lbPassword, password, lbPerfil, perfil, buttons);
        
        Scene scene = new Scene(root, 480, 480);
        stage.setScene(scene);
    }
    
    public void login(Stage stage) {
        VBox root = new VBox();
        
        Label title = new Label("Login");
        
        Label lbLogin = new Label("Login:");
        TextField login = new TextField();
        Label lbPassword = new Label("Senha:");
        PasswordField password = new PasswordField();
        
        ButtonBar buttons = new ButtonBar();
        
        Button voltar = new Button("Voltar");
        voltar.setOnAction(eh -> {
            firstWindow(stage);
        });
        Button loginBt = new Button("Login");
        loginBt.setOnAction(eh -> {
            firstWindow(stage);
        });
        
        buttons.getButtons().addAll(voltar, loginBt);
        
        root.getChildren().addAll(title, lbLogin, login, lbPassword, password, buttons);
        
        Scene scene = new Scene(root, 480, 480);
        stage.setScene(scene);
    }
    
    public void dashboard(Stage stage) {
        VBox root = new VBox();
        
        Label title = new Label("Consulta de Viaturas");
        
        HBox filters = new HBox();
        
        TextField tipo = new TextField("Tipo");
        TextField status = new TextField("status");
        TextField localizacao = new TextField("localizacao");
        
        filters.getChildren().addAll(tipo, status, localizacao);
        
        VBox viaturas = new  VBox();
        
        HBox labels = new HBox();
        
        Label lbViatura = new Label("Viatura");
        Label lbTipo = new Label("Tipo");
        Label lbLocalizacao = new Label("Localizacao");
        Label lbStatus = new Label("Statu");
        
        labels.getChildren().addAll(lbViatura, lbTipo, lbLocalizacao, lbStatus);
        
        HBox ViaturaBox = new HBox();
        Button moreInfos = new Button("...");
        Label nomeViatura = new Label("Viatura 1");
        
        
        viaturas.getChildren().addAll(labels);
        
    }

    public static void main(String[] args) {
        launch();
    }

}