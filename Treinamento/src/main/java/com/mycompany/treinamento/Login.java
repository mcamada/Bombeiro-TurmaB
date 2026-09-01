package com.mycompany.treinamento;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login {

    private Stage stage;

    public Login(Stage stage) {
        this.stage = stage;
    }

    public Scene criarTela() {

        Label titulo = new Label("LOGIN");

        Label lNome = new Label("Nome");

        TextField txtNome = new TextField();

        Button btnEntrar = new Button("ENTRAR");

        btnEntrar.setOnAction(e -> {

            Cadastro cadastro = new Cadastro(stage);

            
        });

        VBox tela = new VBox(10);

        tela.setAlignment(Pos.CENTER);

        tela.getChildren().addAll(
                titulo,
                lNome,
                txtNome,
                btnEntrar
        );

        return new Scene(tela, 400, 300);
    }
}