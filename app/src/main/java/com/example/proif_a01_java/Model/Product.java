package com.example.proif_a01_java.Model;

import android.graphics.drawable.Drawable;

public class Product {
    public String name;
    public String category;
    public int price;
    public int condition;
    public String photo;

    public Product(String name, String category, int price, int condition,String photo) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.condition = condition;
        this.photo=photo;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {

        return category;
    }

    public int getPrice() {
        return price;
    }

    public String getCondition() {
        if(condition==1){
            return "Brand New";
        }else if(condition==2){
            return "Almost New";
        }else{
            return "Second";
        }
    }

    public String getPhoto() {
        return  photo;
    }
}
