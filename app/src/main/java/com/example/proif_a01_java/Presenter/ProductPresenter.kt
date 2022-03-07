package com.example.proif_a01_java.Presenter;

import com.example.proif_a01_java.Model.Product;
import com.example.proif_a01_java.View.IProducts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductPresenter {
    private ArrayList<Product> products;
    private IProducts ui;
    private int sortCode; // 1 for name 2 for price 3 for condition

    public ProductPresenter(IProducts ui){
        this.ui = (IProducts) ui;
        this.products = new ArrayList<>();
        this.sortCode=0;
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
        if(this.sortCode==1) {
            Collections.sort(this.products, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    return product.name.compareTo(t1.name);
                }
            });
            this.sortCode=0;
            this.ui.loadProducts(this.products);
        }else{

            Collections.sort(this.products, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    return t1.name.compareTo(product.name);
                }
            });
            this.sortCode=1;
            this.ui.loadProducts(this.products);
        }
    }

    public void sortProductBasedCondition () {
        if (this.sortCode==2) {
            Collections.sort(this.products, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    return product.condition.compareTo(t1.condition);
                }
            });
            this.sortCode=0;
            this.ui.loadProducts(this.products);
        }else{
            ArrayList<Product> sortedProducts = new ArrayList<>();
            sortedProducts.addAll(this.products);
            Collections.sort(sortedProducts, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    return t1.condition.compareTo(product.condition);
                }
            });
            this.sortCode=2;
            this.ui.loadProducts(sortedProducts);
        }
    }

    public void sortProductBasedPrice () {
        if(this.sortCode==3) {
            Collections.sort(this.products, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    return Integer.compare(product.price, t1.price);
                }
            });
            this.sortCode=0;
            this.ui.loadProducts(this.products);
        }else{
            Collections.sort(this.products, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    return Integer.compare(t1.price, product.price);
                }
            });
            this.sortCode=3;
            this.ui.loadProducts(this.products);
        }
    }

    public void changeCategory (int category) {
        switch (category){
            case Product.CATEGORY_MOBILE:
                ArrayList<Product> mobileProduct = new ArrayList<>();
                int size = this.products.size();
                for (int i=0; i<size; i++) {
                    if (this.products.get(i).rawCategory == Product.CATEGORY_MOBILE) {
                        mobileProduct.add(this.products.get(i));
                    }
                }
                this.ui.loadProducts(mobileProduct);
                break;
            case Product.CATEGORY_TABLET:
                ArrayList<Product> tabletProduct = new ArrayList<>();
                size = this.products.size();
                for (int i=0; i<size; i++) {
                    if (this.products.get(i).rawCategory == Product.CATEGORY_TABLET) {
                        tabletProduct.add(this.products.get(i));
                    }
                }
                this.ui.loadProducts(tabletProduct);
                break;
            default:
                this.ui.loadProducts(this.products);
                break;
        }
    }

    public void moveToDetails (Product product) {
        this.ui.moveToDetails(product);
    }

}
