
package ibirama.bombeiros;

import java.util.ArrayList;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    ArrayList<Bombeiro> lista = new ArrayList<>();

    VBox tela = new VBox(10);

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        VBox menu = new VBox(10);

        Button inicio = new Button("Inicio");
        Button cadastrar = new Button("Cadastrar");
        Button consultar = new Button("Consultar");

        menu.getChildren().add(inicio);
        menu.getChildren().add(cadastrar);
        menu.getChildren().add(consultar);

        inicio.setOnAction(e -> inicio());
        cadastrar.setOnAction(e -> cadastrar());
        consultar.setOnAction(e -> consultar());

        root.setLeft(menu);
        root.setCenter(tela);

        inicio();

        Scene scene = new Scene(root, 800, 500);

        stage.setTitle("Bombeiros");
        stage.setScene(scene);
        stage.show();
    }

    void inicio() {

        tela.getChildren().clear();

        Label titulo = new Label("Sistema dos Bombeiros");

        Label total = new Label(
                "Quantidade de bombeiros: " + lista.size());

        tela.getChildren().add(titulo);
        tela.getChildren().add(total);
    }

    void cadastrar() {

        tela.getChildren().clear();

        Label titulo = new Label("Cadastrar Bombeiro");

        TextField nome = new TextField();
        nome.setPromptText("Nome");

        TextField cpf = new TextField();
        cpf.setPromptText("CPF");

        TextField matricula = new TextField();
        matricula.setPromptText("Matricula");

        TextField telefone = new TextField();
        telefone.setPromptText("Telefone");

        ComboBox<String> patente = new ComboBox<>();

        patente.getItems().add("Soldado");
        patente.getItems().add("Cabo");
        patente.getItems().add("Sargento");
        patente.getItems().add("Tenente");
        patente.getItems().add("Capitao");
        patente.getItems().add("Major");
        patente.getItems().add("Coronel");

        ComboBox<String> especialidade = new ComboBox<>();

        especialidade.getItems().add("Incendio");
        especialidade.getItems().add("Resgate");
        especialidade.getItems().add("APH");
        especialidade.getItems().add("Mergulho");
        especialidade.getItems().add("Busca");

        Button salvar = new Button("Salvar");

        salvar.setOnAction(e -> {

            Bombeiro b = new Bombeiro();

            b.nome = nome.getText();
            b.cpf = cpf.getText();
            b.matricula = matricula.getText();
            b.telefone = telefone.getText();
            b.patente = patente.getValue();
            b.especialidade = especialidade.getValue();

            lista.add(b);

            alerta("Bombeiro cadastrado!");

            inicio();
        });

        tela.getChildren().add(titulo);
        tela.getChildren().add(nome);
        tela.getChildren().add(cpf);
        tela.getChildren().add(matricula);
        tela.getChildren().add(telefone);
        tela.getChildren().add(patente);
        tela.getChildren().add(especialidade);
        tela.getChildren().add(salvar);
    }

    void consultar() {

        tela.getChildren().clear();

        Label titulo = new Label("Bombeiros cadastrados");

        ListView<String> listaTela = new ListView<>();

        for (Bombeiro b : lista) {

            String texto =
                    b.nome + " - " +
                    b.matricula + " - " +
                    b.patente;

            listaTela.getItems().add(texto);
        }

        Button editar = new Button("Editar");
        Button excluir = new Button("Excluir");

        editar.setOnAction(e -> {

            int posicao =
                    listaTela.getSelectionModel().getSelectedIndex();

            if (posicao >= 0) {

                editar(lista.get(posicao));

            } else {

                alerta("Escolha um bombeiro.");
            }
        });

        excluir.setOnAction(e -> {

            int posicao =
                    listaTela.getSelectionModel().getSelectedIndex();

            if (posicao >= 0) {

                lista.remove(posicao);

                consultar();

            } else {

                alerta("Escolha um bombeiro.");
            }
        });

        HBox botoes = new HBox(10);

        botoes.getChildren().add(editar);
        botoes.getChildren().add(excluir);

        tela.getChildren().add(titulo);
        tela.getChildren().add(listaTela);
        tela.getChildren().add(botoes);
    }

    void editar(Bombeiro b) {

        tela.getChildren().clear();

        Label titulo = new Label("Editar Bombeiro");

        TextField nome = new TextField(b.nome);
        TextField cpf = new TextField(b.cpf);
        TextField matricula = new TextField(b.matricula);
        TextField telefone = new TextField(b.telefone);

        ComboBox<String> patente = new ComboBox<>();

        patente.getItems().add("Soldado");
        patente.getItems().add("Cabo");
        patente.getItems().add("Sargento");
        patente.getItems().add("Tenente");
        patente.getItems().add("Capitao");
        patente.getItems().add("Major");
        patente.getItems().add("Coronel");

        patente.setValue(b.patente);

        ComboBox<String> especialidade = new ComboBox<>();

        especialidade.getItems().add("Incendio");
        especialidade.getItems().add("Resgate");
        especialidade.getItems().add("APH");
        especialidade.getItems().add("Mergulho");
        especialidade.getItems().add("Busca");

        especialidade.setValue(b.especialidade);

        Button salvar = new Button("Salvar");

        salvar.setOnAction(e -> {

            b.nome = nome.getText();
            b.cpf = cpf.getText();
            b.matricula = matricula.getText();
            b.telefone = telefone.getText();
            b.patente = patente.getValue();
            b.especialidade = especialidade.getValue();

            alerta("Alterações salvas!");

            consultar();
        });

        tela.getChildren().add(titulo);
        tela.getChildren().add(nome);
        tela.getChildren().add(cpf);
        tela.getChildren().add(matricula);
        tela.getChildren().add(telefone);
        tela.getChildren().add(patente);
        tela.getChildren().add(especialidade);
        tela.getChildren().add(salvar);
    }

    void alerta(String texto) {

        Alert alerta =
                new Alert(Alert.AlertType.INFORMATION);

        alerta.setContentText(texto);

        alerta.showAndWait();
    }

    class Bombeiro {

        String nome;
        String cpf;
        String matricula;
        String telefone;
        String patente;
        String especialidade;
    }

    public static void main(String[] args) {

        launch();
    }
}