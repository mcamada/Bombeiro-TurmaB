package com.mycompany.rycardofusinatoteste;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
    
        GridPane gpCampos = new GridPane();

        Label lbTipo = new Label("Tipo de ocorrencia :");
        lbTipo.setId("lbTipo");
        lbTipo.getStyleClass().add("rotulo");

        Label lbDataHora = new Label("Data e hora :");
        lbDataHora.setId("lbDataHora");
        lbDataHora.getStyleClass().add("rotulo");
        
        Label lbLocal = new Label("Local :");
        lbLocal.setId("lbLocal");
        lbLocal.getStyleClass().add("rotulo");
        
        Label lbDescrição = new Label("Descrição :");
        lbDescrição.setId("lbDescrição");
        lbDescrição.getStyleClass().add("rotulo");
        
        Label lbEquipe = new Label("Equipe Envolvida :");
        lbEquipe.setId("lbEquipe");
        lbEquipe.getStyleClass().add("rotulo");

        TextField tfTipo = new TextField();
        tfTipo.setId("tfTipo");
        tfTipo.getStyleClass().add("campo");

        TextField tfDataHora = new TextField();
        tfDataHora.setId("tfDataHora");
        tfDataHora.getStyleClass().add("campo");
        
        TextField tfLocal = new TextField();
        tfLocal.setId("tfLocal");
        tfLocal.getStyleClass().add("campo");
        
        TextField tfDescrição = new TextField();
        tfDescrição.setId("tfDescrição");
        tfDescrição.getStyleClass().add("campo");
        
        TextField tfEquipe = new TextField();
        tfEquipe.setId("tfEquipe");
        tfEquipe.getStyleClass().add("campo");
        
        Button btCadastrar = new Button("Cadastrar");
        btCadastrar.setId("btCadastrar");
        btCadastrar.getStyleClass().add("botao");

        gpCampos.add(lbTipo, 0, 0);
        gpCampos.add(lbDataHora, 0, 2);
        gpCampos.add(lbLocal, 0, 4);
        gpCampos.add(lbDescrição, 0, 6);
        gpCampos.add(lbEquipe, 0, 8);
        gpCampos.add(tfTipo, 0, 1);
        gpCampos.add(tfDataHora, 0, 3);
        gpCampos.add(tfLocal, 0, 5);
        gpCampos.add(tfDescrição, 0, 7);
        gpCampos.add(tfEquipe, 0, 9);
        gpCampos.add(btCadastrar, 0, 11);
        gpCampos.setHalignment(btCadastrar, HPos.CENTER);

        gpCampos.setAlignment(Pos.CENTER);
       


        root.setCenter(gpCampos);

        ButtonBar painelBt = new ButtonBar();
        
        Button btInicio = new Button("Inicio");
        btInicio.setId("btInicio");
        btInicio.getStyleClass().add("botao");
        
        Button btConsultar = new Button("Consultar");
        btConsultar.setId("btConsultar");
        btConsultar.getStyleClass().add("botao");
        
        Button btCadastrar2 = new Button("Cadastrar");
        btCadastrar2.setId("btCadastrar2");
        btCadastrar2.getStyleClass().add("botao");

        painelBt.getButtons().addAll(btInicio, btCadastrar2, btConsultar);

        HBox header = new HBox();
        header.getStyleClass().add("header");
        header.getChildren().addAll(new Label("Cadastrar Ocorrência"), painelBt);
        
        root.setTop(header);
   
        Scene scene = new Scene(root, 640, 480);
        
        stage.setScene(scene);
        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("Sistema de Teste do JavaFx");
        
        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
                Stage cadastro = new Stage();
                cadastro.initModality(Modality.APPLICATION_MODAL);

                BorderPane topBar = new BorderPane();
                topBar.getStyleClass().add("top-bar");

                Label tituloBarra = new Label("Consultar Ocorrências");
                tituloBarra.getStyleClass().add("titulo-barra");

                HBox menu = new HBox(30);
                menu.setAlignment(Pos.CENTER_RIGHT);

                Button btnInicio = criarBotao("Início");
                Button btnCadastrar = criarBotao("Cadastrar");
                Button btnConsultar = criarBotao("Consultar");

                btnConsultar.getStyleClass().add("botao-consultar");

                menu.getChildren().addAll(
                        btnInicio,
                        btnCadastrar,
                        btnConsultar
                );

                topBar.setLeft(tituloBarra);
                topBar.setRight(menu);

                Label titulo = new Label("Consulta de Ocorrência");
                titulo.getStyleClass().add("titulo-principal");

                TextField campoBusca = new TextField();
                campoBusca.setPromptText("Buscar Ocorrências");
                campoBusca.getStyleClass().add("campo-busca");

                Circle circulo = new Circle(9);
                circulo.setFill(Color.TRANSPARENT);
                circulo.setStroke(Color.GRAY);
                circulo.setStrokeWidth(1.5);

                Line haste = new Line(6, 6, 14, 14);
                haste.setStroke(Color.GRAY);
                haste.setStrokeWidth(1.5);

                StackPane lupa = new StackPane();
                lupa.getChildren().addAll(circulo, haste);

                StackPane.setAlignment(lupa, Pos.CENTER_RIGHT);
                StackPane.setMargin(lupa, new Insets(0, 32, 0, 0));

                StackPane campoBuscaContainer = new StackPane();

                campoBuscaContainer.getChildren().addAll(
                        campoBusca,
                        lupa
                );

                campoBuscaContainer.getStyleClass().add("busca-container");

                VBox listaOcorrencias = new VBox(13);
                listaOcorrencias.getStyleClass().add("lista-ocorrencias");

                listaOcorrencias.getChildren().addAll(

                        criarCard(
                                "Ocorrência",
                                "12/08/2026",
                                "Furto",
                                "Em andamento",
                                "Centro"
                        ),

                        criarCard(
                                "Ocorrência",
                                "10/08/2026",
                                "Roubo",
                                "Concluído",
                                "Jardim América"
                        ),

                        criarCard(
                                "Ocorrência",
                                "08/08/2026",
                                "Acidente",
                                "Em análise",
                                "Vila Nova"
                        )
                );

                ScrollPane scrollPane = new ScrollPane(listaOcorrencias);

                scrollPane.setFitToWidth(true);
                scrollPane.setHbarPolicy(
                        ScrollPane.ScrollBarPolicy.NEVER
                );
                scrollPane.setVbarPolicy(
                        ScrollPane.ScrollBarPolicy.AS_NEEDED
                );

                scrollPane.getStyleClass().add("scroll-pane");

                VBox conteudo = new VBox(14);

                conteudo.setAlignment(Pos.TOP_CENTER);
                conteudo.getStyleClass().add("conteudo-principal");

                conteudo.getChildren().addAll(
                        titulo,
                        campoBuscaContainer,
                        scrollPane
                );

                BorderPane root = new BorderPane();

                root.setTop(topBar);
                root.setCenter(conteudo);

                root.getStyleClass().add("root");

                Scene scene = new Scene(root, 1207, 688);

                scene.getStylesheets().add(
                        getClass()
                                .getResource("/application/style.css")
                                .toExternalForm()
                );

                cadastro.setTitle("Consultar Ocorrências");
                cadastro.setScene(scene);

                cadastro.setMinWidth(900);
                cadastro.setMinHeight(600);

                cadastro.show();
            }
        };

        btCadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        btCadastrar2.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
                
        stage.show();
    }

    private Button criarBotao(String texto) {

        Button button = new Button(texto);

        button.getStyleClass().add("botao-menu");

        return button;
    }

    private VBox criarCard(
            String titulo,
            String data,
            String tipo,
            String status,
            String local
    ) {

        VBox card = new VBox(2);

        card.getStyleClass().add("card-ocorrencia");

        Label lblTitulo = new Label(titulo);
        lblTitulo.getStyleClass().add("card-titulo");

        Label lblData = criarLabel("Data: " + data);
        Label lblTipo = criarLabel("Tipo: " + tipo);
        Label lblStatus = criarLabel("Status: " + status);
        Label lblLocal = criarLabel("Local: " + local);

        card.getChildren().addAll(
                lblTitulo,
                lblData,
                lblTipo,
                lblStatus,
                lblLocal
        );

        return card;
    }

    private Label criarLabel(String texto) {

        Label label = new Label(texto);

        label.getStyleClass().add("card-label");

        return label;
    }

    public static void main(String[] args) {
        launch();
    }
}
