package CSUserInterface.CSForm;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class CSScrenForm {
    private static final double CSPROGRESS_INCREMENT = 0.01; // Incremento de progreso
    private static final double CSPROGRESS_MAX = 1.0; // Progreso máximo
    CSLogin csLogin = new CSLogin();

    public void csPantallaCarga(Stage csPantalla, Group csGroup, Scene csScene) {
        // Ruta de la imagen de fondo
        Image csbackgroundImage = new Image("biologo.jpg");
        ImageView csImageView = new ImageView(csbackgroundImage);
        csImageView.setFitHeight(800);
        csImageView.setFitWidth(800);
        csImageView.setPreserveRatio(false);

        // Configurar el texto de carga
        Label csLoadingLabel = new Label("Cargando...");
        csLoadingLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-background-color: rgba(0, 1, 0, 0.5);");

        // barra de progreso
        ProgressBar csProgressBar = new ProgressBar(0);
        csProgressBar.setPrefWidth(300);
        csProgressBar.setStyle("-fx-accent: lightgreen;"); 

        // Configurar el diseño de la pantalla de carga
        VBox csVbox = new VBox(10, csLoadingLabel, csProgressBar);
        csVbox.setAlignment(javafx.geometry.Pos.CENTER);
        csVbox.setPadding(new Insets(20)); 
        csVbox.setTranslateY(200);

        // Crear un StackPane para superponer la imagen de fondo y el contenido
        StackPane csStackPane = new StackPane();
        csStackPane.getChildren().addAll(csImageView, csVbox);

        // Configurar la escena
        Scene csScene1 = new Scene(csStackPane, 800, 600);
        csPantalla.setTitle("Pantalla de Carga");
        csPantalla.setScene(csScene1);
        csPantalla.show();

        // Simular la carga con una animación
        Timeline csTimeline = new Timeline();
        KeyFrame csKeyFrame = new KeyFrame(Duration.millis(50), e -> {
            double csProgress = csProgressBar.getProgress() + CSPROGRESS_INCREMENT;
            if (csProgress > CSPROGRESS_MAX) {
                csProgress = CSPROGRESS_MAX;
                csTimeline.stop();
                csLogin.csInicio(csPantalla, csGroup, csScene);
            }
            csProgressBar.setProgress(csProgress);
        });
        csTimeline.getKeyFrames().add(csKeyFrame);
        csTimeline.setCycleCount(Timeline.INDEFINITE);
        csTimeline.play();
    }
}
