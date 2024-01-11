package com.example.kckgui.Controller;


import com.example.kckgui.Model.Class.Product;
import com.example.kckgui.Model.Class.Shopping;
import java.util.ArrayList;
import java.util.List;



public class shoppingController {

    private static ArrayList<Shopping> listOfShopping = new ArrayList<>();

    public static void addShopping(Shopping shopping){
        listOfShopping.add(shopping);
    }


    public static void removeShopping(int selected){
        listOfShopping.remove(selected);
    }

    public static ArrayList<Shopping> getShopping() {
        return listOfShopping;
    }



}
