package CSUserInterface.CSForm;

import java.util.List;
import java.util.stream.Collectors;

import CSBusinessLogic.CSHormigaBL;
import CSDataAccess.CSDAO.CSHormigaDao;
import CSDataAccess.CSDTO.CSHormigaDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class EcuaFauna2K24A {

    private static final String CSCedula = "050385533-0";
    private static final String CSNombre = "Casa Stalin";
    private TableView<CSHormigaDto> tableView = new TableView<>();
    private ObservableList<CSHormigaDto> data = FXCollections.observableArrayList();
    private CSHormigaBL csHormigaBL = new CSHormigaBL(); 
    private Pagination pagination = new Pagination();

    public void CSFormulario(Stage csStage) {
        csStage.setTitle("EcuaFauna 2K24A");
        csStage.setResizable(false);

        // Layout principal
        VBox csroot = new VBox(10);
        csroot.setPadding(new Insets(10));
        csroot.setAlignment(Pos.TOP_CENTER);

        // Crear el fondo semioscuro para los campos de cédula y nombre
        Rectangle backgroundRect = new Rectangle(350, 100);
        backgroundRect.setFill(Color.rgb(0, 0, 0, 0.2));
        backgroundRect.setArcWidth(10);
        backgroundRect.setArcHeight(10);

        // GridPane para la información del alumno
        GridPane csGridPane = new GridPane();
        csGridPane.setHgap(20);
        csGridPane.setVgap(20);
        csGridPane.setAlignment(Pos.CENTER);

        // Campos de cédula y nombre usando variables estáticas
        Label lblCedula = new Label("Cédula:");
        TextField txtCedula = new TextField(CSCedula);
        txtCedula.setEditable(false);
        txtCedula.setPrefWidth(250);

        Label lblNombre = new Label("Nombres:");
        TextField txtNombre = new TextField(CSNombre);
        txtNombre.setEditable(false);
        txtNombre.setPrefWidth(250);

        csGridPane.add(lblCedula, 0, 0);
        csGridPane.add(txtCedula, 1, 0);
        csGridPane.add(lblNombre, 0, 1);
        csGridPane.add(txtNombre, 1, 1);

        StackPane infoPane = new StackPane();
        infoPane.getChildren().addAll(backgroundRect, csGridPane);

        Label lblHormiguero = new Label("Hormiguero virtual");
        lblHormiguero.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button btnCrearHormiga = new Button("Crear Hormiga Larva");
        btnCrearHormiga.setPrefSize(180, 45);
        btnCrearHormiga.setOnAction(e -> handleCreateHormiga());

        HBox btnCrearHormigaBox = new HBox();
        btnCrearHormigaBox.setAlignment(Pos.CENTER_RIGHT);
        btnCrearHormigaBox.getChildren().add(btnCrearHormiga);

        Rectangle hormigueroBackground = new Rectangle(570, 200);
        hormigueroBackground.setFill(Color.rgb(0, 0, 0, 0.2));
        hormigueroBackground.setArcWidth(10);
        hormigueroBackground.setArcHeight(10);

        // Configuración de la tabla
        tableView.setPrefSize(500, 200);

        TableColumn<CSHormigaDto, Integer> colId = new TableColumn<>("ID");
        colId.setPrefWidth(50);
        colId.setCellValueFactory(new PropertyValueFactory<>("idCSHormiga"));

        TableColumn<CSHormigaDto, String> colTipoHormiga = new TableColumn<>("Tipo Hormiga");
        colTipoHormiga.setPrefWidth(100);
        colTipoHormiga.setCellValueFactory(new PropertyValueFactory<>("tipoHormiga"));

        TableColumn<CSHormigaDto, String> colSexo = new TableColumn<>("Sexo");
        colSexo.setPrefWidth(50);
        colSexo.setCellValueFactory(new PropertyValueFactory<>("nombreSexo"));

        TableColumn<CSHormigaDto, String> colProvincia = new TableColumn<>("Provincia");
        colProvincia.setPrefWidth(100);
        colProvincia.setCellValueFactory(new PropertyValueFactory<>("nombreProvincia"));

        TableColumn<CSHormigaDto, String> colGenoAlimento = new TableColumn<>("GenoAlimento");
        colGenoAlimento.setPrefWidth(100);
        colGenoAlimento.setCellValueFactory(new PropertyValueFactory<>("nombreGenoAlimento"));

        TableColumn<CSHormigaDto, String> colIngestaNativa = new TableColumn<>("Ingesta Nativa");
        colIngestaNativa.setPrefWidth(100);
        colIngestaNativa.setCellValueFactory(new PropertyValueFactory<>("nombreIngestaNativa"));

        TableColumn<CSHormigaDto, String> colFechaCreacion = new TableColumn<>("Fecha Creación");
        colFechaCreacion.setPrefWidth(100);
        colFechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));

        TableColumn<CSHormigaDto, String> colEstado = new TableColumn<>("Estado");
        colEstado.setPrefWidth(100);
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tableView.getColumns().addAll(colId, colTipoHormiga, colSexo, colProvincia, colGenoAlimento, colIngestaNativa, colFechaCreacion, colEstado);

        // Configurar la paginación
        pagination.setPageFactory(this::createPage);
        loadData();

        StackPane hormigueroPane = new StackPane();
        hormigueroPane.getChildren().addAll(hormigueroBackground, pagination);

        ComboBox<String> cbGenoAlimento = new ComboBox<>();
        cbGenoAlimento.getItems().addAll("X", "XX", "XY");
        cbGenoAlimento.setPrefWidth(150);
        cbGenoAlimento.setStyle("-fx-background-color: white; -fx-background-radius: 5;");

        ComboBox<String> cbIngestaNativa = new ComboBox<>();
        cbIngestaNativa.getItems().addAll("Carnivoro", "Herbívoro", "Omnivoro", "Insectivoro");
        cbIngestaNativa.setPrefWidth(150);
        cbIngestaNativa.setStyle("-fx-background-color: white; -fx-background-radius: 5;");

        Button btnAlimentarGeno = new Button("Alimentar GenoAlimento");
        btnAlimentarGeno.setStyle("-fx-background-color: #2e8b57; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        btnAlimentarGeno.setOnAction(e -> handleAlimentar(cbGenoAlimento.getValue(), true));

        Button btnAlimentarIngesta = new Button("Alimentar Ingesta Nativa");
        btnAlimentarIngesta.setStyle("-fx-background-color: #2e8b57; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        btnAlimentarIngesta.setOnAction(e -> handleAlimentar(cbIngestaNativa.getValue(), false));

        HBox alimentacionBox = new HBox(15, cbGenoAlimento, btnAlimentarGeno, cbIngestaNativa, btnAlimentarIngesta);
        alimentacionBox.setPadding(new Insets(15));
        alimentacionBox.setAlignment(Pos.CENTER);
        alimentacionBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.4); -fx-background-radius: 8;");

        Button btnEliminar = new Button("Eliminar (Matar)");
        btnEliminar.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        btnEliminar.setOnAction(e -> handleEliminar());

        Button btnGuardar = new Button("Refrescar vista");
        btnGuardar.setStyle("-fx-background-color: #5bc0de; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        btnGuardar.setOnAction(e -> loadData());

        HBox accionBox = new HBox(20, btnEliminar, btnGuardar);
        accionBox.setPadding(new Insets(10));
        accionBox.setAlignment(Pos.CENTER);

        csroot.getChildren().addAll(infoPane, lblHormiguero, btnCrearHormigaBox, hormigueroPane, 
                alimentacionBox, accionBox);
        csroot.setStyle("-fx-background-color: rgba(255,255,255,0.7); -fx-background-radius: 10;");
        
        StackPane mainStack = new StackPane();
        try {
            javafx.scene.image.ImageView bgImage = new javafx.scene.image.ImageView(new javafx.scene.image.Image("icon.jpg"));
            bgImage.setFitWidth(800);
            bgImage.setFitHeight(600);
            bgImage.setPreserveRatio(false);
            mainStack.getChildren().add(bgImage);
        } catch (Exception e) {}
        mainStack.getChildren().add(csroot);

        Group csGroup = new Group();
        csGroup.getChildren().add(mainStack);

        Scene csScene = new Scene(csGroup, 800, 600);

        csStage.setScene(csScene);
        csStage.show();
    }

    private void handleCreateHormiga() {
        // Crear y mostrar un diálogo de confirmación
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Creación");
        alert.setHeaderText(null);
        alert.setContentText("¿Estás seguro de crear una hormiga larva?");
        
        ButtonType buttonTypeOk = new ButtonType("Crear");
        ButtonType buttonTypeCancel = new ButtonType("Cancelar");
        
        alert.getButtonTypes().setAll(buttonTypeOk, buttonTypeCancel);
        
        alert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeOk) {
                createNewHormiga();
            }
        });
    }

    private void createNewHormiga() {
         try {
            // Crear una instancia del DAO
            CSHormigaDao hormigaDao = new CSHormigaDao();
            Random random = new Random();
            int randomNumber = random.nextInt(24) + 1;
            int randomNumer1 = random.nextInt(4)+1;
            int min = 5;
            int max = 7;
            int randomNumber3 = random.nextInt(max - min + 1) + min;
            // Crear un objeto CSHormigaDto con los campos necesarios
            CSHormigaDto hormiga = new CSHormigaDto(
                "Larva",   
                3,            
                randomNumber,          
                randomNumer1,      
                randomNumber3,     
                "VIVA"          
            );

            // Agregar el objeto a la base de datos
            boolean result = hormigaDao.csCreate(hormiga);
            if (result) {
                System.out.println("Hormiga agregada exitosamente.");
                loadData();
            } else {
                System.out.println("No se pudo agregar la hormiga.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 




    private void handleAlimentar(String alimento, boolean isGeno) {
        CSHormigaDto selectedHormiga = tableView.getSelectionModel().getSelectedItem();
        if (selectedHormiga == null || alimento == null) {
            new Alert(Alert.AlertType.WARNING, "Seleccione una hormiga y un alimento.").showAndWait();
            return;
        }

        try {
            int idAlimento = 0;
            String nuevoTipo = selectedHormiga.getTipoHormiga();

            if (isGeno) {
                switch(alimento) {
                    case "X": idAlimento = 5; nuevoTipo = "Reina"; break;
                    case "XX": idAlimento = 6; nuevoTipo = selectedHormiga.getTipoHormiga().equals("Larva") ? "Soldado" : selectedHormiga.getTipoHormiga() + " mutada"; break;
                    case "XY": idAlimento = 7; nuevoTipo = selectedHormiga.getTipoHormiga().equals("Larva") ? "Zangano" : selectedHormiga.getTipoHormiga() + " mutada"; break;
                }
                selectedHormiga.setIdGenoAlimento(idAlimento);
            } else {
                switch(alimento) {
                    case "Carnivoro": idAlimento = 1; nuevoTipo = "Depredadora"; break;
                    case "Herbívoro": idAlimento = 2; nuevoTipo = "Recolectora"; break;
                    case "Omnivoro": idAlimento = 3; nuevoTipo = "Exploradora"; break;
                    case "Insectivoro": idAlimento = 4; nuevoTipo = "Guerrera"; break;
                }
                selectedHormiga.setIdIngestaNativa(idAlimento);
            }

            selectedHormiga.setTipoHormiga(nuevoTipo);
            csHormigaBL.csUpdate(selectedHormiga);
            loadData();
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("¡La hormiga se ha alimentado y ahora es: " + nuevoTipo + "!");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleEliminar() {
        CSHormigaDto selectedHormiga = tableView.getSelectionModel().getSelectedItem();
        if (selectedHormiga == null) {
            new Alert(Alert.AlertType.WARNING, "Seleccione una hormiga para eliminar (matar).").showAndWait();
            return;
        }
        try {
            boolean resp = csHormigaBL.csDelete(selectedHormiga.getIdCSHormiga());
            if (resp) {
                loadData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try {
            List<CSHormigaDto> hormigaList = csHormigaBL.csGetAll();
            data.setAll(hormigaList);
            int pageCount = (int) Math.ceil((double) data.size() / 5);
            pagination.setPageCount(pageCount == 0 ? 1 : pageCount);
            
            int currentPage = pagination.getCurrentPageIndex();
            tableView.setItems(FXCollections.observableArrayList(
                data.stream()
                    .skip(currentPage * 5)
                    .limit(5)
                    .collect(Collectors.toList())
            ));
            tableView.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private VBox createPage(int pageIndex) {
        VBox box = new VBox();
        tableView.setItems(FXCollections.observableArrayList(
                data.stream()
                    .skip(pageIndex * 5)
                    .limit(5)
                    .collect(Collectors.toList())
        ));
        box.getChildren().add(tableView);
        return box;
    }
}

