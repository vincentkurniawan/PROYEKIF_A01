package com.example.proif_a01_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import com.example.proif_a01_java.View.ProductListFragment;
import com.example.proif_a01_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment fragments[];
    private ProductListFragment productListFragment;
    private int currentFragment = 1000;
    private final static int backPointer [] = {-100, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        // inisiasi fragment
        this.fm = this.getSupportFragmentManager();
        this.productListFragment = ProductListFragment.newInstance();

        this.fragments=new Fragment[100000];
        this.fragments[0] = this.productListFragment;

        FragmentTransaction ft = this.fm.beginTransaction();
        ft.add(R.id.fragment_container, this.productListFragment).addToBackStack(null).commit();
        this.currentFragment = 0;

        // changePage listener
        this.getSupportFragmentManager().setFragmentResultListener(
                "CHANGE_PAGE", this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        int page = result.getInt("page");
                        changePage(page);
                    }
                }
        );


    }

    private int changePage (int page) {
        if (page == -100) {
            this.closeApplication();
            return -1;
        }

        // SET ANIMASI KETIKA GESER, PENCET, DLL
        this.ft = this.fm.beginTransaction().setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
        );

        if (this.currentFragment != 1000) {
            this.ft.hide(this.fragments[this.currentFragment]);
        }

        if (this.fragments[page].isAdded()) {
            this.ft.show(this.fragments[page]);
        }else{
            this.ft.add(R.id.fragment_container, this.fragments[page]);
        }

        this.ft.commit();
        this.currentFragment = page;
        return -1;
    }

    private void closeApplication () {
        this.moveTaskToBack(true);
        this.finish();
    }

    // METHOD KETIKA TOMBOL BACK DITEKAN
    @Override
    public void onBackPressed () {
        this.changePage(backPointer[this.currentFragment]);
    }
}