package com.mycompany.rycardofusinatoteste;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

    root.setTop(new Label("Cadastrar Ocorrência"));
    
    root.setCenter(new Label("Atendimento de Ocorrências"));
    root.setCenter(new Label("Sistema de controle Operacional para cadastro, consulta, atualização de Ocorrências"));
    
        VBox root2 = new VBox();
    
    Button botoes  = new Button("Cadastrar");
    
    root2.getChildren().add(botoes);
   
    Scene scene = new Scene(root, 640, 480);
        
        stage.setScene(scene);
        stage.setTitle("Sistema de Teste do JavaFx");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}