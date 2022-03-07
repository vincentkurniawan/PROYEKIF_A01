package com.example.proif_a01_java.Model;
import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Product {
    public String name;
    public String category;
    public int price;
    public String condition;
    public ArrayList<String> photo;
    public int rawCategory;
    public String description;

    public final static int CONDITION_NEW = 0;
    public final static int CONDITION_90 = 1;
    public final static int CONDITION_50 = 2;

    public final static int CATEGORY_MOBILE = 0;
    public final static int CATEGORY_TABLET = 1;

    public Product () {

    }

    public Product(String name, int category, int price, int condition, String description) {
        this.name = name;
        this.price = price;
        this.formatCategory(category);
        this.formatCondition(condition);
        this.description = description;
        this.photo=new ArrayList<>();
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
        this.rawCategory = category;
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
            case "IPHONE 1":
                this.photo.add("@drawable/iphone1");
                this.photo.add("@drawable/iphone1_2");
                this.photo.add("@drawable/iphone1_3");
                break;
            case "IPAD 2":
                this.photo.add("@drawable/ipad2");
                this.photo.add("@drawable/ipad2_2");
                this.photo.add("@drawable/ipad2_3");
                break;
            case "IPAD 3":
                this.photo.add("@drawable/ipad3");
                this.photo.add("@drawable/ipad3_2");
                this.photo.add("@drawable/ipad3_3");
                break;
            case "IPHONE 4":
                this.photo.add("@drawable/iphone4");
                this.photo.add("@drawable/iphone4_2");
                this.photo.add("@drawable/iphone4_3");
                break;
            case "IPHONE 5":
                this.photo.add("@drawable/iphone5");
                this.photo.add("@drawable/iphone5_2");
                this.photo.add("@drawable/iphone5_3");
                break;
            case "IPHONE 6":
                this.photo.add("@drawable/iphone6");
                this.photo.add("@drawable/iphone6_2");
                this.photo.add("@drawable/iphone6-3");
                break;
            case "IPHONE 7":
                this.photo.add("@drawable/iphone7");
                this.photo.add("@drawable/iphone7_2");
                this.photo.add("@drawable/iphone7_3");
                break;
            case "IPHONE 8":
                this.photo.add("@drawable/iphone8");
                this.photo.add("@drawable/iphone8_2");
                this.photo.add("@drawable/iphone8_3");
                break;
            case "IPHONE 10":
                this.photo.add( "@drawable/iphone10");
                this.photo.add( "@drawable/iphone10_2");
                this.photo.add( "@drawable/iphone10_3");
                break;
            case "IPHONE 11":
                this.photo.add("@drawable/iphone11");
                this.photo.add("@drawable/iphone11_2");
                this.photo.add("@drawable/iphone11_3");
                break;
            case "IPHONE 12":
                this.photo.add("@drawable/iphone12");
                this.photo.add("@drawable/iphone12_2");
                this.photo.add("@drawable/iphone12_3");
                break;
            case "IPHONE 13":
                this.photo.add("@drawable/iphone13");
                this.photo.add("@drawable/iphone13_2");
                this.photo.add("@drawable/iphone13_3");
                break;
            case "Samsung Galaxy S22":
                this.photo.add("@drawable/samsungs22");
                this.photo.add("@drawable/samsungs22_2");
                this.photo.add("@drawable/samsungs22_3");
                break;
            case "HUAWEI P50 PRO":
                this.photo.add("@drawable/huaweip50pro");
                this.photo.add("@drawable/huaweip50pro_2");
                this.photo.add("@drawable/huaweip50pro_3");
                break;
            case "IPHONE SE 2020":
                this.photo.add("@drawable/iphonese2020");
                this.photo.add("@drawable/iphonese2020_2");
                this.photo.add("@drawable/iphonese2020_3");
                break;
            case "IPAD 4":
                this.photo.add("@drawable/ipad4");
                this.photo.add("@drawable/ipad4_2");
                this.photo.add("@drawable/ipad4_3");
                break;
            case "XIAOMI MI PAD 5 PRO":
                this.photo.add("@drawable/mipad5pro");
                this.photo.add("@drawable/mipad5pro_2");
                this.photo.add("@drawable/mipad5pro_3");
                break;
            case "XIAOMI MI PAD 4":
                this.photo.add("@drawable/mipad4");
                this.photo.add("@drawable/mipad4_2");
                this.photo.add("@drawable/mipad4_3");
                break;
            case "SAMSUNG GALAXY NOTE 8":
                this.photo.add("@drawable/samsungnote8");
                this.photo.add("@drawable/samsungnote8_2");
                this.photo.add("@drawable/samsungnote8_3");
                break;
            case "XIAOMI POCO X3":
                this.photo.add("@drawable/pocox3");
                this.photo.add("@drawable/pocox3_2");
                this.photo.add("@drawable/pocox3_3");
                break;
            case "XIAOMI POCO M3":
                this.photo.add("@drawable/pocom3");
                this.photo.add("@drawable/pocom3_2");
                this.photo.add("@drawable/pocom3_3");
                break;
            case "SAMSUNG GALAXY FOLD 2":
                this.photo.add("@drawable/samsungfold2");
                this.photo.add("@drawable/samsungfold2_2");
                this.photo.add("@drawable/samsungfold2_3");
                break;
            case "XIAOMI MI PAD 5":
                this.photo.add("@drawable/mipad5");
                this.photo.add("@drawable/mipad5_2");
                this.photo.add("@drawable/mipad5_3");
                break;
            case "XIAOMI POCO F3 PRO":
                this.photo.add("@drawable/pocof3pro");
                this.photo.add("@drawable/pocof3pro_2");
                this.photo.add("@drawable/pocof3pro_3");
                break;
            case "SAMSUNG GALAXY S21":
                this.photo.add("@drawable/samsungs21");
                this.photo.add("@drawable/samsungs21_2");
                this.photo.add("@drawable/samsungs21_3");
                break;
            case "XIAOMI POCO F3 GT":
                this.photo.add("@drawable/pocof3gt");
                this.photo.add("@drawable/pocof3gt_2");
                this.photo.add("@drawable/pocof3gt_3");
                break;
            case "SAMSUNG GALAXY TAB S7":
                this.photo.add("@drawable/samsungtabs7");
                this.photo.add("@drawable/samsungtabs7_2");
                this.photo.add("@drawable/samsungtabs7_3");
                break;
            case "SAMSUNG GALAXY TAB A7":
                this.photo.add("@drawable/samsungtaba7");
                this.photo.add("@drawable/samsungtaba7_2");
                this.photo.add("@drawable/samsungtaba7_3");
                break;
            case "XIAOMI MI PAD 2":
                this.photo.add("@drawable/mipad2");
                this.photo.add("@drawable/mipad2_2");
                this.photo.add("@drawable/mipad2_3");
                break;
            case "XIAOMI NOTE 10":
                this.photo.add("@drawable/note10");
                this.photo.add("@drawable/note10_2");
                this.photo.add("@drawable/note10_3");
                break;
            case "SAMSUNG GALAXY S10":
                this.photo.add("@drawable/samsungs10");
                this.photo.add("@drawable/samsungs10_2");
                this.photo.add("@drawable/samsungs10_3");
                break;
        }
    }
}
