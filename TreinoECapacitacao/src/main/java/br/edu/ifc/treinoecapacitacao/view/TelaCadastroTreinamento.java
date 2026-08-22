package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TelaCadastroTreinamento {
    private Stage stage;
    private TextField nome, inicio, fim, instrutor, instituicao, local;
    private TextArea descricao;
    private Spinner<Integer> carga;
    private RadioButton interno, externo;

    public TelaCadastroTreinamento(Stage stage) { this.stage = stage; }

    public Scene criarCena() {
        Label titulo = new Label("Cadastrar treinamento"); titulo.setId("tituloTreinamentos");
        nome = new TextField(); nome.setPromptText("Nome do treinamento");
        descricao = new TextArea(); descricao.setPrefRowCount(3); descricao.setWrapText(true);
        interno = new RadioButton("Interno"); externo = new RadioButton("Externo");
        ToggleGroup grupo = new ToggleGroup(); interno.setToggleGroup(grupo); externo.setToggleGroup(grupo); interno.setSelected(true);
        HBox tipos = new HBox(10, interno, externo);
        carga = new Spinner<Integer>(1, 300, 1);
        inicio = new TextField(); inicio.setPromptText("dd/mm/aaaa");
        fim = new TextField(); fim.setPromptText("dd/mm/aaaa");
        instrutor = new TextField(); instrutor.setPromptText("Nome do instrutor");
        instituicao = new TextField(); instituicao.setPromptText("Instituição responsável"); instituicao.setDisable(true);
        local = new TextField(); local.setPromptText("Local de realização");

        GridPane form = new GridPane(); form.setHgap(12); form.setVgap(10); form.setAlignment(Pos.CENTER); form.getStyleClass().add("formulario");
        form.add(new Label("Nome:"),0,0); form.add(nome,1,0);
        form.add(new Label("Tipo:"),0,1); form.add(tipos,1,1);
        form.add(new Label("Descrição:"),0,2); form.add(descricao,1,2);
        form.add(new Label("Carga horária:"),0,3); form.add(carga,1,3);
        form.add(new Label("Data início:"),0,4); form.add(inicio,1,4);
        form.add(new Label("Data fim:"),0,5); form.add(fim,1,5);
        form.add(new Label("Instrutor:"),0,6); form.add(instrutor,1,6);
        form.add(new Label("Instituição:"),0,7); form.add(instituicao,1,7);
        form.add(new Label("Local:"),0,8); form.add(local,1,8);

        Button cadastrar = new Button("Cadastrar"); cadastrar.getStyleClass().add("botao-principal");
        Button limpar = new Button("Limpar"); Button voltar = new Button("Voltar");
        ButtonBar barra = new ButtonBar(); barra.getButtons().addAll(voltar, limpar, cadastrar);
        interno.setOnAction(e -> { instituicao.clear(); instituicao.setDisable(true); });
        externo.setOnAction(e -> instituicao.setDisable(false));
        cadastrar.setOnAction(e -> cadastrar());
        limpar.setOnAction(e -> limpar());
        voltar.setOnAction(e -> { stage.setScene(new TelaTreinamentos(stage).criarCena()); stage.setTitle("Treinamentos"); });

        VBox raiz = new VBox(15, titulo, new Label("Informe os dados do treinamento"), form, barra);
        raiz.setAlignment(Pos.TOP_CENTER); raiz.setPadding(new Insets(25));
        Scene scene = new Scene(raiz, 650, 650); scene.getStylesheets().add("/css/style.css"); return scene;
    }

    private void cadastrar() {
        if (nome.getText().isBlank() || inicio.getText().isBlank() || fim.getText().isBlank() || instrutor.getText().isBlank() || local.getText().isBlank()) {
            new Alert(Alert.AlertType.WARNING, "Preencha os campos obrigatórios.").show(); return;
        }
        if (externo.isSelected() && instituicao.getText().isBlank()) {
            new Alert(Alert.AlertType.WARNING, "Treinamento externo precisa de instituição.").show(); return;
        }
        String tipo = externo.isSelected() ? "Externo" : "Interno";
        String inst = externo.isSelected() ? instituicao.getText() : "";
        Treinamento t = new Treinamento(nome.getText(), tipo, descricao.getText(), carga.getValue(), inicio.getText(), fim.getText(), instrutor.getText(), inst, local.getText());
        App.treinamentos.add(t); App.historico.add("Treinamento cadastrado: " + t.getNome());
        new Alert(Alert.AlertType.INFORMATION, "Treinamento cadastrado.").show(); limpar();
    }

    private void limpar() {
        nome.clear(); descricao.clear(); carga.getValueFactory().setValue(1); inicio.clear(); fim.clear(); instrutor.clear(); instituicao.clear(); local.clear(); interno.setSelected(true); instituicao.setDisable(true);
    }
}
