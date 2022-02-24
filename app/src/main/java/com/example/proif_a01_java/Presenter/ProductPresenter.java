package com.example.proif_a01_java.Presenter;
import com.example.proif_a01_java.Model.Product;
import com.example.proif_a01_java.View.IProducts;

import java.util.ArrayList;
import java.util.Locale;

public class ProductPresenter {
    private ArrayList<Product> products;
    private IProducts ui;

    public ProductPresenter(IProducts ui){
        this.ui = (IProducts) ui;
        this.products = new ArrayList<>();
    }

    public void loadProducts (ArrayList<Product> newProduct) {
        this.products.addAll(newProduct);
        this.ui.loadProducts(this.products);
    }
    public void searchProducts (String search) {
        ArrayList<Product> tempProduct = new ArrayList<>();
        int size = this.products.size();
        for (int i=0; i<size; i++) {
            if (this.products.get(i).name.toLowerCase().contains(search.toLowerCase())) {
                tempProduct.add(this.products.get(i));
            }
        }
        this.ui.loadProducts(tempProduct);
    }

    public void sortProductBasedName () {

    }

    public void sortProductBasedCondition () {

    }

    public void sortProductBasedPrice () {

    }

}
