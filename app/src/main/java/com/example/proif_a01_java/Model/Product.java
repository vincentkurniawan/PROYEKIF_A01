package com.example.proif_a01_java.Model;
import org.parceler.Parcel;

@Parcel
public class Product {
    public String name;
    public String category;
    public int price;
    public String condition;
    public String photo;
    public int rawCategory;

    public final static int CONDITION_NEW = 0;
    public final static int CONDITION_90 = 1;
    public final static int CONDITION_50 = 2;

    public final static int CATEGORY_MOBILE = 0;
    public final static int CATEGORY_TABLET = 1;

    public Product () {

    }

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
                this.photo = "@drawable/iphone1";
                break;
            case "IPAD 2":
                this.photo = "@drawable/ipad2";
                break;
            case "IPAD 3":
                this.photo = "@drawable/ipad3";
                break;
            case "IPHONE 4":
                this.photo = "@drawable/iphone4";
                break;
            case "IPHONE 5":
                this.photo = "@drawable/iphone5";
                break;
            case "IPHONE 6":
                this.photo = "@drawable/iphone6";
                break;
            case "IPHONE 7":
                this.photo = "@drawable/iphone7";
                break;
            case "IPHONE 8":
                this.photo = "@drawable/iphone8";
                break;
            case "IPHONE 10":
                this.photo = "@drawable/iphone10";
                break;
            case "IPHONE 11":
                this.photo = "@drawable/iphone11";
                break;
            case "IPHONE 12":
                this.photo = "@drawable/iphone12";
                break;
            case "IPHONE 13":
                this.photo = "@drawable/iphone13";
                break;
            case "Samsung Galaxy S22":
                this.photo = "@drawable/samsungs22";
                break;
            case "HUAWEI P50 PRO":
                this.photo = "@drawable/huaweip50pro";
                break;
            case "IPHONE SE 2020":
                this.photo = "@drawable/iphonese2020";
                break;
            case "IPAD 4":
                this.photo = "@drawable/ipad4";
                break;
            case "XIAOMI MI PAD 5 PRO":
                this.photo = "@drawable/mipad5pro";
                break;
            case "XIAOMI MI PAD 4":
                this.photo = "@drawable/mipad4";
                break;
            case "SAMSUNG GALAXY NOTE 8":
                this.photo = "@drawable/samsungnote8";
                break;
            case "XIAOMI POCO X3":
                this.photo = "@drawable/pocox3";
                break;
            case "XIAOMI POCO M3":
                this.photo = "@drawable/pocom3";
                break;

            case "SAMSUNG GALAXY FOLD 2":
                this.photo = "@drawable/samsungfold2";
                break;
            case "XIAOMI MI PAD 5":
                this.photo = "@drawable/mipad5";
                break;
            case "XIAOMI POCO F3 PRO":
                this.photo = "@drawable/pocof3pro";
                break;
            case "SAMSUNG GALAXY S21":
                this.photo = "@drawable/samsungs21";
                break;
            case "XIAOMI POCO F3 GT":
                this.photo = "@drawable/pocof3gt";
                break;


            case "SAMSUNG GALAXY TAB S7":
                this.photo = "@drawable/samsungtabs7";
                break;
            case "SAMSUNG GALAXY TAB A7":
                this.photo = "@drawable/samsungtaba7";
                break;
            case "XIAOMI MI PAD 2":
                this.photo = "@drawable/mipad2";
                break;
            case "XIAOMI NOTE 10":
                this.photo = "@drawable/note10";
                break;
            case "SAMSUNG GALAXY S10":
                this.photo = "@drawable/samsungs10";
                break;





            default:
                this.photo = "";
        }
    }
}
