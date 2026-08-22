package br.edu.ifc.treinoecapacitacao.view;

import br.edu.ifc.treinoecapacitacao.App;
import br.edu.ifc.treinoecapacitacao.model.Treinamento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public TelaDashboard(Stage stage) { this.stage = stage; }

    public Scene criarCena() {
        Label tituloSistema = new Label("Treinamento e Capacitação");
        tituloSistema.setId("tituloDashboard");
        String usuario = App.usuarioLogado == null ? "Usuário" : App.usuarioLogado.getLogin() + " - " + App.usuarioLogado.getPerfil();
        Label usuarioLogado = new Label("Usuário: " + usuario);
        usuarioLogado.getStyleClass().add("texto-secundario");
        VBox textos = new VBox(5); textos.getChildren().addAll(tituloSistema, usuarioLogado);

        Button botaoSair = new Button("Sair");
        botaoSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                App.usuarioLogado = null;
                stage.setScene(new TelaLogin(stage).criarCena());
                stage.setTitle("Treinamento e Capacitação");
            }
        });
        HBox cabecalho = new HBox(30); cabecalho.setAlignment(Pos.CENTER_LEFT);
        cabecalho.setPadding(new Insets(15)); cabecalho.getStyleClass().add("cabecalho");
        cabecalho.getChildren().addAll(textos, botaoSair);

        VBox menu = new VBox(10); menu.setPadding(new Insets(15)); menu.getStyleClass().add("menu-lateral");
        Label tituloMenu = new Label("Menu"); tituloMenu.getStyleClass().add("titulo-secao");
        Button inicio = botaoMenu("Início");
        Button treinamentos = botaoMenu("Treinamentos");
        Button bombeiros = botaoMenu("Bombeiros");
        Button instrutores = botaoMenu("Instrutores");
        Button instituicoes = botaoMenu("Instituições");
        Button participacoes = botaoMenu("Participações");
        Button certificados = botaoMenu("Certificados");
        Button historico = botaoMenu("Histórico");
        menu.getChildren().addAll(tituloMenu, inicio, treinamentos, bombeiros, instrutores,
                instituicoes, participacoes, certificados, historico);

        treinamentos.setOnAction(e -> abrir(new TelaTreinamentos(stage).criarCena(), "Treinamentos"));
        bombeiros.setOnAction(e -> abrir(new TelaBombeiros(stage).criarCena(), "Bombeiros"));
        instrutores.setOnAction(e -> abrir(new TelaInstrutores(stage).criarCena(), "Instrutores"));
        instituicoes.setOnAction(e -> abrir(new TelaInstituicoes(stage).criarCena(), "Instituições"));
        participacoes.setOnAction(e -> abrir(new TelaParticipacoes(stage).criarCena(), "Participações"));
        certificados.setOnAction(e -> abrir(new TelaCertificados(stage).criarCena(), "Certificados"));
        historico.setOnAction(e -> abrir(new TelaHistorico(stage).criarCena(), "Histórico"));

        Label tituloResumo = new Label("Visão geral dos treinamentos"); tituloResumo.getStyleClass().add("titulo-secao");
        int planejados=0, andamento=0, concluidos=0;
        for (Treinamento t : App.treinamentos) {
            if (t.isAtivo() && t.getStatus().equals("Planejado")) planejados++;
            if (t.isAtivo() && t.getStatus().equals("Em andamento")) andamento++;
            if (t.isAtivo() && t.getStatus().equals("Concluído")) concluidos++;
        }
        GridPane resumo = new GridPane(); resumo.setHgap(15); resumo.setVgap(15);
        resumo.add(criarCard("Planejados", String.valueOf(planejados)), 0, 0);
        resumo.add(criarCard("Em andamento", String.valueOf(andamento)), 1, 0);
        resumo.add(criarCard("Concluídos", String.valueOf(concluidos)), 0, 1);
        resumo.add(criarCard("Participações", String.valueOf(App.participacoes.size())), 1, 1);

        Label tituloAtalhos = new Label("Acessos rápidos"); tituloAtalhos.getStyleClass().add("titulo-secao");
        Button cadastrarTreinamento = new Button("Cadastrar treinamento"); cadastrarTreinamento.getStyleClass().add("botao-atalho");
        Button consultar = new Button("Consultar treinamentos"); consultar.getStyleClass().add("botao-atalho");
        Button cadastrarBombeiro = new Button("Bombeiros"); cadastrarBombeiro.getStyleClass().add("botao-atalho");
        cadastrarTreinamento.setOnAction(e -> abrir(new TelaCadastroTreinamento(stage).criarCena(), "Cadastrar Treinamento"));
        consultar.setOnAction(e -> abrir(new TelaConsultaTreinamentos(stage).criarCena(), "Consultar Treinamentos"));
        cadastrarBombeiro.setOnAction(e -> abrir(new TelaBombeiros(stage).criarCena(), "Bombeiros"));
        HBox atalhos = new HBox(10, cadastrarTreinamento, consultar, cadastrarBombeiro);

        Label recentes = new Label("Treinamentos recentes"); recentes.getStyleClass().add("titulo-secao");
        ListView<Treinamento> lista = new ListView<Treinamento>(App.treinamentos); lista.setPrefHeight(130); lista.getStyleClass().add("lista-treinamentos");
        VBox conteudo = new VBox(15, tituloResumo, resumo, tituloAtalhos, atalhos, recentes, lista); conteudo.setPadding(new Insets(20));
        HBox corpo = new HBox(20, menu, conteudo);
        VBox raiz = new VBox(cabecalho, corpo);
        Scene scene = new Scene(raiz, 950, 620); scene.getStylesheets().add("/css/style.css");
        return scene;
    }

    private Button botaoMenu(String texto) { Button b = new Button(texto); b.getStyleClass().add("botao-menu"); return b; }
    private void abrir(Scene scene, String titulo) { stage.setScene(scene); stage.setTitle(titulo); }
    private VBox criarCard(String nome, String quantidade) {
        Label numero = new Label(quantidade); numero.getStyleClass().add("numero-card");
        VBox card = new VBox(5, numero, new Label(nome)); card.setAlignment(Pos.CENTER); card.setPadding(new Insets(20)); card.getStyleClass().add("card"); return card;
    }
}
