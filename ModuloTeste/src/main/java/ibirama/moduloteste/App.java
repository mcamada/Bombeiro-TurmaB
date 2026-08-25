package ibirama.moduloteste;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {
    private Stage stage;

       // LISTA PRINCIPAL DE VIATURAS

     private ObservableList<Viatura> viaturas = FXCollections.observableArrayList();
 @Override
public void start(Stage stage) {

        this.stage = stage;

               // VIATURAS INICIAIS
    
        viaturas.add(new Viatura( "ABTR-01","Quartel","Viatura","Disponível","24 horas","CNH e documentação", "","","" ));

        viaturas.add(new Viatura("ASU-01","Posto de bombeiros","Viatura Administrativa","Em manutenção","Indisponível","Revisão do veículo","","",""));

        telaInicial();
    }

       // TELA INICIAL
  
    private void telaInicial() {

        GridPane root = new GridPane();
    Scene scene = new Scene(root, 800, 600);
     scene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

        Button btCadastrarVt = new Button("Cadastrar Vt");
        Button btConsultarVt = new Button("Consultar Vt");
        Button btExcluirVt = new Button("Excluir Vt");
        Button btCadastrarUs = new Button("Cadastrar Usuário");

        Label titulo = new Label("Gestão de Viaturas");
        titulo.getStyleClass().add("titulo");

        // Gestão de Viaturas
        root.add(titulo, 1, 0);
        GridPane.setHalignment(titulo, HPos.CENTER);

        // Cadastrar Usuário
        root.add(btCadastrarUs, 2, 1);
        GridPane.setHalignment(btCadastrarUs, HPos.CENTER);

        // Botões de Viaturas
        root.add(btCadastrarVt, 0, 2);
        root.add(btConsultarVt, 1, 2);
        root.add(btExcluirVt, 2, 2);

        // Espaçamento
        root.setHgap(30);
        root.setVgap(20);

        // Alinhamento
        root.setAlignment(Pos.TOP_CENTER);

        // Distância do topo
        root.setPadding(new Insets(25, 20, 20, 20));

              // BOTÃO CADASTRAR VIATURA
      
        btCadastrarVt.setOnAction(e -> telaCadastrarViatura());

              // BOTÃO CONSULTAR VIATURA

             btConsultarVt.setOnAction(e -> telaConsultarViaturas());

          // BOTÃO EXCLUIR VIATURA
       
        btExcluirVt.setOnAction(e -> telaExcluirViaturas());

        stage.setTitle("Gestão de Viaturas");
        stage.setScene(scene);
        stage.show();
    }

       // TELA DE CADASTRO DE VIATURA

    private void telaCadastrarViatura() {

        GridPane root = new GridPane();

        root.setPadding(new Insets(30));

        root.setHgap(15);
        root.setVgap(15);

        root.setAlignment(Pos.TOP_CENTER);

              // TÍTULO
      
        Label titulo = new Label("Cadastrar Viatura");
        titulo.getStyleClass().add("titulo");

        root.add(titulo, 0, 0, 2, 1);

        GridPane.setHalignment(titulo,HPos.CENTER);

               // IDENTIFICAÇÃO
  
        Label labelIdentificacao = new Label("Identificação da Viatura:");

        TextField campoIdentificacao = new TextField();

        campoIdentificacao.setPromptText("Ex.: ABTR-02");

        root.add(labelIdentificacao,0,1);

        root.add(campoIdentificacao,1,1);

            // TIPO
     
        Label labelTipo = new Label("Tipo da Viatura:");

        javafx.scene.control.ComboBox<String> campoTipo = new javafx.scene.control.ComboBox<>();

        campoTipo.getItems().addAll("Combate a incêndio","Resgate", "Ambulância","Transporte","Salvamento","Administrativo");

        campoTipo.setPromptText("Selecione o tipo");

        root.add(labelTipo,0,2);

        root.add(campoTipo,1,2);

               // PLACA
   
        Label labelPlaca = new Label("Placa:");

        TextField campoPlaca = new TextField();

        campoPlaca.setPromptText("Ex.: ABC-1234");

        root.add(labelPlaca,0,3);

        root.add(campoPlaca,1,3);
      
        // MODELO
       
        Label labelModelo = new Label("Modelo:");

        TextField campoModelo = new TextField();

        campoModelo.setPromptText("Ex.: Mercedes-Benz Atego");

        root.add(labelModelo,0,4);

        root.add(campoModelo,1,4);

                // ANO DE FABRICAÇÃO

        Label labelAno = new Label("Ano de fabricação:");

        TextField campoAno = new TextField();

        campoAno.setPromptText("Ex.: 2024");

        root.add(labelAno,0,5);

        root.add(campoAno,1,5);

               // STATUS
       
        Label labelStatus = new Label("Status:");

        javafx.scene.control.ComboBox<String> campoStatus = new javafx.scene.control.ComboBox<>();

        campoStatus.getItems().addAll("Disponível","Indisponível","Em manutenção");

        campoStatus.setPromptText("Selecione o status");

        root.add(labelStatus,0,6);

        root.add(campoStatus,1, 6 );
        // BOTÃO CADASTRAR
       
        Button btCadastrar = new Button("Cadastrar");

        btCadastrar.setOnAction(e -> {

            String identificacao = campoIdentificacao.getText().trim();

            String tipo = campoTipo.getValue();

            String placa = campoPlaca.getText().trim();

            String modelo = campoModelo.getText().trim();

            String ano = campoAno.getText().trim();

            String status = campoStatus.getValue();

                      // VERIFICAÇÃO DOS CAMPOS
        
            if (identificacao.isEmpty() || tipo == null || placa.isEmpty() || modelo.isEmpty() || ano.isEmpty() || status == null) {

                Alert alerta = new Alert(Alert.AlertType.WARNING);

                alerta.setTitle("Cadastro de Viatura");

                alerta.setHeaderText("Preencha todos os campos");

                alerta.setContentText("Todos os campos devem ser preenchidos.");

                alerta.showAndWait();
                return;
            }
            // VERIFICA SE A PLACA JÁ ESTÁ CADASTRADA

                for (Viatura viatura : viaturas) {

                if (viatura.getPlaca().equalsIgnoreCase(placa)) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);

                alerta.setTitle("Erro no cadastro");
                alerta.setHeaderText("Placa já cadastrada");
                alerta.setContentText("A placa " + placa + " já está cadastrada no sistema.");

                alerta.showAndWait();

                return;
            }
            }


            // CRIA A NOVA VIATURA
          
            Viatura novaViatura = new Viatura(identificacao,"",tipo,status,"","",placa,modelo,ano);

            // ADICIONA NA LISTA PRINCIPAL
          
            viaturas.add(novaViatura);
            
            // AVISO DE SUCESSO
           
            Alert sucesso = new Alert(Alert.AlertType.INFORMATION);

            sucesso.setTitle("Cadastro realizado");

            sucesso.setHeaderText("Viatura cadastrada com sucesso!");

            sucesso.setContentText("A viatura "+ identificacao+ " foi adicionada.");

            sucesso.showAndWait();
            // Volta para a tela inicial
            telaInicial();
        });

               // BOTÃO CANCELAR
      
        Button btCancelar = new Button("Cancelar");

        btCancelar.setOnAction(e -> telaInicial());

                // BOTÕES
     
        HBox botoes = new HBox(15,btCancelar,btCadastrar);

        botoes.setAlignment(Pos.CENTER);

        root.add(botoes,0,8,2,1);
                // CENA
       
        Scene scene = new Scene(root, 650, 550);
        scene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

        stage.setTitle("Cadastrar Viatura");
        stage.setScene(scene);
        stage.show();
    }

        // TELA DE CONSULTA DE VIATURAS
  
    private void telaConsultarViaturas() {

        BorderPane root = new BorderPane();

        root.setPadding(new Insets(20));

        // TÍTULO
       
        Label titulo = new Label("Consulta de Viaturas");
        titulo.getStyleClass().add("titulo");

        BorderPane.setAlignment(titulo,Pos.CENTER);

        root.setTop(titulo);

              // TABELA
        
        TableView<Viatura> tabela = new TableView<>();

        tabela.setEditable(true);

               // COLUNA NOME / IDENTIFICAÇÃO
        
        TableColumn<Viatura, String> colunaNome = new TableColumn<>("Nome da Viatura");

        colunaNome.setCellValueFactory(data ->data.getValue().nomeProperty());

        colunaNome.setCellFactory( TextFieldTableCell.forTableColumn());

        colunaNome.setOnEditCommit(event -> {event.getRowValue().setNome(event.getNewValue());

        });
       
        // COLUNA LOCALIZAÇÃO
       
        TableColumn<Viatura, String> colunaLocalizacao = new TableColumn<>("Localização");

        colunaLocalizacao.setCellValueFactory(data ->data.getValue().localizacaoProperty());

        colunaLocalizacao.setCellFactory(TextFieldTableCell.forTableColumn());

        colunaLocalizacao.setOnEditCommit(event -> {event.getRowValue().setLocalizacao(event.getNewValue());

        });

              // COLUNA TIPO
       
        TableColumn<Viatura, String> colunaTipo = new TableColumn<>("Tipo");

        colunaTipo.setCellValueFactory(data ->data.getValue().tipoProperty());


        ObservableList<String> tipos =
                FXCollections.observableArrayList("Combate a incêndio","Resgate","Ambulância","Transporte","Salvamento","Administrativo");


        colunaTipo.setCellFactory(ComboBoxTableCell.forTableColumn(tipos));


        colunaTipo.setOnEditCommit(event -> {event.getRowValue().setTipo(event.getNewValue());

        });

        // COLUNA STATUS
        

        TableColumn<Viatura, String> colunaStatus =  new TableColumn<>("Status");

        colunaStatus.setCellValueFactory(data -> data.getValue().statusProperty());


        ObservableList<String> status = FXCollections.observableArrayList("Disponível","Indisponível","Em manutenção");

        colunaStatus.setCellFactory(ComboBoxTableCell.forTableColumn(status)
        );


        colunaStatus.setOnEditCommit(event -> {event.getRowValue().setStatus(event.getNewValue());

        });

        // COLUNA DISPONIBILIDADE
       
        TableColumn<Viatura, String> colunaDisponibilidade = new TableColumn<>("Disponibilidade");

        colunaDisponibilidade.setCellValueFactory(data ->data.getValue().disponibilidadeProperty());

        colunaDisponibilidade.setCellFactory(TextFieldTableCell.forTableColumn());

        colunaDisponibilidade.setOnEditCommit(event -> {event.getRowValue().setDisponibilidade(event.getNewValue());

        });
        // COLUNA CRITÉRIOS
       

        TableColumn<Viatura, String> colunaCriterios = new TableColumn<>("Critérios");

        colunaCriterios.setCellValueFactory(data ->data.getValue().criteriosProperty());

        colunaCriterios.setCellFactory(TextFieldTableCell.forTableColumn());

        colunaCriterios.setOnEditCommit(event -> {event.getRowValue().setCriterios(event.getNewValue());
        });

        // ADICIONANDO AS COLUNAS
        
        tabela.getColumns().addAll(colunaNome,colunaLocalizacao,colunaTipo,colunaStatus,colunaDisponibilidade,colunaCriterios);

        // TAMANHO DAS COLUNAS
        colunaNome.setPrefWidth(160);
        colunaLocalizacao.setPrefWidth(150);
        colunaTipo.setPrefWidth(120);
        colunaStatus.setPrefWidth(150);
        colunaDisponibilidade.setPrefWidth(150);
        colunaCriterios.setPrefWidth(180);

              // USA A LISTA PRINCIPAL
      
        tabela.setItems(viaturas);

            // BOTÃO ADICIONAR
      
        Button btAdicionar = new Button("Adicionar Viatura");

            // Agora o cadastro oficial é feito
            // pela tela Cadastrar Vt.

        btAdicionar.setOnAction(e -> {telaCadastrarViatura();
        });
                // BOTÃO VOLTAR

               Button btVoltar = new Button("Voltar");

        btVoltar.setOnAction(e -> telaInicial());

               // BOTÕES
 
        HBox botoes = new HBox(15,btVoltar,btAdicionar);

        botoes.setAlignment(Pos.CENTER);

        botoes.setPadding(new Insets(20,0,0,0));


        // ORGANIZAÇÃO
        root.setCenter(tabela);

        root.setBottom(botoes);

        BorderPane.setAlignment(tabela,Pos.CENTER);

        // CENA
         Scene scene = new Scene(root, 1000, 600);
         scene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

        stage.setTitle("Consultar Viaturas");

        stage.setScene(scene);

        stage.show();
    }

    // TELA DE EXCLUSÃO DE VIATURAS

    private void telaExcluirViaturas() {

        BorderPane root = new BorderPane();

        root.setPadding(new Insets(20));

        // TÍTULO
       
        Label titulo = new Label("Excluir Viaturas");
        titulo.getStyleClass().add("titulo");

        BorderPane.setAlignment(titulo,Pos.CENTER);
        root.setTop(titulo);

        // LISTA
   
        ListView<Viatura> listaViaturas = new ListView<>();

        listaViaturas.setItems(
                viaturas
        );


        listaViaturas.setCellFactory(
                listView ->
                        new javafx.scene.control.ListCell<Viatura>() {

                            @Override
                            protected void updateItem(Viatura viatura, boolean empty) {

                                super.updateItem(viatura,empty);
                                if (empty|| viatura == null) {
                                    setText(null);
        } else {
        String nome = viatura.getNome();
        
        if (nome == null|| nome.isEmpty()) {
                nome = "Viatura sem nome";
                                    }
         setText(nome);
        }
        }
         }
        );


                // INSTRUÇÃO
       
        Label instrucao = new Label("Clique em uma viatura para excluí-la.");

        instrucao.setPadding(new Insets(10,0,10,0));
        // CLIQUE NA VIATURA
        
        listaViaturas.setOnMouseClicked(event -> {Viatura viaturaSelecionada =listaViaturas.getSelectionModel().getSelectedItem();


         if (viaturaSelecionada== null) {
               return;
                    }

         String nomeViatura =viaturaSelecionada.getNome();


          if (nomeViatura == null|| nomeViatura.isEmpty()) 
                    {
              nomeViatura ="Viatura sem nome";
                    }

                    // CONFIRMAÇÃO
            // Cancelar:
            // não faz nada.       
          Alert confirmacao =new Alert(Alert.AlertType.CONFIRMATION);

          confirmacao.setTitle("Excluir Viatura");

          confirmacao.setHeaderText(
          "Excluir esta viatura?"
                    );

          confirmacao.setContentText("Viatura selecionada: "+ nomeViatura+ "\n\n"+ "Escolha \"Apagar\" "+ "para excluir ou " + "\"Cancelar\" para "+ "cancelar.");


          ButtonType btApagar = new ButtonType("Apagar");

          ButtonType btCancelar = new ButtonType("Cancelar");
                    
          confirmacao.getButtonTypes().setAll(btApagar, btCancelar);
                    
          confirmacao.showAndWait().ifPresent(resposta -> {if (resposta== btApagar) {
          viaturas.remove(viaturaSelecionada);
                                        }
 
       }
    );
  }
);

        // BOTÃO VOLTAR
     

        Button btVoltar = new Button("Voltar");

        btVoltar.setOnAction(e -> telaInicial());

        // CENTRO
        VBox centro = new VBox(10,instrucao,listaViaturas);
        centro.setAlignment(Pos.CENTER);
        root.setCenter(centro);
        // BOTÕES
        HBox botoes = new HBox(btVoltar);
        botoes.setAlignment(Pos.CENTER);
        botoes.setPadding(new Insets(15,0,0,0));
        root.setBottom(botoes);
                // CENA
        
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
        stage.setTitle("Excluir Viaturas");
        stage.setScene(scene);
        stage.show();
    }
       // CLASSE VIATURA
  
    public static class Viatura {
             // INFORMAÇÕES MOSTRADAS NA CONSULTA
    
        private final StringProperty nome;
        private final StringProperty localizacao;
        private final StringProperty tipo;
        private final StringProperty status;
        private final StringProperty disponibilidade;
        private final StringProperty criterios;
                // INFORMAÇÕES DO CADASTRO
        private final StringProperty placa;
        private final StringProperty modelo;
        private final StringProperty ano;

        public Viatura(String nome,String localizacao,String tipo,String status,String disponibilidade,String criterios,String placa,String modelo,String ano) {

            this.nome =
                    new SimpleStringProperty(nome);
            this.localizacao = new SimpleStringProperty(localizacao);

            this.tipo = new SimpleStringProperty(tipo);

            this.status = new SimpleStringProperty(status);

            this.disponibilidade = new SimpleStringProperty(disponibilidade);

            this.criterios = new SimpleStringProperty(criterios);

            this.placa = new SimpleStringProperty(placa);

            this.modelo = new SimpleStringProperty(modelo);

            this.ano = new SimpleStringProperty(ano);
        }
               // NOME / IDENTIFICAÇÃO
    
        public StringProperty nomeProperty() {
            return nome;
        }

        public String getNome() {
            return nome.get();
        }

        public void setNome(String valor) {
            nome.set(valor);
        }
              // LOCALIZAÇÃO
     
        public StringProperty localizacaoProperty() {
            return localizacao;
        }

        public String getLocalizacao() {
            return localizacao.get();
        }

        public void setLocalizacao(String valor) {
            localizacao.set(valor);
        }
                // TIPO
      
        public StringProperty tipoProperty() {
            return tipo;
        }
        public String getTipo() {
            return tipo.get();
        }
        public void setTipo(String valor) {
            tipo.set(valor);
        }
               // STATUS
      
        public StringProperty statusProperty() {
            return status;
        }
        public String getStatus() {
            return status.get();
        }
        public void setStatus(String valor) {
            status.set(valor);
        }
              // DISPONIBILIDADE
       
        public StringProperty disponibilidadeProperty() {
            return disponibilidade;
        }
        public String getDisponibilidade() {
            return disponibilidade.get();
        }
        public void setDisponibilidade(String valor) {
            disponibilidade.set(valor);
        }
               // CRITÉRIOS
       
        public StringProperty criteriosProperty() {
            return criterios;
        }
        public String getCriterios() {
            return criterios.get();
        }

        public void setCriterios(String valor) {
            criterios.set(valor);
        }
       // PLACA
       
        public StringProperty placaProperty() {
            return placa;
        }
        public String getPlaca() {
            return placa.get();
        }
        public void setPlaca(String valor) {
            placa.set(valor);
        }
             // MODELO
      
        public StringProperty modeloProperty() {
            return modelo;
        }

        public String getModelo() {
            return modelo.get();
        }

        public void setModelo(String valor) {
            modelo.set(valor);
        }
              // ANO
       
        public StringProperty anoProperty() {
            return ano;
        }
        public String getAno() {
            return ano.get();
        }
        public void setAno(String valor) {
            ano.set(valor);
        }
    }
       // MAIN
    public static void main(String[] args) {

        launch();
    }
}
