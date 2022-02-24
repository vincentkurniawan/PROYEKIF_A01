package com.example.proif_a01_java.Presenter;

import com.example.proif_a01_java.Model.Product;

import java.util.ArrayList;

public class ProductPresenter {
    private ArrayList<Product> products;
    public ProductPresenter(){
        this.products=new ArrayList<>();
        this.products.add(new Product("Iphone 12","Mobile",10000,1,"@drawable/iphone11"));
        this.products.add(new Product("Iphone 13","Mobile",15000,1,"@drawable/iphone11"));
        this.products.add(new Product("Iphone 13 Pro","Mobile",20000,1,"@drawable/iphone11"));
        this.products.add(new Product("Iphone 13 Pro Max","Mobile",25000,1,"@drawable/iphone11"));
        this.products.add(new Product("Iphone 14","Mobile",30000,1,"@drawable/iphone11"));
    }

    public ArrayList<Product> getProducts(){
        return this.products;
    }





}
