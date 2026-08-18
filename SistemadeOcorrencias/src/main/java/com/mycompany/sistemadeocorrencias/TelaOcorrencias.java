/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeocorrencias;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class TelaOcorrencias {
    
    public void mostrar(Stage stage) {
        
        VBox root = new VBox(20);
        
        root.setStyle(
        "-fx-backGround-color: #C9A5A5;" +
                "-fx-padding: 35;"
        );
        
        
        HBox topo = new HBox();
        
        Label titulo = new Label("Ocorrencias");
        
        titulo.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 48px;"
        );
        
        Button btNova = new Button("+ Nova Ocorrencia");
        
        btNova.setPrefWidth(220);
        btNova.setPrefHeight(45);
        
        btNova.setStyle(
                "-fx-background-color: #5B171F;" +
                        "-fx-text-fill: white;" +
                        "-fx-font size: 16px;" +
                        "-fx-background-radius: 20;"
        );
        topo.setAligment(Pos.CENTER_LEFT);
        topo.setSpacing(500);
        
        topo.getChildren().addAll(
                titulo,
                btNova
        );
        
        VBox formulario = new VBox(8);
        
        formulario.setPrefWidth(430);
        
        formulario.setStyle(
        "-fx-background-color: 3F4E9DD;" +
                "-fx-border-color: #5B171F;" +
                "-fx-border-width: 9;" +
                "-fx-border-radius: 30;" +
                "-fx-background-radius: 30;" +
                "-fx-padding: 25;"
        );
        
        Label tituloForm =
                new Label("Nova ocorrencia");
        
        tituloForm.setStyle(
                "-fx-text-fill: 35B171F;" +
                        "-fx-font-size: 27px;" +
                        "-fx-font-weight: bold;"
        );
        
        Label lblTipo = new Label("Tipo");
        TextField txtTipo = new TextField();
             
        Label lblData = new Label("Data");
        TextField txtData = new TextField();
        
        Label lblHora = new Label("Hora");
        TextField txtHora = new TextField();
        
        Label lblLocal = new Label("Local");
        TextField txtLocal = new TextField();
        
        Label lblDescricao = new Label("Descricao");
        TextField txtDescricao = new TextField();
        
        Label lblStatus = new Label("Status");
        TextField txtStatus = new TextField();
        
        Label lblSinistro = new Label("Sinistro");
        TextField txtSinistro = new TextField();
        
        Label lblPrioridade = new Label("Prioridade");
        TextField txtPrioridade = new TextField();
        
        Button btLimpar = new Button("Limpar");
        Button btSalvar = new Button("Salvar");
        
        btLimpar.setPrefWidth(170);
        btSalvar.setPrefWidth(170);
        
        HBox botoes = new HBox(25);
        
        botoes.getChildren().addAll(
                btLimpar,
                btSalvar
        );
        
        formulario.getChildren().addAll(
                tituloForm,
                
                lblTipo,
                txtTipo,
                
                lblData,
                txtData,
                
                lblHora,
                txtHora,
                
                lblLocal,
                txtlocal,
                
                lblDescricao,
                txtDescricao,
                
                lblStatus,
                txtStatus,
                
                lblSinistro,
                txtSinitro,
                
                lblPrioridade,
                txtPrioridade,
                
                botoes
        );
                
    }
}
