package com.ibirama.gestaodeviaturas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    
    List<User> usuarios = new ArrayList<>();

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
        
        Label title = new Label("Registrar");
        title.setFont(Font.font(30));
        
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
        registrar.setOnAction((var eh) -> {
            if(login.getText().isBlank() || password.getText().isBlank() || perfil.getValue() == null || perfil.getValue().isBlank()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Algum campo não preenchido", ButtonType.OK);
                a.showAndWait();
            } else {
                usuarios.add(new User(login.getText(), password.getText(), perfil.getValue()));
                firstWindow(stage);
            }
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
        
        Label title = new Label("Entrar");
        title.setFont(Font.font(30));
        
        Label lbLogin = new Label("Login:");
        TextField login = new TextField();
        Label lbPassword = new Label("Senha:");
        PasswordField password = new PasswordField();
        
        ButtonBar buttons = new ButtonBar();
        
        Button voltar = new Button("Voltar");
        voltar.setOnAction(eh -> {
            firstWindow(stage);
        });
        Button loginBt = new Button("Entrar");
        loginBt.setOnAction(eh -> {
            if(login.getText().isBlank() || password.getText().isBlank()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Algum campo não preenchido", ButtonType.OK);
                a.showAndWait();
            } else {
                for(User user : usuarios) {
                    if(login.getText().equals(user.login)) {
                        if(password.getText().equals(user.password)) {
                            dashboard(stage);
                        } else {
                            Alert a = new Alert(Alert.AlertType.INFORMATION, "Senha incorreta", ButtonType.OK);
                            a.showAndWait();
                        }
                    } else {
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Login invalido", ButtonType.OK);
                        a.showAndWait();
                    }
                }
            }
        });
        
        buttons.getButtons().addAll(voltar, loginBt);
        
        root.getChildren().addAll(title, lbLogin, login, lbPassword, password, buttons);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        
        Scene scene = new Scene(root, 480, 480);
        stage.setScene(scene);
    }
    
    public void atualizarListaViaturas(VBox viaturasBox, Stage stage, TextField type, TextField stats, TextField local) {
        viaturasBox.getChildren().clear();
        List<Viatura> filterViaturas = viaturas;
        
        if(!type.getText().isBlank()) {
           filterViaturas = filterViaturas.stream().filter(v -> v.type.toString().toLowerCase().contains(type.getText().toLowerCase())).collect(Collectors.toList());
        }
        
        if(!stats.getText().isBlank()) {
           filterViaturas = filterViaturas.stream().filter(v -> v.stats.toString().toLowerCase().contains(stats.getText().toLowerCase())).collect(Collectors.toList());
        }
        
        if(!local.getText().isBlank()) {
           filterViaturas = filterViaturas.stream().filter(v -> v.local.toLowerCase().contains(local.getText().toLowerCase())).collect(Collectors.toList());
        }
        
        for(Viatura v : filterViaturas) {
            viaturasBox.getChildren().add(viaturaCard(stage, v));
        }
    }
    
    public void dashboard(Stage stage) {
        VBox root = new VBox();
        
        Label title = new Label("Consulta de Viaturas");
        title.setFont(Font.font(30));
        
        Label lbFilter = new Label("Filtros");
        
        HBox filters = new HBox();
        
        TextField type = new TextField();
        TextField stats = new TextField();
        TextField local = new TextField();
        
        filters.getChildren().addAll(new Label("Tipo: "), type, new Label("Status: "), stats, new Label("Localização: "), local);
        filters.setSpacing(20);
        
        VBox viaturasBox = new  VBox();
        viaturasBox.setSpacing(20);
        
        atualizarListaViaturas(viaturasBox, stage, type, stats, local);
        
        Button addBt = new Button("+");
        addBt.setOnAction(eh -> {
            addViaturaWindow(stage);
        });
        
        type.setOnKeyReleased(eh -> {
            atualizarListaViaturas(viaturasBox, stage, type, stats, local);
        });
        
        stats.setOnKeyReleased(eh -> {
            atualizarListaViaturas(viaturasBox, stage, type, stats, local);
        });
        
        local.setOnKeyReleased(eh -> {
            atualizarListaViaturas(viaturasBox, stage, type, stats, local);
        });
        
        root.getChildren().addAll(title, lbFilter, filters, viaturasBox, addBt);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
    }
    
    public HBox viaturaCard(Stage stage, Viatura viatura) {
        HBox card = new HBox();
        
        Label name = new Label(viatura.prefix.toString());
        Label local = new Label(viatura.local);
        Label type = new Label(viatura.type.toString());
        Label stats = new Label(viatura.stats.toString());
        Button editBt = new Button("Edit");
        editBt.setOnAction(eh -> {
            editWindow(stage, viatura);
        });
        Button deleteBt = new Button("-");
        deleteBt.setOnAction(eh -> {
            Alert a = new Alert(Alert.AlertType.NONE, "Quer mesmo deletar essa viatura?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> resultado = a.showAndWait();
            if(resultado.isPresent() && resultado.get() == ButtonType.YES) {
                viaturas.remove(viatura);
                dashboard(stage);
            }
        });
        
        deleteBt.setStyle("-fx-background-color: red; -fx-background-radius: 8;");
        
        card.getChildren().addAll( name, type, local, stats, editBt, deleteBt);
        
        card.setSpacing(16);
        card.setPadding(new Insets(16));
        card.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 8;");
        
        return card;
    }
    
    public void addViaturaWindow(Stage dashboardStage) {
        Stage stage = new Stage();
        VBox root = new VBox();
        
        Label title = new Label("Cadastrar Viatura");
        title.setFont(Font.font(30));
        
        HBox columns = new HBox();
        VBox column1 = new VBox();
        VBox column2 = new VBox();
        
        Label lbPrefixo = new Label("Prefixo:");
        ComboBox<Prefixo> prefixo = new ComboBox<>();
        prefixo.getItems().setAll(Prefixo.values());
        Label lbPlaca = new Label("Placa:");
        TextField placa = new TextField();
        Label lbFabricacao = new Label("Fabricacao:");
        DatePicker fabricacao = new DatePicker();
        Label lbLocal = new Label("Local:");
        TextField local = new TextField();
        column1.getChildren().addAll(lbPrefixo, prefixo, lbPlaca, placa, lbFabricacao, fabricacao, lbLocal, local);
        
        Label lbTipo = new Label("Tipo:");
        ComboBox<Tipo> tipo = new ComboBox<>();
        tipo.getItems().setAll(Tipo.values());
        Label lbModelo = new Label("Modelo:");
        TextField modelo = new TextField();
        Label lbStatus = new Label("Status:");
        ComboBox<Status> status = new ComboBox<>();
        status.getItems().setAll(Status.values());
        column2.getChildren().addAll(lbTipo, tipo, lbModelo, modelo, lbStatus, status);
        
        columns.getChildren().addAll(column1, column2);
        
        columns.setSpacing(15);
        
        Button cadastrarBt = new Button("Cadastrar");
        cadastrarBt.setOnAction(eh -> {
            if(prefixo.getValue() == null || placa.getText().isBlank() || fabricacao.getValue() == null || local.getText().isBlank() || tipo.getValue() == null || modelo.getText().isBlank() || status.getValue() == null) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Algum campo não preenchido", ButtonType.OK);
                a.showAndWait();
            } else {
                viaturas.add(new Viatura(prefixo.getValue(), placa.getText(), fabricacao.getValue(), local.getText(), modelo.getText(), tipo.getValue(), status.getValue()));
                dashboard(dashboardStage);
                stage.close();
            }
        });
        
        root.getChildren().addAll(title, columns, cadastrarBt);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    public void editWindow(Stage dashboardStage, Viatura viatura) {
        Stage stage = new Stage();
        VBox root = new VBox();
        
        Label title = new Label("Atualizar Viatura");
        title.setFont(Font.font(30));
        
        HBox columns = new HBox();
        VBox column1 = new VBox();
        VBox column2 = new VBox();
        
        Label lbPrefixo = new Label("Prefixo:");
        ComboBox<Prefixo> prefixo = new ComboBox<>();
        prefixo.getItems().setAll(Prefixo.values());
        prefixo.getSelectionModel().select(viatura.prefix);
        Label lbPlaca = new Label("Placa:");
        TextField placa = new TextField(viatura.placa);
        Label lbFabricacao = new Label("Fabricacao:");
        DatePicker fabricacao = new DatePicker();
        fabricacao.setValue(viatura.fabrication);
        Label lbLocal = new Label("Local:");
        TextField local = new TextField(viatura.local);
        column1.getChildren().addAll(lbPrefixo, prefixo, lbPlaca, placa, lbFabricacao, fabricacao, lbLocal, local);
        
        Label lbTipo = new Label("Tipo:");
        ComboBox<Tipo> tipo = new ComboBox<>();
        tipo.getItems().setAll(Tipo.values());
        tipo.getSelectionModel().select(viatura.type);
        Label lbModelo = new Label("Modelo:");
        TextField modelo = new TextField(viatura.model);
        Label lbStatus = new Label("Statu:");
        ComboBox<Status> status = new ComboBox<>();
        status.getItems().setAll(Status.values());
        status.getSelectionModel().select(viatura.stats);
        column2.getChildren().addAll(lbTipo, tipo, lbModelo, modelo, lbStatus, status);
        
        columns.getChildren().addAll(column1, column2);
        
        columns.setSpacing(15);
        
        Button update = new Button("Atualizar");
        update.setOnAction(eh -> {
            if(prefixo.getValue() == null || placa.getText().isBlank() || fabricacao.getValue() == null || local.getText().isBlank() || tipo.getValue() == null || modelo.getText().isBlank() || status.getValue() == null) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Algum campo não preenchido", ButtonType.OK);
                a.showAndWait();
            } else {
                viatura.prefix = prefixo.getValue();
                viatura.placa = placa.getText();
                viatura.fabrication = fabricacao.getValue();
                viatura.local = local.getText();
                viatura.type = tipo.getValue();
                viatura.model = modelo.getText();
                viatura.stats = status.getValue();
                dashboard(dashboardStage);
                stage.close();
            }
        });
        
        root.getChildren().addAll(title, columns, update);
        
        root.setPadding(new Insets(15));
        root.setSpacing(20);
        
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

class Viatura {
    Prefixo prefix;
    String placa;
    LocalDate fabrication;
    String model;
    Tipo type;
    Status stats;
    String local;

    public Viatura(Prefixo prefix, String placa, LocalDate fabrication, String local, String model, Tipo type, Status stats) {
        this.prefix = prefix;
        this.placa = placa;
        this.fabrication = fabrication;
        this.model = model;
        this.type = type;
        this.stats = stats;
        this.local = local;
    }
}

class User {
    String login;
    String password;
    String perfil;

    public User(String login, String password, String perfil) {
        this.login = login;
        this.password = password;
        this.perfil = perfil;
    }
}

enum Prefixo {
    ASU("ASU"),
    ABTR("ABTR"),
    ABS("ABS"),
    AT_ACT("AT_ACT"),
    AEM("AEM"),
    APC("APC"),
    ABRESC("ABRESC"),
    AM("AM"),
    ARCANJO("ARCANJO");
    
    private final String label;

    private Prefixo(String label) {
        this.label = label;
    }
    
    @Override
    public String toString() {
        return this.label;
    }
}

enum Status {
    OPERACIONAL_DISPONIVEL("Operacional Disponível"),
    BAIXA_MANUTENCAO("Manutenção"),
    ADMINISTRATIVO("Adminitrativo");
    
    private final String label;

    private Status(String label) {
        this.label = label;
    }
    
    @Override
    public String toString() {
        return this.label;
    }
}

enum Tipo {
    AUTO_SOCORRO_DE_URGENCIA("Auto socorro de urgencia"),
    AUTO_BOMBA_TANQUE_RESGATE("Auto bomba tanque resgate"),
    AUTO_BOMBA_SALVAMENTO("Auto bomba salvamento"),
    AUTO_TANQUE_AUTO_CARRETA_TANQUE("Auto tanque"),
    AUTO_ESCADA_MECANICA("Auto escada mecanica"),
    AUTO_POSTO_DE_COMANDO("Auto posto de comando"),
    AUTO_BUSCA_SALVAMENTO_COM_CAES("Auto busca salvamento com caes"),
    AUTO_MOTO("Auto moto"),
    HELICOPTERO_AVIOES("Helicoptero Avioes");
    
    private final String label;

    private Tipo(String label) {
        this.label = label;
    }
    
    @Override
    public String toString() {
        return this.label;
    }
}
