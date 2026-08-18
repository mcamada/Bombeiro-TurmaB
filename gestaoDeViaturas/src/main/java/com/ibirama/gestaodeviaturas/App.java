package com.ibirama.gestaodeviaturas;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    List<Viatura> viaturas = new ArrayList<>();

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
        
        Label title = new Label("Gestão de Viaturas");
        title.setFont(Font.font(30));
        
        root.getChildren().addAll(buttons, title);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        
        Scene scene = new Scene(root, 480, 160);
        stage.setScene(scene);
    }
    
    public void register(Stage stage) {
        VBox root = new VBox();
        
        Label title = new Label("Cadastrar");
        title.setFont(Font.font(30));
        
        Label lbLogin = new Label("Login:");
        TextField login = new TextField();
        Label lbPassword = new Label("Senha:");
        PasswordField password = new PasswordField();
        Label lbPerfil = new Label("Perfil:");
        ComboBox<String> perfil = new ComboBox<>(FXCollections.observableArrayList("Operador", "Supervisor"));
        
        ButtonBar buttons = new ButtonBar();
        
        Button registrar = new Button("Regitrar");
        Button voltar = new Button("<-");
        voltar.setOnAction(event -> {
            firstWindow(stage);
        });
        registrar.setOnAction(eh -> {
            firstWindow(stage);
        });
        
        buttons.getButtons().addAll(voltar, registrar);
        
        root.getChildren().addAll(title, lbLogin, login, lbPassword, password, lbPerfil, perfil, buttons);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        
        Scene scene = new Scene(root, 480, 480);
        stage.setScene(scene);
    }
    
    public void login(Stage stage) {
        VBox root = new VBox();
        
        Label title = new Label("Login");
        title.setFont(Font.font(30));
        
        Label lbLogin = new Label("Login:");
        TextField login = new TextField();
        Label lbPassword = new Label("Senha:");
        PasswordField password = new PasswordField();
        
        ButtonBar buttons = new ButtonBar();
        
        Button voltar = new Button("<-");
        voltar.setOnAction(eh -> {
            firstWindow(stage);
        });
        Button loginBt = new Button("Login");
        loginBt.setOnAction(eh -> {
            dashboard(stage);
        });
        
        buttons.getButtons().addAll(voltar, loginBt);
        
        root.getChildren().addAll(title, lbLogin, login, lbPassword, password, buttons);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        
        Scene scene = new Scene(root, 480, 480);
        stage.setScene(scene);
    }
    
    public void dashboard(Stage stage) {
        VBox root = new VBox();
        
        Label title = new Label("Consulta de Viaturas");
        title.setFont(Font.font(30));
        
        Label lbFilter = new Label("Filtros");
        
        HBox filters = new HBox();
        
        TextField tipo = new TextField();
        TextField status = new TextField();
        TextField localizacao = new TextField();
        
        filters.getChildren().addAll(new Label("Tipo: "), tipo, new Label("Status: "), status, new Label("Localização: "), localizacao);
        
        VBox viaturas = new  VBox();
        
        viaturas.getChildren().addAll(labels, );
        
        Button addBt = new Button("+");
        addBt.setOnAction(eh -> {
            addViaturaWindow();
        });
        
        root.getChildren().addAll(title, lbFilter, filters, viaturas, addBt);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        
    }
    
    public static HBox viaturaCard(Viatura viatura) {
        HBox card = new HBox();
        
        Label nomeViatura = new Label("Viatura 1");
        Label localViatura = new Label("Quartel 3");
        Label tipoViatura = new Label("Resgate");
        Label statusViatura = new Label("disponível");
        Button editBt = new Button("Edit");
        editBt.setOnAction(eh -> {
            editWindow();
        });
        Button deleteBt = new Button("Delete");
        
        card.getChildren().addAll( nomeViatura, tipoViatura, localViatura, statusViatura, editBt, deleteBt);
        
        return card;
    }
    
    public static void addViaturaWindow() {
        VBox root = new VBox();
        
        Label title = new Label("Cadastrar Viatura");
        title.setFont(Font.font(30));
        
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
        Label lbStatus = new Label("Status:");
        TextField status = new TextField();
        column2.getChildren().addAll(lbTipo, tipo, lbModelo, modelo, lbStatus, status);
        
        columns.getChildren().addAll(column1, column2);
        
        columns.setSpacing(15);
        
        Button update = new Button("Cadastrar");
        
        root.getChildren().addAll(title, columns, update);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    public static void editWindow() {
        VBox root = new VBox();
        
        Label title = new Label("Atualizar Viatura");
        title.setFont(Font.font(30));
        
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
        
        columns.setSpacing(15);
        
        Button update = new Button("Atualizar");
        
        root.getChildren().addAll(title, columns, update);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

class Viatura {
    String prefixo;
    String placa;
    String fabricacao;
    String modelo;
    String tipo;
    String status;

    public Viatura(String prefixo, String placa, String fabricacao, String modelo, String tipo, String status) {
        this.prefixo = prefixo;
        this.placa = placa;
        this.fabricacao = fabricacao;
        this.modelo = modelo;
        this.tipo = tipo;
        this.status = status;
    }
}