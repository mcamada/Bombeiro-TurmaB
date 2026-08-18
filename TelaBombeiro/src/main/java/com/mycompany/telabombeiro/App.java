package com.mycompany.telabombeiro;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Font fonteTitulo = Font.font("Verdana",FontWeight.BOLD, FontPosture.REGULAR, 30);
        Font fonteCampos = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        Font fonteEntrada = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16);
        
        Label titulo = new Label("Login");
        titulo.setId("titulo");
        titulo.setFont(fonteTitulo);

        Label usuario = new Label("Nome de Guerra:");
        usuario.setId("usuario");
        usuario.setFont(fonteCampos);

        Label senha = new Label("Senha:");
        senha.setId("senha");
        senha.setFont(fonteCampos);

        TextField campoUsuario = new TextField();
        campoUsuario.setId("campoUsuario");
        campoUsuario.setFont(fonteEntrada);
        campoUsuario.setPromptText("Digite seu nome de guerra");
        campoUsuario.setPrefWidth(280);

        PasswordField campoSenha = new PasswordField();
        campoSenha.setId("campoSenha");
        campoSenha.setFont(fonteEntrada);
        campoSenha.setPromptText("Digite sua senha");
        campoSenha.setPrefWidth(280);

        GridPane campos = new GridPane();
        campos.setAlignment(Pos.CENTER);
        campos.setHgap(12);
        campos.setVgap(15);

        campos.add(usuario, 0, 0);
        campos.add(campoUsuario, 1, 0);

        campos.add(senha, 0, 1);
        campos.add(campoSenha, 1, 1);

        VBox root = new VBox();
        root.getStyleClass().add("root");
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(25);

        root.getChildren().add(titulo);
        root.getChildren().add(campos);
        
        //BOTÃO
        Button botaoEntrar = new Button("Entrar");
        root.getChildren().add(botaoEntrar);
        botaoEntrar.setId("botaoEntrar");

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("Sistema de Teste do JavaFX");
        stage.setScene(scene);
        
        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                Stage cadastro = new Stage();
                VBox rootCadastro = new VBox();
                
                rootCadastro.getChildren().add(new Label("teste"));
                Scene cenarioCadastro = new Scene(rootCadastro, 800, 600);
                
                cadastro.setScene(cenarioCadastro);
                
                cadastro.show();
            }
            
            
            
            
        };
        botaoEntrar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        
        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}