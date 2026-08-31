package ibirama.ifc.moduloalmoxarifado;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private ObservableList<Item> itens = FXCollections.observableArrayList();
    private ObservableList<String> categorias = FXCollections.observableArrayList();

    private void aplicarCss(Alert alert) {
        var css = getClass().getResource("/css/style.css");
        alert.getDialogPane().getStylesheets().add(css.toExternalForm());
    }

    /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    Atualizar Itens
---------------------------------------------------------------------------------------------------
===================================================================================================
     */
    
    private void atualizarItem(Item itemSelecionado, TableView<Item> tabela, Stage consultaTela) {
        Stage atualizarTela = new Stage();
        VBox cRoot = new VBox();
        Label txAtualizar = new Label("Atualizar Item");
        txAtualizar.getStyleClass().add("titulos");

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

        HBox botoes = new HBox();
        Button btSalve = new Button("Atualizar Item");
        btSalve.setDisable(true);
        Button btVoltarAtu = new Button("Voltar");
        botoes.getChildren().addAll(btSalve, btVoltarAtu);
        botoes.getStyleClass().add("grupo-botoes");

        /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    Voltar para Tela Consulta
---------------------------------------------------------------------------------------------------
===================================================================================================
         */
        
        EventHandler<MouseEvent> cnstVoltarAtu = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                consultaTela.show();
                atualizarTela.close();
            }
        };

        btVoltarAtu.setOnMouseClicked(cnstVoltarAtu);

        btSalve.disableProperty().bind(
                infName.textProperty().isEmpty()
                        .or(infCategoria.textProperty().isEmpty())
                        .or(infQuant.textProperty().isEmpty())
                        .or(infUnidMedid.textProperty().isEmpty())
                        .or(infLocal.textProperty().isEmpty())
                        .or(infMin.textProperty().isEmpty()));

        cRoot.getChildren().addAll(txAtualizar, tName, infName, tCategoria,
                infCategoria, tQuant, infQuant, tUnidMedid, infUnidMedid, tLocal,
                infLocal, tMin, infMin, botoes);

        Scene atualizarCena = new Scene(cRoot, 640, 480);
        var css = getClass().getResource("/css/style.css");
        atualizarCena.getStylesheets().add(css.toExternalForm());
        atualizarTela.setTitle("Atualizar Item");
        atualizarTela.setScene(atualizarCena);
        consultaTela.close();
        atualizarTela.show();

        btSalve.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                atualizarTela.close();
                Alert aviso = new Alert(Alert.AlertType.INFORMATION);
                aviso.setHeaderText("Item Atualizado com Sucesso");
                aplicarCss(aviso);
                consultaTela.show();
                aviso.show();

                String novaCategoria = infCategoria.getText();

                if (!categorias.contains(novaCategoria)) {
                    categorias.add(novaCategoria);
                }

                itemSelecionado.categoria = novaCategoria;

                itemSelecionado.nome = infName.getText();
                itemSelecionado.categoria = infCategoria.getText();
                itemSelecionado.quantidade = Integer.parseInt(infQuant.getText());
                itemSelecionado.unidade = infUnidMedid.getText();
                itemSelecionado.local = infLocal.getText();
                itemSelecionado.nivelMinimo = Integer.parseInt(infMin.getText());
                tabela.refresh();

            }
        }));
    }

    /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    Tela Inicial
---------------------------------------------------------------------------------------------------
===================================================================================================
     */
    
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();

        HBox menu = new HBox();
        Button cadastrarItem = new Button("Cadastrar Item");
        Button consultarItens = new Button("Consultar Itens");
        menu.getChildren().addAll(cadastrarItem, consultarItens);

        Label recepsao = new Label("Seja Bem-Vindo(a)");

        StackPane.setAlignment(menu, Pos.TOP_CENTER);
        StackPane.setAlignment(recepsao, Pos.CENTER);
        menu.setMaxHeight(Region.USE_PREF_SIZE);

        root.getChildren().addAll(menu, recepsao);

        menu.getStyleClass().add("menu");
        cadastrarItem.getStyleClass().add("menu-button");
        consultarItens.getStyleClass().add("menu-button");
        recepsao.getStyleClass().add("boas-vindas");

        var scene = new Scene(root, 640, 480);
        var css = getClass().getResource("/css/style.css");
        System.out.println(css);
        scene.getStylesheets().add(css.toExternalForm());
        stage.setTitle("Modulo Almoxarifado");
        stage.setScene(scene);
        stage.show();

        /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    Cadastrar Itens
