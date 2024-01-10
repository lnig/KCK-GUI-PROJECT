package com.example.kckgui.Model.Class;

import com.example.kckgui.Model.Type.measureType;

public class Product {

    private String pName;
    private String pCategory;
    private Double pPrice;
    private measureType pMeasureType;

    public String getName() {
        return pName;
    }

    public String getCategory() {
        return pCategory;
    }

    public Double getPrice() {
        return pPrice;
    }

    public measureType getMeasureType() {
        return pMeasureType;
    }

    public void setName(String pName) {
        this.pName = pName;
    }

    public void setCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    public void setPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public void setMeasureType(measureType pMeasureType) {
        this.pMeasureType = pMeasureType;
    }

    public Product(String pName, String pCategory, Double pPrice, measureType pMeasureType) {
        this.pName = pName;
        this.pCategory = pCategory;
        this.pPrice = pPrice;
        this.pMeasureType = pMeasureType;
    }

    @Override
    public String toString() {
        return pName + "     " + pPrice + "$";
    }
}
