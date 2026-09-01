package com.mycompany.treinamento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Login login = new Login(stage);
        Scene cena = login.criarTela();

        stage.setTitle("Treinamentos");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}