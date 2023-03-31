package com.example.demo;

import com.example.demo.model.data.Storage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TouristApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Storage.initialize ();
        FXMLLoader fxmlLoader = new FXMLLoader (TouristApplication.class.getResource ("tourist-view.fxml"));
        Scene scene = new Scene (fxmlLoader.load (), 400, 600);
        stage.setTitle ("Tourists Application");
        stage.setScene (scene);
        stage.show ();
    }

    public static void main(String[] args) {
        launch ();
    }
}