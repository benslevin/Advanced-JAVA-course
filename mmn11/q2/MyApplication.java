
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("MyProgram.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 500);
        stage.setTitle("MyProgram");
        stage.setScene(scene);
        stage.show();
    }

    // The program opens a window with a grid on it, when the button in the top left corner is pressed
    // 10% of the cells will be filled automatically
    public static void main(String[] args) {
        launch();

    }
}