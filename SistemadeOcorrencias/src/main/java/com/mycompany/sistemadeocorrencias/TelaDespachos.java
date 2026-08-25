/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeocorrencias;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class TelaDespachos {
    private VBox historico;
    
    private TextField txOcorencia;
    private TextField txData;
    private TextField txHora;
    private TextField txStatus;
    private TextField txViatura;
    private TextField txObservacao;
    
    public void mostrar(Stage stage) {

        VBox root = new VBox(25);

        root.setPadding(new Insets(35));

        root.setStyle("-fx-background-color: #C9A5A5;");


        HBox topo = new HBox();

        topo.setAlignment(Pos.CENTER_LEFT);

        Label titulo = new Label("Despachos");

        titulo.setStyle("-fx-text-fill: white;" + "-fx-font-size: 50px;" +"-fx-font-family: 'Georgia'");

        Button btNovo = new Button("+ Novo despacho");

        btNovo.setPrefWidth(220);
        btNovo.setPrefHeight(50);

        btNovo.setStyle("-fx-background-color: #5B171F;" +"-fx-text-fill: white;" +"-fx-font-size: 17px;" +"-fx-background-radius: 25;");


        HBox.setMargin(btNovo, new Insets(10, 0, 0, 650));

        topo.getChildren().addAll(titulo,btNovo);
        VBox formulario = new VBox(7);

        formulario.setPrefWidth(430);
        formulario.setPrefHeight(570);

        formulario.setPadding(new Insets(30));

        formulario.setStyle("-fx-background-color: #F4E9DD;" +"-fx-border-color: #5B171F;" +"-fx-border-width: 9;" +"-fx-border-radius: 30;" +"-fx-background-radius: 30;");

        Label tituloForm = new Label("Novo Despacho");

        tituloForm.setStyle("-fx-text-fill: #5B171F;" +"-fx-font-size: 28px;" +"-fx-font-weight: bold;");

        Label lblOcorrencia =new Label("Ocorrência");

    }  
}
