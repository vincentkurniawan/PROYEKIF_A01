package com.example.proif_a01_java.View;

import com.example.proif_a01_java.Model.Product;

import java.util.ArrayList;

public interface IProducts {
    void loadProducts (ArrayList<Product> products);
    void moveToDetails (Product product);
}
