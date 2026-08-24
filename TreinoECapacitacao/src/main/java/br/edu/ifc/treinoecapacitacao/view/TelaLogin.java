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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
        VBox ladoEsquerdo = criarLadoEsquerdo();
        VBox ladoDireito = criarLadoDireito();

        HBox raiz = new HBox();
        raiz.getStyleClass().add("login-raiz");
        raiz.getChildren().addAll(ladoEsquerdo, ladoDireito);

        Scene scene = new Scene(raiz, 900, 560);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private VBox criarLadoEsquerdo() {
        Label marca = new Label("TREINAMENTO & CAPACITAÇÃO");
        marca.getStyleClass().add("marca-login");

        Label titulo = new Label("Gestão de treinamentos e capacitações");
        titulo.getStyleClass().add("titulo-login-grande");
        titulo.setWrapText(true);

        Label texto = new Label("Controle cursos, participantes, instrutores e certificados em um único sistema.");
        texto.getStyleClass().add("texto-login");
        texto.setWrapText(true);

        Label etiquetaInterno = new Label("CURSOS INTERNOS");
        etiquetaInterno.getStyleClass().add("etiqueta-login");

        Label etiquetaExterno = new Label("CURSOS EXTERNOS");
        etiquetaExterno.getStyleClass().add("etiqueta-login");

        Label etiquetaCertificado = new Label("CERTIFICAÇÃO");
        etiquetaCertificado.getStyleClass().add("etiqueta-login");

        HBox etiquetas = new HBox(8);
        etiquetas.getChildren().addAll(
                etiquetaInterno,
                etiquetaExterno,
                etiquetaCertificado
        );

        VBox lado = new VBox(22);
        lado.getStyleClass().add("login-lado-esquerdo");
        lado.setPadding(new Insets(55));
        lado.setAlignment(Pos.CENTER_LEFT);
        lado.getChildren().addAll(
                marca,
                titulo,
                texto,
                etiquetas
        );

        return lado;
    }

    private VBox criarLadoDireito() {
        Label titulo = new Label("Acessar sistema");
        titulo.setId("tituloLogin");

        Label subtitulo = new Label("Entre com um dos usuários abaixo para continuar.");
        subtitulo.getStyleClass().add("subtitulo");
        subtitulo.setWrapText(true);

        Label textoLogin = new Label("Login");
        textoLogin.getStyleClass().add("label-campo");

        campoLogin = new TextField();
        campoLogin.setPromptText("Digite seu login");

        Label textoSenha = new Label("Senha");
        textoSenha.getStyleClass().add("label-campo");

        campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        Button botaoEntrar = new Button("Entrar");
        botaoEntrar.getStyleClass().add("botao-principal");
        botaoEntrar.setMaxWidth(Double.MAX_VALUE);

        Button botaoLimpar = new Button("Limpar");
        botaoLimpar.setMaxWidth(Double.MAX_VALUE);

        HBox botoes = new HBox(10);
        botoes.getChildren().addAll(botaoEntrar, botaoLimpar);

        Label tituloLogins = new Label("Usuários disponíveis");
        tituloLogins.getStyleClass().add("titulo-logins");

        Label coordenador = new Label("Coordenador   •   login: coordenador   •   senha: 123");
        coordenador.getStyleClass().add("login-disponivel");

        Label instrutor = new Label("Instrutor        •   login: instrutor        •   senha: 123");
        instrutor.getStyleClass().add("login-disponivel");

        Label supervisor = new Label("Supervisor   •   login: supervisor   •   senha: 123");
        supervisor.getStyleClass().add("login-disponivel");

        VBox logins = new VBox(7);
        logins.getStyleClass().add("logins-teste");
        logins.getChildren().addAll(
                tituloLogins,
                coordenador,
                instrutor,
                supervisor
        );

        VBox cartao = new VBox(11);
        cartao.getStyleClass().add("cartao-login");
        cartao.getChildren().addAll(
                titulo,
                subtitulo,
                textoLogin,
                campoLogin,
                textoSenha,
                campoSenha,
                botoes,
                logins
        );

        VBox lado = new VBox();
        lado.getStyleClass().add("login-lado-direito");
        lado.setPadding(new Insets(45));
        lado.setAlignment(Pos.CENTER);
        lado.getChildren().add(cartao);

        botaoEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                entrar();
            }
        });

        botaoLimpar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                limparCampos();
            }
        });

        return lado;
    }

    private void entrar() {
        String login = campoLogin.getText();
        String senha = campoSenha.getText();

        if (login.isBlank() || senha.isBlank()) {
            Alert alerta = new Alert(
                    Alert.AlertType.WARNING,
                    "Preencha o login e a senha."
            );

            alerta.show();
            return;
        }

        Usuario encontrado = null;

        for (Usuario usuario : App.usuarios) {
            boolean mesmoLogin = usuario.getLogin().equals(login);
            boolean mesmaSenha = usuario.getSenha().equals(senha);

            if (mesmoLogin && mesmaSenha) {
                encontrado = usuario;
            }
        }

        if (encontrado == null) {
            Alert alerta = new Alert(
                    Alert.AlertType.ERROR,
                    "Login ou senha inválidos."
            );

            alerta.show();
            return;
        }

        App.usuarioLogado = encontrado;
        App.historico.add("Login realizado por " + encontrado.getLogin());

        TelaDashboard telaDashboard = new TelaDashboard(stage);
        Scene scene = telaDashboard.criarCena();

        stage.setScene(scene);
        stage.setTitle("Painel - Treinamento e Capacitação");
    }

    private void limparCampos() {
        campoLogin.clear();
        campoSenha.clear();
        campoLogin.requestFocus();
    }
}
