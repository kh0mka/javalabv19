package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteTourController implements Initializable {
    @FXML
    private Button deleteTourButton;

    @FXML
    private TableColumn<?, ?> destinationColumn;

    @FXML
    private TextField destinationToDeleteField;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    void onDeleteTourClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        destinationColumn.setCellValueFactory (new PropertyValueFactory<> ("destination"));
        priceColumn.setCellValueFactory (new PropertyValueFactory<> ("price"));
    }
}
