package com.cad.despacho;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuLateral {

    public VBox criar() {

        VBox raiz = new VBox();

        VBox marca = new VBox();
        Label titulo = new Label("SISTEMA CAD");
        Label subtitulo = new Label("CORPO DE BOMBEIROS");
        marca.getChildren().add(titulo);
        marca.getChildren().add(subtitulo);

        VBox listaNav = new VBox();

        Button itemNovaOcorrencia = new Button("Nova Ocorrencia");
        itemNovaOcorrencia.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent evento) {
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Nova Ocorrencia");
                novaJanela.setScene(new Scene(new TelaNovaOcorrencia().criar(), 900, 600));
                novaJanela.show();
            }
        });

        Button itemConsultar = new Button("Consultar Ocorrencias");
        itemConsultar.setOnAction(new EventHandler<ActionEvent>() {
         
            public void handle(ActionEvent evento) {
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Consultar Ocorrencias");
                novaJanela.setScene(new Scene(new TelaConsultarOcorrencias().criar(), 900, 600));
                novaJanela.show();
            }
        });

        Button itemComunicacao = new Button("Comunicacao");
        itemComunicacao.setOnAction(new EventHandler<ActionEvent>() {
          
            public void handle(ActionEvent evento) {
                Stage novaJanela = new Stage();
                novaJanela.setTitle("Comunicacao");
                novaJanela.setScene(new Scene(new TelaComunicacao().criar(), 900, 600));
                novaJanela.show();
            }
        });

        listaNav.getChildren().add(itemNovaOcorrencia);
        listaNav.getChildren().add(itemConsultar);
        listaNav.getChildren().add(itemComunicacao);

        raiz.getChildren().add(marca);
        raiz.getChildren().add(listaNav);

        return raiz;
    }
}
