package ibirama.bombeiros;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import static javafx.application.Application.launch;

public class App extends Application {

    ObservableList<Bombeiro> bombeiros = FXCollections.observableArrayList();
    VBox tela = new VBox(10);

    @Override
    public void start(Stage stage) {

        bombeiros.add(new Bombeiro("Marcos Yuzure de Oliveira Camada", "12345678900",
                "BM001", Patente.SOLDADO, Especialidade.INCENDIO,
                "99999-1111", Status.ATIVO));

        bombeiros.add(new Bombeiro("Jefferson Vansuita", "98765432100",
                "BM002", Patente.CORONEL, Especialidade.RESGATE,
                "99999-2222", Status.AFASTADO));

        bombeiros.add(new Bombeiro("João Guilherme Burg", "45678912300",
                "BM003", Patente.TENENTE, Especialidade.OPERACOES_AEREAS,
                "99999-3333", Status.ATIVO));

        BorderPane principal = new BorderPane();

        VBox menu = new VBox(10);
        menu.setPrefWidth(180);
        menu.setStyle("-fx-padding: 15; -fx-background-color: #1e293b;");

        Button inicio = new Button("Início");
        Button cadastrar = new Button("Cadastrar");
        Button consultar = new Button("Consultar");

        inicio.setMaxWidth(180);
        cadastrar.setMaxWidth(180);
        consultar.setMaxWidth(180);

        menu.getChildren().addAll(inicio, cadastrar, consultar);

        tela.setStyle("-fx-padding: 20;");

        inicio.setOnAction(e -> inicio());
        cadastrar.setOnAction(e -> cadastrar());
        consultar.setOnAction(e -> consultar());

        principal.setLeft(menu);
        principal.setCenter(tela);

        inicio();

        Scene cena = new Scene(principal, 900, 600);
        stage.setTitle("Sistema dos Bombeiros");
        stage.setScene(cena);
        stage.show();
    }

    void inicio() {

        tela.getChildren().clear();

        Label titulo = new Label("Painel dos Bombeiros");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label total = new Label("Total: " + bombeiros.size());

        int ativos = 0;
        int afastados = 0;
        int inativos = 0;

        for (Bombeiro b : bombeiros) {
            if (b.status == Status.ATIVO)
                ativos++;
            else if (b.status == Status.AFASTADO)
                afastados++;
            else
                inativos++;
        }

        tela.getChildren().addAll(
                titulo,
                total,
                new Label("Ativos: " + ativos),
                new Label("Afastados: " + afastados),
                new Label("Inativos: " + inativos)
        );
    }

    void cadastrar() {

        tela.getChildren().clear();

        Label titulo = new Label("Cadastrar Bombeiro");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        TextField nome = new TextField();
        nome.setPromptText("Nome");

        TextField cpf = new TextField();
        cpf.setPromptText("CPF");

        TextField matricula = new TextField();
        matricula.setPromptText("Matrícula");

        TextField contato = new TextField();
        contato.setPromptText("Contato");

        ComboBox<Patente> patente = new ComboBox<>();
        patente.getItems().addAll(Patente.values());
        patente.setPromptText("Patente");

        ComboBox<Especialidade> especialidade = new ComboBox<>();
        especialidade.getItems().addAll(Especialidade.values());
        especialidade.setPromptText("Especialidade");

        ComboBox<Status> status = new ComboBox<>();
        status.getItems().addAll(Status.values());
        status.setValue(Status.ATIVO);

        Button salvar = new Button("Salvar");

        salvar.setOnAction(e -> {

            if (nome.getText().isEmpty() ||
                cpf.getText().isEmpty() ||
                matricula.getText().isEmpty()) {

                alerta("Preencha nome, CPF e matrícula.");
                return;
            }

            for (Bombeiro b : bombeiros) {
                if (b.matricula.equals(matricula.getText())) {
                    alerta("Essa matrícula já existe.");
                    return;
                }
            }

            bombeiros.add(new Bombeiro(
                    nome.getText(),
                    cpf.getText(),
                    matricula.getText(),
                    patente.getValue(),
                    especialidade.getValue(),
                    contato.getText(),
                    status.getValue()
            ));

            alerta("Bombeiro cadastrado!");
            inicio();
        });

        tela.getChildren().addAll(
                titulo,
                nome,
                cpf,
                matricula,
                contato,
                patente,
                especialidade,
                status,
                salvar
        );
    }

