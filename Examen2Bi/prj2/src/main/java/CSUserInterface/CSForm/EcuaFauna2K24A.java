package CSUserInterface.CSForm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EcuaFauna2K24A {

    // Variables estáticas globales
    private static final String CSCedula = "050385533-0";
    private static final String CSNombre = "Casa Stalin";

    public void CSFormulario(Stage csStage) {
        csStage.setTitle("EcuaFauna 2K24A");
        csStage.setResizable(false); // Deshabilitar la opción de maximizar la pantalla

        // Layout principal
        VBox csroot = new VBox(10); // Reducido el espacio entre elementos
        csroot.setPadding(new Insets(10)); // Reducido los márgenes
        csroot.setAlignment(Pos.TOP_CENTER); // Centrar verticalmente el contenido

        // Crear el fondo semioscuro para los campos de cédula y nombre
        Rectangle backgroundRect = new Rectangle(350, 100);
        backgroundRect.setFill(Color.rgb(0, 0, 0, 0.2)); // Color negro con opacidad 0.2
        backgroundRect.setArcWidth(10); // Bordes redondeados
        backgroundRect.setArcHeight(10);

        // GridPane para la información del alumno
        GridPane csGridPane = new GridPane();
        csGridPane.setHgap(20);
        csGridPane.setVgap(20);
        csGridPane.setAlignment(Pos.CENTER); // Centrar horizontalmente el contenido

        // Campos de cédula y nombre usando variables estáticas
        Label lblCedula = new Label("Cédula:");
        TextField txtCedula = new TextField(CSCedula);
        txtCedula.setEditable(false);
        txtCedula.setPrefWidth(250); // Ajustar el ancho del campo

        Label lblNombre = new Label("Nombres:");
        TextField txtNombre = new TextField(CSNombre);
        txtNombre.setEditable(false);
        txtNombre.setPrefWidth(250); // Ajustar el ancho del campo

        csGridPane.add(lblCedula, 0, 0);
        csGridPane.add(txtCedula, 1, 0);
        csGridPane.add(lblNombre, 0, 1);
        csGridPane.add(txtNombre, 1, 1);

        // Contenedor para el fondo semioscuro y el GridPane
        StackPane infoPane = new StackPane();
        infoPane.getChildren().addAll(backgroundRect, csGridPane);

        // Sección del hormiguero virtual
        Label lblHormiguero = new Label("Hormiguero virtual");
        lblHormiguero.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;"); // Estilo para la etiqueta

        Button btnCrearHormiga = new Button("Crear Hormiga Larva");
        btnCrearHormiga.setPrefSize(180, 45); // Tamaño del botón

        // HBox para alinear el botón "Crear Hormiga Larva" a la derecha
        HBox btnCrearHormigaBox = new HBox();
        btnCrearHormigaBox.setAlignment(Pos.CENTER_RIGHT); // Alinear a la derecha
        btnCrearHormigaBox.getChildren().add(btnCrearHormiga);

        // Crear el fondo semioscuro para las etiquetas y el TableView
        Rectangle hormigueroBackground = new Rectangle(570, 200);
        hormigueroBackground.setFill(Color.rgb(0, 0, 0, 0.2)); // Color negro con opacidad 0.2
        hormigueroBackground.setArcWidth(10); // Bordes redondeados
        hormigueroBackground.setArcHeight(10);

      
        // Contenedor para el fondo semioscuro y el TableView del hormiguero
        StackPane hormigueroPane = new StackPane();
        hormigueroPane.getChildren().addAll(hormigueroBackground);

        // Crear botones de navegación
        Button btnPrevious = new Button("Anterior");
        Button btnNext = new Button("Siguiente");

        // HBox para botones de navegación
        HBox navigationBox = new HBox(20, btnPrevious, btnNext);
        navigationBox.setPadding(new Insets(10));
        navigationBox.setAlignment(Pos.CENTER); // Centrar horizontalmente

        // ComboBoxes para GenoAlimento e IngestaNativa
        ComboBox<String> cbGenoAlimento = new ComboBox<>();
        cbGenoAlimento.getItems().addAll("X", "XX", "XY");
        cbGenoAlimento.setPrefWidth(150); // Ancho del ComboBox

        ComboBox<String> cbIngestaNativa = new ComboBox<>();
        cbIngestaNativa.getItems().addAll("Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro");
        cbIngestaNativa.setPrefWidth(150); // Ancho del ComboBox

        // Botones para interactuar con la base de datos
        Button btnAlimentarGeno = new Button("Alimentar GenoAlimento");
        Button btnAlimentarIngesta = new Button("Alimentar Ingesta Nativa");

        // Layout para los comboboxes y botones de alimentar
        HBox alimentacionBox = new HBox(10, cbGenoAlimento, btnAlimentarGeno, cbIngestaNativa, btnAlimentarIngesta);
        alimentacionBox.setPadding(new Insets(10));
        alimentacionBox.setAlignment(Pos.CENTER); // Centrar horizontalmente

        // Botones de guardar y eliminar
        Button btnEliminar = new Button("Eliminar");
        Button btnGuardar = new Button("Guardar");

        // Layout para botones de guardar y eliminar
        HBox accionBox = new HBox(10, btnEliminar, btnGuardar);
        accionBox.setPadding(new Insets(10));
        accionBox.setAlignment(Pos.CENTER); // Centrar horizontalmente

        // Agregar todo al layout principal
        csroot.getChildren().addAll(infoPane, lblHormiguero, btnCrearHormigaBox, hormigueroPane, navigationBox,
                alimentacionBox, accionBox);

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
