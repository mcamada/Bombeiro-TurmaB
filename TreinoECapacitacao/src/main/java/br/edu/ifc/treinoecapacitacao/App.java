package br.edu.ifc.treinoecapacitacao;

import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import br.edu.ifc.treinoecapacitacao.view.TelaLogin;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static ObservableList<Treinamento> treinamentos
            = FXCollections.observableArrayList();

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
