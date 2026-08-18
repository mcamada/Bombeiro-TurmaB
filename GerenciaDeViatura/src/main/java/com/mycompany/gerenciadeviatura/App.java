package com.mycompany.gerenciadeviatura;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
            
        Font fInput = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20);
        Font fcampos = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20);
        
        root.getStyleClass().add("root");
                
        BorderPane campos = new BorderPane();
        Label gest = new Label("GESTÃO DE VIATURA");
        gest.setFont(fcampos);
        campos.setLeft(gest);
        Label usuario = new Label("Usuário");
        usuario.setFont(fcampos);
        campos.setRight(usuario);
        
      
        
        
        
        
        VBox botoes = new VBox();
        
        root.getChildren().add(campos);
        
        Button btCadastrar = new Button("Cadastrar Viatura");
        Button btConsultar = new Button("Consultar Viatura");
        
        
        botoes.getChildren().add(btCadastrar);
        botoes.getChildren().add(btConsultar);
        
        botoes.setAlignment(Pos.CENTER);
        
        root.getChildren().add(botoes);

            EventHandler<MouseEvent> cadastRar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
           
                Stage tCadas= new Stage();
                GridPane boot = new GridPane();
                
                TextField Identificacao  = new TextField();
                TextField Tipo = new TextField();
                TextField Placa = new TextField();
                TextField Anodefabricacao = new TextField();
                TextField Modelo = new TextField();
                TextField StatusInicial = new TextField();


                Label tVC = new Label("Cadrastar Viatura");
                
                
                boot.add(new Label("Identificação 2"), 0, 0);
                boot.add(Identificacao , 0,1);
                
                boot.add(new Label("Tipo 3"), 3, 0);
                boot.add(Tipo , 3,1);
                
                boot.add(new Label("Ano de fabricação 3"), 5,0);
                boot.add(Placa ,5,1);
             
                boot.add(new Label("Placa 2"), 0, 4);
                boot.add(Anodefabricacao , 0,7);
                
                boot.add(new Label("Modelo 3"), 3, 4);
                boot.add(Modelo, 3,7);
                
                boot.add(new Label("Status Inicial 3"), 5,4);
                boot.add(StatusInicial ,5,7);
                
                
                
                
                
                Scene scene = new Scene(boot, 800, 600);
                tCadas.setScene(scene);
                scene.getStylesheets().add("/css/css.css");
                tCadas.setTitle("Sistema de teste do JavaFX");
                tCadas.show();
        
                
                
            }
            
        };
           btCadastrar.setOnMouseClicked(cadastRar);
           
        
        
          
          
        
        
        
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
       
        scene.getStylesheets().add("/css/css.css");
        stage.setTitle("Sistema de teste do JavaFX");
        stage.show();
        

    }

 

    public static void main(String[] args) {
        launch();
    }

}
