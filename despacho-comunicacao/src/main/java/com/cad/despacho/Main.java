package com.cad.despacho;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage janela) {

        janela.setTitle("Sistema CAD - Despacho e Comunicacao");

        TelaLogin telaLogin = new TelaLogin();

        Scene cena = new Scene(telaLogin.criar(janela), 1200, 750);
        janela.show();
    }
}
