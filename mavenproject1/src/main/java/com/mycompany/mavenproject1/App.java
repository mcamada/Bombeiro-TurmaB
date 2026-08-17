package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.setStyle("-fx-background-color: #f4f5f7;");

        HBox header = createHeader();

        VBox content = new VBox(30);
        content.setPadding(new Insets(30));

        HBox statsRow = new HBox(20);

        statsRow.getChildren().addAll(
                createStatCard("Chamadas Ativas", "2", "🔥"),
                createStatCard("Equipes Disponíveis", "67", "👥"),
                createStatCard("Viaturas em uso", "3", "🚚"),
                createStatCard("Emergências hoje", "8", "⚠️")
        );

        VBox emergenciesList = new VBox(15);

        emergenciesList.getChildren().addAll(
                createEmergencyCard(
                        "#1334-987",
                        "🔥 Incêndio Residencial",
                        "Avenida principal R.15",
                        "Há 1 minuto",
                        "Ativa",
                        "#dc3545"
                ),

                createEmergencyCard(
                        "#1238-147",
                        "🔥 Resgate de Pessoas",
                        "Rua 15, 607",
                        "Há 19 Minutos",
                        "Ativa",
                        "#dc3545"
                ),

                createEmergencyCard(
                        "#6767-244",
                        "🔥 Afogamento de Cachorro",
                        "Rua 25, 3190",
                        "Há 30 Minutos",
                        "Em Atendimento",
                        "#fd7e14"
                ),

                createEmergencyCard(
                        "#0703-010",
                        "🔥 Resgate em Altura",
                        "Banco Central",
                        "Há 4 horas",
                        "Em Atendimento",
                        "#fd7e14"
                )
        );

        content.getChildren().addAll(
                statsRow,
                emergenciesList
        );

        root.getChildren().addAll(
                header,
                content
        );

        Scene scene = new Scene(root, 1000, 700);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Corpo de Bombeiros");
        primaryStage.show();
    }


    private HBox createHeader() {

        HBox header = new HBox(15);

        header.setStyle(
                "-fx-background-color: #d31111;" +
                "-fx-padding: 20 30;"
        );

        header.setAlignment(Pos.CENTER_LEFT);

        Label logo = new Label("🔥");

        logo.setTextFill(Color.WHITE);
        logo.setFont(
                Font.font("System", FontWeight.BOLD, 40)
        );

        VBox titleBox = new VBox();

        Label title = new Label("Corpo de bombeiros");

        title.setTextFill(Color.WHITE);

        title.setFont(
                Font.font("System", FontWeight.BOLD, 28)
        );

        Label subtitle =
                new Label("Sistema de gestão de emergências");

        subtitle.setTextFill(Color.WHITE);

        subtitle.setFont(
                Font.font("System", 16)
        );

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        header.getChildren().addAll(
                logo,
                titleBox
        );

        return header;
    }


    private VBox createStatCard(
            String titleText,
            String valueText,
            String iconText) {

        VBox card = new VBox(10);

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 15;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);"
        );

        Label title = new Label(titleText);

        title.setFont(
                Font.font("System", 14)
        );

        title.setTextFill(
                Color.web("#555555")
        );

        HBox valueRow = new HBox();

        valueRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label value = new Label(valueText);

        value.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        36
                )
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label icon = new Label(iconText);

        icon.setFont(
                Font.font("System", 24)
        );

        valueRow.getChildren().addAll(
                value,
                spacer,
                icon
        );

        card.getChildren().addAll(
                title,
                valueRow
        );

        return card;
    }


    private VBox createEmergencyCard(
            String idText,
            String titleText,
            String addressText,
            String timeText,
            String statusText,
            String statusColor) {

        VBox card = new VBox(5);

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 15 20;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 5, 0, 0, 2);"
        );

        Label id = new Label(idText);

        id.setTextFill(
                Color.web("#777777")
        );

        id.setFont(
                Font.font("System", 12)
        );

        BorderPane titleRow =
                new BorderPane();

        Label title =
                new Label(titleText);

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        18
                )
        );

        Label statusBadge =
                new Label(statusText);

        statusBadge.setTextFill(
                Color.WHITE
        );

        statusBadge.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        12
                )
        );

        statusBadge.setStyle(
                "-fx-background-color: " + statusColor + ";" +
                "-fx-padding: 4 12;" +
                "-fx-background-radius: 12;"
        );

        titleRow.setLeft(title);
        titleRow.setRight(statusBadge);

        BorderPane.setAlignment(
                statusBadge,
                Pos.CENTER
        );

        Label address =
                new Label(addressText);

        address.setTextFill(
                Color.web("#333333")
        );

        Label time =
                new Label(timeText);

        time.setTextFill(
                Color.web("#888888")
        );

        card.getChildren().addAll(
                id,
                titleRow,
                address,
                time
        );

        return card;
    }


    public static void main(String[] args) {
        launch(args);
    }
}