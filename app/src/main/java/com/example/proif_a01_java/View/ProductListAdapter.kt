package com.example.proif_a01_java.View


import android.app.Activity
import android.view.View
import com.example.proif_a01_java.Presenter.ProductPresenter
import android.widget.BaseAdapter
import com.example.proif_a01_java.Model.Product
import android.view.ViewGroup

import com.example.proif_a01_java.databinding.ProductListItemBinding
import java.util.ArrayList

class ProductListAdapter(private val activity: Activity, private var presenter: ProductPresenter) : BaseAdapter() {

    lateinit var binding: ProductListItemBinding
    var products: ArrayList<Product> = ArrayList()

    fun loadData(products: ArrayList<Product>) {
        this.products = ArrayList()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return products.size
    }

    override fun getItem(i: Int): Product {
        return products[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view: View? = view
        val currProduct = getItem(i)
        if (view == null) {
            binding = ProductListItemBinding.inflate(activity.layoutInflater)
            view = binding.root
            view.setTag(binding)
        } else {
            binding = view.tag as ProductListItemBinding
        }

        // SET TEXT
        binding.productName.text = currProduct.name
        binding.category.text = currProduct.category
        binding.condition.text = currProduct.condition
        binding.price.text = "$ " + currProduct.price
        binding.root.setOnClickListener { presenter.moveToDetails(currProduct) }
        return binding.root
    }
}