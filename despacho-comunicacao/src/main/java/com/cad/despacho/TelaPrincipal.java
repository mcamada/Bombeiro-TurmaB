package com.cad.despacho;
import javafx.scene.layout.BorderPane;

public class TelaPrincipal {

    public BorderPane criar() {

        BorderPane raiz = new BorderPane();

        MenuLateral menu = new MenuLateral();
        raiz.setLeft(menu.criar());

        return raiz;
    }
}
