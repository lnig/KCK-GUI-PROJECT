package com.example.kckgui;

import com.example.kckgui.Controller.familyMemberController;
import com.example.kckgui.Controller.productController;
import com.example.kckgui.Model.Class.Product;
import com.example.kckgui.Model.Class.familyMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HomeController implements Initializable {
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


    public boolean canGoToTasksView(){
       List<familyMember> list = familyMemberController.getFamilyMembers();
       return !list.isEmpty();
    }

    public boolean canGoToShoppingView(){

        List<Product> list = productController.getProducts();
        return !list.isEmpty();

    }
    @FXML
    private void loadTasksView() {
        if (canGoToTasksView()) {
            loadView("TasksView.fxml");
        }else {
            showAlert("Podaj czlonkow rodziny");
        }
    }
    @FXML
    private void loadProductsView() {
            loadView("ProductsView.fxml");

    }
    @FXML
    private void loadShoppingView() {
        if (canGoToShoppingView()) {
            loadView("ShoppingView.fxml");
        }else {
            showAlert("Dodaj produkty do zakladki Produkty");
        }
    }
    

    private void loadView(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = loader.load();
            contentArea.getChildren().setAll(root);
        } catch (IOException e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void loadFamilyView(ActionEvent actionEvent) {
        loadView("familyView.fxml");
    }
}
