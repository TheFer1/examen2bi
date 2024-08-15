module examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens examen to javafx.fxml;
    exports examen;
}
