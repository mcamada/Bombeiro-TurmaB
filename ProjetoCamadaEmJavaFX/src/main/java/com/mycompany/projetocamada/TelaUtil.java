package com.mycompany.projetocamada;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class TelaUtil {

    private TelaUtil() {
    }

    /**
     * Cria um fundo "cover" a partir de uma imagem em /imagens.
     * Se a imagem nao existir, usa um fundo cinza claro para o app
     * continuar funcionando enquanto a arte nao chega.
     */
    public static Background fundoDeImagem(String caminho) {
        var stream = TelaUtil.class.getResourceAsStream(caminho);
        if (stream == null) {
            System.out.println("Imagem nao encontrada: " + caminho);
            return new Background(new BackgroundFill(Color.web("#F4F4F4"), CornerRadii.EMPTY, null));
        }

        Image imagem = new Image(stream);
        BackgroundImage fundo = new BackgroundImage(
                imagem,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true));
        return new Background(fundo);
    }
}
