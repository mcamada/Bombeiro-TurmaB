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

        Scene cena = new Scene(root, 800, 600);
        stage.setTitle("login");
        stage.setScene(cena);
        stage.show();

        /*CADASTRO*/
        EventHandler<MouseEvent> cadastro = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Todos os dados preenchidos");
                alert.show();

                event.consume();
                Stage cadastro = new Stage();
                GridPane rootCadastro = new GridPane();

                rootCadastro.add(new Label("Consulta"), 0, 0);
                rootCadastro.add(new Label("Atualização"), 0, 2);
                rootCadastro.add(new Label("Exclusão"), 2, 0);
                rootCadastro.add(new Label("Cadastro"), 2, 2);
                rootCadastro.add(new Button("Cancelar"), 3, 3);
                rootCadastro.add(new Button("Confirmar"), 3,4 );

                Button btCancelarCadastro = new Button("Cancelar");
                Button btConfirmarCadastro = new Button("Confimar");
                ButtonBar painelBtCadastro = new ButtonBar();
           

                rootCadastro.getChildren().addAll(painelBtCadastro);
                Scene cenarioCadastro = new Scene(rootCadastro, 800, 600);
                cadastro.setScene(cenarioCadastro);
                cadastro.showAndWait();
            }
        };
        btConfirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, cadastro);

        /*CONSULTA*/
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

                Button btCancelarConsulta = new Button("Cancelar");
                Button btConfirmarConsulta = new Button("Confimar");
                ButtonBar painelBtConsulta = new ButtonBar();
                painelBtConsulta.getButtons().addAll(btCancelarConsulta, btConfirmarConsulta);

                rootConsulta.getChildren().addAll(item, campoItem, categoria, campoCategoria, quantDisponivel, campoQuantidadeDisponivel, localizacao, campoLocalizacao, painelBtConsulta);
                Scene cenarioConsulta = new Scene(rootConsulta, 800, 600);
                consulta.setScene(cenarioConsulta);
                consulta.showAndWait();
            }
        };
        btConfirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, consulta);
        /*ATUALIZAR*/
        EventHandler<MouseEvent> atualizar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Todos os dados preenchidos");
                alert.show();

                event.consume();
                Stage atualizacao = new Stage();
                VBox rootAtualizacao = new VBox();

                Label quantidadeAR = new Label("Quantidade(ajuste ou reposição)");
                TextField campoQuantidadeAR = new TextField();
                Label localizacao = new Label("Localização");
                TextField campoLocalizacao = new TextField();
                Label nivelMinimo = new Label("Nivel minimo");
                TextField campoNivelMinimo = new TextField();
                Label descricao = new Label("Descrição");
                TextField campoDescricao = new TextField();

                Button btCancelarAtualizacao = new Button("Cancelar");
                Button btConfirmarAtualizacao = new Button("Confimar");
                ButtonBar painelBtAtualizacao = new ButtonBar();
                painelBtAtualizacao.getButtons().addAll(btCancelarAtualizacao, btConfirmarAtualizacao);

                rootAtualizacao.getChildren().addAll(quantidadeAR, campoQuantidadeAR, localizacao, campoLocalizacao, nivelMinimo, campoNivelMinimo, descricao, campoDescricao, painelBtAtualizacao);
                Scene cenarioAtualizacao = new Scene(rootAtualizacao, 800, 600);
                atualizacao.setScene(cenarioAtualizacao);
                atualizacao.showAndWait();
            }
        };
        btConfirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, atualizar);
        /*EXCLUSAO*/

        Label excluirItem = new Label(("Qual item deseja excluir"));
        TextField exclusaoItem = new TextField();

        EventHandler<MouseEvent> exclusao = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Tem certeza que gostaria de excluir?");
                alert.show();
                Stage exclusao = new Stage();
                VBox rootExclusao = new VBox();

                event.consume();

                Button btCancelarExclusao = new Button("Cancelar");
                Button btConfirmarExclusao = new Button("Confimar");
                ButtonBar painelBtExclusao = new ButtonBar();
                painelBtExclusao.getButtons().addAll(btCancelarExclusao, btConfirmarExclusao);

                rootExclusao.getChildren().addAll(excluirItem, exclusaoItem, painelBtExclusao);
                Scene cenarioExclusao = new Scene(rootExclusao, 800, 600);
                exclusao.setScene(cenarioExclusao);
                exclusao.showAndWait();
            }
        };
        btConfirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, exclusao);

    }

    public static void main(String[] args) {
        launch();
    }
;

}
