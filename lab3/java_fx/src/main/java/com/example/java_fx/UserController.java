package com.example.java_fx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import storage.TourPlanStorage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class UserController {
    @FXML
    private TableColumn<TourPlan, String> destinationColumn;

    @FXML
    private Button sortPlansAscButton;

    @FXML
    private TableColumn<TourPlan, Double> priceColumn;

    @FXML
    private TextField priceField;

    @FXML
    private Label priceTextFieldLabel;

    @FXML
    private Button showFilteredPlansButton;

    @FXML
    private Button showPlansButton;

    @FXML
    private Button sortPlansDescButton;

    @FXML
    private Button submitFilterButton;

    @FXML
    private Label toMainLabel;

    @FXML
    private Label toHomeLabel;

    @FXML
    private TableView<TourPlan> tourPlanTable;

    public void initialize() {
        tourPlanTable.setVisible (false);
        destinationColumn.setCellValueFactory(new PropertyValueFactory<TourPlan, String> ("destination"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<TourPlan, Double>("price"));
        tourPlanTable.setItems(FXCollections.observableArrayList());
    }

    @FXML
    void onToHomeClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)showPlansButton.getScene ().getWindow ();
        stage.setTitle("Выберите режим");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void onShowFilteredPlansButton(ActionEvent event) {
        showFilteredPlansButton.setVisible (false);
        showPlansButton.setVisible (false);
        sortPlansDescButton.setVisible (false);
        sortPlansAscButton.setVisible (false);
        toHomeLabel.setVisible (false);

        priceField.setVisible (true);
        priceTextFieldLabel.setVisible (true);
        tourPlanTable.setVisible(true);
        priceColumn.setVisible (true);
        destinationColumn.setVisible (true);
        toMainLabel.setVisible (true);
        submitFilterButton.setVisible (true);

        tourPlanTable.setItems (FXCollections.observableArrayList(TourPlanStorage.getTours ()));
    }

    @FXML
    void onShowPlansButton(ActionEvent event) {
        showFilteredPlansButton.setVisible (false);
        showPlansButton.setVisible (false);
        sortPlansDescButton.setVisible (false);
        sortPlansAscButton.setVisible (false);
        priceField.setVisible (false);
        priceTextFieldLabel.setVisible (false);
        toHomeLabel.setVisible (false);

        tourPlanTable.setVisible(true);
        priceColumn.setVisible (true);
        destinationColumn.setVisible (true);
        toMainLabel.setVisible (true);

        tourPlanTable.setItems (FXCollections.observableArrayList(TourPlanStorage.getTours ()));
    }

    @FXML
    void onSortPlansAscButton(ActionEvent event) {
        showFilteredPlansButton.setVisible (false);
        showPlansButton.setVisible (false);
        sortPlansDescButton.setVisible (false);
        sortPlansAscButton.setVisible (false);
        priceField.setVisible (false);
        priceTextFieldLabel.setVisible (false);
        toHomeLabel.setVisible (false);

        tourPlanTable.setVisible(true);
        priceColumn.setVisible (true);
        destinationColumn.setVisible (true);
        toMainLabel.setVisible (true);

        tourPlanTable.setItems (FXCollections.observableArrayList(TourPlanStorage.getToursSortedByPrice ()));
    }

    @FXML
    void onSortPlansDescButton(ActionEvent event) {
        showFilteredPlansButton.setVisible (false);
        showPlansButton.setVisible (false);
        sortPlansDescButton.setVisible (false);
        sortPlansAscButton.setVisible (false);
        priceField.setVisible (false);
        priceTextFieldLabel.setVisible (false);
        toHomeLabel.setVisible (false);

        tourPlanTable.setVisible(true);
        priceColumn.setVisible (true);
        destinationColumn.setVisible (true);
        toMainLabel.setVisible (true);

        tourPlanTable.setItems (FXCollections.observableArrayList(TourPlanStorage.getToursSortedByPriceDesc ()));
    }

    @FXML
    void onToMainMenuClicked(MouseEvent event) {
        switchToMain ();
    }

    @FXML
    void onSubmitFilter(ActionEvent event) {
        if(priceField.getText ().isEmpty ()){
            showAlert(Alert.AlertType.ERROR, priceField.getScene().getWindow(), "Ошибка формы!", "Пожалуйста, заполните все поля!");
            return;
        }

        try {
            var price = Double.parseDouble (priceField.getText ());
            tourPlanTable.setItems (FXCollections.observableArrayList(TourPlanStorage.getToursFilteredByPrice(price)));
        }
       catch (Exception exception){
           showAlert(Alert.AlertType.ERROR, priceField.getScene().getWindow(), "Ошибка формы!", "Неверный формат данных");
       }
    }

    private void switchToMain()
    {
        priceField.clear();
        priceField.setVisible (false);
        tourPlanTable.setVisible(false);
        destinationColumn.setVisible (false);
        priceColumn.setVisible (false);
        priceTextFieldLabel.setVisible (false);
        toMainLabel.setVisible (false);
        submitFilterButton.setVisible (false);

        sortPlansDescButton.setVisible (true);
        sortPlansAscButton.setVisible (true);
        showPlansButton.setVisible (true);
        showFilteredPlansButton.setVisible (true);
        toHomeLabel.setVisible (true);
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}