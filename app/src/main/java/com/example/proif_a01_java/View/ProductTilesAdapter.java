package com.example.proif_a01_java.View;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;

import com.example.proif_a01_java.Model.Product;
import com.example.proif_a01_java.R;
import com.example.proif_a01_java.databinding.ProductListItemBinding;
import com.example.proif_a01_java.databinding.ProductTilesItemBinding;

import java.util.ArrayList;

public class ProductTilesAdapter extends BaseAdapter {
    private Activity activity;
    private FragmentManager fm;
    private ProductTilesItemBinding binding;
    private ArrayList<Product> products;


    public ProductTilesAdapter (Activity activity, FragmentManager fm, ArrayList<Product> products) {
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
        int size=this.products.size()/3;
        if(this.products.size()%3==0){
            return size;
        }else{
            size++;
            return size;
        }


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

       int shown=i*3;
        if(getCount() >=shown){
            Product satu=getItem(shown);
            Product dua=getItem(shown+1);
            Product tiga=getItem(shown+2);

            binding.productName1.setText(satu.getName());
            binding.condition1.setText(satu.getCondition()+"");
            binding.category1.setText(satu.getCategory());
            binding.price1.setText(satu.price+"");
            binding.gambar1.setImageResource(this.activity.getResources().getIdentifier(satu.getPhoto(),"drawable", activity.getPackageName()));

            binding.productName2.setText(dua.getName());
            binding.condition2.setText(dua.getCondition()+"");
            binding.category2.setText(dua.getCategory());
            binding.price2.setText(dua.price+"");
            binding.gambar2.setImageResource(this.activity.getResources().getIdentifier(dua.getPhoto(),"drawable", activity.getPackageName()));

            binding.productName3.setText(tiga.getName());
            binding.condition3.setText(tiga.getCondition()+"");
            binding.category3.setText(tiga.getCategory());
            binding.price3.setText(tiga.price+"");
            binding.gambar3.setImageResource(this.activity.getResources().getIdentifier(tiga.getPhoto(),"drawable", activity.getPackageName()));

        }else if (getCount() >=shown-1){
            Product satu=getItem(shown);
            Product dua=getItem(shown+1);

            binding.productName1.setText(satu.getName());
            binding.condition1.setText(satu.getCondition()+"");
            binding.category1.setText(satu.getCategory());
            binding.price1.setText(satu.price+"");
            binding.gambar1.setImageResource(this.activity.getResources().getIdentifier(satu.getPhoto(),"drawable", activity.getPackageName()));

            binding.productName2.setText(dua.getName());
            binding.condition2.setText(dua.getCondition()+"");
            binding.category2.setText(dua.getCategory());
            binding.price2.setText(dua.price+"");
            binding.gambar2.setImageResource(this.activity.getResources().getIdentifier(dua.getPhoto(),"drawable", activity.getPackageName()));
        }else{
            Product satu=getItem(shown);

            binding.productName1.setText(satu.getName());
            binding.condition1.setText(satu.getCondition()+"");
            binding.category1.setText(satu.getCategory());
            binding.price1.setText(satu.price+"");
            binding.gambar1.setImageResource(this.activity.getResources().getIdentifier(satu.getPhoto(),"drawable", activity.getPackageName()));
        }


        return binding.getRoot();
    }
}
