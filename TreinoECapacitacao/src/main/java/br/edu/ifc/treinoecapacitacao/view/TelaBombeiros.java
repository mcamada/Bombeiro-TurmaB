package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Bombeiro;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TelaBombeiros {
    private Stage stage;
    public TelaBombeiros(Stage stage){this.stage=stage;}
    public Scene criarCena(){
        Label titulo=new Label("Bombeiros"); titulo.setId("tituloTreinamentos");
        TextField nome=new TextField(), cpf=new TextField(), matricula=new TextField(), nascimento=new TextField(), patente=new TextField(), especialidade=new TextField(), contato=new TextField();
        nome.setPromptText("Nome"); cpf.setPromptText("CPF"); matricula.setPromptText("Matrícula"); nascimento.setPromptText("dd/mm/aaaa"); patente.setPromptText("Patente"); especialidade.setPromptText("Especialidade"); contato.setPromptText("Contato");
        RadioButton ativo=new RadioButton("Ativo"), afastado=new RadioButton("Afastado"), inativo=new RadioButton("Inativo"); ToggleGroup grupo=new ToggleGroup(); ativo.setToggleGroup(grupo); afastado.setToggleGroup(grupo); inativo.setToggleGroup(grupo); ativo.setSelected(true);
        GridPane form=new GridPane(); form.setHgap(8); form.setVgap(8); form.getStyleClass().add("formulario");
        String[] labs={"Nome:","CPF:","Matrícula:","Nascimento:","Patente:","Especialidade:","Contato:"}; TextField[] campos={nome,cpf,matricula,nascimento,patente,especialidade,contato};
        for(int i=0;i<campos.length;i++){form.add(new Label(labs[i]),0,i);form.add(campos[i],1,i);} form.add(new Label("Status:"),0,7); form.add(new HBox(8,ativo,afastado,inativo),1,7);
        Button cadastrar=new Button("Cadastrar"); cadastrar.getStyleClass().add("botao-principal"); Button voltar=new Button("Voltar");
        ListView<Bombeiro> lista=new ListView<Bombeiro>(App.bombeiros); lista.setPrefHeight(180);
        cadastrar.setOnAction(e->{ if(nome.getText().isBlank()||matricula.getText().isBlank()){new Alert(Alert.AlertType.WARNING,"Informe nome e matrícula.").show();return;} String status=afastado.isSelected()?"Afastado":inativo.isSelected()?"Inativo":"Ativo"; Bombeiro b=new Bombeiro(nome.getText(),cpf.getText(),matricula.getText(),nascimento.getText(),patente.getText(),especialidade.getText(),contato.getText(),status); App.bombeiros.add(b); App.historico.add("Bombeiro cadastrado: "+b.getNome()); nome.clear();cpf.clear();matricula.clear();nascimento.clear();patente.clear();especialidade.clear();contato.clear();ativo.setSelected(true); });
        voltar.setOnAction(e->{stage.setScene(new TelaDashboard(stage).criarCena());stage.setTitle("Painel - Treinamento e Capacitação");});
        VBox raiz=new VBox(12,titulo,form,new HBox(8,cadastrar,voltar),new Label("Bombeiros cadastrados"),lista); raiz.setPadding(new Insets(20)); raiz.setAlignment(Pos.TOP_CENTER); Scene scene=new Scene(raiz,750,680); scene.getStylesheets().add("/css/style.css"); return scene;
    }
}
