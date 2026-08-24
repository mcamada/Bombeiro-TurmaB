package com.mycompany.projetocamada;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TelaConsulta {

    public static final double LARGURA = 890;
    public static final double ALTURA = 502;

    private final AnchorPane root;

    public TelaConsulta(App app) {
        root = new AnchorPane();
        root.setBackground(TelaUtil.fundoDeImagem("/imagens/TerceiraTela.png"));

        Button botaoConsultar = new Button("Consultar os Bombeiros");
        botaoConsultar.getStyleClass().add("botao-vermelho");
        botaoConsultar.setOnAction(event -> app.mostrarTelaLista());

        AnchorPane.setTopAnchor(botaoConsultar, 330.0);
        AnchorPane.setLeftAnchor(botaoConsultar, 285.0);

        root.getChildren().add(botaoConsultar);
    }

    public Parent getRoot() {
        return root;
    }
}
