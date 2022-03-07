package com.example.proif_a01_java.View

import com.example.proif_a01_java.Model.Product
import java.util.ArrayList

interface IProducts {
    fun loadProducts(products: ArrayList<Product>)
    fun moveToDetails(product: Product)
}