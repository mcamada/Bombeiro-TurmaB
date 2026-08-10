package ibirama.projetoalmoxarifado;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
        
        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>(){
            @Override
            public void handle (MouseEvent event){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Todos os dados preenchidos");
                alert.show();
                
                event.consume();
              Stage cadastro = new Stage();
              VBox rootCadastro = new VBox();
              
              rootCadastro.getChildren().add(new Label("Atualizar item"));
              Scene cenarioCadastro = new Scene (rootCadastro,100,100);
              cadastro.setScene(cenarioCadastro);
              cadastro.show();
            }
        };
        btConfirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        Scene scene = new Scene (root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}