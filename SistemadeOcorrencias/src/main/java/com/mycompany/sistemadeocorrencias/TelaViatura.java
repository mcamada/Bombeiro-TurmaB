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
public class TelaViatura {

    private VBox listaViaturas;

    public void mostrar(Stage stage) {
        
         VBox root = new VBox(25);

        root.setPadding(new Insets(35));

        root.setStyle("-fx-background-color: #C9A5A5;");
         HBox topo = new HBox();

        topo.setAlignment(Pos.CENTER_LEFT);

        Label titulo = new Label("Viaturas");

        titulo.setStyle("-fx-text-fill: white;" +"-fx-font-size: 50px;" +"-fx-font-family: 'Georgia';");

        Button btNova = new Button("+ Nova viatura");

        btNova.setPrefWidth(220);
        btNova.setPrefHeight(50);

        btNova.setStyle("-fx-background-color: #5B171F;" +"-fx-text-fill: white;" +"-fx-font-size: 17px;" +"-fx-background-radius: 25;");

        HBox.setMargin(btNova, new Insets(10, 0, 0, 730));

        topo.getChildren().addAll(titulo,btNova);
        
        VBox formulario = new VBox(7);

        formulario.setPrefWidth(430);
        formulario.setPrefHeight(570);

        formulario.setPadding(new Insets(30));

        formulario.setStyle("-fx-background-color: #F4E9DD;" +"-fx-border-color: #5B171F;" + "-fx-border-width: 9;" +"-fx-border-radius: 30;" +"-fx-background-radius: 30;");
        
        Label tituloForm = new Label("Dados da Viatura");

        tituloForm.setStyle("-fx-text-fill: #5B171F;" + "-fx-font-size: 28px;" + "-fx-font-weight: bold;");
        Label lblTipo = new Label("Tipo");

        TextField Tipo = new TextField();
        Tipo.setPrefHeight(35);

        Label lblPrefixo = new Label("Prefixo");

        TextField Prefixo = new TextField();
        Prefixo.setPrefHeight(35);

        Label lblPlaca = new Label("Placa");

        TextField Placa = new TextField();
        Placa.setPrefHeight(35);
        Label lblStatus = new Label("Status");

        TextField Status = new TextField();
        Status.setPrefHeight(35);

        Label lblLocalizacao = new Label("Localização Atual ou última localização");

        TextField Localizacao = new TextField();
        Localizacao.setPrefHeight(35);
        
        
    }
}
