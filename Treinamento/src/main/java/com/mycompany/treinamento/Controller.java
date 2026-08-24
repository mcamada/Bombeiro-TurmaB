package com.mycompany.treinamento;

import com.mycompany.treinamento.model.Bombeiro;
import com.mycompany.treinamento.model.Certificado;
import com.mycompany.treinamento.model.Treinamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Controller {

    private final Stage stage;
    private final String caminhoCss;


    private final ObservableList<Treinamento> treinamentos = FXCollections.observableArrayList();
    private final ObservableList<Bombeiro> bombeiros = FXCollections.observableArrayList();
    private final ObservableList<Certificado> certificados = FXCollections.observableArrayList();

    public Controller(Stage stage) {
        this.stage = stage;
        this.caminhoCss = getClass().getResource("/css/style.css").toExternalForm();
        carregarDadosDeExemplo();
    }

    private void carregarDadosDeExemplo() {
        treinamentos.add(new Treinamento("Combate a Incêndio", "Interno", "25/08/2026", "40 horas", "Cap. João", "Quartel"));
        treinamentos.add(new Treinamento("Primeiros Socorros", "Externo", "02/09/2026", "24 horas", "Enf. Carlos", "Hospital Municipal"));

        bombeiros.add(new Bombeiro("Lilian Arcanjo", "1024", "Juniores", "Combate a incêndio", "Ativo"));
        bombeiros.add(new Bombeiro("Carlos Souza", "1087", "Cabo", "Resgate", "Ativo"));

        certificados.add(new Certificado("João Silva", "Combate a Incêndio", "30/08/2026", "40 horas"));
    }


    private void trocarTela(javafx.scene.Parent layout, double largura, double altura) {
        Scene cena = new Scene(layout, largura, altura);
        cena.getStylesheets().add(caminhoCss);
        stage.setScene(cena);
    }


    public void mostrarInicio() {
        Label titulo = new Label("CORPO DE BOMBEIROS");
        titulo.getStyleClass().add("titulo");

        Label subtitulo = new Label("Sistema de Treinamento e Capacitação");
        subtitulo.getStyleClass().add("subtitulo");

        VBox cabecalho = new VBox(6, titulo, subtitulo);
        cabecalho.getStyleClass().add("cabecalho");
        cabecalho.setAlignment(Pos.CENTER);

        Button btnTreinamentos = new Button("Treinamentos");
        Button btnBombeiros = new Button("Bombeiros");
        Button btnCertificados = new Button("Certificados");
        Button btnSair = new Button("Sair");

        for (Button b : new Button[]{btnTreinamentos, btnBombeiros, btnCertificados, btnSair}) {
            b.getStyleClass().add("botao-menu");
        }


        btnTreinamentos.setOnAction(e -> mostrarTreinamentos());
        btnBombeiros.setOnAction(e -> mostrarBombeiros());
        btnCertificados.setOnAction(e -> mostrarCertificados());
        btnSair.setOnAction(e -> stage.close());

        VBox menu = new VBox(10, btnTreinamentos, btnBombeiros, btnCertificados, btnSair);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(30));

        VBox layout = new VBox(cabecalho, menu);
        trocarTela(layout, 500, 450);
    }


    public void mostrarTreinamentos() {
        Button voltar = new Button("Voltar");
        voltar.getStyleClass().add("botao-secundario");
        voltar.setOnAction(e -> mostrarInicio());

        Button cadastrar = new Button("Cadastrar novo");
        cadastrar.setOnAction(e -> mostrarCadastroTreinamento());

        HBox topo = new HBox(15, voltar, cadastrar);
        topo.setPadding(new Insets(15));

        TableView<Treinamento> tabela = new TableView<>(treinamentos);

        TableColumn<Treinamento, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Treinamento, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        TableColumn<Treinamento, String> colData = new TableColumn<>("Data");
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));

        TableColumn<Treinamento, String> colCarga = new TableColumn<>("Carga Horária");
        colCarga.setCellValueFactory(new PropertyValueFactory<>("carga"));

        TableColumn<Treinamento, String> colInstrutor = new TableColumn<>("Instrutor");
        colInstrutor.setCellValueFactory(new PropertyValueFactory<>("instrutor"));

        TableColumn<Treinamento, String> colLocal = new TableColumn<>("Local");
        colLocal.setCellValueFactory(new PropertyValueFactory<>("local"));

        tabela.getColumns().addAll(colNome, colTipo, colData, colCarga, colInstrutor, colLocal);

        BorderPane layout = new BorderPane();
        layout.setTop(topo);
        layout.setCenter(tabela);

        trocarTela(layout, 800, 500);
    }

 
    public void mostrarCadastroTreinamento() {
        Label titulo = new Label("Cadastrar Treinamento");
        titulo.getStyleClass().add("titulo-tela");

        TextField nome = new TextField();
        nome.setPromptText("Nome do treinamento");

        ComboBox<String> tipo = new ComboBox<>();
        tipo.getItems().addAll("Interno", "Externo");
        tipo.setPromptText("Tipo");

        TextField data = new TextField();
        data.setPromptText("Data (exemplo: 25/08/2026)");

        TextField carga = new TextField();
        carga.setPromptText("Carga horária (exemplo: 40 horas)");

        TextField instrutor = new TextField();
        instrutor.setPromptText("Instrutor responsável");

        TextField local = new TextField();
        local.setPromptText("Local");

        Button salvar = new Button("Salvar");
        salvar.getStyleClass().add("botao-menu");

        Button voltar = new Button("Voltar");
        voltar.getStyleClass().add("botao-secundario");

        salvar.setOnAction(e -> {
            if (nome.getText().isEmpty() || tipo.getValue() == null || data.getText().isEmpty()
                    || carga.getText().isEmpty() || instrutor.getText().isEmpty() || local.getText().isEmpty()) {
                mostrarAlerta("Erro", "Preencha todos os campos.");
                return;
            }

            treinamentos.add(new Treinamento(
                    nome.getText(), tipo.getValue(), data.getText(),
                    carga.getText(), instrutor.getText(), local.getText()
            ));

            mostrarAlerta("Sucesso", "Treinamento cadastrado!");
            mostrarTreinamentos();
        });

        voltar.setOnAction(e -> mostrarTreinamentos());

        VBox layout = new VBox(10, titulo, nome, tipo, data, carga, instrutor, local, salvar, voltar);
        layout.setPadding(new Insets(25));

        trocarTela(layout, 400, 500);
    }

    public void mostrarBombeiros() {
        Button voltar = new Button("Voltar");
        voltar.getStyleClass().add("botao-secundario");
        voltar.setOnAction(e -> mostrarInicio());

        HBox topo = new HBox(voltar);
        topo.setPadding(new Insets(15));

        TableView<Bombeiro> tabela = new TableView<>(bombeiros);

        TableColumn<Bombeiro, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Bombeiro, String> colMatricula = new TableColumn<>("Matrícula");
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        TableColumn<Bombeiro, String> colPatente = new TableColumn<>("Patente");
        colPatente.setCellValueFactory(new PropertyValueFactory<>("patente"));

        TableColumn<Bombeiro, String> colEspecialidade = new TableColumn<>("Especialidade");
        colEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));

        TableColumn<Bombeiro, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tabela.getColumns().addAll(colNome, colMatricula, colPatente, colEspecialidade, colStatus);

        BorderPane layout = new BorderPane();
        layout.setTop(topo);
        layout.setCenter(tabela);

        trocarTela(layout, 750, 450);
    }

    public void mostrarCertificados() {
        Button voltar = new Button("Voltar");
        voltar.getStyleClass().add("botao-secundario");
        voltar.setOnAction(e -> mostrarInicio());

        HBox topo = new HBox(voltar);
        topo.setPadding(new Insets(15));

        TableView<Certificado> tabela = new TableView<>(certificados);

        TableColumn<Certificado, String> colBombeiro = new TableColumn<>("Bombeiro");
        colBombeiro.setCellValueFactory(new PropertyValueFactory<>("bombeiro"));

        TableColumn<Certificado, String> colTreinamento = new TableColumn<>("Treinamento");
        colTreinamento.setCellValueFactory(new PropertyValueFactory<>("treinamento"));

        TableColumn<Certificado, String> colData = new TableColumn<>("Data de emissão");
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));

        TableColumn<Certificado, String> colCarga = new TableColumn<>("Carga Horária");
        colCarga.setCellValueFactory(new PropertyValueFactory<>("carga"));

        tabela.getColumns().addAll(colBombeiro, colTreinamento, colData, colCarga);

        BorderPane layout = new BorderPane();
        layout.setTop(topo);
        layout.setCenter(tabela);

        trocarTela(layout, 700, 400);
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
