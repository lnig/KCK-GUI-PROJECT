package com.example.kckgui;

import com.example.kckgui.Model.Class.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SingleProductInShoppingView {

    @FXML
    private Label productName;

    @FXML
    private Label productPrice;
    @FXML
    private Label productAmount;

    public void setData(Product product, int amount) {
        productName.setText(product.getName());
        productPrice.setText(product.getPrice().toString() + " $");
        productAmount.setText(String.valueOf(amount));
    }


}
