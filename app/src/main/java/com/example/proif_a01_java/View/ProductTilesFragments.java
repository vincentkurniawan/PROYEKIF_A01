package com.example.proif_a01_java.View;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.proif_a01_java.Model.Inventory;
import com.example.proif_a01_java.Model.Page;
import com.example.proif_a01_java.Model.Product;
import com.example.proif_a01_java.Presenter.ProductPresenter;
import com.example.proif_a01_java.databinding.FragmentProductTilesBinding;

import java.util.ArrayList;

public class ProductTilesFragments extends Fragment implements IProducts, View.OnClickListener {
    public Inventory inv;
    private FragmentProductTilesBinding binding;
    private FragmentManager fragmentManager;
    private ProductPresenter presenter;
    private ProductTilesAdapter adapter;
    private int availLoads;
    private int loadNumber;

    // constructor kosong
    public ProductTilesFragments () {

    }

    // singleton
    public static ProductTilesFragments newInstance(Inventory inv) {
        ProductTilesFragments fragments = new ProductTilesFragments();
        fragments.inv = inv;
        return fragments;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.fragmentManager = getParentFragmentManager();
        this.binding = FragmentProductTilesBinding.inflate(inflater, container, false);

        // inisiasi
        this.presenter = new ProductPresenter(this);
        this.adapter = new ProductTilesAdapter(getActivity(), this.fragmentManager);

        // set adapter
        this.binding.lvProducts.setAdapter(this.adapter);

        // filtering
        this.binding.etFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String search = binding.etFilter.getText().toString();
                presenter.searchProducts(search);
            }
        });

        // set onclick listener
        this.binding.ivList.setOnClickListener(this::onClick);
        this.binding.showMore.setOnClickListener(this::onClick);

        // load new products
        this.loadProducts();

        // set adapter
        this.binding.lvProducts.setAdapter(this.adapter);

        return this.binding.getRoot();
    }

    private void loadProducts () {
        ArrayList<Product> products = new ArrayList<>();

        for (int i=0; i<5; i++) {
            products.add(this.inv.products[i]);
        }

        this.loadNumber = 5;
        this.availLoads = this.inv.products.length - 5;

        this.presenter.loadProducts(products);
    }

    private void loadMoreProducts () {
        if (this.availLoads > 0) {
            ArrayList<Product> products = new ArrayList<>();
            int max;
            if (this.availLoads < 5) {
                max = this.loadNumber + this.availLoads;
            }else{
                max = this.loadNumber + 5;
            }
            for (int i=this.loadNumber; i<max; i++) {
                System.out.println(i);
                products.add(this.inv.products[i]);
            }
            this.presenter.addProducts(products);
            this.loadNumber = max;
            this.availLoads -= 5;
        }
    }

    @Override
    public void loadProducts(ArrayList<Product> products) {
        this.adapter.loadData(products);
    }

    @Override
    public void addProducts(ArrayList<Product> products) {
        this.adapter.addProducts(products);
    }

    @Override
    public void onClick(View view) {
        // tombol ubah ke tiles mode
        if (view == this.binding.ivList) {
            this.changePage(Page.PAGE_LIST_MODE);
        }
        // tombol show more
        else if (view == this.binding.showMore) {
            this.loadMoreProducts();
        }
    }

    //METHOD GANTI HALAMAN
    private void changePage(int page){
        Bundle result = new Bundle();
        result.putInt("page", page);
        this.fragmentManager.setFragmentResult("CHANGE_PAGE", result);
    }

}
