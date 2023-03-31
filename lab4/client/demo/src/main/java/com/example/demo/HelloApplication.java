package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets (25, 25, 25, 25));

        Label titleLabel = new Label("Search Sentences in Text");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(titleLabel, 0, 0, 2, 1);

        Label queryLabel = new Label("Search Query:");
        gridPane.add(queryLabel, 0, 1);

        TextField queryField = new TextField();
        gridPane.add(queryField, 1, 1);

        Button searchButton = new Button("Search");
        gridPane.add(searchButton, 1, 2);

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        gridPane.add(resultArea, 0, 3, 2, 1);

        Scene scene = new Scene(gridPane, 600, 400);
        stage.setTitle("TCP Client");
        stage.setScene(scene);
        stage.show();

        searchButton.setOnAction(event -> {
            try (
                    Socket clientSocket = new Socket("localhost", 5000);
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()))
            ) {

                String query = queryField.getText().trim ();

                if(query.equals (""))
                {
                    resultArea.setText("THE INPUT IS EMPTY");
                }
                else{
                    out.println(query);
                    String response = in.readLine();
                    response = response.replace ("*EOS", ".    \n");
                    resultArea.setText(response);
                }
            }
            catch (Exception e) {
                resultArea.setText(e.getMessage ());
            }
        });
    }

    public static void main(String[] args) {
        launch ();
    }
}