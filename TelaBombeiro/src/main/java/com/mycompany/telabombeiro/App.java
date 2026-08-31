package com.mycompany.telabombeiro;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Font fonteTitulo = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
        Font fonteCampos = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 18);
        Font fonteEntrada = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16);

        Label titulo = new Label("Login");
        titulo.setId("titulo");
        titulo.setFont(fonteTitulo);

        Label usuario = new Label("Nome de Guerra:");
        usuario.setId("usuario");
        usuario.setFont(fonteCampos);

        Label senha = new Label("Senha:");
        senha.setId("senha");
        senha.setFont(fonteCampos);

        TextField campoUsuario = new TextField();
        campoUsuario.setId("campoUsuario");
        campoUsuario.setFont(fonteEntrada);
        campoUsuario.setPromptText("Digite seu nome de guerra");
        campoUsuario.setPrefWidth(280);

        PasswordField campoSenha = new PasswordField();
        campoSenha.setId("campoSenha");
        campoSenha.setFont(fonteEntrada);
        campoSenha.setPromptText("Digite sua senha");
        campoSenha.setPrefWidth(280);

        GridPane campos = new GridPane();
        campos.setAlignment(Pos.CENTER);
        campos.setHgap(12);
        campos.setVgap(15);

        campos.add(usuario, 0, 0);
        campos.add(campoUsuario, 1, 0);

        campos.add(senha, 0, 1);
        campos.add(campoSenha, 1, 1);

        VBox root = new VBox();
        root.getStyleClass().add("root");
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(25);

        root.getChildren().add(titulo);
        root.getChildren().add(campos);

        Button botaoEntrar = new Button("Entrar");
        root.getChildren().add(botaoEntrar);
        botaoEntrar.setId("botaoEntrar");

        Button novoUsuario = new Button("Novo Usuário");
        root.getChildren().add(novoUsuario);
        novoUsuario.setId("botaoEntrar");

        HBox painelBt = new HBox();
        painelBt.setAlignment(Pos.CENTER);
        painelBt.getChildren().addAll(botaoEntrar, novoUsuario);

        root.getChildren().add(painelBt);

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("Sistema de Teste do JavaFX");
        stage.setScene(scene);

        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                stage.close();

                Stage ocorrencias = new Stage();

                Font fonteTituloTelaOcorrencias = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);

                VBox rootTelaOcorrencias = new VBox();
                rootTelaOcorrencias.setAlignment(Pos.TOP_CENTER);

                Label tituloOcorrencias = new Label("Ocorrências");
                tituloOcorrencias.setId("tituloOcorrencias");
                tituloOcorrencias.setFont(fonteTituloTelaOcorrencias);

                Label local = new Label("Local");
                local.setId("local");
                Label data = new Label("Data");
                data.setId("data");
                Label hora = new Label("Hora");
                hora.setId("hora");
                Label equipe = new Label("Equipe");
                equipe.setId("equipe");
                Label tipo = new Label("Tipo");
                tipo.setId("tipo");
                Label descricao = new Label("Descrição");
                descricao.setId("descricao");

                Label localCoisa = new Label("Casa do Zanella");
                local.setId("local");
                Label dataCoisa = new Label("20/10/1981");
                data.setId("data");
                Label horaCoisa = new Label("23:59");
                hora.setId("hora");
                Label equipeCoisa = new Label("Bazanella");
                equipe.setId("equipe");
                Label tipoCoisa = new Label("Muito tempo na hora H");
                tipo.setId("tipo");
                Label descricaoCoisa = new Label("Tempo muito passado");
                descricao.setId("descricao");

                GridPane telaOcorrencias = new GridPane();
                telaOcorrencias.setHgap(12);
                telaOcorrencias.setVgap(15);
                telaOcorrencias.setAlignment(Pos.CENTER);

                telaOcorrencias.add(local, 0, 0);
                telaOcorrencias.add(data, 1, 0);
                telaOcorrencias.add(hora, 2, 0);
                telaOcorrencias.add(equipe, 3, 0);
                telaOcorrencias.add(tipo, 4, 0);
                telaOcorrencias.add(descricao, 5, 0);

                telaOcorrencias.add(localCoisa, 0, 1);
                telaOcorrencias.add(dataCoisa, 1, 1);
                telaOcorrencias.add(horaCoisa, 2, 1);
                telaOcorrencias.add(equipeCoisa, 3, 1);
                telaOcorrencias.add(tipoCoisa, 4, 1);
                telaOcorrencias.add(descricaoCoisa, 5, 1);

                rootTelaOcorrencias.getChildren().add(tituloOcorrencias);
                rootTelaOcorrencias.getChildren().add(telaOcorrencias);

                Button botaoCadastrarOcorrencia = new Button("Cadastrar Ocorrência");
                rootTelaOcorrencias.getChildren().add(botaoCadastrarOcorrencia);
                botaoCadastrarOcorrencia.setId("botaoOcorrencia");

                Scene Ocorrencias = new Scene(rootTelaOcorrencias, 800, 600);

                Ocorrencias.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

                EventHandler<MouseEvent> e = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Stage CadastrodeOcorrencias = new Stage();

                        Font fonteTituloTelaOcorrencias = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);

                        Label tituloCadastro = new Label("Cadastrar Ocorrência");
                        tituloCadastro.setId("tituloOcorrencias");
                        tituloCadastro.setFont(fonteTituloTelaOcorrencias);

                        VBox rootCadastrarOcorrencia = new VBox();
                        rootCadastrarOcorrencia.setAlignment(Pos.TOP_CENTER);

                        Label localCadastroOcorrencias = new Label("Local");
                        Label dataCadastroOcorrencias = new Label("Data");
                        Label horaCadastroOcorrencias = new Label("Hora");
                        Label descricaoCadastroOcorrencias = new Label("Descrição");
                        Label equipeCadastroOcorrencias = new Label("Equipe");
                        Label tipoCadastroOcorrencias = new Label("Tipo");

                        TextField localOcorrencias = new TextField();
                        TextField dataOcorrencias = new TextField();
                        TextField horaOcorrencias = new TextField();
                        TextField descricaoOcorrencias = new TextField();
                        TextField equipeOcorrencias = new TextField();
                        TextField tipoOcorrencias = new TextField();

                        GridPane cadastroOcorrencias = new GridPane();
                        cadastroOcorrencias.setAlignment(Pos.CENTER);
                        cadastroOcorrencias.setHgap(12);
                        cadastroOcorrencias.setVgap(15);

                        cadastroOcorrencias.add(localCadastroOcorrencias, 0, 0);
                        cadastroOcorrencias.add(localOcorrencias, 1, 0);
                        cadastroOcorrencias.add(dataCadastroOcorrencias, 0, 1);
                        cadastroOcorrencias.add(dataOcorrencias, 1, 1);
                        cadastroOcorrencias.add(horaCadastroOcorrencias, 0, 2);
                        cadastroOcorrencias.add(horaOcorrencias, 1, 2);
                        cadastroOcorrencias.add(descricaoCadastroOcorrencias, 0, 3);
                        cadastroOcorrencias.add(descricaoOcorrencias, 1, 3);
                        cadastroOcorrencias.add(equipeCadastroOcorrencias, 0, 4);
                        cadastroOcorrencias.add(equipeOcorrencias, 1, 4);
                        cadastroOcorrencias.add(tipoCadastroOcorrencias, 0, 5);
                        cadastroOcorrencias.add(tipoOcorrencias, 1, 5);

                        HBox botoes = new HBox();
                        botoes.setAlignment(Pos.CENTER);

                        Button enviar = new Button("Enviar");
                        Button cancelar = new Button("Cancelar");

                        EventHandler<MouseEvent> h = new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                CadastrodeOcorrencias.close();
                            }
                        };

                        EventHandler<MouseEvent> hh = new EventHandler<MouseEvent>() {
                            public void handle(MouseEvent event) {
                                CadastrodeOcorrencias.close();
                            }
                        };

                        botoes.getChildren().addAll(enviar, cancelar);

                        enviar.addEventHandler(MouseEvent.MOUSE_CLICKED, h);
                        cancelar.addEventHandler(MouseEvent.MOUSE_CLICKED, hh);

                        rootCadastrarOcorrencia.getChildren().add(tituloCadastro);
                        rootCadastrarOcorrencia.getChildren().add(cadastroOcorrencias);
                        rootCadastrarOcorrencia.getChildren().add(botoes);

                        Scene sceneCadastroOcorrencias = new Scene(rootCadastrarOcorrencia, 800, 600);
                        sceneCadastroOcorrencias.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

                        CadastrodeOcorrencias.setTitle("Cadastro de Ocorrencias");
                        CadastrodeOcorrencias.setScene(sceneCadastroOcorrencias);
                        CadastrodeOcorrencias.show();
                    }
                };

                botaoCadastrarOcorrencia.addEventHandler(MouseEvent.MOUSE_CLICKED, e);

                ocorrencias.setTitle("Ocorrências");
                ocorrencias.setScene(Ocorrencias);
                ocorrencias.show();
            }
        };

        EventHandler<MouseEvent> novoUsuarioo = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.close();
                Stage novoUsuario = new Stage();
                

                Font fonteTitulo = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);

                VBox rootNovoUsuario = new VBox();
                rootNovoUsuario.setId("root");
                rootNovoUsuario.setAlignment(Pos.TOP_CENTER);

                Label titulo = new Label("CADASTRO DO USUÁRIO");
                titulo.setId("titulo");
                titulo.setFont(fonteTitulo);
                Label espaco = new Label("         ");

                Label nome = new Label("Nome:");
                Label nomeGuerra = new Label("Nome de Guerra:");
                Label departamento = new Label("Departamento");
                Label senha = new Label("Senha:");
                Label confirmarSenha = new Label("Confirmar Senha:");

                TextField campoTexto = new TextField();
                campoTexto.setId("camposUsuario");
                TextField nomeGuerraTexto = new TextField();
                nomeGuerraTexto.setId("camposUsuario");
                TextField departamentoTexto = new TextField();
                departamentoTexto.setId("camposUsuario");
                TextField senhaTexto = new TextField();
                senhaTexto.setId("camposUsuario");
                TextField confirmarSenhaTexto = new TextField();
                confirmarSenhaTexto.setId("camposUsuario");

                Label email = new Label("E-mail:");
                Label cpf = new Label("CPF:");
                Label rg = new Label("RG:");
                Label cidade = new Label("Cidada:");
                Label estado = new Label("Estado:");

                TextField emailTexto = new TextField();
                emailTexto.setId("camposUsuario");
                TextField cpfTexto = new TextField();
                cpfTexto.setId("camposUsuario");
                TextField rgTexto = new TextField();
                rgTexto.setId("camposUsuario");
                TextField cidadeCampoTexto = new TextField();
                cidadeCampoTexto.setId("camposUsuario");
                TextField estadoTexto = new TextField();
                estadoTexto.setId("camposUsuario");

                SplitPane espacos = new SplitPane();
                espacos.setOrientation(Orientation.HORIZONTAL);
                espacos.setId("espacos");

                GridPane espaco1 = new GridPane();
                espaco1.setHgap(12);
                espaco1.setVgap(15);

                espaco1.add(nome, 0, 0);
                espaco1.add(nomeGuerra, 0, 1);
                espaco1.add(departamento, 0, 2);
                espaco1.add(senha, 0, 3);
                espaco1.add(confirmarSenha, 0, 4);

                espaco1.add(campoTexto, 1, 0);
                espaco1.add(nomeGuerraTexto, 1, 1);
                espaco1.add(departamentoTexto, 1, 2);
                espaco1.add(senhaTexto, 1, 3);
                espaco1.add(confirmarSenhaTexto, 1, 4);

                GridPane espaco2 = new GridPane();
                espaco2.setHgap(12);
                espaco2.setVgap(15);
                
                espaco2.add(email, 0, 0);
                espaco2.add(cpf, 0, 1);
                espaco2.add(rg, 0, 2);
                espaco2.add(cidade, 0, 3);
                espaco2.add(estado, 0, 4);

                espaco2.add(emailTexto, 1, 0);
                espaco2.add(cpfTexto, 1, 1);
                espaco2.add(rgTexto, 1, 2);
                espaco2.add(cidadeCampoTexto, 1, 3);
                espaco2.add(estadoTexto, 1, 4);

                HBox botoes = new HBox();
                botoes.setAlignment(Pos.CENTER);

                Button confirmar = new Button("Confirmar");
                confirmar.setId("botaoConfirmar");

                EventHandler<MouseEvent> eventoConfirmar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        stage.show();
                        novoUsuario.close();
                    }
                };

                Button cancelar = new Button("Cancelar");
                cancelar.setId("botaoCancelar");

                EventHandler<MouseEvent> eventoCancelar = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        stage.show();
                        novoUsuario.close();
                    }
                };

                botoes.getChildren().addAll(confirmar, cancelar);

                espacos.getItems().add(espaco1);
                espacos.getItems().add(espaco2);

                rootNovoUsuario.getChildren().add(titulo);
                rootNovoUsuario.getChildren().add(espaco);
                rootNovoUsuario.getChildren().add(espacos);
                rootNovoUsuario.getChildren().add(botoes);

                confirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, eventoConfirmar);
                cancelar.addEventHandler(MouseEvent.MOUSE_CLICKED, eventoCancelar);

                Scene cenarioCadastro = new Scene(rootNovoUsuario, 800, 600);
                cenarioCadastro.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
                novoUsuario.setScene(cenarioCadastro);
                novoUsuario.show();
            }
        };

        botaoEntrar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        novoUsuario.addEventHandler(MouseEvent.MOUSE_CLICKED, novoUsuarioo);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}