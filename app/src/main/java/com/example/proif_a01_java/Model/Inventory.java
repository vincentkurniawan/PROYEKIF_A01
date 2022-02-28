package com.example.proif_a01_java.Model;

public class Inventory {
    public Product [] products = new Product[31];

    public Inventory () {
        products[0] = new Product("IPHONE 1", Product.CATEGORY_MOBILE, 100, Product.CONDITION_NEW);
        products[1] = new Product("IPAD 2", Product.CATEGORY_TABLET, 1500, Product.CONDITION_NEW);
        products[2] = new Product("IPAD 3", Product.CATEGORY_TABLET, 1500, Product.CONDITION_NEW);
        products[3] = new Product("IPHONE 4", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[4] = new Product("IPHONE 5", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[5] = new Product("IPHONE 6", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[6] = new Product("IPHONE 7", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[7] = new Product("IPHONE 8", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[8] = new Product("Samsung Galaxy S22", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[9] = new Product("IPHONE 10", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[10] = new Product("IPHONE 11", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[11] = new Product("IPHONE 12", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[12] = new Product("IPHONE 13", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[13] = new Product("IPHONE SE 2020", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[14] = new Product("HUAWEI P50 PRO", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[15] = new Product("IPAD 4", Product.CATEGORY_TABLET, 1500, Product.CONDITION_NEW);
        products[16] = new Product("XIAOMI MI PAD 5 PRO", Product.CATEGORY_TABLET,1000,Product.CONDITION_90);
        products[17] = new Product("XIAOMI POCO M3",Product.CATEGORY_MOBILE,100,Product.CONDITION_NEW);
        products[18] = new Product("XIAOMI MI PAD 4",Product.CATEGORY_TABLET,500,Product.CONDITION_NEW);
        products[19] = new Product("SAMSUNG GALAXY NOTE 8",Product.CATEGORY_MOBILE,1200,Product.CONDITION_NEW);
        products[20] = new Product("XIAOMI POCO X3",Product.CATEGORY_MOBILE,500,Product.CONDITION_50);
        products[21] = new Product("SAMSUNG GALAXY FOLD 2",Product.CATEGORY_MOBILE,3000,Product.CONDITION_NEW);
        products[22] = new Product("XIAOMI MI PAD 5",Product.CATEGORY_TABLET,400,Product.CONDITION_90);
        products[23] = new Product("XIAOMI POCO F3 PRO",Product.CATEGORY_MOBILE,700,Product.CONDITION_NEW);
        products[24] = new Product("SAMSUNG GALAXY S21",Product.CATEGORY_MOBILE,2000,Product.CONDITION_NEW);
        products[25] = new Product("XIAOMI POCO F3 GT",Product.CATEGORY_MOBILE,200,Product.CONDITION_90);
        products[26] = new Product("SAMSUNG GALAXY TAB S7",Product.CATEGORY_TABLET,500,Product.CONDITION_NEW);
        products[27] = new Product("SAMSUNG GALAXY TAB A7",Product.CATEGORY_TABLET,300,Product.CONDITION_50);
        products[28] = new Product("XIAOMI MI PAD 2",Product.CATEGORY_TABLET,200,Product.CONDITION_NEW);
        products[29] = new Product("XIAOMI NOTE 10",Product.CATEGORY_MOBILE,100,Product.CONDITION_90);
        products[30] = new Product("SAMSUNG GALAXY S10", Product.CATEGORY_MOBILE,500,Product.CONDITION_NEW);


    }

}
