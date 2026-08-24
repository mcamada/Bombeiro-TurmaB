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
                VBox rootCadastro = new VBox();

                rootCadastro.getChildren().add(new Label("Cadastro de item"));
                Label nomeItem = new Label("Nome do item");
                Label categoriaItem = new Label("Categoria do item");
                Label quantInicial = new Label("Quantidade inicial");
                Label unidadeMedida = new Label("Unidade de medida");
                Label localizacaoEstoque = new Label("Localização no estoque");
                Label nivelMinimoEstoque = new Label("Nível mínimo de estoque");

                TextField nome = new TextField();
                TextField categoria = new TextField();
                TextField QuantidadeI = new TextField();
                TextField unidadeM = new TextField();
                TextField LocalizacaoE = new TextField();
                TextField NivelME = new TextField();

                Button btCancelar = new Button("Cancelar");
                Button btConfirmar = new Button("Confirmar");
                ButtonBar painelBt = new ButtonBar();
                painelBt.getButtons().addAll(btCancelar, btConfirmar);

                EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Todos os dados preenchidos");
                        alert.show();

                        event.consume();
                        rootCadastro.getChildren().addAll(nomeItem, nome, categoriaItem, categoria, quantInicial, QuantidadeI, unidadeMedida, unidadeM, localizacaoEstoque, LocalizacaoE, nivelMinimoEstoque, NivelME, btCancelar, btConfirmar);
                        Scene cenarioCadastro = new Scene(rootCadastro, 800, 600);
                        cadastro.setScene(cenarioCadastro);
                        cadastro.show();

                        Stage consulta = new Stage();
                        VBox rootConsulta = new VBox();

                        rootConsulta.getChildren().add(new Label("Consulta de item"));
                        Label quantDisponivel = new Label("Quantidade disponível");
                        TextField quantD = new TextField();

                        rootCadastro.getChildren().addAll(nomeItem, nome, categoriaItem, categoria, localizacaoEstoque, LocalizacaoE, quantDisponivel, quantD, btCancelar, btConfirmar);
                        Scene cenarioConsulta = new Scene(rootConsulta, 800, 600);
                        consulta.setScene(cenarioConsulta);
                        consulta.show();

                        Stage atulizacao = new Stage();
                        VBox rootAtualizacao = new VBox();

                        Label quantidadeAjusteOuReposicao = new Label("Quantidade para reposição ou ajuste");
                        Label descricao = new Label("Descrição");
                        TextField descrição = new TextField();
                        TextField quantAR = new TextField();

                        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText("Todos os dados preenchidos");
                                alert.show();

                                event.consume();
                                rootAtualizacao.getChildren().addAll(quantidadeAjusteOuReposicao, quantAR, localizacaoEstoque, LocalizacaoE, nivelMinimoEstoque, NivelME, descricao, descrição, painelBt);
                            }
                        };

                        Stage exclusao = new Stage();
                        VBox rootExclusao = new VBox();

                        Label excluirItem = new Label(("Qual item deseja excluir"));
                        TextField exclusaoItem = new TextField();

                        EventHandler<MouseEvent> he = new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText("Tem certeza que gostaria de excluir?");
                                alert.show();

                                event.consume();
                                rootExclusao.getChildren().addAll(excluirItem, exclusaoItem, btCancelar, btConfirmar);

                            }
                        };
                    }

                };

                btConfirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
                Scene scene = new Scene(root, 800, 600);
                stage.setScene(scene);
                stage.show();
            }
        };

    }

    public static void main(String[] args) {
        launch();
    }
}
