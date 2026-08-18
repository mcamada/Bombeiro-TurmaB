package com.ibirama.gestaodeviaturas;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
            dashboard(stage);
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
        
        TextField tipo = new TextField();
        TextField status = new TextField();
        TextField localizacao = new TextField();
        
        filters.getChildren().addAll(new Label("Tipo: "), tipo, new Label("Status: "), status, new Label("Localização: "), localizacao);
        
        VBox viaturas = new  VBox();
        
        HBox labels = new HBox();
        
        Label lbViatura = new Label("Viatura");
        Label lbTipo = new Label("Tipo");
        Label lbLocalizacao = new Label("Localizacao");
        Label lbStatus = new Label("Statu");
        
        labels.getChildren().addAll(lbViatura, lbTipo, lbLocalizacao, lbStatus);
        
        HBox viaturaBox = new HBox();
        Button moreInfos = new Button("...");
        Label nomeViatura = new Label("Viatura 1");
        Label localViatura = new Label("Quartel 3");
        Label tipoViatura = new Label("Resgate");
        Label statusViatura = new Label("disponível");
        Button editBt = new Button("Edit");
        editBt.setOnAction(eh -> {
            editWindow();
        });
        Button deleteBt = new Button("Delete");
        
        viaturaBox.getChildren().addAll(moreInfos, nomeViatura, tipoViatura, localViatura, statusViatura, editBt, deleteBt);
        
        
        viaturas.getChildren().addAll(labels, viaturaBox);
        
        Button addBt = new Button("+");
        addBt.setOnAction(eh -> {
            addViaturaWindow();
        });
        
        root.getChildren().addAll(title, filters, viaturas, addBt);
        
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        
    }
    
    public static void addViaturaWindow() {
        VBox root = new VBox();
        
        Label title = new Label("Cadastrar Viatura");
        
        HBox columns = new HBox();
        VBox column1 = new VBox();
        VBox column2 = new VBox();
        
        Label lbPrefixo = new Label("Prefixo:");
        TextField prefixo = new TextField();
        Label lbPlaca = new Label("Placa:");
        TextField placa = new TextField();
        Label lbFabricacao = new Label("Fabricacao:");
        TextField fabricacao = new TextField();
        column1.getChildren().addAll(lbPrefixo, prefixo, lbPlaca, placa, lbFabricacao, fabricacao);
        
        Label lbTipo = new Label("Tipo:");
        TextField tipo = new TextField();
        Label lbModelo = new Label("Modelo:");
        TextField modelo = new TextField();
        Label lbStatus = new Label("Statu:");
        TextField status = new TextField();
        column2.getChildren().addAll(lbTipo, tipo, lbModelo, modelo, lbStatus, status);
        
        columns.getChildren().addAll(column1, column2);
        
        Button update = new Button("Cadastrar");
        
        root.getChildren().addAll(title, columns, update);
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    public static void editWindow() {
        VBox root = new VBox();
        
        Label title = new Label("Atualizar Viatura");
        
        HBox columns = new HBox();
        VBox column1 = new VBox();
        VBox column2 = new VBox();
        
        Label lbPrefixo = new Label("Prefixo:");
        TextField prefixo = new TextField();
        Label lbPlaca = new Label("Placa:");
        TextField placa = new TextField();
        Label lbFabricacao = new Label("Fabricacao:");
        TextField fabricacao = new TextField();
        column1.getChildren().addAll(lbPrefixo, prefixo, lbPlaca, placa, lbFabricacao, fabricacao);
        
        Label lbTipo = new Label("Tipo:");
        TextField tipo = new TextField();
        Label lbModelo = new Label("Modelo:");
        TextField modelo = new TextField();
        Label lbStatus = new Label("Statu:");
        TextField status = new TextField();
        column2.getChildren().addAll(lbTipo, tipo, lbModelo, modelo, lbStatus, status);
        
        columns.getChildren().addAll(column1, column2);
        
        Button update = new Button("Atualizar");
        
        root.getChildren().addAll(title, columns, update);
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}