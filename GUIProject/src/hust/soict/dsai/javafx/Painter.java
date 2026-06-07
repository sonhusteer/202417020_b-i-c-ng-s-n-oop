package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Lab 05 – Section 4.3: Painter JavaFX Application.
 * Khởi động ứng dụng vẽ từ file FXML.
 */
public class Painter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlUrl = getClass().getResource("Painter.fxml");
        if (fxmlUrl == null) {
            throw new RuntimeException("Cannot find Painter.fxml");
        }

        Parent root = FXMLLoader.load(fxmlUrl);
        Scene scene = new Scene(root);

        primaryStage.setTitle("Painter – Lab 05");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
