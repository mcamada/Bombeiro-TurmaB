package com.mycompany.gerenciadeviatura;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        Font fInput = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20);
        Font fcampos = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20);

        root.getStyleClass().add("root");

        BorderPane campos = new BorderPane();
        Label gest = new Label("GESTÃO DE VIATURA");
        gest.setFont(fcampos);
        gest.setTextFill(Color.WHITE);
        campos.setLeft(gest);
        Label usuario = new Label("Usuário");
        usuario.setFont(fcampos);
        usuario.setTextFill(Color.WHITE);
        campos.setRight(usuario);

        VBox botoes = new VBox();

        root.getChildren().add(campos);

        Button btCadastrar = new Button("Cadastrar Viatura");
        Button btConsultar = new Button("Consultar Viatura");

        botoes.getChildren().add(btCadastrar);
        botoes.getChildren().add(btConsultar);

        botoes.setAlignment(Pos.CENTER);

        root.getChildren().add(botoes);

        EventHandler<MouseEvent> cadastrAr = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Stage tCadas = new Stage();
                GridPane boot = new GridPane();

                TextField identificacaoText = new TextField();
                TextField tipoText = new TextField();
                TextField placaText = new TextField();
                TextField anodefabricacaoText = new TextField();
                TextField modeloText = new TextField();
                TextField statusInicialText = new TextField();

                Label tVC = new Label("Cadastrar Viatura");

                Label identificacaoLabel = new Label("Identificação");
                identificacaoLabel.setTextFill(Color.WHITE);

                Label tipoLabel = new Label("Tipo");
                tipoLabel.setTextFill(Color.WHITE);

                Label placaLabel = new Label("Placa");
                placaLabel.setTextFill(Color.WHITE);

                Label anodefabricacaoLabel = new Label("Ano de Fabricação");
                anodefabricacaoLabel.setTextFill(Color.WHITE);

                Label modeloLabel = new Label("Modelo");
                modeloLabel.setTextFill(Color.WHITE);

                Label statusInicialLabel = new Label("Status Iniciais");
                statusInicialLabel.setTextFill(Color.WHITE);

                boot.add(identificacaoLabel, 0, 0);
                boot.add(identificacaoText, 0, 1);

                boot.add(tipoLabel, 3, 0);
                boot.add(tipoText, 3, 1);

                boot.add(placaLabel, 5, 0);
                boot.add(placaText, 5, 1);

                boot.add(anodefabricacaoLabel, 0, 4);
                boot.add(anodefabricacaoText, 0, 7);

                boot.add(modeloLabel, 3, 4);
                boot.add(modeloText, 3, 7);

                boot.add(statusInicialLabel, 5, 4);
                boot.add(statusInicialText, 5, 7);

                VBox botos = new VBox();

                Button ctConfirmar = new Button("Confirmar");
                Button ctCancelar = new Button("Cancelar");

                botos.getChildren().addAll(ctConfirmar, ctCancelar);

                boot.add(botos, 0, 8, 6, 1);

                EventHandler<MouseEvent> cCancelar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Alert aviso = new Alert(Alert.AlertType.INFORMATION);
                        aviso.setHeaderText("Cancelado com sucesso");
                        aviso.show();

                        tCadas.close();

                    }

                };
                
                EventHandler<MouseEvent> cConfirmar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        tCadas.close();
                        Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
                        aviso.setHeaderText("Viatura atribuida com sucesso");
                        aviso.show();

                    }

                };

                ctCancelar.setOnMouseClicked(cCancelar);
                ctConfirmar.setOnMouseClicked(cConfirmar);

                Scene scene = new Scene(boot, 800, 600);
                tCadas.setScene(scene);
                scene.getStylesheets().add("/css/style.css");
                tCadas.setTitle("Sistema de teste do JavaFX");
                tCadas.show();

            }
        };

        btCadastrar.setOnMouseClicked(cadastrAr);

        EventHandler<MouseEvent> consultarViatura;
        consultarViatura = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Stage tCadas = new Stage();
                GridPane goot = new GridPane();

                TextField disponibilidadeTextF = new TextField();
                TextField localizacaoTextF = new TextField();
                TextField tipoTextF = new TextField();
                TextField statusTextF = new TextField();

                Label tVC = new Label("Consultar Viatura");

                Label disponibilidadeLabel = new Label("Disponibilidade");
                disponibilidadeLabel.setTextFill(Color.WHITE);
                Label localizacaoLabel = new Label("Localização");
                localizacaoLabel.setTextFill(Color.WHITE);
                Label tipoLabel = new Label("Tipo");
                tipoLabel.setTextFill(Color.WHITE);
                Label statusLabel = new Label("Status");
                statusLabel.setTextFill(Color.WHITE);

                goot.add(disponibilidadeLabel, 0, 0);
                goot.add(disponibilidadeTextF, 0, 1);

                goot.add(localizacaoLabel, 0, 4);
                goot.add(localizacaoTextF, 0, 7);

                goot.add(tipoLabel, 0, 8);
                goot.add(tipoTextF, 0, 10);

                goot.add(statusLabel, 0, 12);
                goot.add(statusTextF, 0, 13);
                
                HBox botoees = new HBox();

                Button vtCancelar = new Button("Cancelar");
                Button vtPesquisar = new Button("Pesquisar");

                botoees.getChildren().addAll(vtCancelar, vtPesquisar);
                
                goot.add(botoees, 0, 16, 6, 1);
                
                Label viatura1 = new Label("Viatura 1");
                viatura1.setTextFill(Color.WHITE);
                
                viatura1.setFont(fcampos);
                
                Region r1 = new Region();
                r1.setMinHeight(25);
                
                Label viatura2 = new Label("Viatura 2");
                viatura2.setTextFill(Color.WHITE);
                viatura2.setFont(fcampos);
                
                Label viatura3 = new Label("Viatura 3");
                viatura3.setTextFill(Color.WHITE);
                
                
                Button ver1 = new Button("Ver");
                Button ver2 = new Button("Ver");
                Button ver3 = new Button("Ver");
                
                
                goot.add(viatura1, 0, 25);
                goot.add(r1, 0, 26);
                
                
                goot.add(viatura2, 0, 27);
                goot.add(viatura3, 0, 27);
                

                Scene scene = new Scene(goot, 800, 600);
                tCadas.setScene(scene);
                scene.getStylesheets().add("/css/style.css");
                tCadas.setTitle("Sistema de teste do JavaFX");
                tCadas.show();

                

                

                EventHandler<MouseEvent> cCancelar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        tCadas.close();
                        Alert aviso = new Alert(Alert.AlertType.INFORMATION);
                        aviso.setHeaderText("Cancelado com sucesso");
                        aviso.show();

                    }

                };
                vtCancelar.setOnMouseClicked(cCancelar);

            }
        };

        btConsultar.setOnMouseClicked(consultarViatura);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);

        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("Sistema de teste do JavaFX");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
