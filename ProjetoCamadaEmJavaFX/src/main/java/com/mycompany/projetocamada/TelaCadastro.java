package com.mycompany.projetocamada;

import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class TelaCadastro {

    public static final double LARGURA = 890;
    public static final double ALTURA = 502;

    private final AnchorPane root;

    public TelaCadastro(App app) {
        root = new AnchorPane();
        root.setBackground(TelaUtil.fundoDeImagem("/imagens/SegundaTela.png"));

        GridPane grade = new GridPane();
        grade.setHgap(20);
        grade.setVgap(10);

        grade.add(criarRotulo("Usuário:"), 0, 0);
        grade.add(criarCampo("Digite o usuário"), 0, 1);

        grade.add(criarRotulo("Matrícula:"), 1, 0);
        grade.add(criarCampo("Digite a matrícula"), 1, 1);

        grade.add(criarRotulo("CPF:"), 0, 2);
        grade.add(criarCampo("000.000.000-00"), 0, 3);

        grade.add(criarRotulo("Patente:"), 1, 2);
        grade.add(criarCampo("Digite a patente"), 1, 3);

        grade.add(criarRotulo("Data de Nascimento:"), 0, 4);
        grade.add(criarCampo("dd/mm/aaaa"), 0, 5);

        grade.add(criarRotulo("Especialidade:"), 1, 4);
        grade.add(criarCampo("Digite a especialidade"), 1, 5);

        Button botaoEntrar = new Button("Entrar");
        botaoEntrar.getStyleClass().add("botao-vermelho");
        botaoEntrar.setOnAction(event -> app.mostrarTelaConsulta());
        grade.add(botaoEntrar, 0, 6, 2, 1);
        GridPane.setHalignment(botaoEntrar, HPos.CENTER);

        AnchorPane.setTopAnchor(grade, 215.0);
        AnchorPane.setLeftAnchor(grade, 115.0);

        root.getChildren().add(grade);
    }

    private Label criarRotulo(String texto) {
        Label rotulo = new Label(texto);
        rotulo.getStyleClass().add("rotulo");
        return rotulo;
    }

    private TextField criarCampo(String dica) {
        TextField campo = new TextField();
        campo.setPromptText(dica);
        campo.getStyleClass().add("campo");
        return campo;
    }

    public Parent getRoot() {
        return root;
    }
}
