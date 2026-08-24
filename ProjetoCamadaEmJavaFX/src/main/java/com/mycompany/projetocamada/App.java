package com.mycompany.projetocamada;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setResizable(false);
        mostrarTelaLogin();
    }

    public void mostrarTelaLogin() {
        TelaLogin tela = new TelaLogin(this);
        trocarTela(tela.getRoot(), TelaLogin.LARGURA, TelaLogin.ALTURA, "Login");
    }

    public void mostrarTelaCadastro() {
        TelaCadastro tela = new TelaCadastro(this);
        trocarTela(tela.getRoot(), TelaCadastro.LARGURA, TelaCadastro.ALTURA, "Cadastro Bombeiro");
    }

    public void mostrarTelaConsulta() {
        TelaConsulta tela = new TelaConsulta(this);
        trocarTela(tela.getRoot(), TelaConsulta.LARGURA, TelaConsulta.ALTURA, "Consulta Bombeiros");
    }

    public void mostrarTelaLista() {
        TelaLista tela = new TelaLista(this);
        trocarTela(tela.getRoot(), TelaLista.LARGURA, TelaLista.ALTURA, "Lista Bombeiros");
    }

    private void trocarTela(Parent root, double largura, double altura, String titulo) {
        Scene cena = new Scene(root, largura, altura);
        cena.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());
        stage.setTitle(titulo);
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
