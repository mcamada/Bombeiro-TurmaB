package ibirama.projetoalmoxarifado;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
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

        Label usuario = new Label("Usuário");
        Label senha = new Label("Senha");

        TextField campoUsuario = new TextField();
        PasswordField campoSenha = new PasswordField();

        Button btCancelar = new Button("Cancelar");
        Button btConfirmar = new Button("Confirmar");

        ButtonBar painelBt = new ButtonBar();
        painelBt.getButtons().addAll(btCancelar, btConfirmar);
        root.getChildren().addAll(usuario, campoUsuario, senha, campoSenha, painelBt);
        
        Scene cena = new Scene (root, 800, 600);
        stage.setTitle ("login");
        stage.setScene(cena);
        stage.show();
        
       

        EventHandler<MouseEvent> cadastro = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Todos os dados preenchidos");
                alert.show();

                event.consume();
                Stage cadastro = new Stage();
                GridPane rootMenu = new GridPane();

                rootMenu.add(new Label("Consulta"), 0, 0);
                rootMenu.add(new Label("Atualização"), 0, 2);
                rootMenu.add(new Label("Exclusão"), 2, 0);
                rootMenu.add(new Label("Cadastro"), 2, 2);

                EventHandler<ActionEvent> confirmarLogin;

                Scene cenadrato = new Scene(rootMenu, 800, 600);
                cadastro.setScene(cenadrato);
                cadastro.show();
            }
        };

        EventHandler<MouseEvent> consulta = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Todos os dados preenchidos");
                alert.show();

                event.consume();

                Stage consulta = new Stage();
                VBox rootConsulta = new VBox();

                Label item = new Label("Item");
                TextField campoItem = new TextField();
                Label categoria = new Label("Categoria");
                TextField campoCategoria = new TextField();
                Label quantDisponivel = new Label("Quantidade disponivel");
                TextField campoQuantidadeDisponivel = new TextField();
                Label localizacao = new Label("Localização");
                TextField campoLocalizacao = new TextField();
                Button btConsulta = new Button();
                
                rootConsulta.getChildren().addAll(item, campoItem, categoria, campoCategoria, quantDisponivel, campoQuantidadeDisponivel, localizacao, campoLocalizacao, btConsulta);
                Scene cenarioConsulta = new Scene(rootConsulta, 800, 600);
                consulta.setScene(cenarioConsulta);
                consulta.show();

                EventHandler<MouseEvent> atualizar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Todos os dados preenchidos");
                        alert.show();

                        event.consume();
                        Stage atulizacao = new Stage();
                        VBox rootAtualizacao = new VBox();

                        Label quantidadeAR = new Label("Quantidade(ajuste ou reposição)");
                        TextField campoQuantidadeAR = new TextField();
                        Label localizacao = new Label("Localização");
                        TextField campoLocalizacao = new TextField();
                        Label nivelMinimo = new Label("Nivel minimo");
                        TextField campoNivelMinimo = new TextField();
                        Label descricao = new Label("Descrição");
                        TextField campoDescricao = new TextField();

                        Button btAtualizar = new Button("Atualizar");
                    }
                };

                EventHandler<MouseEvent> he = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Tem certeza que gostaria de excluir?");
                        alert.show();
                        Stage exclusao = new Stage();
                        VBox rootExclusao = new VBox();

                        Label excluirItem = new Label(("Qual item deseja excluir"));
                        TextField exclusaoItem = new TextField();

                        Button btCancelarExclusao = new Button("Cancelar");
                        Button btConfirmarExclusao = new Button("Confirmar");

                        event.consume();
                        rootExclusao.getChildren().addAll(excluirItem, exclusaoItem, btCancelarExclusao, btConfirmarExclusao);

                    }
                };
            }

        };

    }

    public static void main(String[] args) {
        launch();
    }
}
