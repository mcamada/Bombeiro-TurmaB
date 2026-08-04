package ibirama.projetoalmoxarifado;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) { 
        GridPane root = new GridPane();
        
     root.add(new Label("Usuário"), 0, 1);
     root.add(new Label("Senha"),0, 2);
        
        TextField campo = new TextField();
        PasswordField senha = new PasswordField();
        root.getChildren().addAll(campo, senha);
        Scene scene = new Scene (root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}