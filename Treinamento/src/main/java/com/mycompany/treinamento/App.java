package com.mycompany.treinamento;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Corpo de Bombeiros - Treinamento e Capacitação");

        Controller controller = new Controller(stage);
        controller.mostrarInicio();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
