package com.example.proif_a01_java.View;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.proif_a01_java.Model.Page;
import com.example.proif_a01_java.Model.Product;
import com.example.proif_a01_java.R;
import com.example.proif_a01_java.databinding.FragmentProductDetailsBinding;

import org.parceler.Parcels;

public class ProductDetailsFragments extends Fragment implements View.OnClickListener, View.OnTouchListener{
    private FragmentProductDetailsBinding binding;
    private FragmentManager fragmentManager;
    private float x1 = 0, x2 = 0;
    private int curPic = 0;
    private Product curProduct;

    // constructor kosong
    public ProductDetailsFragments () {

    }

    // singleton
    public static ProductDetailsFragments newInstance() {
        ProductDetailsFragments fragments = new ProductDetailsFragments();
        return fragments;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.fragmentManager = getParentFragmentManager();
        this.binding = FragmentProductDetailsBinding.inflate(inflater, container, false);

        // from fragment list and tiles listener
        this.fragmentManager.setFragmentResultListener(
                "MOVE_DETAILS", this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        Product product = (Product) Parcels.unwrap(result.getParcelable("products"));
                        setProducts(product);
                    }
                }
        );

        // set onclick listener
        this.binding.btnAdd.setOnClickListener(this::onClick);
        this.binding.ivBack.setOnClickListener(this::onClick);

        this.binding.ivPics.setOnTouchListener(this::onTouch);

        return this.binding.getRoot();
    }

    public void setProducts (Product product) {
        // set all products info here
        this.binding.tvName.setText(product.name);
        this.binding.tvCategory.setText(product.category);
        this.binding.tvCondition.setText(product.condition);
        this.binding.tvPrice.setText(product.getPrice() + "");
        this.binding.tvDesc.setText(product.description);

        this.curProduct = product;

        // sementara belum carousel, !PERLU DIUBAH JADI BENTUK CAROUSEL!
        //IMPLEMENTASI GLIDE LIBRARY
        Glide.with(getActivity())
                .load(getActivity().getResources().getIdentifier(product.photo.get(0),"drawable", getActivity().getPackageName()))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.progress_bar)
                .into(this.binding.ivPics);
    }

    @Override
    public void onClick(View view) {
        if (view == this.binding.btnAdd) {
            this.addCartToast();
        }
        else if (view == this.binding.ivBack) {
            this.changePage(Page.PAGE_LIST_MODE);
        }
    }

    private void addCartToast () {
        Toast toast = Toast.makeText(getContext(), "Product added to cart", Toast.LENGTH_SHORT);
        toast.show();
    }

    //METHOD GANTI HALAMAN
    private void changePage(int page){
        Bundle result = new Bundle();
        result.putInt("page", page);
        this.fragmentManager.setFragmentResult("CHANGE_PAGE", result);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = motionEvent.getX();
                Log.d("DOWN", x1+"");
                break;
            case MotionEvent.ACTION_UP:
                x2 = motionEvent.getX();
                Log.d("UP", x2+"");
                if (Math.abs(x2-x1) > 150) {
                    if (x2 > x1) {
                        // swipe right
                        this.curPic ++;
                        if (this.curPic > 2) {
                            this.curPic = 0;
                        }
                    }else{
                        // swipe left
                        this.curPic --;
                        if (this.curPic < 0) {
                            this.curPic = 2;
                        }
                    }
                    this.slidePic();
                }
                break;
        }
        return true;
    }

    private void slidePic () {
        Glide.with(getActivity())
                .load(getActivity().getResources().getIdentifier(this.curProduct.photo.get(this.curPic),"drawable", getActivity().getPackageName()))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.progress_bar)
                .into(this.binding.ivPics);
    }

}
