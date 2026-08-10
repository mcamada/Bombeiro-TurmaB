package ibirama.ifc.moduloalmoxarifado;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
         VBox root = new VBox();

        Label recepsao = new Label("Seja Bem-Vindo");
        
        MenuBar menu = new MenuBar();
        Menu cadastrarItem = new Menu("Cadastrar Item");
        
        root.getChildren().addAll(recepsao, menu);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}