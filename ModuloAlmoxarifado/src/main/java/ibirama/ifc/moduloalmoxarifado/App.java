package ibirama.ifc.moduloalmoxarifado;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 * JavaFX App
 */
public class App extends Application {

    private ObservableList<Item> itens = FXCollections.observableArrayList();
    private ObservableList<String> categorias = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {

        VBox root = new VBox();

        HBox menu = new HBox();
        Button cadastrarItem = new Button("Cadastrar Item");
        Button consultarItens = new Button("Consultar Itens");
        menu.getChildren().addAll(cadastrarItem, consultarItens);

        menu.setStyle(
                "-fx-background-color: #333333;"
                + "-fx-padding: 5px;"
        );

        cadastrarItem.setStyle(
                "-fx-background-color: transparent;"
                + "-fx-text-fill: white;"
                + "-fx-font-size: 14px;"
        );

        consultarItens.setStyle(
                "-fx-background-color: transparent;"
                + "-fx-text-fill: white;"
                + "-fx-font-size: 14px;"
        );

        Label recepsao = new Label("Seja Bem-Vindo");
        root.getChildren().addAll(menu, recepsao);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();

        //Cadastrar Itens
        EventHandler<MouseEvent> cadastrar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Stage cadastroTela = new Stage();
                VBox cRoot = new VBox();
                Label txCadastro = new Label("Cadastrar Item");

                Label tName = new Label("Nome do Item");
                TextField infName = new TextField();

                Label tCategoria = new Label("Categoria");
                TextField infCategoria = new TextField();

                Label tQuant = new Label("Quantidade Inicial");
                TextField infQuant = new TextField();

                Label tUnidMedid = new Label("Unidade de Medida");
                TextField infUnidMedid = new TextField();

                Label tLocal = new Label("Local no Estoque");
                TextField infLocal = new TextField();

                Label tMin = new Label("Nivel Minimo de Estoque");
                TextField infMin = new TextField();

                Button btSalve = new Button("Salvar Cadastro");
                btSalve.setDisable(true);

                HBox botoes = new HBox();
                Button btFiltrar = new Button("Filtrar");
                Button btExcluir = new Button("Excluir");
                Button btVoltar = new Button("Voltar");

                botoes.getChildren().addAll(btFiltrar, btExcluir, btVoltar);

                btSalve.disableProperty().bind(
                        infName.textProperty().isEmpty()
                                .or(infCategoria.textProperty().isEmpty())
                                .or(infQuant.textProperty().isEmpty())
                                .or(infUnidMedid.textProperty().isEmpty())
                                .or(infLocal.textProperty().isEmpty())
                                .or(infMin.textProperty().isEmpty())
                );

                cRoot.getChildren().addAll(txCadastro, tName, infName, tCategoria,
                        infCategoria, tQuant, infQuant, tUnidMedid, infUnidMedid, tLocal,
                        infLocal, tMin, infMin, btSalve, btVoltar);

                Scene cadastroCena = new Scene(cRoot, 640, 480);
                cadastroTela.setTitle("Cadastrar Itens");
                cadastroTela.setScene(cadastroCena);
                stage.close();
                cadastroTela.show();

                //Voltar
                EventHandler<MouseEvent> cdstVoltar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        stage.show();
                        cadastroTela.close();
                    }
                };

                btSalve.setOnMouseClicked((new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        String categoria = infCategoria.getText();

                        Item novoItem = new Item(
                                infName.getText(),
                                infCategoria.getText(),
                                Integer.parseInt(infQuant.getText()),
                                infUnidMedid.getText(),
                                infLocal.getText(),
                                Integer.parseInt(infMin.getText())
                        );

                        if (!categorias.contains(categoria)) {
                            categorias.add(categoria);

                        };

                        btVoltar.setOnMouseClicked(cdstVoltar);
                        itens.add(novoItem);

                        Alert aviso = new Alert(Alert.AlertType.INFORMATION);
                        aviso.setHeaderText("Item Cadastrado com Sucesso");
                        cadastroTela.close();
                        stage.show();
                        aviso.show();

                    }

                }));
            }
        };

        //Consultar Itens
        EventHandler<MouseEvent> consultar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Stage consultaTela = new Stage();
                VBox cRoot = new VBox();
                Label txConsultar = new Label("Consultar Itens");

                ObservableList<Item> itensFiltrados = FXCollections.observableArrayList(itens);

                HBox botoes = new HBox();
                Button btFiltrar = new Button("Filtrar");
                Button btExcluir = new Button("Excluir");
                Button btVoltarConst = new Button("Voltar");

                botoes.getChildren().addAll(btFiltrar, btExcluir, btVoltarConst);
