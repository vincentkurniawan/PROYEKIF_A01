package com.example.proif_a01_java.View;

import android.app.Activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.fragment.app.FragmentManager;

import com.example.proif_a01_java.Model.Product;
import com.example.proif_a01_java.Presenter.ProductPresenter;
import com.example.proif_a01_java.databinding.ProductTilesItemBinding;


import java.util.ArrayList;

public class ProductTilesAdapter extends BaseAdapter {
    private Activity activity;
    private FragmentManager fm;
    private ProductTilesItemBinding binding;
    private ArrayList<Product> products;
    private ProductPresenter presenter;

    public ProductTilesAdapter(Activity activity, FragmentManager fm, ProductPresenter presenter) {
        this.activity = activity;
        this.fm = fm;
        this.products = new ArrayList<>();
        this.presenter = presenter;
    }

    public void loadData (ArrayList<Product> products) {
        this.products = products;
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
            this.binding = ProductTilesItemBinding.inflate(this.activity.getLayoutInflater());
            view = this.binding.getRoot();
            view.setTag(this.binding);
        }else{
            this.binding = (ProductTilesItemBinding) view.getTag();
        }

        // SET TEXT and PHOTO
        this.binding.name.setText(currProduct.name);
        this.binding.category.setText(currProduct.category);
        this.binding.condition.setText(currProduct.condition);
        this.binding.price.setText("$ "+currProduct.price);
        this.binding.ivProducts.setImageResource(this.activity.getResources().getIdentifier(currProduct.photo,"drawable", activity.getPackageName()));
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.moveToDetails(currProduct);
            }
        });

        return binding.getRoot();
    }
}
