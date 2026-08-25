package com.cad.despacho;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaNovaOcorrencia {

    public VBox criar() {

        VBox raiz = new VBox();
        raiz.getChildren().add(new Label("REGISTRAR NOVA OCORRENCIA"));

        VBox card = new VBox();

        Label tituloCard = new Label("DADOS DO EVENTO / SINISTRO");

        Label labelTipo = new Label("TIPO DE OCORRENCIA");
        Label valorTipo = new Label("Incendio Comercial");
        VBox campoTipoBox = new VBox();
        campoTipoBox.getChildren().add(labelTipo);
        campoTipoBox.getChildren().add(valorTipo);

        Label labelPrioridade = new Label("PRIORIDADE TATICA");
        Button botaoAlta = new Button("ALTA");
        Button botaoMedia = new Button("MEDIA");
        Button botaoBaixa = new Button("BAIXA");
        HBox boxPrioridade = new HBox(botaoAlta, botaoMedia, botaoBaixa);
        VBox campoPrioridadeBox = new VBox();
        campoPrioridadeBox.getChildren().add(labelPrioridade);
        campoPrioridadeBox.getChildren().add(boxPrioridade);

        HBox linha1 = new HBox(campoTipoBox, campoPrioridadeBox);

        Label labelLocal = new Label("LOCALIZACAO");
        Label valorLocal = new Label("Rua, numero - Bairro, Cidade/UF");
        VBox campoLocalBox = new VBox();
        campoLocalBox.getChildren().add(labelLocal);
        campoLocalBox.getChildren().add(valorLocal);

        Label labelData = new Label("DATA E HORA DO REGISTRO");
        Label valorData = new Label("09/05/2026 - 14:15");
        VBox campoDataBox = new VBox();
        campoDataBox.getChildren().add(labelData);
        campoDataBox.getChildren().add(valorData);

        Label labelSolicitante = new Label("SOLICITANTE / CONTATO");
        Label valorSolicitante = new Label("Nome (obs) e telefone");
        VBox campoSolicitanteBox = new VBox();
        campoSolicitanteBox.getChildren().add(labelSolicitante);
        campoSolicitanteBox.getChildren().add(valorSolicitante);

        HBox linha3 = new HBox(campoDataBox, campoSolicitanteBox);

        Label labelDescricao = new Label("DESCRICAO INICIAL DA OCORRENCIA");
        Label valorDescricao = new Label("Descreve ai o que foi relatado...");
        VBox campoDescricaoBox = new VBox();
        campoDescricaoBox.getChildren().add(labelDescricao);
        campoDescricaoBox.getChildren().add(valorDescricao);

        card.getChildren().add(tituloCard);
        card.getChildren().add(linha1);
        card.getChildren().add(campoLocalBox);
        card.getChildren().add(linha3);
        card.getChildren().add(campoDescricaoBox);

        HBox linhaBotao = new HBox();
        Button botaoRegistrar = new Button("Registrar e Despachar");
        linhaBotao.getChildren().add(botaoRegistrar);

        VBox formulario = new VBox();
        formulario.getChildren().add(card);
        formulario.getChildren().add(linhaBotao);

        VBox painel = new VBox();

        Label tituloViaturas = new Label("VIATURAS DISPONIVEIS");

        VBox listaViaturas = new VBox();
        listaViaturas.getChildren().add(new Label("ABTR-05"));
        listaViaturas.getChildren().add(new Label("ASU-12"));
        listaViaturas.getChildren().add(new Label("AT-03"));
        listaViaturas.getChildren().add(new Label("UR-03"));
        listaViaturas.getChildren().add(new Label("ASU-01  (indisponivel)"));
        listaViaturas.getChildren().add(new Label("ABTR-02  (indisponivel)"));

        painel.getChildren().add(tituloViaturas);
        painel.getChildren().add(listaViaturas);

        HBox conteudo = new HBox(formulario, painel);

        raiz.getChildren().add(conteudo);

        return raiz;
    }
}
