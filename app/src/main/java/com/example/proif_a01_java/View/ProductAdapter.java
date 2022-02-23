package com.example.proif_a01_java.View;

import android.app.Activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.fragment.app.FragmentManager;

import com.example.proif_a01_java.Model.Product;
import com.example.proif_a01_java.databinding.ProductListItemBinding;


import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Activity activity;
    private FragmentManager fm;
    private ProductListItemBinding binding;
    private ArrayList<Product> products;

    public ProductAdapter (Activity activity, FragmentManager fm, ArrayList<Product> products) {
        this.activity = activity;
        this.fm = fm;
        this.products=products;
    }

    public void update (ArrayList<Product> products) {
        this.products.addAll(products);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public Product getItem(int i) {
        return this.products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Product currProduct =  this.getItem(i);
        if (view == null) {
            this.binding = ProductListItemBinding.inflate(this.activity.getLayoutInflater());
            view = this.binding.getRoot();
            view.setTag(this.binding);
        }else{
            this.binding = (ProductListItemBinding) view.getTag();
        }

        // SET TEXT
        this.binding.productName.setText(currProduct.name);
        this.binding.category.setText(currProduct.category);
        this.binding.condition.setText(currProduct.condition+"");
        this.binding.price.setText(Integer.toString(currProduct.price));

        return binding.getRoot();
    }
}
