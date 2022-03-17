package com.example.proif_a01_java.Model;

import android.graphics.drawable.Drawable;

public class Product {
    public String name;
    public String category;
    public int price;
    public String condition;
    public String photo;

    public final static int CONDITION_NEW = 0;
    public final static int CONDITION_90 = 1;
    public final static int CONDITION_50 = 2;

    public final static int CATEGORY_MOBILE = 0;
    public final static int CATEGORY_TABLET = 1;

    public Product(String name, int category, int price, int condition) {
        this.name = name;
        this.price = price;
        this.formatCategory(category);
        this.formatCondition(condition);
        this.setPhoto(name);
    }

    private void formatCondition (int condition) {
        switch (condition){
            case 0:
                this.condition = "NEW";
                break;
            case 1:
                this.condition = "90% CONDITION";
                break;
            case 2:
                this.condition = "50% CONDITION";
                break;
            default:
                this.condition = "";
        }
    }

    private void formatCategory (int category) {
        switch (category){
            case 0:
                this.category = "MOBILE";
                break;
            case 1:
                this.category = "TABLET";
                break;
            default:
                this.category = "";
        }
    }

    private void setPhoto (String name) {
        switch (name){
            case "Iphone 11":
                this.photo = "@drawable/iphone11";
                break;
            default:
                this.photo = "";
        }
    }

    public boolean validateInput(){
        return ((this.condition.equals("NEW") || this.condition.equals("90% CONDITION") || this.condition.equals("50% CONDITION"))
                && (this.category.equals("MOBILE") || this.category.equals("TABLET")));
    }
}
