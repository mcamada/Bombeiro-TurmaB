package br.edu.ifc.treinoecapacitacao.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaLogin {

    private Stage stage;
    private TextField campoLogin;
    private PasswordField campoSenha;

    public TelaLogin(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label titulo = new Label("Treinamento e Capacitação");
        Label subtitulo = new Label("Acesso ao sistema");

        Label textoLogin = new Label("Login:");
        Label textoSenha = new Label("Senha:");

        campoLogin = new TextField();
        campoLogin.setPromptText("Digite seu login");

        campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        GridPane formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);
        formulario.setAlignment(Pos.CENTER);
        formulario.add(textoLogin, 0, 0);
        formulario.add(campoLogin, 1, 0);
        formulario.add(textoSenha, 0, 1);
        formulario.add(campoSenha, 1, 1);

        Button botaoEntrar = new Button("Entrar");
        Button botaoLimpar = new Button("Limpar");

        ButtonBar barraBotoes = new ButtonBar();
        barraBotoes.getButtons().addAll(botaoEntrar, botaoLimpar);

        botaoEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                verificarCampos();
            }
        });

        botaoLimpar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                limparCampos();
            }
        });

        VBox raiz = new VBox(15);
        raiz.setAlignment(Pos.CENTER);
        raiz.setPadding(new Insets(30));
        raiz.getChildren().addAll(titulo, subtitulo, formulario, barraBotoes);

        return new Scene(raiz, 500, 330);
    }

    private void verificarCampos() {
        String login = campoLogin.getText();
        String senha = campoSenha.getText();

        if (login.isBlank() || senha.isBlank()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos obrigatórios");
            alerta.setHeaderText("Preencha o login e a senha.");
            alerta.show();
            return;
        }

        TelaDashboard telaDashboard = new TelaDashboard(stage);
        stage.setScene(telaDashboard.criarCena());
        stage.setTitle("Painel - Treinamento e Capacitação");
    }

    private void limparCampos() {
        campoLogin.clear();
        campoSenha.clear();
        campoLogin.requestFocus();
    }
}
