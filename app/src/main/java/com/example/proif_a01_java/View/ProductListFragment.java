package com.example.proif_a01_java.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.proif_a01_java.Model.Product;
import com.example.proif_a01_java.Presenter.ProductPresenter;
import com.example.proif_a01_java.R;
import com.example.proif_a01_java.databinding.FragmentProductListBinding;

public class ProductListFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private FragmentProductListBinding binding;
    private FragmentManager fm;
    private ProductPresenter pp;
    private  Boolean isList=true;
    private ProductAdapter pa;
    private  ProductTilesAdapter pta;

    public static ProductListFragment newInstance () {
        return new ProductListFragment();
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.fm = getParentFragmentManager();
        this.binding = FragmentProductListBinding.inflate(inflater,container,false);
        this.pp=new ProductPresenter();


        View view = this.binding.getRoot();

        // spinner settings
        Spinner spin = this.binding.categorySpinner;
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1; // you dont display last item. It is used as hint.
            }

        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("MOBILE");
        adapter.add("TABLET");
        adapter.add("CATEGORY");
        spin.setAdapter(adapter);
        spin.setSelection(adapter.getCount()); //display hint
        spin.setAdapter(adapter);

        // on click listener
        this.binding.ivTiles.setOnClickListener(this::onClick);
        this.pa = new ProductAdapter(getActivity(), this.fm,this.pp.getProducts());
        this.binding.listView.setAdapter(this.pa);


        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == this.binding.ivTiles) {
            if(this.isList) {

                //ganti jadi Product tiles
                if(this.pta==null){
                    this.pta=new ProductTilesAdapter(getActivity(), this.fm,this.pp.getProducts());
                }
                this.binding.listView.setAdapter(this.pta);

                this.isList=false;
                this.binding.ivTiles.setImageResource(R.drawable.ic_baseline_list_24);
            }else{
                //this.changePage(1);
                if (this.pa == null) {
                    this.pa = new ProductAdapter(getActivity(), this.fm,this.pp.getProducts());
                }
                this.binding.listView.setAdapter(this.pa);

                //set kebalikan
                this.isList=true;
                this.binding.ivTiles.setImageResource(R.drawable.ic_baseline_apps_24);
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (view == this.binding.categorySpinner) {
            // select category from spinner

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //METHOD GANTI HALAMAN
    private void changePage(int page){
        Bundle result = new Bundle();
        result.putInt("page", page);
        this.fm.setFragmentResult("CHANGE_PAGE", result);
    }
}
