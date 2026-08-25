package com.mycompany.mavenproject1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
//Tela de inicio
    private void mostrarInicio() {

        VBox root = new VBox();

        root.setStyle("-fx-background-color: #f4f5f7;"
        );
        HBox header = createHeader();

        VBox content = new VBox(30);
        content.setPadding(new Insets(30));

        HBox statsRow = new HBox(20);
        //quadradinho que mostra ocorrencia , viaturas ,equipes e tals
        statsRow.getChildren().addAll(
                createStatCard("Chamadas Ativas","2", "🔥"),
                createStatCard("Equipes Disponíveis","6", "👥"),
                createStatCard("Viaturas em uso","3", "🚒"),
                //nao sei pq o emoji de atenção e bugado 
                createStatCard("Emergências hoje","8", "⚠️")
        );

        VBox emergenciesList = new VBox(15);
        //card de emergencia feito pela funcao do emrgenci card (feito pra quando adicionar uma ocorrencia o inerir o texto e função criar automatico)
        emergenciesList.getChildren().addAll(
                createEmergencyCard("#1334-987","🔥 Incêndio Residencial","Avenida principal R.15","Há 1 minuto","Ativa","#dc3545"),
                createEmergencyCard("#1238-147","🔥 Resgate de Pessoas","Rua 15, 607","Há 19 minutos","Ativa","#dc3545"),
                createEmergencyCard("#6767-244","🔥 Afogamento de Cachorro","Rua 25, 3190","Há 30 minutos","Em Atendimento","#fd7e14"),
                createEmergencyCard("#0703-010","🔥 Resgate em Altura","Banco Central","Há 4 horas","Em Atendimento","#fd7e14")
        );

        content.getChildren().addAll(statsRow,emergenciesList);
        root.getChildren().addAll(header,content);

        Scene scene = new Scene(root,1860,1000);
        janela.setScene(scene);
    }
//Tela de quando clica na correncia
    private void mostrarOcorrencia(String nomeOcorrencia) {

        VBox root = new VBox();
        root.setStyle("-fx-background-color: #f4f5f7;");

        HBox header = createHeader();
        VBox content = new VBox(20);
        content.setPadding(new Insets(25));
        Button voltar = new Button("← Voltar");
        
        voltar.setStyle("-fx-background-color:#d31111;"+ "-fx-background-radius: 8;"+"-fx-font-size:25;"+"-fx-text-fill:white;" + "-fx-font-weigth:bold;");
//event do botao de voltar
        voltar.setOnAction(e -> {
            mostrarInicio();
        });

        Label titulo = new Label(nomeOcorrencia.replace("🔥 ", "").toUpperCase());

        titulo.setFont(
                Font.font("System",FontWeight.BOLD,32
                )
        );
        titulo.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 3, 3);"
        );

        HBox tituloBox = new HBox(titulo);

        tituloBox.setAlignment(Pos.CENTER);

        VBox bombeiros = new VBox(15);
        //mema coisa de cards mas esse nao sao clicaveis
        bombeiros.getChildren().addAll(
                createBombeiroCard("#JOAOSANTOS","🔥 João Santos","Cabo","Chegou há 1 minuto","No local","#ff0000"),
                createBombeiroCard("#PEDROALBERTO","🔥 Pedro Alberto","Sargento","Chegou há 6 minutos","No local","#ff0000"),
                createBombeiroCard("#HENRIQUEDEFERRAZ","🔥 Henrique De Ferraz","Cabo","Chega em aproximadamente 8 minutos","Indo ao local","#a85500"),
                createBombeiroCard("#CARLOSEDUARDO","🔥 Carlos Eduardo","Sub tenente","Chega em aproximadamente 45 minutos","Indo ao local","#a85500")
        );
        Button cadastrar = new Button(
                "+ Cadastrar Bombeiro"
        );
        cadastrar.setOnMouseClicked(e -> {
            mostrarCadastro(
            );
        });

        cadastrar.setStyle("-fx-background-color: #d31111;"+ "-fx-text-fill: white;"+ "-fx-font-weight: bold;"+ "-fx-padding: 10 20;");
        content.getChildren().addAll(voltar,tituloBox,bombeiros,cadastrar);
        root.getChildren().addAll(header,content);
        Scene scene = new Scene(root,1860,1000);
        janela.setScene(scene);
    }
