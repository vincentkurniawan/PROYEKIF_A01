package com.example.proif_a01_java.View

import android.widget.AdapterView
import com.example.proif_a01_java.Model.Inventory
import com.example.proif_a01_java.Presenter.ProductPresenter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.text.TextWatcher
import android.text.Editable
import android.view.View

import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment

import com.example.proif_a01_java.Model.Page
import com.example.proif_a01_java.R
import com.example.proif_a01_java.Model.Product
import org.parceler.Parcels
import com.example.proif_a01_java.databinding.FragmentProductListBinding
import java.util.ArrayList

class ProductListFragments: Fragment(), IProducts, View.OnClickListener, AdapterView.OnItemSelectedListener {

    lateinit var inv: Inventory
    lateinit var binding: FragmentProductListBinding
    lateinit var presenter: ProductPresenter
    lateinit var adapter: ProductListAdapter
    private var loadNumber = 0
    private var availLoads = 0

    companion object {
        // singleton
        fun newInstance(inv: Inventory): ProductListFragments {
            val fragments = ProductListFragments()
            fragments.inv = inv
            return fragments
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // viewBinding
        binding = FragmentProductListBinding.inflate(inflater, container, false)

        // inisiasi
        presenter = ProductPresenter(this)
        adapter = ProductListAdapter(requireActivity(), presenter)

        // set adapter list produk
        binding.lvProducts.adapter = adapter

        // filtering
        binding.etFilter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                val search = binding.etFilter.text.toString()
                presenter.searchProducts(search)
            }
        })

        // spinner
        val ctSpinner = binding.categorySpinner
        val arr = arrayOf<String>("ALL", "MOBILE", "TABLET")
        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any>(requireContext(), R.layout.category_spinner_item, arr)
        adapter.setDropDownViewResource(R.layout.category_spinner_item)
        ctSpinner.adapter = adapter
        ctSpinner.onItemSelectedListener = this

        // set onclick listener
        binding.ivTiles.setOnClickListener { view: View -> onClick(view) }
        binding.productName.setOnClickListener { view: View -> onClick(view) }
        binding.price.setOnClickListener{ view: View -> onClick(view) }
        binding.category.setOnClickListener { view: View -> onClick(view) }
        binding.condition.setOnClickListener { view: View -> onClick(view) }
        binding.showMore.setOnClickListener { view: View -> onClick(view) }

        // load new products
        this.loadProducts()
        return binding.root
    }

    private fun loadProducts() {
        val products = ArrayList<Product>()
        for (i in 0..4) {
            products.add(inv.products[i])
        }
        loadNumber = 5
        availLoads = inv.products.size - 5
        presenter.loadProducts(products)
    }

    private fun loadMoreProducts() {
        if (availLoads > 0) {
            val products = ArrayList<Product>()
            val max: Int
            max = if (availLoads < 5) {
                loadNumber + availLoads
            } else {
                loadNumber + 5
            }
            for (i in loadNumber until max) {
                println(i)
                products.add(inv.products[i])
            }
            presenter.loadProducts(products)
            loadNumber = max
            availLoads -= 5
        }
    }

    override fun loadProducts(products: ArrayList<Product>) {
        adapter.loadData(products)
    }

    override fun moveToDetails(product: Product) {
        val result = Bundle()
        result.putParcelable("products", Parcels.wrap(product))
        result.putInt("pageFrom", Page.PAGE_LIST_MODE)
        parentFragmentManager.setFragmentResult("MOVE_DETAILS", result)
        changePage(Page.PAGE_DETAILS_MODE)
    }

    override fun onClick(view: View) {
        // tombol ubah ke tiles mode
        if (view == binding.ivTiles) {
            changePage(Page.PAGE_TILES_MODE)
        } else if (view == binding.productName) {
            presenter.sortProductBasedName()
        } else if (view == binding.condition) {
            presenter.sortProductBasedCondition()
        } else if (view == binding.price) {
            presenter.sortProductBasedPrice()
        } else if (view == binding.showMore) {
            loadMoreProducts()
        }
    }

    //METHOD GANTI HALAMAN
    private fun changePage(page: Int) {
        val result = Bundle()
        result.putInt("page", page)
        parentFragmentManager.setFragmentResult("CHANGE_PAGE", result)
    }

    // method untuk spinner
    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        presenter.changeCategory(i - 1)
    }

    override fun onNothingSelected(adapterView: AdapterView<*>) {}


}