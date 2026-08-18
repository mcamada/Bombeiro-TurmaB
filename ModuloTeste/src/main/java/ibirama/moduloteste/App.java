package ibirama.moduloteste;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        GridPane root = new GridPane();
        Scene scene = new Scene(root, 800, 600);

        Button btCadastrarVt = new Button("Cadastrar Vt");
        Button btConsultarVt = new Button("Consultar Vt");
        Button btExcluirVt = new Button("Excluir Vt");
        Button btCadastrarUs = new Button("Cadastrar Usuário");

        Label titulo = new Label("Gestão de Viaturas");

        // Gestão de Viaturas
        // Sozinho no topo e centralizado
        root.add(titulo, 1, 0);
        GridPane.setHalignment(titulo, HPos.CENTER);

        // Cadastrar Usuário
        // Linha própria, alinhado com Excluir Vt
        root.add(btCadastrarUs, 2, 1);
        GridPane.setHalignment(btCadastrarUs, HPos.CENTER);

        // Botões de Viaturas
        root.add(btCadastrarVt, 0, 2);
        root.add(btConsultarVt, 1, 2);
        root.add(btExcluirVt, 2, 2);

        // Espaçamento entre os elementos
        root.setHgap(30);
        root.setVgap(20);

        // GridPane no topo e centralizado
        root.setAlignment(Pos.TOP_CENTER);

        // Distância do topo da janela
        root.setPadding(new Insets(25, 20, 20, 20));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}