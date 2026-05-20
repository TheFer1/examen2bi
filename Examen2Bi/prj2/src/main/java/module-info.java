module examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    opens CSDataAccess.CSDTO to javafx.base;
    opens examen to javafx.fxml;
    exports examen;
    exports CSUserInterface.CSForm;
    exports CSBusinessLogic;
    exports CSDataAccess.CSDTO;
}
