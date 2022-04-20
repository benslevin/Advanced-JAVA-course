

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("4-in-a-row.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("4 in a row game");
        stage.setScene(scene);
        stage.show();
    }

    //This application is a '4 in a row' game, with graphic and logic classes for the convenience of the players
    public static void main(String[] args) {
        launch();
    }
}