//Tela do botao de cadastrar bombeiro 
    private void mostrarCadastro(){
        VBox root = new VBox();

        root.setStyle("-fx-background-color: #f4f5f7;");
        HBox header = createHeader();
        
          Button voltar = new Button("← Voltar");
        
        voltar.setStyle("-fx-background-color: #d31111;"+ "-fx-text-fill: white;"+ "-fx-font-weight: bold;"+ "-fx-padding: 10 30;"+"-fx-font-size:24px;"+"-fx-background-radius:16;");
        voltar.setOnAction(e -> {
            mostrarOcorrencia("Ocorrencia");
        });
        
        GridPane Formulario = new GridPane();
        Formulario.setAlignment(Pos.CENTER);
        Formulario.setVgap(15);
        Formulario.setHgap(10);
        
        //formulario do cadastro
        Label name = new Label("Nome:");
        Formulario.add(name, 0, 0);
        name.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 3, 3);"+"-fx-pref-width: 200px;"+"-fx-pref-height: 50px;"+"-fx-font-weight: bold;");
        TextArea TXname =  new TextArea();
        TXname.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+"-fx-pref-width: 200px;"+"-fx-pref-height: 50px;"+"-fx-border-width:2px;"+"-fx-border-color:grey;"+"-fx-border-radius:8"
        );
        Formulario.add(TXname, 1, 0);
        
        
        Label id = new Label("Identificação:");
        id.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 3, 3);"+"-fx-pref-width: 200px;"+"-fx-pref-height: 50px;"+"-fx-font-weight: bold;"
        );
        Formulario.add(id, 0, 1);
        TextArea TXid =  new TextArea();
        TXid.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+"-fx-pref-width: 200px;"+"-fx-pref-height: 50px;"+"-fx-border-width:2px;"+"-fx-border-color:grey;"+"-fx-border-radius:8"
        );
        Formulario.add(TXid, 1, 1);
        
        
        Label password = new Label("Senha:");
        password.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 3, 3);"+"-fx-pref-width: 200px;"+"-fx-pref-height: 50px;"+"-fx-font-weight: bold;"
        );
        Formulario.add(password, 0, 2);
        TextArea TXpassword =  new TextArea();
        TXpassword.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+"-fx-pref-width: 200px;"+"-fx-pref-height: 50px;"+"-fx-border-width:2px;"+"-fx-border-color:grey;"+"-fx-border-radius:8"
        );
        Formulario.add(TXpassword, 1, 2);
        
        
        Label patente = new Label("Patente:");
        patente.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 3, 3);"+"-fx-pref-width: 200px;"+"-fx-pref-height: 50px;"+"-fx-font-weight: bold;"
        );
        Formulario.add(patente, 0, 3);
        TextArea TXpatente =  new TextArea();
        TXpatente.setStyle("-fx-background-color: white;"+ "-fx-padding: 15 30;"+ "-fx-background-radius: 8;"+"-fx-pref-width: 200px;"+"-fx-pref-height: 50px;"+"-fx-border-width:2px;"+"-fx-border-color:grey;"+"-fx-border-radius:8"
        );
        Formulario.add(TXpatente, 1, 3);
 
        StackPane sla = new StackPane();
        
        Button cadastrar = new Button(
                "+ Cadastrar Bombeiro"
        );

        sla.getChildren().addAll(cadastrar);
        sla.setAlignment(Pos.CENTER);
        //verificação
        cadastrar.setOnMouseClicked(e -> {
            
            if (TXpatente.getText().trim().isEmpty()){
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Erro");
            alert.setContentText("patente vazia");
            alert.showAndWait();  
            }else if (TXpassword.getText().trim().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Erro");
            alert.setContentText("patente vazia");
            alert.showAndWait();  
            }else if (TXid.getText().trim().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Erro");
            alert.setContentText("identificação vazia");
            alert.showAndWait();  
            }else if (TXname.getText().trim().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText("Erro");
            alert.setContentText("nome vazio");
            alert.showAndWait();  
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("O " +TXname.getText().trim() +" foi cadastrado com sucesso");
            alert.setContentText("Pode sair da tela");
            alert.showAndWait();  
            }
            
                
        });

        cadastrar.setStyle("-fx-background-color: #d31111;"+ "-fx-text-fill: white;"+ "-fx-font-weight: bold;"+ "-fx-padding: 15 30;"+"-fx-background-radius:8;"+"-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 3, 3);");
        //espaçamento
        root.setSpacing(25); 
        
        VBox.setMargin(voltar, new Insets(0, 0, 0, 25)); 
        VBox.setMargin(Formulario, new Insets(10, 0, 20, 0));
        VBox.setMargin(sla, new Insets(8, 0, 85, 0));
        HBox sla2 = new HBox(15);
        sla2.setStyle("-fx-background-color: #d31111;"+ "-fx-padding: 75 30;");
        sla2.setAlignment(Pos.CENTER_LEFT);
        
        
        root.getChildren().addAll(header,voltar,Formulario,sla,sla2);
      
        Scene scene = new Scene(root,930,800);
        janela.setResizable(false);
        janela.setScene(scene);
        
        
    }
    //funcao que cria todos os cabeçalhos (pois sao iguais)
    private HBox createHeader() {

        HBox header = new HBox(15);

        header.setStyle("-fx-background-color: #d31111;"+ "-fx-padding: 20 30;");
        header.setAlignment(Pos.CENTER_LEFT);

        Label logo = new Label("🔥");
        logo.setFont(
                Font.font(
                        "System",
                        40
                )
        );

        VBox root = new VBox();

        Label title = new Label("Corpo de bombeiros");
        title.setTextFill(Color.WHITE);
        title.setFont(
                Font.font("System",FontWeight.BOLD,28
                )
        );

        Label subtitle = new Label("Sistema de gestão de emergências");
        subtitle.setTextFill(Color.WHITE);

        subtitle.setFont(Font.font("System",16
                )
        );
        root.getChildren().addAll(title,subtitle);
        header.getChildren().addAll(logo,root);

        return header;
    }
    //aquele card quadradinho que motra equipe e tals
    private VBox createStatCard(String tituloTexto,String valorTexto,String iconeTexto) {

        VBox card = new VBox(10);
        card.setStyle("-fx-background-color: white;"+ "-fx-background-radius: 8;"+ "-fx-padding: 15;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);"
        );

        Label titulo = new Label(tituloTexto);
        titulo.setTextFill(Color.web("#555555"));
        
        Label valor = new Label(valorTexto);
        valor.setFont(
                Font.font("System",FontWeight.BOLD,36
                )
        );

        Label icone = new Label(iconeTexto);
        icone.setFont(
                Font.font("System",24
                )
        );

        Region espaco = new Region();

        HBox.setHgrow(espaco,Priority.ALWAYS);

        HBox linha = new HBox();

        linha.setAlignment(Pos.CENTER_LEFT);

        linha.getChildren().addAll(valor,espaco,icone);
        card.getChildren().addAll(titulo,linha);
        return card;
    }
    //card de emergencia (mesma coisa do de bombeiro , so muda o nome de varivel e tem o evento de abrir a ocorrencia
    private VBox createEmergencyCard(String idTexto,String tituloTexto,String enderecoTexto,String tempoTexto,String statusTexto,String statusCor) {
        VBox card = new VBox(5);

        card.setStyle("-fx-background-color: white;"+ "-fx-background-radius: 8;"+ "-fx-padding: 15 20;"+ "-fx-cursor: hand;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 2);"
        );
        Label id = new Label( idTexto);
        id.setTextFill(Color.web("#777777"));
        Label titulo = new Label(tituloTexto);
        titulo.setFont(
                Font.font("System",FontWeight.BOLD,18
                )
        );

        Label endereco = new Label(enderecoTexto);

        Label tempo = new Label(tempoTexto);
        tempo.setTextFill(Color.GRAY);
        
        
        Label status = new Label(statusTexto);
        status.setTextFill(Color.WHITE);
        status.setStyle("-fx-background-color: " + statusCor + ";"+ "-fx-padding: 5 12;"+ "-fx-background-radius: 10;"
        );

        BorderPane linhaTitulo = new BorderPane();
        
        
        linhaTitulo.setLeft(titulo);
        linhaTitulo.setRight(status);

        card.getChildren().addAll(id,linhaTitulo,endereco,tempo);
//evento
        card.setOnMouseClicked(e -> {
            mostrarOcorrencia(tituloTexto
            );
        });

        return card;
    }
