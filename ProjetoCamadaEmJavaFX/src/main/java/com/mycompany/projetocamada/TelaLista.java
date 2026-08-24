package com.mycompany.projetocamada;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TelaLista {

    public static final double LARGURA = 890;
    public static final double ALTURA = 502;

    private final AnchorPane root;

    public TelaLista(App app) {
        root = new AnchorPane();
        root.setBackground(TelaUtil.fundoDeImagem("/imagens/QuartaTela.png"));

        Button botaoDisponiveis = new Button("Bombeiros Disponíveis");
        botaoDisponiveis.getStyleClass().add("botao-vermelho");
        botaoDisponiveis.setOnAction(event -> app.mostrarTelaLogin());

        AnchorPane.setTopAnchor(botaoDisponiveis, 330.0);
        AnchorPane.setLeftAnchor(botaoDisponiveis, 285.0);

        root.getChildren().add(botaoDisponiveis);
    }

    public Parent getRoot() {
        return root;
    }
}
