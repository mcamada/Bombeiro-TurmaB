package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaEditarTreinamento {

    private Stage stage;
    private Treinamento treinamento;

    public TelaEditarTreinamento(Stage stage, Treinamento treinamento) {
        this.stage = stage;
        this.treinamento = treinamento;
    }

    public Scene criarCena() {
        Label titulo = new Label("Editar treinamento");
        titulo.setId("tituloTreinamentos");

        TextField nome = new TextField(treinamento.getNome());

        TextArea descricao = new TextArea(treinamento.getDescricao());
        descricao.setPrefRowCount(2);

        TextField inicio = new TextField(treinamento.getDataInicio());
        TextField fim = new TextField(treinamento.getDataFim());
        TextField instrutor = new TextField(treinamento.getInstrutor());
        TextField instituicao = new TextField(treinamento.getInstituicao());
        TextField local = new TextField(treinamento.getLocal());

        Spinner<Integer> carga = new Spinner<Integer>(
                1,
                300,
                treinamento.getCargaHoraria()
        );

        RadioButton planejado = new RadioButton("Planejado");
        RadioButton andamento = new RadioButton("Em andamento");
        RadioButton concluido = new RadioButton("Concluído");
        RadioButton cancelado = new RadioButton("Cancelado");

        ToggleGroup grupoStatus = new ToggleGroup();
        planejado.setToggleGroup(grupoStatus);
        andamento.setToggleGroup(grupoStatus);
        concluido.setToggleGroup(grupoStatus);
        cancelado.setToggleGroup(grupoStatus);

        selecionarStatusAtual(
                planejado,
                andamento,
                concluido,
                cancelado
        );

        VBox opcoesStatus = new VBox(4);
        opcoesStatus.getChildren().addAll(
                planejado,
                andamento,
                concluido,
                cancelado
        );

        GridPane formulario = new GridPane();
        formulario.getStyleClass().add("formulario");
        formulario.setHgap(10);
        formulario.setVgap(8);
        formulario.setAlignment(Pos.CENTER);
        formulario.add(new Label("Nome:"), 0, 0);
        formulario.add(nome, 1, 0);
        formulario.add(new Label("Descrição:"), 0, 1);
        formulario.add(descricao, 1, 1);
        formulario.add(new Label("Carga:"), 0, 2);
        formulario.add(carga, 1, 2);
        formulario.add(new Label("Data início:"), 0, 3);
        formulario.add(inicio, 1, 3);
        formulario.add(new Label("Data fim:"), 0, 4);
        formulario.add(fim, 1, 4);
        formulario.add(new Label("Instrutor:"), 0, 5);
        formulario.add(instrutor, 1, 5);
        formulario.add(new Label("Instituição:"), 0, 6);
        formulario.add(instituicao, 1, 6);
        formulario.add(new Label("Local:"), 0, 7);
        formulario.add(local, 1, 7);
        formulario.add(new Label("Status:"), 0, 8);
        formulario.add(opcoesStatus, 1, 8);

        Button salvar = new Button("Salvar");
        salvar.getStyleClass().add("botao-principal");

        Button voltar = new Button("Voltar");

        HBox botoes = new HBox(10);
        botoes.getChildren().addAll(salvar, voltar);

        VBox painel = new VBox(12);
        painel.getStyleClass().add("painel-pagina");
        painel.getChildren().addAll(formulario, botoes);

        VBox raiz = new VBox(12);
        raiz.getStyleClass().add("pagina");
        raiz.setPadding(new Insets(24));
        raiz.setAlignment(Pos.TOP_CENTER);
        raiz.getChildren().addAll(titulo, painel);

        salvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                treinamento.setNome(nome.getText());
                treinamento.setDescricao(descricao.getText());
                treinamento.setCargaHoraria(carga.getValue());
                treinamento.setDataInicio(inicio.getText());
                treinamento.setDataFim(fim.getText());
                treinamento.setInstrutor(instrutor.getText());
                treinamento.setInstituicao(instituicao.getText());
                treinamento.setLocal(local.getText());

                if (andamento.isSelected()) {
                    treinamento.setStatus("Em andamento");
                } else if (concluido.isSelected()) {
                    treinamento.setStatus("Concluído");
                } else if (cancelado.isSelected()) {
                    treinamento.setStatus("Cancelado");
                } else {
                    treinamento.setStatus("Planejado");
                }

                App.historico.add(
                        "Treinamento alterado: " + treinamento.getNome()
                );

                Alert alerta = new Alert(
                        Alert.AlertType.INFORMATION,
                        "Alterações salvas."
                );

                alerta.show();
            }
        });

        voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TelaConsultaTreinamentos tela = new TelaConsultaTreinamentos(stage);

                stage.setScene(tela.criarCena());
                stage.setTitle("Consultar Treinamentos");
            }
        });

        Scene scene = new Scene(raiz, 700, 700);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private void selecionarStatusAtual(
            RadioButton planejado,
            RadioButton andamento,
            RadioButton concluido,
            RadioButton cancelado
    ) {
        if (treinamento.getStatus().equals("Em andamento")) {
            andamento.setSelected(true);
        } else if (treinamento.getStatus().equals("Concluído")) {
            concluido.setSelected(true);
        } else if (treinamento.getStatus().equals("Cancelado")) {
            cancelado.setSelected(true);
        } else {
            planejado.setSelected(true);
        }
    }
}
