package com.example.java_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button adminButton;

    @FXML
    private Button userButton;

    @FXML
    void onAdminButtonClicked(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("admin-view.fxml"));
            Scene scene = new Scene(root);
            Stage childStage = (Stage) (adminButton.getScene().getWindow());
            childStage.setScene(scene);
            childStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void onUserButtonClicked(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("user-view.fxml"));
            Scene scene = new Scene(root);
            Stage childStage = (Stage) (userButton.getScene().getWindow());
            childStage.setScene(scene);
            childStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
