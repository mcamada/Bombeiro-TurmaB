package br.edu.ifc.treinoecapacitacao;

import br.edu.ifc.treinoecapacitacao.view.TelaLogin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        TelaLogin telaLogin = new TelaLogin(stage);
        Scene scene = telaLogin.criarCena();

        stage.setTitle("Treinamento e Capacitação");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
