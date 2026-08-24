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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Font fonteTitulo = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
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

        //GridPane
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

        //Segunda Tela
        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage ocorrencias = new Stage();

                Font fonteTituloTelaOcorrencias = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);

                VBox rootTelaOcorrencias = new VBox();
                rootTelaOcorrencias.setAlignment(Pos.TOP_CENTER);
                
                
                Label tituloOcorrencias = new Label("Ocorrências");
                tituloOcorrencias.setId("tituloOcorrencias");
                tituloOcorrencias.setFont(fonteTituloTelaOcorrencias);

                //sub+titulos = subtitulos
                Label local = new Label("Local");
                local.setId("local");

                Label data = new Label("Data");
                data.setId("data");

                Label hora = new Label("Hora");
                hora.setId("hora");

                Label equipe = new Label("Equipe");
                equipe.setId("equipe");

                Label tipo = new Label("Tipo");
                tipo.setId("tipo");

                Label descricao = new Label("Descrição");
                descricao.setId("descricao");
                
                //coisas
                Label localCoisa = new Label("Casa do Zanella");
                local.setId("local");

                Label dataCoisa = new Label("20/10/1981");
                data.setId("data");

                Label horaCoisa = new Label("23:99");
                hora.setId("hora");

                Label equipeCoisa = new Label("Bazanella");
                equipe.setId("equipe");

                Label tipoCoisa = new Label("Muito tempo na hora H");
                tipo.setId("tipo");

                Label descricaoCoisa = new Label("Tempo muito passado");
                descricao.setId("descricao");

                GridPane telaOcorrencias = new GridPane();
                telaOcorrencias.setHgap(12);
                telaOcorrencias.setVgap(15);
                telaOcorrencias.setAlignment(Pos.CENTER);

                telaOcorrencias.add(local, 0, 0);
                telaOcorrencias.add(data, 1, 0);
                telaOcorrencias.add(hora, 2, 0);
                telaOcorrencias.add(equipe, 3, 0);
                telaOcorrencias.add(tipo, 4, 0);
                telaOcorrencias.add(descricao, 5, 0);

                telaOcorrencias.add(localCoisa, 0, 1);
                telaOcorrencias.add(dataCoisa, 1, 1);
                telaOcorrencias.add(horaCoisa, 2, 1);
                telaOcorrencias.add(equipeCoisa, 3, 1);
                telaOcorrencias.add(tipoCoisa, 4, 1);
                telaOcorrencias.add(descricaoCoisa, 5, 1);
                
                rootTelaOcorrencias.getChildren().add(tituloOcorrencias);
                rootTelaOcorrencias.getChildren().add(telaOcorrencias);

                Scene Ocorrencias = new Scene(rootTelaOcorrencias, 800, 600);

                Ocorrencias.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

                ocorrencias.setTitle("Ocorrências");
                ocorrencias.setScene(Ocorrencias);
                ocorrencias.show();
            }
        };

        //Resto
        botaoEntrar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
