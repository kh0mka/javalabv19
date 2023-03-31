package com.example.java_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TouristApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Выберите режим");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch ();
    }
}