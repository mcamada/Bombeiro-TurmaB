package com.mycompany.rycardofusinatoteste;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        
    
        GridPane gpCampos = new GridPane();
        gpCampos.getStyleClass().add("formulario");
        gpCampos.setVgap(5);

        Label lbTipo = new Label("Tipo de ocorrencia :");
        lbTipo.setId("lbTipo");
        lbTipo.getStyleClass().add("rotulo");

        Label lbDataHora = new Label("Data e hora :");
        lbDataHora.setId("lbDataHora");
        lbDataHora.getStyleClass().add("rotulo");
        
        Label lbLocal = new Label("Local :");
        lbLocal.setId("lbLocal");
        lbLocal.getStyleClass().add("rotulo");
        
        Label lbDescrição = new Label("Descrição :");
        lbDescrição.setId("lbDescrição");
        lbDescrição.getStyleClass().add("rotulo");
        
        Label lbEquipe = new Label("Equipe Envolvida :");
        lbEquipe.setId("lbEquipe");
        lbEquipe.getStyleClass().add("rotulo");

        TextField tfTipo = new TextField();
        tfTipo.setId("tfTipo");
        tfTipo.getStyleClass().add("campo");

        TextField tfDataHora = new TextField();
        tfDataHora.setId("tfDataHora");
        tfDataHora.getStyleClass().add("campo");
        
        TextField tfLocal = new TextField();
        tfLocal.setId("tfLocal");
        tfLocal.getStyleClass().add("campo");
        
        TextField tfDescrição = new TextField();
        tfDescrição.setId("tfDescrição");
        tfDescrição.getStyleClass().add("campo");
        
        TextField tfEquipe = new TextField();
        tfEquipe.setId("tfEquipe");
        tfEquipe.getStyleClass().add("campo");
        
        Button btCadastrar = new Button("Cadastrar");
        btCadastrar.setId("btCadastrar");
        btCadastrar.getStyleClass().add("botao");

        gpCampos.add(lbTipo, 0, 0);
        gpCampos.add(lbDataHora, 0, 2);
        gpCampos.add(lbLocal, 0, 4);
        gpCampos.add(lbDescrição, 0, 6);
        gpCampos.add(lbEquipe, 0, 8);
        gpCampos.add(tfTipo, 0, 1);
        gpCampos.add(tfDataHora, 0, 3);
        gpCampos.add(tfLocal, 0, 5);
        gpCampos.add(tfDescrição, 0, 7);
        gpCampos.add(tfEquipe, 0, 9);
        gpCampos.add(btCadastrar, 0, 11);
        gpCampos.setHalignment(btCadastrar, HPos.CENTER);

        gpCampos.setAlignment(Pos.CENTER);
       

//////////////
        gpCampos.setAlignment(Pos.CENTER);

        gpCampos.setMaxSize(
        javafx.scene.layout.Region.USE_PREF_SIZE,
        javafx.scene.layout.Region.USE_PREF_SIZE
);

        StackPane painelCentral = new StackPane(gpCampos);
        painelCentral.setAlignment(Pos.CENTER);

        root.setCenter(painelCentral);
//////////////
        ButtonBar painelBt = new ButtonBar();
        
        Button btInicio = new Button("Inicio");
        btInicio.setId("btInicio");
        btInicio.getStyleClass().add("botao");
        
        Button btConsultar = new Button("Consultar");
        btConsultar.setId("btConsultar");
        btConsultar.getStyleClass().add("botao");
        
        Button btCadastrar2 = new Button("Cadastrar");
        btCadastrar2.setId("btCadastrar2");
        btCadastrar2.getStyleClass().add("botao");

        painelBt.getButtons().addAll(btInicio, btCadastrar2, btConsultar);

        HBox header = new HBox();
        header.getStyleClass().add("header");
        header.getChildren().addAll(new Label("Cadastrar Ocorrência"), painelBt);
        
        root.setTop(header);
   
        Scene scene = new Scene(root, 640, 480);
        
        stage.setScene(scene);
        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("Sistema de Teste do JavaFx");
        stage.show();
        }
    public static void main(String[] args) {
        launch();
    }
}
