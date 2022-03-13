package com.example.proif_a01_java.Presenter

import com.example.proif_a01_java.View.IProducts
import com.example.proif_a01_java.Model.Product
import java.util.*

class ProductPresenter(private val ui: IProducts) {

    private var products: ArrayList<Product> = ArrayList()
    private var sortCode: Int = 0

    fun loadProducts(newProduct: ArrayList<Product>) {
        products.addAll(newProduct)
        ui.loadProducts(products)
    }

    fun searchProducts(search: String) {
        val tempProduct = ArrayList<Product>()
        val size = products.size
        for (i in 0 until size) {
            if (products[i].name.lowercase().contains(search.lowercase())) {
                tempProduct.add(products[i])
            }
        }
        ui.loadProducts(tempProduct)
    }

    fun sortProductBasedName() {
        if (sortCode == 1) { // descending
            Collections.sort(products) { product, t1 -> product.name.compareTo(t1.name) }
            sortCode = 0
            ui.loadProducts(products)
        } else { // ascending
            Collections.sort(products) { product, t1 -> t1.name.compareTo(product.name) }
            sortCode = 1
            ui.loadProducts(products)
        }
    }

    fun sortProductBasedCondition() {
        if (sortCode == 2) { // descending
            Collections.sort(products) { product, t1 -> product.condition.compareTo(t1.condition) }
            sortCode = 0
            ui.loadProducts(products)
        } else { // ascending
            Collections.sort(products) { product, t1 -> t1.condition.compareTo(product.condition) }
            sortCode = 2
            ui.loadProducts(products)
        }
    }

    fun sortProductBasedPrice() {
        if (sortCode == 3) { // descending
            Collections.sort(products) { product, t1 -> Integer.compare(product.price, t1.price) }
            sortCode = 0
            ui.loadProducts(products)
        } else { // ascending
            Collections.sort(products) { product, t1 -> Integer.compare(t1.price, product.price) }
            sortCode = 3
            ui.loadProducts(products)
        }
    }

    fun changeCategory(category: Int) {
        when (category) {
            Product.CATEGORY_MOBILE -> {
                val mobileProduct = ArrayList<Product>()
                val size = products.size
                var i = 0
                while (i < size) {
                    if (products[i].rawCategory == Product.CATEGORY_MOBILE) {
                        mobileProduct.add(products[i])
                    }
                    i++
                }
                ui.loadProducts(mobileProduct)
            }
            Product.CATEGORY_TABLET -> {
                val tabletProduct = ArrayList<Product>()
                var size = products.size
                var i = 0
                while (i < size) {
                    if (products[i].rawCategory == Product.CATEGORY_TABLET) {
                        tabletProduct.add(products[i])
                    }
                    i++
                }
                ui.loadProducts(tabletProduct)
            }
            else -> ui.loadProducts(products)
        }
    }

    fun moveToDetails(product: Product) {
        ui.moveToDetails(product)
    }
}