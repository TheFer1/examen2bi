package examen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.Group;
import javafx.stage.Stage;
import CSBusinessLogic.CSAlimentoBL;
import CSBusinessLogic.CSHormigaBL;
import CSUserInterface.CSForm.CSScrenForm;



public class App extends Application {


    @Override
    public void start(@SuppressWarnings("exports") Stage csStage) throws Exception {
        
      Group csGroup = new Group(); 
      Scene csScene = new Scene(csGroup,800,600);
      CSScrenForm cs = new CSScrenForm() ; 
      cs.csPantallaCarga(csStage, csGroup, csScene);
       Image csImage = new Image("icon.jpg");
      csStage.getIcons().add(csImage);
      CSAlimentoBL csbl = new CSAlimentoBL() ; 
      CSHormigaBL bl = new CSHormigaBL() ;
        


     

        

        






//        Label cedulaLabel = new Label("Cedula del Alumno:");
//        TextField cedulaTextField = new TextField();
//
//        Label nombresLabel = new Label("Nombres del Alumno:");
//        TextField nombresTextField = new TextField();
//
//        Label laboratorioLabel = new Label("Laboratorio de mutación:");
//
//        Button crearAnimalButton = new Button("crear animal");
//        Button alimentarAnimalButton = new Button("alimentar animal");
//
//        ComboBox<String> genoAlimentoComboBox = new ComboBox<>();
//        genoAlimentoComboBox.getItems().addAll("GenoAlimento1", "GenoAlimento2", "GenoAlimento3");
//
//        Button eliminarButton = new Button("Eliminar");
//        Button guardarButton = new Button("Guardar");
//
//        // Layout
//        GridPane gridPane = new GridPane();
//        gridPane.setVgap(10);
//        gridPane.setHgap(10);
//
//        gridPane.add(cedulaLabel, 0, 0);
//        gridPane.add(cedulaTextField, 1, 0);
//
//        gridPane.add(nombresLabel, 0, 1);
//        gridPane.add(nombresTextField, 1, 1);
//
//        gridPane.add(laboratorioLabel, 0, 2, 2, 1);
//
//        // Espacio para los botones de mutación
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                gridPane.add(new Button(), i, j + 3); // Añadir botones vacíos como placeholders
//            }
//        }
//
//        gridPane.add(crearAnimalButton, 3, 3, 1, 1);
//        gridPane.add(alimentarAnimalButton, 3, 4, 1, 1);
//
//        gridPane.add(genoAlimentoComboBox, 1, 6);
//
//        gridPane.add(eliminarButton, 0, 7);
//        gridPane.add(guardarButton, 1, 7);
//
//        // Crear el Group y añadir el GridPane
//        Group csGroup = new Group(gridPane);
//        scene = new Scene(csGroup, 800, 500);
//
//        // Configurar el escenario
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) throws Exception {
  

        launch();
    }
}
