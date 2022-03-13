package com.example.proif_a01_java

import androidx.appcompat.app.AppCompatActivity
import com.example.proif_a01_java.View.ProductListFragments
import com.example.proif_a01_java.View.ProductTilesFragments
import com.example.proif_a01_java.View.ProductDetailsFragments
import com.example.proif_a01_java.Model.Inventory
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.proif_a01_java.R
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.FragmentTransaction
import com.example.proif_a01_java.MainActivity
import com.example.proif_a01_java.Model.Page
import com.example.proif_a01_java.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction
    lateinit var fragments: Array<Fragment>
    lateinit var productListFragments: ProductListFragments
    lateinit var productTilesFragments: ProductTilesFragments
    lateinit var productDetailsFragments: ProductDetailsFragments
    lateinit var inv: Inventory
    private var currentFragment = 1000
    private val backPointer = intArrayOf(Page.PAGE_EXIT, Page.PAGE_LIST_MODE, Page.PAGE_LIST_MODE);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding.root)

        // Make new inventory
        inv = Inventory()

        // inisiasi fragment
        fm = this.supportFragmentManager
        productListFragments = ProductListFragments.newInstance(inv)
        productTilesFragments = ProductTilesFragments.newInstance(inv)
        productDetailsFragments = ProductDetailsFragments.newInstance()
        fragments = arrayOf(
         productListFragments,
        productTilesFragments,
        productDetailsFragments)
        val ft = fm.beginTransaction()
        ft.add(R.id.fragment_container, productListFragments).addToBackStack(null).commit()
        currentFragment = 0

        // changePage listener
        this.supportFragmentManager.setFragmentResultListener(
            "CHANGE_PAGE", this
        ) { requestKey, result ->
            val page = result.getInt("page")
            changePage(page)
        }
    }

    private fun changePage(page: Int): Int {
        if (page == Page.PAGE_EXIT) {
            closeApplication()
            return -1
        }

        // SET ANIMASI KETIKA GESER, PENCET, DLL
//        this.ft = this.fm.beginTransaction().setCustomAnimations(
//                R.anim.slide_in,
//                R.anim.fade_out,
//                R.anim.fade_in,
//                R.anim.slide_out
//        );
        ft = fm.beginTransaction()
        if (currentFragment != 1000) {
            ft.hide(fragments[currentFragment])
        }
        if (fragments[page].isAdded) {
            ft.show(fragments[page])
        } else {
            ft.add(R.id.fragment_container, fragments[page])
        }
        ft.commit()
        currentFragment = page
        return -1
    }

    private fun closeApplication() {
        moveTaskToBack(true)
        finish()
    }

    // METHOD KETIKA TOMBOL BACK DITEKAN
    override fun onBackPressed() {
        changePage(backPointer[currentFragment])
    }

//    companion object {
//        private val backPointer =
//            intArrayOf(Page.PAGE_EXIT, Page.PAGE_LIST_MODE, Page.PAGE_LIST_MODE)
//    }
}