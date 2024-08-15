package CSUserInterface.CSForm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EcuaFauna2K24A {

    // Variables estáticas globales
    private static final String CSCedula = "050385533-0";
    private static final String CSNombre = "Casa Stalin";
    
    public void CSFormulario(Stage csStage) {
        csStage.setTitle("EcuaFauna 2K24A");

        // Layout principal
        VBox csroot = new VBox(20); // Aumentar el espacio entre elementos
        csroot.setPadding(new Insets(20)); // Aumentar los márgenes
        csroot.setAlignment(Pos.TOP_CENTER); // Centrar verticalmente el contenido

        // GridPane para la información del alumno
        GridPane csGridPane = new GridPane();
        csGridPane.setHgap(15);
        csGridPane.setVgap(15);
        csGridPane.setAlignment(Pos.CENTER); // Centrar horizontalmente el contenido

        // Campos de cédula y nombre usando variables estáticas
        Label lblCedula = new Label("Cédula:");
        TextField txtCedula = new TextField(CSCedula);
        txtCedula.setEditable(false);
        txtCedula.setPrefWidth(200); // Ajustar el ancho del campo

        Label lblNombre = new Label("Nombres:");
        TextField txtNombre = new TextField(CSNombre);
        txtNombre.setEditable(false);
        txtNombre.setPrefWidth(200); // Ajustar el ancho del campo

        csGridPane.add(lblCedula, 0, 0);
        csGridPane.add(txtCedula, 1, 0);
        csGridPane.add(lblNombre, 0, 1);
        csGridPane.add(txtNombre, 1, 1);

        // Sección del hormiguero virtual
        Label lblHormiguero = new Label("Hormiguero virtual");

        Button btnCrearHormiga = new Button("crear hormiga larva");
        btnCrearHormiga.setPrefSize(150, 40);

        // GridPane para representar el hormiguero
        GridPane hormigueroGrid = new GridPane();
        hormigueroGrid.setHgap(10);
        hormigueroGrid.setVgap(10);
        hormigueroGrid.setPadding(new Insets(10, 0, 10, 0));
        hormigueroGrid.setAlignment(Pos.CENTER);

        // Crear botones en la cuadrícula de 4x4
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button btnHormiga = new Button();
                btnHormiga.setPrefSize(50, 50); // Tamaño del botón
                hormigueroGrid.add(btnHormiga, j, i);
            }
        }

        // ComboBoxes para GenoAlimento e IngestaNativa
        ComboBox<String> cbGenoAlimento = new ComboBox<>();
        cbGenoAlimento.getItems().addAll("X", "XX", "XY");
        cbGenoAlimento.setPrefWidth(120); // Ancho del ComboBox

        ComboBox<String> cbIngestaNativa = new ComboBox<>();
        cbIngestaNativa.getItems().addAll("Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro");
        cbIngestaNativa.setPrefWidth(120); // Ancho del ComboBox

        // Botones para interactuar con la base de datos
        Button btnAlimentarGeno = new Button("Alimentar con GenoAlimento");
        Button btnAlimentarIngesta = new Button("Alimentar con Ingesta Nativa");

        // Layout para los comboboxes y botones de alimentar
        HBox alimentacionBox = new HBox(20, cbGenoAlimento, btnAlimentarGeno, cbIngestaNativa, btnAlimentarIngesta);
        alimentacionBox.setPadding(new Insets(20, 0, 20, 0));
        alimentacionBox.setAlignment(Pos.CENTER); // Centrar horizontalmente

        // Botones de guardar y eliminar
        Button btnEliminar = new Button("Eliminar");
        Button btnGuardar = new Button("Guardar");

        // Layout para botones de guardar y eliminar
        HBox accionBox = new HBox(20, btnEliminar, btnGuardar);
        accionBox.setPadding(new Insets(20, 0, 20, 0));
        accionBox.setAlignment(Pos.CENTER); // Centrar horizontalmente

        // Agregar todo al layout principal
        csroot.getChildren().addAll(csGridPane, lblHormiguero,btnCrearHormiga, hormigueroGrid, alimentacionBox, accionBox);

        // Agregar el layout principal al grupo
        Group csGroup = new Group();
        csGroup.getChildren().add(csroot);

        // Configuración de la escena
        Scene csScene = new Scene(csGroup, 800, 600);

        // Mostrar el Stage
        csStage.setScene(csScene);
        csStage.show();
    }
}
