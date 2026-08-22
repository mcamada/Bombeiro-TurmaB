package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Usuario;
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

    public TelaLogin(Stage stage) { this.stage = stage; }

    public Scene criarCena() {
        Label titulo = new Label("Treinamento e Capacitação");
        titulo.setId("tituloLogin");
        Label subtitulo = new Label("Acesso ao sistema");
        subtitulo.getStyleClass().add("subtitulo");

        campoLogin = new TextField();
        campoLogin.setPromptText("Digite seu login");
        campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        GridPane formulario = new GridPane();
        formulario.setHgap(10); formulario.setVgap(10); formulario.setAlignment(Pos.CENTER);
        formulario.getStyleClass().add("formulario");
        formulario.add(new Label("Login:"), 0, 0); formulario.add(campoLogin, 1, 0);
        formulario.add(new Label("Senha:"), 0, 1); formulario.add(campoSenha, 1, 1);

        Button botaoEntrar = new Button("Entrar");
        botaoEntrar.getStyleClass().add("botao-principal");
        Button botaoLimpar = new Button("Limpar");
        ButtonBar barra = new ButtonBar();
        barra.getButtons().addAll(botaoEntrar, botaoLimpar);

        botaoEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) { entrar(); }
        });
        botaoLimpar.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) { campoLogin.clear(); campoSenha.clear(); }
        });

        VBox raiz = new VBox(15);
        raiz.setAlignment(Pos.CENTER); raiz.setPadding(new Insets(30));
        raiz.getChildren().addAll(titulo, subtitulo, formulario, barra);
        Scene scene = new Scene(raiz, 500, 330);
        scene.getStylesheets().add("/css/style.css");
        return scene;
    }

    private void entrar() {
        if (campoLogin.getText().isBlank() || campoSenha.getText().isBlank()) {
            new Alert(Alert.AlertType.WARNING, "Preencha o login e a senha.").show();
            return;
        }

        Usuario encontrado = null;
        for (Usuario usuario : App.usuarios) {
            if (usuario.getLogin().equals(campoLogin.getText())
                    && usuario.getSenha().equals(campoSenha.getText())) {
                encontrado = usuario;
            }
        }

        if (encontrado == null) {
            new Alert(Alert.AlertType.ERROR, "Login ou senha inválidos.").show();
            return;
        }

        App.usuarioLogado = encontrado;
        App.historico.add("Login realizado por " + encontrado.getLogin());
        TelaDashboard tela = new TelaDashboard(stage);
        stage.setScene(tela.criarCena());
        stage.setTitle("Painel - Treinamento e Capacitação");
    }
}
