package com.mycompany.projetocamada;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        mostrarTelaLogin(primaryStage);
    }

    private void mostrarTelaLogin(Stage primaryStage) {
        VBox root = new VBox(10);
        Image imagem = new Image(getClass().getResourceAsStream("/imagens/PrimeiraTela.png"));
        Label labelUsuario = new Label("Usuário:");
        TextField fieldUsuario = new TextField();
        fieldUsuario.setPromptText("Digite seu Usuário");
        Label labelSenha = new Label("Senha:");
        PasswordField fieldSenha = new PasswordField();
        fieldSenha.setPromptText("Digite sua Senha");
        Button botaoEntrar = new Button("Entrar");
        botaoEntrar.setOnAction(event -> mostrarCadastroBombeiroLugar(primaryStage));
        root.setAlignment(Pos.CENTER);
        root.setPadding(new javafx.geometry.Insets(100, 20, 20, 20));


        BackgroundImage fundo = new BackgroundImage(
                imagem,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true));

        root.setBackground(new Background(fundo));

        root.getChildren().addAll(labelUsuario, fieldUsuario, labelSenha, fieldSenha, botaoEntrar);

        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private void mostrarCadastroBombeiroLugar(Stage primaryStage) {
        VBox root = criarTelaDeLugar("Cadastro Bombeiro", "/imagens/SegundaTela.png");
        Label labelUsuario = new Label("Usuário:");
        TextField fieldUsuario = new TextField();
         Label labelCPF  = new Label("CPF:");
        TextField fieldCPF = new TextField();
         Label labelDataNasc = new Label("Data de Nascimento:");
        TextField fieldDataNasc = new TextField();
         Label labelMatricula= new Label("Matrícula:");
        TextField fieldMatricula= new TextField();
         Label labelPatente = new Label("Patente:");
        TextField fieldPatente = new TextField();
         Label labelEspecialidade = new Label("Especialidade:");
        TextField fieldEspecialidade = new TextField();
   
        Button proximo = new Button("Entrar");
        proximo.setOnAction(event -> mostrarConsultaBombeirosLugar(primaryStage));
        root.getChildren().add(proximo);

        primaryStage.setTitle("Cadastro Bombeiro");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private void mostrarConsultaBombeirosLugar(Stage primaryStage) {
        VBox root = criarTelaDeLugar("Consulta Bombeiros", "/imagens/TerceiraTela.png");
        Button voltar = new Button("Consultar os Bombeiros");
        voltar.setOnAction(event -> mostrarListarBombeirosLugar(primaryStage));
        root.getChildren().add(voltar);

        primaryStage.setTitle("Consulta Bombeiros");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
     private void mostrarListarBombeirosLugar(Stage primaryStage) {
        VBox root = criarTelaDeLugar("Lista Bombeiros", "/imagens/QuartaTela.png");
        Button voltar = new Button("Bombeiros Disponíveis");
        voltar.setOnAction(event -> mostrarTelaLogin(primaryStage));
        root.getChildren().add(voltar);

        primaryStage.setTitle("Lista Bombeiros");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private VBox criarTelaDeLugar(String titulo, String caminhoImagem) {
        VBox root = new VBox(20);
        Label label = new Label(titulo);
        Image imagem = new Image(getClass().getResourceAsStream(caminhoImagem));

        BackgroundImage fundo = new BackgroundImage(
                imagem,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true));

        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(fundo));
        root.getChildren().add(label);
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
