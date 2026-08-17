package ibirama.moduloteste;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 800, 600);
        
        ButtonBar painelBt = new ButtonBar();
        Button btCadastrarVt = new Button("CadastrarVt");
        Button btConsultarVt = new Button("ConsultarVt");
        Button btExcluirVt = new Button("ExcluirVt");
        
        painelBt.getButtons().addAll(btCadastrarVt, btConsultarVt, btExcluirVt);
    
        root.add(new Label("Gestão de Viaturas"), 0,1);
        
        root.add(btCadastrarVt, 2, 2);
        root.add(btConsultarVt, 3, 2);
        root.add(btExcluirVt, 4, 2);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}