package com.example.kckgui;

import com.example.kckgui.Model.Class.Product;
import com.example.kckgui.Model.Type.measureType;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.enums.FloatMode;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.IllegalFormatConversionException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.kckgui.HelloApplication.addProduct;
import static com.example.kckgui.HelloApplication.getList;


public class Products implements Initializable {

    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, String> pName;
    @FXML
    private TableColumn<Product, String> pCategory;
    @FXML
    private TableColumn<Product, Double> pPrice;
    @FXML
    private TableColumn<Product, measureType> pMeasureType;
    @FXML
    private MFXTextField textFieldName;
    @FXML
    private MFXTextField textFieldCategory;
    @FXML
    private MFXTextField textFieldPrice;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView minimize;
    @FXML
    private Label errorMsg;
    @FXML
    private MFXComboBox<measureType> selectMeasureType;
    @FXML
    private AnchorPane content;
    @FXML
    private AnchorPane contentArea;

    private ArrayList<Product> products = getList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
        });

        pName.setCellValueFactory(new PropertyValueFactory<>("name"));
        pCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        pPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        pMeasureType.setCellValueFactory(new PropertyValueFactory<>("measureType"));

        tableView.setPlaceholder(new Label("No items to display."));
        selectMeasureType.getItems().addAll(measureType.values());

        tableView.getItems().setAll(products);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                textFieldName.setText(newValue.getName());
                textFieldCategory.setText(newValue.getCategory());
                textFieldPrice.setText(String.valueOf(newValue.getPrice()));
//                selectMeasureType.setValue(newValue.getMeasureType());
            }
        });

        content.setOnMouseClicked(mouseEvent -> {
            tableView.getSelectionModel().clearSelection();
            clearFields();
            content.requestFocus();
        });
    }

    private void clearFields() {
        textFieldName.clear();
        textFieldCategory.clear();
        textFieldPrice.clear();
        selectMeasureType.clear();
        textFieldName.requestFocus();
        textFieldCategory.requestFocus();
        textFieldPrice.requestFocus();
        selectMeasureType.requestFocus();
        content.requestFocus();
    }



    public void buttonAdd(ActionEvent actionEvent) throws InterruptedException {

        double price = 0;
        String name = "", category = "", priceString = "";
        measureType measureType;

        try {
            if (!textFieldPrice.getText().isEmpty()) {
                priceString = textFieldPrice.getText();
                price = Double.parseDouble(priceString);
                price *= 100;
                price = Math.round(price);
                price /= 100;
            }

            name = textFieldName.getText();
            category = textFieldCategory.getText();
            measureType = selectMeasureType.getValue();

        } catch (NumberFormatException e) {
            e.printStackTrace();
            errorMsg.setText("Nie prawidlowy format ceny");
            return;
        }

        if (name.isEmpty() || category.isEmpty() || priceString.isEmpty() || measureType == null) {
            errorMsg.setText("Wypelnij wszystkie pola");
            return;
        }else {
            errorMsg.setText("");
        }


        Product product = new Product(name, category, price, measureType);
        addProduct(product);

        tableView.getItems().add(product);
        clearFields();

    }


    public void buttonRemove(ActionEvent actionEvent) {

        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
        products.remove(selectedID);

    }

    public void buttonEdit(ActionEvent actionEvent) {

        Product selectedProduct = tableView.getSelectionModel().getSelectedItem();
        int id = tableView.getSelectionModel().getSelectedIndex();

        Product product = products.get(id);

        if (selectedProduct != null) {
            product.setName(textFieldName.getText());
            product.setCategory(textFieldCategory.getText());

            try {
                double price = Double.parseDouble(textFieldPrice.getText());
                price *= 100;
                price = Math.round(price);
                price /= 100;

                product.setPrice(price);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                errorMsg.setText("Invalid price format");
                return;
            }

            product.setMeasureType(selectMeasureType.getValue());
            tableView.refresh();
            clearFields();
        }

    }
}