package com.mycompany.projetocamada;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class TelaLogin {

    public static final double LARGURA = 890;
    public static final double ALTURA = 502;

    private final AnchorPane root;

    public TelaLogin(App app) {
        root = new AnchorPane();
        root.setBackground(TelaUtil.fundoDeImagem("/imagens/PrimeiraTela.png"));

        Label rotuloUsuario = new Label("Usuário:");
        rotuloUsuario.getStyleClass().add("rotulo");

        TextField campoUsuario = new TextField();
        campoUsuario.setPromptText("Digite seu usuário");
        campoUsuario.getStyleClass().add("campo");

        Label rotuloSenha = new Label("Senha:");
        rotuloSenha.getStyleClass().add("rotulo");

        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");
        campoSenha.getStyleClass().add("campo");

        Button botaoEntrar = new Button("Entrar");
        botaoEntrar.getStyleClass().add("botao-vermelho");
        botaoEntrar.setOnAction(event -> app.mostrarTelaCadastro());

        VBox formulario = new VBox(10, rotuloUsuario, campoUsuario, rotuloSenha, campoSenha, botaoEntrar);
        AnchorPane.setTopAnchor(formulario, 250.0);
        AnchorPane.setLeftAnchor(formulario, 285.0);

        root.getChildren().add(formulario);
    }

    public Parent getRoot() {
        return root;
    }
}
