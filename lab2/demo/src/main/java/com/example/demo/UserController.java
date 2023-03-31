package com.example.demo;

import com.example.demo.model.TourPlan;
import com.example.demo.model.data.Storage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    private Button viewPrivelegedDestinationsButton;
    @FXML
    private Button viewToursButton;
    @FXML
    private Button showCommonPriceButton;
    @FXML
    private Button addFilterButton;
    @FXML
    private TableView<TourPlan> table;
    @FXML
    private TableColumn<TourPlan, String> destinationColumn;
    @FXML
    private Label toMainMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    @FXML
    void onViewPrivelegedClick(ActionEvent event) {

    }

    @FXML
    void onCalculatePriceClick(ActionEvent event) throws IOException {
        var tours = Storage.getTours ();
        double commonPrice = tours.stream()
                .mapToDouble(TourPlan::getPrice)
                .sum();

        Stage stage = (Stage) showCommonPriceButton.getScene ().getWindow ();
        stage.setTitle("CommonPrice");

        Text t = new Text (10, 10, "Common price: " + commonPrice);
        Group root = new Group(t);
        t.setX(10.0f);
        t.setY(10.0f);

        Scene scene = new Scene(root, 200, 200);
        stage.setScene (scene);
        stage.show ();
    }

    @FXML
    void onViewToursClick(ActionEvent event) {
        var tours = Storage.getTours ();

        table.setItems (tours);

        double commonPrice = tours.stream()
                .mapToDouble(TourPlan::getPrice)
                .sum();
        Text t = new Text (10, 10, "Common price: " + commonPrice);

        table.setVisible (true);
    }

    @FXML
    void onToMainMenuClicked(MouseEvent event) throws IOException {
        Stage window = (Stage) toMainMenu.getScene ().getWindow ();
        switchScene ("tourist-view.fxml", "Tourist application", window);
    }

    @FXML
    void onAddFilterClick (MouseEvent event)  {

    }

    void switchScene(String name, String title, Stage window) throws IOException {
        Parent root =  FXMLLoader.load (getClass().getResource(name));
        window.setScene (new Scene (root,600, 400));
        window.setTitle(title);
    }
}
