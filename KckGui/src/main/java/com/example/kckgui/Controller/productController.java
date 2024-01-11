package com.example.kckgui.Controller;

import com.example.kckgui.Model.Class.Product;
import com.example.kckgui.Model.Type.measureType;

import java.util.ArrayList;
import java.util.List;

public class productController {


    private static ArrayList<Product> listOfProduct = new ArrayList<>(DataProduct());

    public static void addProduct(Product product){
        listOfProduct.add(product);
    }


    public static void removeProduct(int selected){
        listOfProduct.remove(selected);
    }

    public static ArrayList<Product> getProducts() {
//        listOfProduct.addAll(DataProduct());
        return listOfProduct;
    }

    public static List<Product> DataProduct(){

        List<Product> list = new ArrayList<>();

        list.add(new Product("Chleb", "Zywnosc", 2.1, measureType.SZT));
        list.add(new Product("Mleko", "Nabial", 3.5, measureType.SZT));
        list.add(new Product("Jogurt", "Nabial", 2.0, measureType.SZT));
        list.add(new Product("Jajka", "Nabial", 5.99, measureType.SZT));
        list.add(new Product("Ryż", "Produkty zbożowe", 7.5, measureType.KG));
        list.add(new Product("Marchewka", "Warzywa", 1.8, measureType.KG));
        list.add(new Product("Pomarańcze", "Owoce", 4.99, measureType.KG));
        list.add(new Product("Woda mineralna", "Napoje", 2.49, measureType.SZT));
        list.add(new Product("Szynka", "Wędlina", 15.99, measureType.KG));
        list.add(new Product("Papier toaletowy", "Artykuły gospodarstwa domowego", 3.79, measureType.SZT));

        return list;
    }

}
