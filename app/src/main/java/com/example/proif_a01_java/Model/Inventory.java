package com.example.proif_a01_java.Model;

public class Inventory {
    public Product [] products = new Product[16];

    public Inventory () {
        products[0] = new Product("IPHONE 1", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[1] = new Product("IPAD 2", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[2] = new Product("IPAD 3", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[3] = new Product("IPHONE 4", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[4] = new Product("IPHONE 5", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[5] = new Product("IPHONE 6", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[6] = new Product("IPHONE 7", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[7] = new Product("IPHONE 8", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[8] = new Product("IPHONE 9", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[9] = new Product("IPHONE 10", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[10] = new Product("IPHONE 11", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[11] = new Product("IPHONE 12", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[12] = new Product("IPHONE 13", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[13] = new Product("IPHONE 14", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[14] = new Product("IPHONE 15", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        products[15] = new Product("IPHONE 16", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
    }

}
