package com.example.kckgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Shopping implements Initializable {

    @FXML
    private ImageView exit;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private ImageView minimize;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
        });


    }

    public void buttonAdd(ActionEvent actionEvent) {

    }
}
