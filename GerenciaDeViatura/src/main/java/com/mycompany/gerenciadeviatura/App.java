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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
     public void start(Stage stage) {
        VBox root = new VBox();
        
        Menu file = new Menu("Gerencia");
        Text gerencia = new Text("Gerencia de viaturas");
        file.getItems().add(gerencia);
        
        MenuBar meuMenu = new MenuBar();
        meuMenu.getMenus().addAll(file);
        
        Group grupoPrincipal = new Group(meuMenu);
        root.getChildren().add(grupoPrincipal);
        
        TreeItem<String> cursos = new TreeItem<String>("Cursos");
        TreeItem<String> tecnicos = new TreeItem<String>("Técnicos");
        TreeItem<String> informatica = new TreeItem<String>("Informática");
        TreeItem<String> vestuario = new TreeItem<String>("Vestuário");
        TreeItem<String> adm = new TreeItem<String>("Administração");
        
        cursos.getChildren().add(tecnicos);
        tecnicos.getChildren().addAll(informatica, vestuario, adm);
        
        TreeView<String> cursosIFC = new TreeView<String>(cursos);
        root.getChildren().add(cursosIFC);
        
        Spinner<Integer> mes = new Spinner<Integer>(1,12,1);
        root.getChildren().add(mes);
        
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