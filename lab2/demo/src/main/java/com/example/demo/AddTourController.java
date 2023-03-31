package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTourController implements Initializable {
    @FXML
    private Button addTourSubmitButton;

    @FXML
    private TextField destinationTextField;

    @FXML
    private TextField priceTextField;

    public AddTourController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        destinationTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                destinationTextField.setStyle("-fx-background-color: pink;");
            } else {
                destinationTextField.setStyle("");
            }
        });

        priceTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                priceTextField.setStyle("-fx-background-color: pink;");
            } else {
                priceTextField.setStyle("");
            }
        });
    }
}