---------------------------------------------------------------------------------------------------
===================================================================================================
         */
        
        EventHandler<MouseEvent> cadastrar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Stage cadastroTela = new Stage();
                StackPane fundoFormulario = new StackPane();

                VBox cRoot = new VBox();
                cRoot.getStyleClass().add("formulario");
                fundoFormulario.getStyleClass().add("borda-formulario");

                fundoFormulario.getChildren().add(cRoot);

                Label txCadastro = new Label("Cadastrar Item");
                txCadastro.getStyleClass().add("titulos");

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

                HBox boteosCadastro = new HBox();

                HBox botoes = new HBox();
                Button btFiltrar = new Button("Filtrar");
                Button btExcluir = new Button("Excluir");
                Button btVoltar = new Button("Voltar");

                botoes.getChildren().addAll(btFiltrar, btExcluir, btVoltar);
                boteosCadastro.getChildren().addAll(btSalve, btVoltar);

                boteosCadastro.getStyleClass().add("grupo-botoes");

                btSalve.disableProperty().bind(
                        infName.textProperty().isEmpty()
                                .or(infCategoria.textProperty().isEmpty())
                                .or(infQuant.textProperty().isEmpty())
                                .or(infUnidMedid.textProperty().isEmpty())
                                .or(infLocal.textProperty().isEmpty())
                                .or(infMin.textProperty().isEmpty()));

                cRoot.getChildren().addAll(txCadastro, tName, infName, tCategoria,
                        infCategoria, tQuant, infQuant, tUnidMedid, infUnidMedid, tLocal,
                        infLocal, tMin, infMin, boteosCadastro);

                Scene cadastroCena = new Scene(fundoFormulario, 640, 480);
                var css = getClass().getResource("/css/style.css");
                cadastroCena.getStylesheets().add(css.toExternalForm());
                cadastroTela.setTitle("Cadastrar Itens");
                cadastroTela.setScene(cadastroCena);
                stage.close();
                cadastroTela.show();

                /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    Voltar para Tela Inicial
---------------------------------------------------------------------------------------------------
=================================================================================================
                 */
                
                EventHandler<MouseEvent> cdstVoltar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        stage.show();
                        cadastroTela.close();
                    }
                };

                btVoltar.setOnMouseClicked(cdstVoltar);

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
                                Integer.parseInt(infMin.getText()));

                        if (!categorias.contains(categoria)) {
                            categorias.add(categoria);

                        };

                        itens.add(novoItem);

                        Alert aviso = new Alert(Alert.AlertType.INFORMATION);
                        aviso.setHeaderText("Item Cadastrado com Sucesso");
                        aplicarCss(aviso);
                        cadastroTela.close();
                        stage.show();
                        aviso.show();

                    }

                }));
            }
        };

        /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    consultar Itens
---------------------------------------------------------------------------------------------------
===================================================================================================
         */
        
        EventHandler<MouseEvent> consultar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Stage consultaTela = new Stage();
                VBox cRoot = new VBox();
                Label txConsultar = new Label("Consultar Itens");
                txConsultar.getStyleClass().add("titulos");

                ObservableList<Item> itensFiltrados = FXCollections.observableArrayList(itens);

                HBox botoes = new HBox();
                Button btFiltrar = new Button("Filtrar");
                Button btExcluir = new Button("Excluir");
                Button btVoltarConst = new Button("Voltar");

                botoes.getChildren().addAll(btFiltrar, btExcluir, btVoltarConst);
                botoes.getStyleClass().add("grupo-botoes");

                /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    Excluir Itens Selecionados
