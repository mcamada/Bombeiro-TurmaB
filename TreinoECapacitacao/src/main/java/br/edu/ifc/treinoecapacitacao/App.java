package br.edu.ifc.treinoecapacitacao;

import br.edu.ifc.treinoecapacitacao.model.Bombeiro;
import br.edu.ifc.treinoecapacitacao.model.Certificado;
import br.edu.ifc.treinoecapacitacao.model.Instituicao;
import br.edu.ifc.treinoecapacitacao.model.Instrutor;
import br.edu.ifc.treinoecapacitacao.model.Participacao;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import br.edu.ifc.treinoecapacitacao.model.Usuario;
import br.edu.ifc.treinoecapacitacao.view.TelaLogin;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static ObservableList<Treinamento> treinamentos = FXCollections.observableArrayList();
    public static ObservableList<Bombeiro> bombeiros = FXCollections.observableArrayList();
    public static ObservableList<Instrutor> instrutores = FXCollections.observableArrayList();
    public static ObservableList<Instituicao> instituicoes = FXCollections.observableArrayList();
    public static ObservableList<Participacao> participacoes = FXCollections.observableArrayList();
    public static ObservableList<Certificado> certificados = FXCollections.observableArrayList();
    public static ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
    public static ObservableList<String> historico = FXCollections.observableArrayList();

    public static Usuario usuarioLogado;

    @Override
    public void start(Stage stage) {
        carregarUsuarios();

        TelaLogin telaLogin = new TelaLogin(stage);
        Scene scene = telaLogin.criarCena();

        stage.setTitle("Treinamento e Capacitação");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void carregarUsuarios() {
        if (usuarios.isEmpty()) {
            Usuario coordenador = new Usuario("coordenador", "123", "Coordenador");
            Usuario instrutor = new Usuario("instrutor", "123", "Instrutor");
            Usuario supervisor = new Usuario("supervisor", "123", "Supervisor");

            usuarios.add(coordenador);
            usuarios.add(instrutor);
            usuarios.add(supervisor);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