//card de bombeiro (mesma coisa da emergencia, so muda o nome de varivel e tem nao o evento de click)
    private VBox createBombeiroCard(String usuarioTexto,String nomeTexto,String patenteTexto,String tempoTexto,String statusTexto,String statusCor) {

        VBox card = new VBox();

        card.setStyle("-fx-background-color: white;"+ "-fx-background-radius: 8;"+ "-fx-padding: 12 15;"+ "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 5, 0, 0, 2);"
        );

        Label usuario = new Label(usuarioTexto);
        usuario.setFont(
                Font.font("System",11
                )
        );
        Label nome = new Label(nomeTexto);
        nome.setFont(
                Font.font("System",FontWeight.BOLD,16
                )
        );

        Label patente = new Label(patenteTexto);
        Label tempo = new Label(tempoTexto);
        tempo.setTextFill(Color.GRAY);

        Label status = new Label(statusTexto);
        
        status.setTextFill(Color.WHITE);
        status.setStyle("-fx-background-color: " + statusCor + ";"+ "-fx-padding: 5 15;"+ "-fx-background-radius: 10;"
        );

        VBox dados = new VBox(3, usuario, nome, patente, tempo);
        BorderPane linha = new BorderPane();

        linha.setLeft(dados);
        linha.setRight(status);
        
        BorderPane.setAlignment(status, Pos.CENTER);
        card.getChildren().add(linha);

        return card;
    }
    public static void main(String[] args) {
        launch(args);
    }
}