/*
                =======================================================================
                Terminar
                =======================================================================
                */
                //Atualizar Item
                EventHandler<itens> atualizar = new EventHandler<itens>() {
                    @Override
                    public void handle(itens itemSelecionado) {
                        Stage atualizarTela = new Stage();
                        VBox cRoot = new VBox();
                        Label txAtualizar = new Label("Atualizar Item");

                        Label tName = new Label("Nome do Item");
                        TextField infName = new TextField();

                        Label tCategoria = new Label("Categoria");
                        TextField infCategoria = new TextField();

                        Label tQuant = new Label("Quantidade Inicial");
                        TextField infQuant = new TextField();

                        Label tUnidMedid = new Label("Unidade de Medida");
                        TextField infUnidMedid = new TextField();

                        Label tLocal = new Label("Local no Estoque");
                        TextField infLocal = new TextField();

                        Label tMin = new Label("Nivel Minimo de Estoque");
                        TextField infMin = new TextField();

                        infName.setText(itemSelecionado.nome);
                        
                        infCategoria.setText(itemSelecionado.categoria);
                        
                        infQuant.setText(String.valueOf(itemSelecionado.quantidade));
                        
                        infUnidMedid.setText(itemSelecionado.unidade);
                        
                        infLocal.setText(itemSelecionado.local);
                        
                        infMin.setText(String.valueOf(itemSelecionado.nivelMinimo));

                        Button btSalve = new Button("Atualizar Item");
                        btSalve.setDisable(true);

                        btSalve.disableProperty().bind(
                                infName.textProperty().isEmpty()
                                        .or(infCategoria.textProperty().isEmpty())
                                        .or(infQuant.textProperty().isEmpty())
                                        .or(infUnidMedid.textProperty().isEmpty())
                                        .or(infLocal.textProperty().isEmpty())
                                        .or(infMin.textProperty().isEmpty())
                        );

                        cRoot.getChildren().addAll(txAtualizar, tName, infName, tCategoria,
                                infCategoria, tQuant, infQuant, tUnidMedid, infUnidMedid, tLocal,
                                infLocal, tMin, infMin, btSalve);

                        Scene cadastroCena = new Scene(cRoot, 640, 480);
                        atualizarTela.setTitle("Atualizar Item");
                        atualizarTela.setScene(cadastroCena);
                        consultaTela.close();
                        atualizarTela.show();

                        btSalve.setOnMouseClicked((new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                atualizarTela.close();
                                Alert aviso = new Alert(Alert.AlertType.INFORMATION);
                                aviso.setHeaderText("Item Atualizado com Sucesso");
                                consultaTela.show();
                                aviso.show();

                            }
                        }));
                    }
                };

                //Excluir
                btExcluir.setDisable(true);

                btExcluir.setOnMouseClicked(event -> {

                    Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmacao.setTitle("Confirmar Exclusão");
                    confirmacao.setHeaderText("Excluir itens selecionados?");
                    confirmacao.setContentText("Os itens selecionados serão excluídos.");

                    var resultado = confirmacao.showAndWait();

                    if (resultado.isPresent()
                            && resultado.get() == javafx.scene.control.ButtonType.OK) {

                        itensFiltrados.removeIf(Item::isSelecionado);
                        itens.removeIf(Item::isSelecionado);

                        btExcluir.setDisable(true);
                    }
                });

                TableView<Item> Tabela = new TableView<>();

                TableColumn<Item, Boolean> caixaExcluir = new TableColumn<>("Selecionar");
                TableColumn<Item, String> nome = new TableColumn<>("Nome");
                TableColumn<Item, String> categoria = new TableColumn<>("Categoria");
                TableColumn<Item, String> quant = new TableColumn<>("Quantidade");
                TableColumn<Item, String> unidMedid = new TableColumn<>("Unidade de Medida");
                TableColumn<Item, String> local = new TableColumn<>("Local no Estoque");
                TableColumn<Item, String> min = new TableColumn<>("Nivel Minimo de Estoque");

                nome.setCellValueFactory(
                        celula -> new SimpleStringProperty(celula.getValue().nome)
                );
                categoria.setCellValueFactory(
                        celula -> new SimpleStringProperty(celula.getValue().categoria)
                );
                quant.setCellValueFactory(
                        celula -> new SimpleStringProperty(
                                String.valueOf(celula.getValue().quantidade)
                        )
                );
                unidMedid.setCellValueFactory(
                        celula -> new SimpleStringProperty(celula.getValue().unidade)
                );
                local.setCellValueFactory(
                        celula -> new SimpleStringProperty(celula.getValue().local)
                );
                min.setCellValueFactory(
                        celula -> new SimpleStringProperty(
                                String.valueOf(celula.getValue().nivelMinimo)
                        )
                );

                Tabela.setItems(itensFiltrados);

                caixaExcluir.setCellFactory(coluna -> {
                    return new TableCell<Item, Boolean>() {

                        private final CheckBox checkBox = new CheckBox();

                        {
                            checkBox.setOnAction(event -> {
                                Item item = getTableView().getItems().get(getIndex());

                                item.setSelecionado(checkBox.isSelected());

                                boolean algumSelecionado = Tabela.getItems().stream()
                                        .anyMatch(Item::isSelecionado);

                                btExcluir.setDisable(!algumSelecionado);
                            });
                        }

                        @Override
                        protected void updateItem(Boolean item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                Item itemTabela = getTableView().getItems().get(getIndex());
                                checkBox.setSelected(itemTabela.isSelecionado());
                                setGraphic(checkBox);
                            }
                        }
                    };
                });

                Tabela.getColumns().addAll(caixaExcluir, nome, categoria, quant, unidMedid, local, min);

                Tabela.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2) {
                        Item itemSelecionado = Tabela.getSelectionModel().getSelectedItem();
                        if (itemSelecionado == null) {
                            return;
                        }
                        atualizar.handle(itemSelecionado);
                    }
                });

                cRoot.getChildren().addAll(txConsultar, botoes, Tabela);

                Scene consultaCena = new Scene(cRoot, 640, 480);
                consultaTela.setTitle("Consultar Itens");
                consultaTela.setScene(consultaCena);
                stage.close();
                consultaTela.show();

                //Voltar
                EventHandler<MouseEvent> cnstVoltar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        stage.show();
                        consultaTela.close();
                    }
                };

                /*
==========================================================================================================
    por opção para não ter a filtração no fltrar e por multiplas ecolha!!
==========================================================================================================
                 */
                //Filtar Item
                EventHandler<MouseEvent> filtar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        Stage filtarTela = new Stage();
                        VBox cRoot = new VBox();
                        Label txFiltar = new Label("Filtar Item");

                        Label tCategoria = new Label("Categoria");
                        ListView<String> listCategoria = new ListView<>();
                        listCategoria.setItems(categorias);

                        Button btFiltar = new Button("Filtar Itens");

                        cRoot.getChildren().addAll(txFiltar, tCategoria, listCategoria, btFiltar, btVoltarConst);

                        Scene cadastroCena = new Scene(cRoot, 640, 480);
                        filtarTela.setTitle("Filtar Item");
                        filtarTela.setScene(cadastroCena);
                        consultaTela.close();
                        filtarTela.show();

                        btFiltar.setOnMouseClicked(event -> {

                            String categoriaSelecionada = listCategoria.getSelectionModel().getSelectedItem();

                            if (categoriaSelecionada == null) {
                                Alert aviso = new Alert(Alert.AlertType.WARNING);
                                aviso.setHeaderText("Selecione uma categoria");
                                aviso.show();
                                return;
                            }

                            itensFiltrados.clear();

                            for (Item item : itens) {
                                if (item.categoria.equals(categoriaSelecionada)) {
                                    itensFiltrados.add(item);
                                }
                            }

                            consultaTela.show();
                            filtarTela.close();
                        });
                    }
                };

                btFiltrar.setOnMouseClicked(filtar);
                btVoltarConst.setOnMouseClicked(cnstVoltar);
            }
        };

        cadastrarItem.setOnMouseClicked(cadastrar);
        consultarItens.setOnMouseClicked(consultar);

    }

    public static void main(String[] args) {
        launch();
    }

}