---------------------------------------------------------------------------------------------------
===================================================================================================
                 */
                
                btExcluir.setDisable(true);

                btExcluir.setOnMouseClicked(event -> {

                    Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
                    aplicarCss(confirmacao);
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
                TableColumn<Item, Integer> quant = new TableColumn<>("Quantidade");
                TableColumn<Item, String> unidMedid = new TableColumn<>("Unidade de Medida");
                TableColumn<Item, String> local = new TableColumn<>("Local no Estoque");
                TableColumn<Item, Integer> min = new TableColumn<>("Nivel Minimo de Estoque");

                nome.setCellValueFactory(
                        celula -> new SimpleStringProperty(celula.getValue().nome)
                );
                categoria.setCellValueFactory(
                        celula -> new SimpleStringProperty(celula.getValue().categoria)
                );
                quant.setCellValueFactory(
                        celula -> new SimpleIntegerProperty(celula.getValue().quantidade).asObject()
                );
                unidMedid.setCellValueFactory(
                        celula -> new SimpleStringProperty(celula.getValue().unidade)
                );
                local.setCellValueFactory(
                        celula -> new SimpleStringProperty(celula.getValue().local)
                );
                min.setCellValueFactory(
                        celula -> new SimpleIntegerProperty(celula.getValue().nivelMinimo).asObject()
                );

                Tabela.setItems(itensFiltrados);
                VBox.setVgrow(Tabela, Priority.ALWAYS);

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
                        atualizarItem(itemSelecionado, Tabela, consultaTela);
                    }
                });

                cRoot.getChildren()
                        .addAll(txConsultar, botoes, Tabela);

                Scene consultaCena = new Scene(cRoot, 640, 480);
                var css = getClass().getResource("/css/style.css");
                consultaCena.getStylesheets().add(css.toExternalForm());
                consultaTela.setTitle("Consultar Itens");
                consultaTela.setScene(consultaCena);
                stage.close();
                consultaTela.show();

                /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    Voltar para Tela Inicial
---------------------------------------------------------------------------------------------------
===================================================================================================
                 */
                
                EventHandler<MouseEvent> cnstVoltar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        stage.show();
                        consultaTela.close();
                    }
                };

                /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    Filtrar Itens
---------------------------------------------------------------------------------------------------
===================================================================================================
                 */
                
                EventHandler<MouseEvent> filtar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        Stage filtrarTela = new Stage();
                        VBox cRoot = new VBox();
                        Label txFiltar = new Label("Filtar Item");
                        txFiltar.getStyleClass().add("titulos");

                        Label tCategoria = new Label("Categoria");
                        ListView<String> listCategoria = new ListView<>();
                        listCategoria.setItems(categorias);
                        VBox.setVgrow(listCategoria, Priority.ALWAYS);

                        HBox botoeFiltro = new HBox();

                        Button btFiltar = new Button("Filtar Itens");
                        Button btLimparFiltro = new Button("Limpar Filtro");
                        Button btVoltarFiltro = new Button("Voltar");
                        botoeFiltro.getStyleClass().add("grupo-botoes");

                        botoeFiltro.getChildren().addAll(btFiltar, btLimparFiltro, btVoltarFiltro);

                        cRoot.getChildren().addAll(txFiltar, tCategoria, listCategoria, botoeFiltro);

                        Scene filtroCena = new Scene(cRoot, 640, 480);
                        var css = getClass().getResource("/css/style.css");
                        filtroCena.getStylesheets().add(css.toExternalForm());
                        filtrarTela.setTitle("Filtar Item");
                        filtrarTela.setScene(filtroCena);
                        consultaTela.close();
                        filtrarTela.show();

                        btFiltar.setOnMouseClicked(event -> {

                            String categoriaSelecionada = listCategoria.getSelectionModel().getSelectedItem();

                            if (categoriaSelecionada == null) {
                                Alert aviso = new Alert(Alert.AlertType.WARNING);
                                aviso.setHeaderText("Selecione uma categoria");
                                aplicarCss(aviso);
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
                            filtrarTela.close();
                        });

                        btLimparFiltro.setOnMouseClicked(event -> {
                            itensFiltrados.clear();
                            for (Item item : itens) {
                                itensFiltrados.add(item);
                            }
                            consultaTela.show();
                            filtrarTela.close();
                        });

                        /*
===================================================================================================
---------------------------------------------------------------------------------------------------
    Voltar para Tela de Consulta
---------------------------------------------------------------------------------------------------
===================================================================================================
                         */
                        
                        btVoltarFiltro.setOnMouseClicked(event -> {
                            filtrarTela.close();
                            consultaTela.show();
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
