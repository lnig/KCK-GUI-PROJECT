package com.example.kckgui;

import com.example.kckgui.Controller.productController;
import com.example.kckgui.Controller.shoppingController;
import com.example.kckgui.Model.Class.Product;
import com.example.kckgui.Model.Class.Shopping;
import com.example.kckgui.Model.Class.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.kckgui.HelloApplication.*;

public class Shoppings implements Initializable {

    @FXML
    private ImageView exit;
    @FXML
    private ImageView minimize;
    @FXML
    private Label productsPriceSum;
    @FXML
    private ListView<Product> listViewProducts;
    @FXML
    private ListView<Shopping> listViewShopping;
    @FXML
    private GridPane gridPane;
    private ArrayList<Product> products = productController.getProducts();
    private ArrayList<Shopping> shoppings = shoppingController.getShopping();
    double sum = 0;
    int id = 0;
    int column = 0;
    int row= 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });

        minimize.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
        });

        listViewProducts.getItems().addAll(products);
        refreshViewShopping();

    }

    public void buttonAdd(ActionEvent actionEvent) {
        Product product = listViewProducts.getSelectionModel().getSelectedItem();

      openQuantityDialog(product);

    }

    private void openQuantityDialog(Product product) {
        TextInputDialog dialog = new TextInputDialog();
        DialogPane dialogPane = dialog.getDialogPane();

        dialogPane.getStylesheets().add(
                getClass().getResource("style.css").toExternalForm()
        );

        dialogPane.getStyleClass().add("quantity-dialog-pane");

        dialog.setTitle("Podaj ilość");
        dialog.setGraphic(null);
        dialog.setHeaderText("Podaj ilość produktu " + product.getName());
        dialog.setContentText("Ilość:");

        dialog.showAndWait().ifPresent(quantity -> {
            try {
                int quantityValue = Integer.parseInt(quantity);

                shoppingController.addShopping(new Shopping(product,quantityValue));

            } catch (NumberFormatException e) {
                System.out.println("Wprowadzono nieprawidłową ilość!");
            }
        });

        refreshViewShopping();
    }

    public void refreshViewShopping(){
        gridPane.getChildren().clear();
        column = 0;
        try {
            for (Shopping s: shoppings) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SingleProductInShoppingView.fxml"));
                VBox productBox = fxmlLoader.load();
                productBox.setId("product" + ++id);
                SingleProductInShoppingView singleProductInShoppingView = fxmlLoader.getController();
                singleProductInShoppingView.setData(s.getProduct(), s.getAmount());

                        if (column == 2) {
                            column = 0;
                            ++row;
                        }
                        gridPane.add(productBox, column++, row);
                        GridPane.setMargin(productBox, new Insets(5, 5, 5, 5));
                    }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sum = shoppings.stream().mapToDouble(s -> s.getAmount() * s.getProduct().getPrice()).sum();
        sum*= 100;
        sum = Math.round(sum);
        sum/= 100;
        productsPriceSum.setText("Suma produktow na liscie: " + sum + " $");

    }

}
