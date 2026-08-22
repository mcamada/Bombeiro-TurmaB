package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TelaEditarTreinamento {
    private Stage stage; private Treinamento t;
    public TelaEditarTreinamento(Stage stage, Treinamento t) { this.stage=stage; this.t=t; }
    public Scene criarCena() {
        Label titulo = new Label("Editar treinamento"); titulo.setId("tituloTreinamentos");
        TextField nome = new TextField(t.getNome()); TextArea descricao = new TextArea(t.getDescricao()); descricao.setPrefRowCount(2);
        TextField inicio = new TextField(t.getDataInicio()); TextField fim = new TextField(t.getDataFim());
        TextField instrutor = new TextField(t.getInstrutor()); TextField instituicao = new TextField(t.getInstituicao()); TextField local = new TextField(t.getLocal());
        Spinner<Integer> carga = new Spinner<Integer>(1,300,t.getCargaHoraria());
        RadioButton planejado=new RadioButton("Planejado"), andamento=new RadioButton("Em andamento"), concluido=new RadioButton("Concluído"), cancelado=new RadioButton("Cancelado");
        ToggleGroup status=new ToggleGroup(); planejado.setToggleGroup(status); andamento.setToggleGroup(status); concluido.setToggleGroup(status); cancelado.setToggleGroup(status);
        if(t.getStatus().equals("Em andamento")) andamento.setSelected(true); else if(t.getStatus().equals("Concluído")) concluido.setSelected(true); else if(t.getStatus().equals("Cancelado")) cancelado.setSelected(true); else planejado.setSelected(true);
        GridPane form=new GridPane(); form.setHgap(10); form.setVgap(8); form.setAlignment(Pos.CENTER); form.getStyleClass().add("formulario");
        form.add(new Label("Nome:"),0,0); form.add(nome,1,0); form.add(new Label("Descrição:"),0,1); form.add(descricao,1,1); form.add(new Label("Carga:"),0,2); form.add(carga,1,2);
        form.add(new Label("Data início:"),0,3); form.add(inicio,1,3); form.add(new Label("Data fim:"),0,4); form.add(fim,1,4); form.add(new Label("Instrutor:"),0,5); form.add(instrutor,1,5);
        form.add(new Label("Instituição:"),0,6); form.add(instituicao,1,6); form.add(new Label("Local:"),0,7); form.add(local,1,7); form.add(new Label("Status:"),0,8); form.add(new VBox(4,planejado,andamento,concluido,cancelado),1,8);
        Button salvar=new Button("Salvar"); salvar.getStyleClass().add("botao-principal"); Button voltar=new Button("Voltar");
        salvar.setOnAction(e -> { t.setNome(nome.getText()); t.setDescricao(descricao.getText()); t.setCargaHoraria(carga.getValue()); t.setDataInicio(inicio.getText()); t.setDataFim(fim.getText()); t.setInstrutor(instrutor.getText()); t.setInstituicao(instituicao.getText()); t.setLocal(local.getText()); if(andamento.isSelected())t.setStatus("Em andamento"); else if(concluido.isSelected())t.setStatus("Concluído"); else if(cancelado.isSelected())t.setStatus("Cancelado"); else t.setStatus("Planejado"); App.historico.add("Treinamento alterado: "+t.getNome()); new Alert(Alert.AlertType.INFORMATION,"Alterações salvas.").show(); });
        voltar.setOnAction(e -> { stage.setScene(new TelaConsultaTreinamentos(stage).criarCena()); stage.setTitle("Consultar Treinamentos"); });
        VBox raiz=new VBox(12,titulo,form,new HBox(10,salvar,voltar)); raiz.setPadding(new Insets(20)); raiz.setAlignment(Pos.TOP_CENTER); Scene scene=new Scene(raiz,650,650); scene.getStylesheets().add("/css/style.css"); return scene;
    }
}
