package com.mycompany.treinamento;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Cadastro {

    public Cadastro(Stage stage) {
    }

    public void criarTela() {
        Stage stage = new Stage();
        stage.setTitle("Tela de Cadastro");
        
        VBox layout = new VBox(10);
        Label label = new Label("Bem-vindo à tela de cadastro!");
        layout.getChildren().add(label);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show(); 
    }
}