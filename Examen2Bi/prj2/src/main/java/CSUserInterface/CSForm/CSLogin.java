package CSUserInterface.CSForm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CSLogin {
    EcuaFauna2K24A csEcuaFauna2K24A = new EcuaFauna2K24A() ;
    public void csInicio (Stage csSTage, Group csGroup, Scene csScene){
        Label csUserLabel = new Label("Usuario:");
        TextField csUserTextField = new TextField();

        Label csNameLabel = new Label("Password:");
        PasswordField csPasswordField = new PasswordField();  

        Button csLoginButton = new Button("Iniciar sesión");

        // Evento al hacer clic en el botón de inicio de sesión
        csLoginButton.setOnAction(e -> {
            String csUsername = csUserTextField.getText().trim();
            String csPassword = csPasswordField.getText().trim();
            
            // Validación básica
            if ("admin".equals(csUsername) && "1234".equals(csPassword)) {
                System.out.println("¡Inicio de sesión exitoso!");
                csEcuaFauna2K24A.CSFormulario(csSTage);
                
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
            }
        });

        GridPane csGridPane = new GridPane();
        csGridPane.setAlignment(Pos.CENTER);
        csGridPane.setPadding(new Insets(10));
        csGridPane.setHgap(10);
        csGridPane.setVgap(10);

        csGridPane.add(csUserLabel, 0, 0);
        csGridPane.add(csUserTextField, 1, 0);
        csGridPane.add(csNameLabel, 0, 1);
        csGridPane.add(csPasswordField, 1, 1);
        csGridPane.add(csLoginButton, 1, 2);

        csGridPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8);"); 

        csNameLabel.setStyle("-fx-background-color: white; -fx-border-color: lightgray; -fx-padding: 5px;");
        csPasswordField.setStyle("-fx-background-color: white; -fx-border-color: lightgray; -fx-padding: 5px;");
        csLoginButton.setStyle("-fx-background-color: lightblue; -fx-border-color: gray;");

        Image backgroundImage = new Image("icon.jpg"); 
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(800);
        backgroundImageView.setFitHeight(600);
        backgroundImageView.setPreserveRatio(false);

        // Crear un StackPane para superponer la imagen de fondo y el GridPane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(backgroundImageView, csGridPane);
        
        csScene = new Scene(stackPane, 800, 600);
        csSTage.setTitle("Pantalla de Login");
        csSTage.setScene(csScene);

        csSTage.show();

        
    }



}
