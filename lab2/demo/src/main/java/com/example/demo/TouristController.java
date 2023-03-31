package com.example.demo;

import com.example.demo.model.TourPlan;
import com.example.demo.model.data.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.*;

public class TouristController implements Initializable {
    @FXML
    private Button adminButton;
    @FXML
    private Button userButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onAdminButtonClick(ActionEvent event) throws IOException {
        Stage window = (Stage) adminButton.getScene ().getWindow ();
        switchScene ("admin-view.fxml", "Admin panel", window);
    }

    @FXML
    void onUserButtonClick(ActionEvent event) throws IOException {
        Stage window = (Stage) userButton.getScene ().getWindow ();
        switchScene ("user-view.fxml", "User panel", window);
    }

    void switchScene(String name, String title, Stage window) throws IOException {
        Parent root =  FXMLLoader.load (getClass().getResource(name));
        window.setScene (new Scene (root,600, 400));
        window.setTitle(title);
    }
}
