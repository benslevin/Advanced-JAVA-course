

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("paint-on-pane.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Drawing Class");
        stage.setScene(scene);
        stage.show();
    }

    //The program creates a pane witch you can draw different shapes with different colors
    //You also have an 'undo' and 'clear' button for use
    public static void main(String[] args) {
        launch();
    }
}