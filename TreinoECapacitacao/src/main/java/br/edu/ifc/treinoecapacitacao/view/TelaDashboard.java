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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaDashboard {

    private Stage stage;

    public TelaDashboard(Stage stage) {
        this.stage = stage;
    }

    public Scene criarCena() {
        VBox menu = criarMenu();
        HBox cabecalho = criarCabecalho();
        VBox conteudo = criarConteudo();

        VBox areaPrincipal = new VBox();
        areaPrincipal.getStyleClass().add("area-principal");
        areaPrincipal.getChildren().addAll(cabecalho, conteudo);
        HBox.setHgrow(areaPrincipal, Priority.ALWAYS);

        HBox raiz = new HBox();
        raiz.getStyleClass().add("dashboard-raiz");
        raiz.getChildren().addAll(menu, areaPrincipal);

        Scene scene = new Scene(raiz, 1180, 720);
        scene.getStylesheets().add("/css/style.css");

        return scene;
    }

    private VBox criarMenu() {
        Label marca = new Label("TREINAMENTO");
        marca.getStyleClass().add("marca-menu");

        Label marcaMenor = new Label("& CAPACITAÇÃO");
        marcaMenor.getStyleClass().add("marca-menu-menor");

        VBox marcaSistema = new VBox(1);
        marcaSistema.getChildren().addAll(marca, marcaMenor);

        Button inicio = botaoMenu("Início");
        inicio.getStyleClass().add("botao-menu-ativo");

        Button treinamentos = botaoMenu("Treinamentos");
        Button bombeiros = botaoMenu("Bombeiros");
        Button instrutores = botaoMenu("Instrutores");
        Button instituicoes = botaoMenu("Instituições");
        Button participacoes = botaoMenu("Participações");
        Button certificados = botaoMenu("Certificados");
        Button historico = botaoMenu("Histórico");

        VBox menu = new VBox(7);
        menu.getStyleClass().add("menu-lateral");
        menu.setPadding(new Insets(28, 14, 20, 14));
        menu.getChildren().addAll(
                marcaSistema,
                criarEspaco(24),
                inicio,
                treinamentos,
                bombeiros,
                instrutores,
                instituicoes,
                participacoes,
                certificados,
                historico
        );

        treinamentos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaTreinamentos(stage).criarCena(),
                        "Treinamentos"
                );
            }
        });

        bombeiros.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaBombeiros(stage).criarCena(),
                        "Bombeiros"
                );
            }
        });

        instrutores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaInstrutores(stage).criarCena(),
                        "Instrutores"
                );
            }
        });

        instituicoes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaInstituicoes(stage).criarCena(),
                        "Instituições"
                );
            }
        });

        participacoes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaParticipacoes(stage).criarCena(),
                        "Participações"
                );
            }
        });

        certificados.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaCertificados(stage).criarCena(),
                        "Certificados"
                );
            }
        });

        historico.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaHistorico(stage).criarCena(),
                        "Histórico"
                );
            }
        });

        return menu;
    }

    private HBox criarCabecalho() {
        Label tituloSistema = new Label("Visão geral");
        tituloSistema.setId("tituloDashboard");

        Label subtitulo = new Label("Acompanhe os treinamentos e capacitações cadastrados.");
        subtitulo.getStyleClass().add("texto-secundario");

        VBox textos = new VBox(2);
        textos.getChildren().addAll(tituloSistema, subtitulo);

        String nomeUsuario = "Usuário";

        if (App.usuarioLogado != null) {
            nomeUsuario = App.usuarioLogado.getLogin();
            nomeUsuario = nomeUsuario + " - " + App.usuarioLogado.getPerfil();
        }

        Label usuarioLogado = new Label(nomeUsuario);
        usuarioLogado.getStyleClass().add("usuario-cabecalho");

        Button botaoSair = new Button("Sair");

        Region espaco = new Region();
        HBox.setHgrow(espaco, Priority.ALWAYS);

        HBox cabecalho = new HBox(12);
        cabecalho.getStyleClass().add("cabecalho");
        cabecalho.setAlignment(Pos.CENTER_LEFT);
        cabecalho.setPadding(new Insets(20, 24, 18, 24));
        cabecalho.getChildren().addAll(
                textos,
                espaco,
                usuarioLogado,
                botaoSair
        );

        botaoSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                App.usuarioLogado = null;

                TelaLogin telaLogin = new TelaLogin(stage);

                stage.setScene(telaLogin.criarCena());
                stage.setTitle("Treinamento e Capacitação");
            }
        });

        return cabecalho;
    }

    private VBox criarConteudo() {
        Label tituloResumo = new Label("Visão geral dos treinamentos");
        tituloResumo.getStyleClass().add("titulo-secao");

        int planejados = 0;
        int andamento = 0;
        int concluidos = 0;

        for (Treinamento treinamento : App.treinamentos) {
            if (treinamento.isAtivo()) {
                if (treinamento.getStatus().equals("Planejado")) {
                    planejados++;
                }

                if (treinamento.getStatus().equals("Em andamento")) {
                    andamento++;
                }

                if (treinamento.getStatus().equals("Concluído")) {
                    concluidos++;
                }
            }
        }

        VBox cardPlanejados = criarCard(
                "Planejados",
                String.valueOf(planejados),
                "card-vermelho"
        );

        VBox cardAndamento = criarCard(
                "Em andamento",
                String.valueOf(andamento),
                "card-amarelo"
        );

        VBox cardConcluidos = criarCard(
                "Concluídos",
                String.valueOf(concluidos),
                "card-verde"
        );

        VBox cardParticipacoes = criarCard(
                "Participações",
                String.valueOf(App.participacoes.size()),
                "card-azul"
        );

        HBox resumo = new HBox(14);
        resumo.getChildren().addAll(
                cardPlanejados,
                cardAndamento,
                cardConcluidos,
                cardParticipacoes
        );

        Label tituloAtalhos = new Label("Acessos rápidos");
        tituloAtalhos.getStyleClass().add("titulo-secao");

        Button cadastrarTreinamento = new Button("Cadastrar treinamento");
        cadastrarTreinamento.getStyleClass().add("botao-principal");

        Button consultarTreinamentos = new Button("Consultar treinamentos");
        consultarTreinamentos.getStyleClass().add("botao-secundario");

        Button abrirBombeiros = new Button("Bombeiros");
        abrirBombeiros.getStyleClass().add("botao-secundario");

        HBox atalhos = new HBox(10);
        atalhos.getChildren().addAll(
                cadastrarTreinamento,
                consultarTreinamentos,
                abrirBombeiros
        );

        Label tituloRecentes = new Label("Treinamentos recentes");
        tituloRecentes.getStyleClass().add("titulo-secao");

        ListView<Treinamento> listaTreinamentos = new ListView<Treinamento>(App.treinamentos);
        listaTreinamentos.setPrefHeight(230);
        listaTreinamentos.getStyleClass().add("lista-treinamentos");

        VBox painelRecentes = new VBox(12);
        painelRecentes.getStyleClass().add("painel");
        painelRecentes.getChildren().addAll(
                tituloRecentes,
                listaTreinamentos
        );

        VBox conteudo = new VBox(14);
        conteudo.getStyleClass().add("conteudo-dashboard");
        conteudo.setPadding(new Insets(22, 24, 24, 24));
        conteudo.getChildren().addAll(
                tituloResumo,
                resumo,
                tituloAtalhos,
                atalhos,
                painelRecentes
        );

        cadastrarTreinamento.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaCadastroTreinamento(stage).criarCena(),
                        "Cadastrar Treinamento"
                );
            }
        });

        consultarTreinamentos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaConsultaTreinamentos(stage).criarCena(),
                        "Consultar Treinamentos"
                );
            }
        });

        abrirBombeiros.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                abrirTela(
                        new TelaBombeiros(stage).criarCena(),
                        "Bombeiros"
                );
            }
        });

        return conteudo;
    }

    private Button botaoMenu(String texto) {
        Button botao = new Button(texto);
        botao.getStyleClass().add("botao-menu");

        return botao;
    }

    private VBox criarCard(String nome, String quantidade, String classeCor) {
        Label descricao = new Label(nome);
        descricao.getStyleClass().add("descricao-card");

        Label numero = new Label(quantidade);
        numero.getStyleClass().add("numero-card");

        VBox card = new VBox(4);
        card.getStyleClass().add("card");
        card.getStyleClass().add(classeCor);
        card.setPadding(new Insets(16));
        card.getChildren().addAll(descricao, numero);

        return card;
    }

    private Region criarEspaco(double altura) {
        Region espaco = new Region();
        espaco.setPrefHeight(altura);

        return espaco;
    }

    private void abrirTela(Scene scene, String titulo) {
        stage.setScene(scene);
        stage.setTitle(titulo);
    }
}
