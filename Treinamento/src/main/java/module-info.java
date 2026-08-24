module com.mycompany.treinamento {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens com.mycompany.treinamento to javafx.fxml;
    exports com.mycompany.treinamento;
}
