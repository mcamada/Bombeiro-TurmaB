package ibirama.projetoalmoxarifado;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
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
        VBox root = new VBox();
 
     Label Texto1 = new Label("Usuário");
     Label Texto2 = new Label("Senha");
     
     TextField campo = new TextField();
        PasswordField senha = new PasswordField();
        
        Button btCancelar = new Button ("Cancelar");
        Button btConfirmar = new Button ("Confirmar");
        
        ButtonBar painelBt = new ButtonBar();
        painelBt.getButtons().addAll(btCancelar,btConfirmar);
        root.getChildren().addAll(Texto1, campo, Texto2, senha, painelBt);
        Scene scene = new Scene (root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}