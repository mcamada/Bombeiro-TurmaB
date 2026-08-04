package br.edu.ifc.treinoecapacitacao.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaDashboard {

    private Stage stage;

    public TelaDashboard(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        Label tituloSistema = new Label("Treinamento e Capacitação");
        Label usuarioLogado = new Label("Usuário: Coordenador de Treinamento");

        VBox textosCabecalho = new VBox(5);
        textosCabecalho.getChildren().addAll(tituloSistema, usuarioLogado);

        Button botaoSair = new Button("Sair");

        HBox cabecalho = new HBox(30);
        cabecalho.setAlignment(Pos.CENTER_LEFT);
        cabecalho.setPadding(new Insets(15));
        cabecalho.getChildren().addAll(textosCabecalho, botaoSair);

        Label tituloMenu = new Label("Menu");
        Button botaoInicio = new Button("Início");
        Button botaoTreinamentos = new Button("Treinamentos");
        Button botaoBombeiros = new Button("Bombeiros");
        Button botaoInstrutores = new Button("Instrutores");
        Button botaoInstituicoes = new Button("Instituições");
        Button botaoParticipacoes = new Button("Participações");
        Button botaoCertificados = new Button("Certificados");

        VBox menuLateral = new VBox(10);
        menuLateral.setPadding(new Insets(15));
        menuLateral.getChildren().addAll(
                tituloMenu,
                botaoInicio,
                botaoTreinamentos,
                botaoBombeiros,
                botaoInstrutores,
                botaoInstituicoes,
                botaoParticipacoes,
                botaoCertificados
        );

        Label tituloResumo = new Label("Visão geral dos treinamentos");

        VBox cardPlanejados = criarCard("Planejados", "0");
        VBox cardAndamento = criarCard("Em andamento", "0");
        VBox cardConcluidos = criarCard("Concluídos", "0");
        VBox cardParticipantes = criarCard("Participantes", "0");

        GridPane resumo = new GridPane();
        resumo.setHgap(15);
        resumo.setVgap(15);
        resumo.add(cardPlanejados, 0, 0);
        resumo.add(cardAndamento, 1, 0);
        resumo.add(cardConcluidos, 0, 1);
        resumo.add(cardParticipantes, 1, 1);

        Label tituloAtalhos = new Label("Acessos rápidos");
        Button botaoCadastrarTreinamento = new Button("Cadastrar treinamento");
        Button botaoConsultarTreinamento = new Button("Consultar treinamentos");
        Button botaoCadastrarBombeiro = new Button("Cadastrar bombeiro");

        HBox atalhos = new HBox(10);
        atalhos.getChildren().addAll(
                botaoCadastrarTreinamento,
                botaoConsultarTreinamento,
                botaoCadastrarBombeiro
        );

        Label tituloRecentes = new Label("Treinamentos recentes");
        ObservableList<String> treinamentos = FXCollections.observableArrayList(
                "Nenhum treinamento cadastrado"
        );
        ListView<String> listaTreinamentos = new ListView<String>(treinamentos);
        listaTreinamentos.setPrefHeight(130);

        VBox conteudo = new VBox(15);
        conteudo.setPadding(new Insets(20));
        conteudo.getChildren().addAll(
                tituloResumo,
                resumo,
                tituloAtalhos,
                atalhos,
                tituloRecentes,
                listaTreinamentos
        );

        HBox corpo = new HBox(20);
        corpo.getChildren().addAll(menuLateral, conteudo);

        VBox raiz = new VBox();
        raiz.getChildren().addAll(cabecalho, corpo);

        return new Scene(raiz, 950, 620);
    }

    private VBox criarCard(String nome, String quantidade) {
        Label numero = new Label(quantidade);
        Label descricao = new Label(nome);

        VBox card = new VBox(5);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(20));
        card.getChildren().addAll(numero, descricao);

        return card;
    }
}