    void consultar() {

        tela.getChildren().clear();

        Label titulo = new Label("Consultar Bombeiros");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        TextField busca = new TextField();
        busca.setPromptText("Digite o nome");

        Button pesquisar = new Button("Pesquisar");
        Button mostrarTodos = new Button("Mostrar todos");

        TableView<Bombeiro> tabela = new TableView<>();

        TableColumn<Bombeiro, String> nome =
                new TableColumn<>("Nome");
        nome.setCellValueFactory(
                x -> new javafx.beans.property.SimpleStringProperty(x.getValue().nome));

        TableColumn<Bombeiro, String> matricula =
                new TableColumn<>("Matrícula");
        matricula.setCellValueFactory(
                x -> new javafx.beans.property.SimpleStringProperty(x.getValue().matricula));

        TableColumn<Bombeiro, String> patente =
                new TableColumn<>("Patente");
        patente.setCellValueFactory(
                x -> new javafx.beans.property.SimpleStringProperty(
                        x.getValue().patente.toString()));

        TableColumn<Bombeiro, String> especialidade =
                new TableColumn<>("Especialidade");
        especialidade.setCellValueFactory(
                x -> new javafx.beans.property.SimpleStringProperty(
                        x.getValue().especialidade.toString()));

        TableColumn<Bombeiro, String> status =
                new TableColumn<>("Status");
        status.setCellValueFactory(
                x -> new javafx.beans.property.SimpleStringProperty(
                        x.getValue().status.toString()));

        tabela.getColumns().addAll(
                nome, matricula, patente, especialidade, status
        );

        tabela.setItems(bombeiros);

        pesquisar.setOnAction(e -> {

            ObservableList<Bombeiro> resultado =
                    FXCollections.observableArrayList();

            for (Bombeiro b : bombeiros) {
                if (b.nome.toLowerCase().contains(
                        busca.getText().toLowerCase())) {

                    resultado.add(b);
                }
            }

            tabela.setItems(resultado);
        });

        mostrarTodos.setOnAction(e -> tabela.setItems(bombeiros));

        Button editar = new Button("Editar");
        Button excluir = new Button("Excluir");

        editar.setOnAction(e -> {

            Bombeiro b = tabela.getSelectionModel().getSelectedItem();

            if (b != null)
                editar(b);
            else
                alerta("Selecione um bombeiro.");
        });

        excluir.setOnAction(e -> {

            Bombeiro b = tabela.getSelectionModel().getSelectedItem();

            if (b != null) {
                bombeiros.remove(b);
                tabela.refresh();
            } else {
                alerta("Selecione um bombeiro.");
            }
        });

        HBox botoes = new HBox(10);
        botoes.getChildren().addAll(
                pesquisar,
                mostrarTodos,
                editar,
                excluir
        );

        tela.getChildren().addAll(
                titulo,
                busca,
                botoes,
                tabela
        );
    }

    void editar(Bombeiro b) {

        tela.getChildren().clear();

        Label titulo = new Label("Editar Bombeiro");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        TextField nome = new TextField(b.nome);
        TextField cpf = new TextField(b.cpf);
        TextField contato = new TextField(b.contato);

        ComboBox<Patente> patente = new ComboBox<>();
        patente.getItems().addAll(Patente.values());
        patente.setValue(b.patente);

        ComboBox<Especialidade> especialidade = new ComboBox<>();
        especialidade.getItems().addAll(Especialidade.values());
        especialidade.setValue(b.especialidade);

        ComboBox<Status> status = new ComboBox<>();
        status.getItems().addAll(Status.values());
        status.setValue(b.status);

        Button salvar = new Button("Salvar");

        salvar.setOnAction(e -> {

            b.nome = nome.getText();
            b.cpf = cpf.getText();
            b.contato = contato.getText();
            b.patente = patente.getValue();
            b.especialidade = especialidade.getValue();
            b.status = status.getValue();

            alerta("Alterações salvas!");
            consultar();
        });

        tela.getChildren().addAll(
                titulo,
                nome,
                cpf,
                contato,
                patente,
                especialidade,
                status,
                salvar
        );
    }

    void alerta(String texto) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText(texto);
        alerta.showAndWait();
    }

    enum Status {
        ATIVO, AFASTADO, INATIVO
    }

    enum Patente {
        SOLDADO, CABO, SARGENTO, SUBTENENTE,
        TENENTE, CAPITAO, MAJOR, CORONEL
    }

    enum Especialidade {
        INCENDIO, RESGATE, APH, MERGULHO,
        BUSCA, OPERACOES_AEREAS
    }

    class Bombeiro {

        String nome;
        String cpf;
        String matricula;
        LocalDate nascimento;
        Patente patente;
        Especialidade especialidade;
        String contato;
        Status status;

        Bombeiro(String nome, String cpf, String matricula,
                 Patente patente, Especialidade especialidade,
                 String contato, Status status) {

            this.nome = nome;
            this.cpf = cpf;
            this.matricula = matricula;
            this.patente = patente;
            this.especialidade = especialidade;
            this.contato = contato;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}