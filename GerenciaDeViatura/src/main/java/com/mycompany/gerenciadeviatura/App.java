package com.mycompany.gerenciadeviatura;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
     public void start(Stage stage) {
        VBox root = new VBox();
            
        Font fInput = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20);
        Font fcampos = Font.font("Verdana", FontWeight.NORMAL, FontPosture.ITALIC, 20);

                
        GridPane campos = new GridPane();
        Label usuario = new Label("GESTÃO DE VIATURA");
        campos.add(usuario, 0, 0);
       
        usuario.setFont(fcampos);
        
        root.getChildren().add(campos);
        
        Button btCadastrar = new Button("Cadastrar Viatura");
        Button btConsultar = new Button("Consultar Viatura");
        

        
        root.getChildren().add(btCadastrar);
        root.getChildren().add(btConsultar);

        root.getChildren().add(new Text("Exemplo de area de botoes"));
        
        Button btVoltar = new Button("Voltar");
        Button btConfirmar = new Button("Confirmar");
        Button btExcluir = new Button("Excluir");
        
        ButtonBar painelBT = new ButtonBar();
        painelBT.getButtons().addAll(btVoltar, btConfirmar, btExcluir);
        
        root.getChildren().add(painelBT);
        
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Sistema de teste do JavaFX");
        stage.show();
        

    }

    public static void main(String[] args) {
        launch();
    }

}