package com.example.java_fx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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

import java.io.IOException;

public class AdminController {
    @FXML
    private Button addPlanButton;
    @FXML
    private Button deletePlanButton;
    @FXML
    private Button editPlanButton;

    @FXML
    private Button submitAddPlanButton;
    @FXML
    private Button submitDeletePlanButton;
    @FXML
    private Button submitEditPlanButton;
    @FXML
    private Label toMainLabel;
    @FXML
    private Label toHomeLabel;
    @FXML
    private TextField destinationField;
    @FXML
    private TextField priceField;
    @FXML
    private TableView<TourPlan> tourPlanTable;

    @FXML
    private Label destinationTextFieldLabel;

    @FXML
    private Label priceTextFieldLabel;

    @FXML
    private TableColumn<TourPlan, Double> priceColumn;
    @FXML
    private TableColumn<TourPlan, String> destinationColumn;

    public void initialize() {
        var tourPlans = TourPlanStorage.getTours ();

        tourPlanTable.setVisible (false);
        destinationColumn.setCellValueFactory(new PropertyValueFactory<TourPlan, String> ("destination"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<TourPlan, Double>("price"));
        tourPlanTable.setItems(FXCollections.observableArrayList(tourPlans));
    }

    @FXML
    void onToHomeClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)addPlanButton.getScene ().getWindow ();
        stage.setTitle("Выберите режим");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void onAddPlanButton(ActionEvent event) {
        destinationField.clear();
        priceField.clear();
        addPlanButton.setVisible (false);
        editPlanButton.setVisible (false);
        deletePlanButton.setVisible (false);
        submitDeletePlanButton.setVisible (false);
        submitEditPlanButton.setVisible (false);
        toHomeLabel.setVisible (false);

        destinationField.setVisible (true);
        priceField.setVisible (true);
        priceTextFieldLabel.setVisible (true);
        destinationTextFieldLabel.setVisible (true);
        submitAddPlanButton.setVisible (true);
        toMainLabel.setVisible (true);
    }

    @FXML
    void onDeletePlanButton(ActionEvent event) {
        addPlanButton.setVisible (false);
        editPlanButton.setVisible (false);
        deletePlanButton.setVisible (false);
        submitAddPlanButton.setVisible (false);
        submitEditPlanButton.setVisible (false);
        destinationField.setVisible (false);
        destinationTextFieldLabel.setVisible (false);
        toHomeLabel.setVisible (false);

        tourPlanTable.setVisible(true);
        priceColumn.setVisible (true);
        destinationColumn.setVisible (true);
        submitDeletePlanButton.setVisible (true);
        toMainLabel.setVisible (true);
    }

    @FXML
    void onEditPlanButton(ActionEvent event) {
        destinationField.clear();
        priceField.clear();
        addPlanButton.setVisible (false);
        editPlanButton.setVisible (false);
        deletePlanButton.setVisible (false);
        submitDeletePlanButton.setVisible (false);
        submitAddPlanButton.setVisible (false);
        toHomeLabel.setVisible (false);

        destinationField.setVisible (true);
        priceField.setVisible (true);
        priceTextFieldLabel.setVisible (true);
        destinationTextFieldLabel.setVisible (true);
        submitEditPlanButton.setVisible (true);
        toMainLabel.setVisible (true);
    }

    @FXML
    void onToMainMenuClicked(MouseEvent event) {
        switchToMain();
    }

    @FXML
    void onSubmitDeletePlanButton(ActionEvent event) {
        var tour = tourPlanTable.getSelectionModel ().getSelectedItem ();
        if(tour == null) {
            showAlert(Alert.AlertType.ERROR, tourPlanTable.getScene().getWindow(), "Ошибка формы!", "Выберите тур для удаления!");
            return;
        }

        TourPlanStorage.deleteTour (tour.destination);

        tourPlanTable.setItems (FXCollections.observableArrayList(TourPlanStorage.getTours ()));

        switchToMain ();
        showAlert(Alert.AlertType.INFORMATION, addPlanButton.getScene().getWindow(), "Успех!", "Туристический план успешно удалён.");
    }

    @FXML
    void onSubmitEditPlanButton(ActionEvent event) {
        if(!validateTextFields()) return;

        try{
            var destination = destinationField.getText ();
            var price = Double.parseDouble (priceField.getText ());

            var tourPlan = new TourPlan (destination, price);
            var isUpdated = TourPlanStorage.editTour (tourPlan);
            if(!isUpdated){
                showAlert(Alert.AlertType.ERROR, destinationField.getScene().getWindow(), "Ошибка формы!", "План не был изменён.");
                return;
            }

            tourPlanTable.setItems (FXCollections.observableArrayList(TourPlanStorage.getTours ()));

            switchToMain ();
            showAlert(Alert.AlertType.INFORMATION, addPlanButton.getScene().getWindow(), "Успех!", "Туристический план успешно изменён.");
        }
        catch (Exception exception){
            showAlert(Alert.AlertType.ERROR, destinationField.getScene().getWindow(), "Ошибка формы!", "Неверный формат данных");
        }
    }

    @FXML
    void onSubmitAddPlanButton(ActionEvent event) {
        if(!validateTextFields()) return;

        try{
            var destination = destinationField.getText ();
            var price = Double.parseDouble (priceField.getText ());

            var tourPlan = new TourPlan (destination, price);
            TourPlanStorage.insertTour (tourPlan);

            tourPlanTable.setItems (FXCollections.observableArrayList(TourPlanStorage.getTours ()));

            switchToMain ();
            showAlert(Alert.AlertType.INFORMATION, addPlanButton.getScene().getWindow(), "Успех!", "Туристический план успешно добавлен.");
        }
        catch (Exception exception){
            showAlert(Alert.AlertType.ERROR, destinationField.getScene().getWindow(), "Ошибка формы!", "Неверный формат данных");
        }
    }


    private boolean validateTextFields(){
        if(destinationField.getText().isEmpty() || priceField.getText ().isEmpty ()) {
            showAlert(Alert.AlertType.ERROR, destinationField.getScene().getWindow(), "Ошибка формы!", "Пожалуйста, заполните все поля!");
            return false;
        }

        if(destinationField.getText().length () < 4) {
            showAlert(Alert.AlertType.ERROR, destinationField.getScene().getWindow(), "Ошибка формы!", "Название пункта должно содержать 4 и более символов.");
            return false;
        }

        return true;
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    private void switchToMain()
    {
        destinationField.clear();
        priceField.clear();
        destinationField.setVisible (false);
        priceField.setVisible (false);
        tourPlanTable.setVisible(false);
        destinationColumn.setVisible (false);
        priceColumn.setVisible (false);
        destinationTextFieldLabel.setVisible (false);
        priceTextFieldLabel.setVisible (false);
        toMainLabel.setVisible (false);
        submitEditPlanButton.setVisible (false);
        submitAddPlanButton.setVisible (false);
        submitDeletePlanButton.setVisible (false);

        deletePlanButton.setVisible (true);
        addPlanButton.setVisible (true);
        editPlanButton.setVisible (true);
        toHomeLabel.setVisible (true);
    }
}
