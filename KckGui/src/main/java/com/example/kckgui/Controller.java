package com.example.kckgui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

    @FXML
    private ImageView exit;

    @FXML
    private Circle avatar;

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

        Image img = new Image("C:\\Users\\dmier\\Desktop\\KckGui\\KckGui\\src\\main\\resources\\images\\icons8-avatar-96.png");
        avatar.setFill(new ImagePattern(img));


    }

    @FXML
    private void loadTasksView() {
        loadView("TasksView.fxml");
    }

    @FXML
    private void loadProductsView() {
        loadView("ProductsView.fxml");
    }

    @FXML
    private void loadShoppingView() {
        loadView("ShoppingView.fxml");
    }

    private void loadView(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = loader.load();
            contentArea.getChildren().setAll(root);
        } catch (IOException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
