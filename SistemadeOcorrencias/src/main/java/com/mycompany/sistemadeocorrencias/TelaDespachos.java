/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeocorrencias;

import javafx.scene.control.TextField;
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
    
    public void mostrar(Stage stage){
        VBox root = new VBox(25);
        root.setPadding(New Insets(35));
        root.setStyle("-fx-backgroud-color:#C9A5A5");
    }
    
}
