package com.example.proif_a01_java.View

import android.app.Activity
import android.view.View
import com.example.proif_a01_java.Presenter.ProductPresenter
import android.widget.BaseAdapter
import com.example.proif_a01_java.Model.Product
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.proif_a01_java.databinding.ProductTilesItemBinding
import java.util.ArrayList

class ProductTilesAdapter(private val activity: Activity, presenter: ProductPresenter) :
    BaseAdapter() {
    lateinit var binding: ProductTilesItemBinding
    lateinit var products: ArrayList<Product>
    lateinit var presenter: ProductPresenter
    fun loadData(products: ArrayList<Product>) {
        this.products = products
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
            binding = ProductTilesItemBinding.inflate(
                activity.layoutInflater
            )
            view = binding.root
            view.setTag(binding)
        } else {
            binding = view.tag as ProductTilesItemBinding
        }

        // SET TEXT and PHOTO
        binding.name.text = currProduct.name
        binding.category.text = currProduct.category
        binding.condition.text = currProduct.condition
        binding.price.text = "$ " + currProduct.price

        //IMPLEMENTASI GLIDE LIBRARY
        Glide.with(activity)
            .load(
                activity.resources.getIdentifier(
                    currProduct.photo[0],
                    "drawable",
                    activity.packageName
                )
            )
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.ivProducts)
        binding.root.setOnClickListener { presenter.moveToDetails(currProduct) }
        return binding.root
    }

    init {
        products = ArrayList()
        this.presenter = presenter
    }
}