package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TelaConsultaTreinamentos {
    private Stage stage;
    private TextField nome, instrutor, periodoInicio, periodoFim;
    private RadioButton todos, interno, externo;
    private ListView<Treinamento> lista;

    public TelaConsultaTreinamentos(Stage stage) { this.stage = stage; }

    public Scene criarCena() {
        Label titulo = new Label("Consultar treinamentos"); titulo.setId("tituloTreinamentos");
        nome = new TextField(); nome.setPromptText("Nome");
        instrutor = new TextField(); instrutor.setPromptText("Instrutor");
        periodoInicio = new TextField(); periodoInicio.setPromptText("Início dd/mm/aaaa");
        periodoFim = new TextField(); periodoFim.setPromptText("Fim dd/mm/aaaa");
        todos = new RadioButton("Todos"); interno = new RadioButton("Interno"); externo = new RadioButton("Externo");
        ToggleGroup grupo = new ToggleGroup(); todos.setToggleGroup(grupo); interno.setToggleGroup(grupo); externo.setToggleGroup(grupo); todos.setSelected(true);
        HBox tipos = new HBox(10, todos, interno, externo);
        Button filtrar = new Button("Filtrar"); Button limpar = new Button("Limpar filtros");
        GridPane filtros = new GridPane(); filtros.setHgap(8); filtros.setVgap(8); filtros.getStyleClass().add("formulario");
        filtros.add(new Label("Nome:"),0,0); filtros.add(nome,1,0); filtros.add(new Label("Instrutor:"),2,0); filtros.add(instrutor,3,0);
        filtros.add(new Label("Tipo:"),0,1); filtros.add(tipos,1,1); filtros.add(new Label("Período:"),2,1); filtros.add(new HBox(5, periodoInicio, periodoFim),3,1);
        filtros.add(new HBox(8, filtrar, limpar),1,2);

        lista = new ListView<Treinamento>(App.treinamentos); lista.setPrefHeight(250); lista.getStyleClass().add("lista-treinamentos");
        Button detalhes = new Button("Detalhes"); Button editar = new Button("Editar"); Button inativar = new Button("Inativar"); Button voltar = new Button("Voltar");
        filtrar.setOnAction(e -> filtrar()); limpar.setOnAction(e -> { nome.clear(); instrutor.clear(); periodoInicio.clear(); periodoFim.clear(); todos.setSelected(true); lista.setItems(App.treinamentos); });
        detalhes.setOnAction(e -> abrirSelecionado(false)); editar.setOnAction(e -> abrirSelecionado(true)); inativar.setOnAction(e -> inativar());
        voltar.setOnAction(e -> { stage.setScene(new TelaTreinamentos(stage).criarCena()); stage.setTitle("Treinamentos"); });
        HBox botoes = new HBox(10, detalhes, editar, inativar, voltar); botoes.setAlignment(Pos.CENTER);
        VBox raiz = new VBox(12, titulo, filtros, lista, botoes); raiz.setPadding(new Insets(20)); raiz.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(raiz, 900, 600); scene.getStylesheets().add("/css/style.css"); return scene;
    }

    private void filtrar() {
        ObservableList<Treinamento> resultado = FXCollections.observableArrayList();
        for (Treinamento t : App.treinamentos) {
            boolean ok = true;
            if (!nome.getText().isBlank() && !t.getNome().toLowerCase().contains(nome.getText().toLowerCase())) ok = false;
            if (!instrutor.getText().isBlank() && !t.getInstrutor().toLowerCase().contains(instrutor.getText().toLowerCase())) ok = false;
            if (interno.isSelected() && !t.getTipo().equals("Interno")) ok = false;
            if (externo.isSelected() && !t.getTipo().equals("Externo")) ok = false;
            if (!periodoInicio.getText().isBlank() && !t.getDataInicio().equals(periodoInicio.getText())) ok = false;
            if (!periodoFim.getText().isBlank() && !t.getDataFim().equals(periodoFim.getText())) ok = false;
            if (ok) resultado.add(t);
        }
        lista.setItems(resultado);
    }

    private void abrirSelecionado(boolean edicao) {
        Treinamento t = lista.getSelectionModel().getSelectedItem();
        if (t == null) { new Alert(Alert.AlertType.WARNING, "Selecione um treinamento.").show(); return; }
        if (edicao) { stage.setScene(new TelaEditarTreinamento(stage, t).criarCena()); stage.setTitle("Editar Treinamento"); }
        else { stage.setScene(new TelaDetalhesTreinamento(stage, t).criarCena()); stage.setTitle("Detalhes do Treinamento"); }
    }

    private void inativar() {
        Treinamento t = lista.getSelectionModel().getSelectedItem();
        if (t == null) { new Alert(Alert.AlertType.WARNING, "Selecione um treinamento.").show(); return; }
        t.setAtivo(false); App.historico.add("Treinamento inativado: " + t.getNome()); lista.refresh();
        new Alert(Alert.AlertType.INFORMATION, "Treinamento inativado.").show();
    }
}
