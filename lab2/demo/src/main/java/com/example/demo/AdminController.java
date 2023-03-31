package com.example.demo;

import com.example.demo.model.TourPlan;
import com.example.demo.model.data.Storage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private TextField destinationToDeleteField;
    @FXML
    private Button deleteTourSubmitButton;
    @FXML
    private Button addTourSubmitButton;
    @FXML
    private Button addTourButton;
    @FXML
    private Button deleteTourButton;
    @FXML
    private Button editTourButton;
    @FXML
    private Label toAdminMenu;
    @FXML
    private TableView<TourPlan> table;
    @FXML
    private TableColumn<TourPlan, String> destinationColumn;
    @FXML
    private TableColumn<TourPlan, Double> priceColumn;
    @FXML
    private Label toMainMenu;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField destinationTextField;

    private boolean submitClicked = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    void onToAdminMenuClicked(MouseEvent event) throws IOException {
        Stage window = (Stage) toAdminMenu.getScene ().getWindow ();
        switchScene ("admin-view.fxml", "Tourist application", window);
    }

    @FXML
    void onAddTourClick(ActionEvent event) throws IOException {
        Stage window = (Stage) addTourButton.getScene ().getWindow ();
        switchScene ("add-tour-dialog-view.fxml", "Add tour", window);
    }
    @FXML
    void onAddTourSubmitClick(ActionEvent event) throws IOException {
        String destination = destinationTextField.getText ();
        String price = priceTextField.getText ();
        TourPlan newTour = new TourPlan(destination, Double.parseDouble (price));
        Storage.insertTour (newTour);
        Stage window = (Stage) toAdminMenu.getScene ().getWindow ();
        switchScene ("admin-view.fxml", "Tourist application", window);
    }

    @FXML
    void onDeleteTourClick(ActionEvent event) throws IOException {
        Stage window = (Stage) deleteTourButton.getScene ().getWindow ();
        switchScene ("delete-tour-view.fxml", "Delete panel", window);

        table.setItems (Storage.getTours ());
    }

    @FXML
    void onDeleteTourSubmitClick(ActionEvent event) throws IOException {
        Storage.deleteTourByDestination (destinationToDeleteField.getText ());

        Stage window = (Stage) deleteTourButton.getScene ().getWindow ();
        switchScene ("user-view.fxml", "User panel", window);
    }

    @FXML
    void onEditTourClick(ActionEvent event) {

    }

    @FXML
    void onAdminButtonClick(ActionEvent event) throws IOException {
        Stage window = (Stage) toMainMenu.getScene ().getWindow ();
        switchScene ("admin-view.fxml", "Admin panel", window);
    }
    @FXML
    void onToMainMenuClicked(ActionEvent event) throws IOException {
        Stage window = (Stage) toMainMenu.getScene ().getWindow ();
        switchScene ("tourist-view.fxml", "Tourist application", window);
    }

    void switchScene(String name, String title, Stage window) throws IOException {
        Parent root =  FXMLLoader.load (getClass().getResource(name));
        window.setScene (new Scene (root,600, 400));
        window.setTitle(title);
    }

    private boolean validateInput() {
        boolean isValid = true;
        if (destinationTextField.getText().isEmpty()) {
            destinationTextField.setStyle("-fx-background-color: pink;");
            isValid = false;
        }
        if (priceTextField.getText().isEmpty()) {
            priceTextField.setStyle("-fx-background-color: pink;");
            isValid = false;
        }

        return isValid;
    }
}
