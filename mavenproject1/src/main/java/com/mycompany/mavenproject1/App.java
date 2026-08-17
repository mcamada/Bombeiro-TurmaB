package com.mycompany.mavenproject1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class App extends Application {

    Stage janela;

    @Override
    public void start(Stage primaryStage) {

        janela = primaryStage;

        mostrarInicio();

        janela.setTitle("Corpo de Bombeiros");
        janela.show();
    }

    private void mostrarInicio() {

        VBox root = new VBox();

        root.setStyle("-fx-background-color: #f4f5f7;"
        );
        HBox header = createHeader();

        VBox content = new VBox(30);
        content.setPadding(new Insets(30));

        HBox statsRow = new HBox(20);

        statsRow.getChildren().addAll(
                createStatCard("Chamadas Ativas","2", "🔥"
                ),
                createStatCard("Equipes Disponíveis","67", "👥"
                ),
                createStatCard("Viaturas em uso","3", "🚚"
                ),
                createStatCard("Emergências hoje","8", "⚠️"
                )
        );

        VBox emergenciesList = new VBox(15);

        emergenciesList.getChildren().addAll(
                createEmergencyCard("#1334-987","🔥 Incêndio Residencial","Avenida principal R.15","Há 1 minuto","Ativa","#dc3545"
                ),
                createEmergencyCard("#1238-147","🔥 Resgate de Pessoas","Rua 15, 607","Há 19 minutos","Ativa","#dc3545"
                ),
                createEmergencyCard("#6767-244","🔥 Afogamento de Cachorro","Rua 25, 3190","Há 30 minutos","Em Atendimento","#fd7e14"
                ),
                createEmergencyCard("#0703-010","🔥 Resgate em Altura","Banco Central","Há 4 horas","Em Atendimento","#fd7e14"
                )
        );

        content.getChildren().addAll(statsRow,emergenciesList
        );

        root.getChildren().addAll(header,content
        );

        Scene scene = new Scene(root,1860,1000
        );
        janela.setScene(scene);
    }

    private void mostrarOcorrencia(String nomeOcorrencia) {

        VBox root = new VBox();

        root.setStyle("-fx-background-color: #f4f5f7;"
        );

        HBox header = createHeader();

        VBox content = new VBox(20);

        content.setPadding(
                new Insets(25)
        );

        Button voltar = new Button("← Voltar");

        voltar.setOnAction(e -> {
            mostrarInicio();
        });

        Label titulo = new Label(nomeOcorrencia.replace("🔥 ", "").toUpperCase()
        );

        titulo.setFont(
                Font.font("System",FontWeight.BOLD,32
                )
        );
        titulo.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 3, 3);"
        );

        HBox tituloBox = new HBox(titulo);

        tituloBox.setAlignment(
                Pos.CENTER
        );

        VBox bombeiros = new VBox(15);
        bombeiros.getChildren().addAll(
                createBombeiroCard("#JOAOSANTOS","🔥 João Santos","Cabo","Chegou há 1 minuto","No local","#ff0000"
                ),
                createBombeiroCard("#PEDROALBERTO","🔥 Pedro Alberto","Sargento","Chegou há 6 minutos","No local","#ff0000"
                ),
                createBombeiroCard("#HENRIQUEDEFERRAZ","🔥 Henrique De Ferraz","Cabo","Chega em aproximadamente 8 minutos","Indo ao local","#a85500"
                ),
                createBombeiroCard("#CARLOSEDUARDO","🔥 Carlos Eduardo","Sub tenente","Chega em aproximadamente 45 minutos","Indo ao local","#a85500"
                )
        );
        // BOTÃO DE CADASTRO
        // ainda n faz nada , deixar pra próxima aula , mas ja ta estilizado
        Button cadastrar = new Button(
                "+ Cadastrar Bombeiro"
        );

        cadastrar.setStyle("-fx-background-color: #d31111;"+ "-fx-text-fill: white;"+ "-fx-font-weight: bold;"+ "-fx-padding: 10 20;"
        );
        content.getChildren().addAll(voltar,tituloBox,bombeiros,cadastrar
        );
        root.getChildren().addAll(header,content
        );
        Scene scene = new Scene(root,1860,1000
        );
        janela.setScene(scene);
    }
    private HBox createHeader() {

        HBox header = new HBox(15);

        header.setStyle("-fx-background-color: #d31111;"+ "-fx-padding: 20 30;"
        );

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        Label logo = new Label("🔥");

        logo.setFont(
                Font.font(
                        "System",
                        40
                )
        );

        VBox titleBox = new VBox();

        Label title = new Label(
                "Corpo de bombeiros"
        );

        title.setTextFill(
                Color.WHITE
        );

        title.setFont(
                Font.font("System",FontWeight.BOLD,28
                )
        );

        Label subtitle = new Label("Sistema de gestão de emergências"
        );

        subtitle.setTextFill(Color.WHITE
        );

        subtitle.setFont(Font.font("System",16
                )
        );

        titleBox.getChildren().addAll(title,subtitle
        );

        header.getChildren().addAll(logo,titleBox
        );

        return header;
    }
    private VBox createStatCard(String tituloTexto,String valorTexto,String iconeTexto) {

        VBox card = new VBox(10);

        card.setStyle("-fx-background-color: white;"+ "-fx-background-radius: 8;"+ "-fx-padding: 15;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);"
        );

        Label titulo = new Label(
                tituloTexto
        );
        titulo.setTextFill(
                Color.web("#555555")
        );
        Label valor = new Label(
                valorTexto
        );
        valor.setFont(
                Font.font("System",FontWeight.BOLD,36
                )
        );

        Label icone = new Label(iconeTexto
        );

        icone.setFont(
                Font.font("System",24
                )
        );

        Region espaco = new Region();

        HBox.setHgrow(espaco,Priority.ALWAYS
        );

        HBox linha = new HBox();

        linha.setAlignment(
                Pos.CENTER_LEFT
        );

        linha.getChildren().addAll(valor,espaco,icone
        );

        card.getChildren().addAll(titulo,linha
        );
        return card;
    }
    private VBox createEmergencyCard(String idTexto,String tituloTexto,String enderecoTexto,String tempoTexto,String statusTexto,String statusCor) {
        VBox card = new VBox(5);

        card.setStyle("-fx-background-color: white;"+ "-fx-background-radius: 8;"+ "-fx-padding: 15 20;"+ "-fx-cursor: hand;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 2);"
        );

        Label id = new Label( idTexto
        );
        id.setTextFill(Color.web("#777777")
        );
        Label titulo = new Label(tituloTexto
        );
        titulo.setFont(
                Font.font("System",FontWeight.BOLD,18
                )
        );

        Label endereco = new Label(enderecoTexto
        );

        Label tempo = new Label(tempoTexto
        );

        tempo.setTextFill(Color.GRAY
        );

        Label status = new Label(statusTexto
        );

        status.setTextFill(Color.WHITE
        );

        status.setStyle("-fx-background-color: " + statusCor + ";"+ "-fx-padding: 5 12;"+ "-fx-background-radius: 10;"
        );

        BorderPane linhaTitulo = new BorderPane();

        linhaTitulo.setLeft(titulo
        );

        linhaTitulo.setRight(status
        );

        card.getChildren().addAll(id,linhaTitulo,endereco,tempo
        );

        card.setOnMouseClicked(e -> {
            mostrarOcorrencia(tituloTexto
            );
        });

        return card;
    }

    private VBox createBombeiroCard(String usuarioTexto,String nomeTexto,String patenteTexto,String tempoTexto,String statusTexto,String statusCor) {

        VBox card = new VBox();

        card.setStyle("-fx-background-color: white;"+ "-fx-background-radius: 8;"+ "-fx-padding: 12 15;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 2);"
        );

        Label usuario = new Label(usuarioTexto
        );

        usuario.setFont(
                Font.font("System",11
                )
        );
        Label nome = new Label(nomeTexto
        );
        nome.setFont(
                Font.font("System",FontWeight.BOLD,16
                )
        );

        Label patente = new Label(patenteTexto
        );

        Label tempo = new Label(tempoTexto
        );

        tempo.setTextFill(Color.GRAY
        );

        Label status = new Label(statusTexto
        );

        status.setTextFill(Color.WHITE
        );

        status.setStyle("-fx-background-color: " + statusCor + ";"+ "-fx-padding: 5 15;"+ "-fx-background-radius: 10;"
        );

        VBox dados = new VBox(3, usuario, nome, patente, tempo);

        BorderPane linha = new BorderPane();

        linha.setLeft(dados);

        linha.setRight(status);

        BorderPane.setAlignment(status, Pos.CENTER
        );

        card.getChildren().add(
                linha
        );

        return card;
    }
    public static void main(String[] args) {
        launch(args);
    }
}