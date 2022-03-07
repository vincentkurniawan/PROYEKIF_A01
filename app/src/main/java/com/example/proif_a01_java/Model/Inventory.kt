package com.example.proif_a01_java.Model


class Inventory {
    lateinit var products:Array<Product>

    init {
        var empty=Product("default",0,0,0,"default");
        products=Array(31){empty}


        products[0] = Product(
            "IPHONE 1",
            Product.CATEGORY_MOBILE,
            100,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[1] = Product(
            "IPAD 2",
            Product.CATEGORY_TABLET,
            1500,
            Product.CONDITION_NEW,
            "HAVE 20MP FRONT CAMERA"
        )
        products[2] = Product(
            "IPAD 3",
            Product.CATEGORY_TABLET,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[3] = Product(
            "IPHONE 4",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[4] = Product(
            "IPHONE 5",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[5] = Product(
            "IPHONE 6",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[6] = Product(
            "IPHONE 7",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[7] = Product(
            "IPHONE 8",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[8] = Product(
            "Samsung Galaxy S22",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[9] = Product(
            "IPHONE 10",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[10] = Product(
            "IPHONE 11",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[11] = Product(
            "IPHONE 12",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[12] = Product(
            "IPHONE 13",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[13] = Product(
            "IPHONE SE 2020",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[14] = Product(
            "HUAWEI P50 PRO",
            Product.CATEGORY_MOBILE,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[15] = Product(
            "IPAD 4",
            Product.CATEGORY_TABLET,
            1500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[16] = Product(
            "XIAOMI MI PAD 5 PRO",
            Product.CATEGORY_TABLET,
            1000,
            Product.CONDITION_90,
            "HAVE 64MP FRONT CAMERA"
        )
        products[17] = Product(
            "XIAOMI POCO M3",
            Product.CATEGORY_MOBILE,
            100,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[18] = Product(
            "XIAOMI MI PAD 4",
            Product.CATEGORY_TABLET,
            500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[19] = Product(
            "SAMSUNG GALAXY NOTE 8",
            Product.CATEGORY_MOBILE,
            1200,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[20] = Product(
            "XIAOMI POCO X3",
            Product.CATEGORY_MOBILE,
            500,
            Product.CONDITION_50,
            "HAVE 64MP FRONT CAMERA"
        )
        products[21] = Product(
            "SAMSUNG GALAXY FOLD 2",
            Product.CATEGORY_MOBILE,
            3000,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[22] = Product(
            "XIAOMI MI PAD 5",
            Product.CATEGORY_TABLET,
            400,
            Product.CONDITION_90,
            "HAVE 64MP FRONT CAMERA"
        )
        products[23] = Product(
            "XIAOMI POCO F3 PRO",
            Product.CATEGORY_MOBILE,
            700,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[24] = Product(
            "SAMSUNG GALAXY S21",
            Product.CATEGORY_MOBILE,
            2000,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[25] = Product(
            "XIAOMI POCO F3 GT",
            Product.CATEGORY_MOBILE,
            200,
            Product.CONDITION_90,
            "HAVE 64MP FRONT CAMERA"
        )
        products[26] = Product(
            "SAMSUNG GALAXY TAB S7",
            Product.CATEGORY_TABLET,
            500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[27] = Product(
            "SAMSUNG GALAXY TAB A7",
            Product.CATEGORY_TABLET,
            300,
            Product.CONDITION_50,
            "HAVE 64MP FRONT CAMERA"
        )
        products[28] = Product(
            "XIAOMI MI PAD 2",
            Product.CATEGORY_TABLET,
            200,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
        products[29] = Product(
            "XIAOMI NOTE 10",
            Product.CATEGORY_MOBILE,
            100,
            Product.CONDITION_90,
            "HAVE 64MP FRONT CAMERA"
        )
        products[30] = Product(
            "SAMSUNG GALAXY S10",
            Product.CATEGORY_MOBILE,
            500,
            Product.CONDITION_NEW,
            "HAVE 64MP FRONT CAMERA"
        )
    }
}