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

        Button btCancelar = new Button("Cancelar");
        Button btConfirmar = new Button("Confirmar");

        ButtonBar painelBt = new ButtonBar();
        painelBt.getButtons().addAll(btCancelar, btConfirmar);
        root.getChildren().addAll(Texto1, campo, Texto2, senha, painelBt);

        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Todos os dados preenchidos");
                alert.show();

                event.consume();
                Stage cadastro = new Stage();
                GridPane rootMenu = new GridPane();

                btConfirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
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

                rootConsulta.getChildren().add(new Label("Consulta de item"));
                Label quantDisponivel = new Label("Quantidade disponível");
                TextField quantD = new TextField();

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

                        Label quantidadeAjusteOuReposicao = new Label("Quantidade para reposição ou ajuste");
                        Label descricao = new Label("Descrição");
                        TextField descrição = new TextField();
                        TextField quantAR = new TextField();
                        rootAtualizacao.getChildren().addAll(quantidadeAjusteOuReposicao, quantAR, localizacaoEstoque, LocalizacaoE, nivelMinimoEstoque, NivelME, descricao, descrição, painelBt);
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

                        event.consume();
                        rootExclusao.getChildren().addAll(excluirItem, exclusaoItem, btCancelar, btConfirmar);

                    }
                };
            }

        };

    }

    public static void main(String[] args) {
        launch();
    }
}
