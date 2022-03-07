package com.example.proif_a01_java.Model

import android.os.Parcelable
import java.util.ArrayList
import kotlinx.parcelize.Parcelize
@Parcelize
class Product() : Parcelable {
    lateinit var name: String
    lateinit var category: String
    var price :Int=0
    lateinit var condition: String
    lateinit var photo: ArrayList<String>
    var rawCategory:Int =0
    lateinit var description: String


    constructor(name: String, category: Int, price: Int, condition: Int, description: String) : this() {
        this.name = name
        this.price = price
        formatCategory(category)
        formatCondition(condition)
        this.description = description
        photo = ArrayList()
        setPhoto(name)
    }

    private fun formatCondition(condition: Int) {
        when (condition) {
            0 -> this.condition = "NEW"
            1 -> this.condition = "90% CONDITION"
            2 -> this.condition = "50% CONDITION"
            else -> this.condition = ""
        }
    }

    private fun formatCategory(category: Int) {
        rawCategory = category
        when (category) {
            0 -> this.category = "MOBILE"
            1 -> this.category = "TABLET"
            else -> this.category = ""
        }
    }

    private fun setPhoto(name: String?) {
        when (name) {
            "IPHONE 1" -> {
                photo!!.add("@drawable/iphone1")
                photo!!.add("@drawable/iphone1_2")
                photo!!.add("@drawable/iphone1_3")
            }
            "IPAD 2" -> {
                photo!!.add("@drawable/ipad2")
                photo!!.add("@drawable/ipad2_2")
                photo!!.add("@drawable/ipad2_3")
            }
            "IPAD 3" -> {
                photo!!.add("@drawable/ipad3")
                photo!!.add("@drawable/ipad3_2")
                photo!!.add("@drawable/ipad3_3")
            }
            "IPHONE 4" -> {
                photo!!.add("@drawable/iphone4")
                photo!!.add("@drawable/iphone4_2")
                photo!!.add("@drawable/iphone4_3")
            }
            "IPHONE 5" -> {
                photo!!.add("@drawable/iphone5")
                photo!!.add("@drawable/iphone5_2")
                photo!!.add("@drawable/iphone5_3")
            }
            "IPHONE 6" -> {
                photo!!.add("@drawable/iphone6")
                photo!!.add("@drawable/iphone6_2")
                photo!!.add("@drawable/iphone6-3")
            }
            "IPHONE 7" -> {
                photo!!.add("@drawable/iphone7")
                photo!!.add("@drawable/iphone7_2")
                photo!!.add("@drawable/iphone7_3")
            }
            "IPHONE 8" -> {
                photo!!.add("@drawable/iphone8")
                photo!!.add("@drawable/iphone8_2")
                photo!!.add("@drawable/iphone8_3")
            }
            "IPHONE 10" -> {
                photo!!.add("@drawable/iphone10")
                photo!!.add("@drawable/iphone10_2")
                photo!!.add("@drawable/iphone10_3")
            }
            "IPHONE 11" -> {
                photo!!.add("@drawable/iphone11")
                photo!!.add("@drawable/iphone11_2")
                photo!!.add("@drawable/iphone11_3")
            }
            "IPHONE 12" -> {
                photo!!.add("@drawable/iphone12")
                photo!!.add("@drawable/iphone12_2")
                photo!!.add("@drawable/iphone12_3")
            }
            "IPHONE 13" -> {
                photo!!.add("@drawable/iphone13")
                photo!!.add("@drawable/iphone13_2")
                photo!!.add("@drawable/iphone13_3")
            }
            "Samsung Galaxy S22" -> {
                photo!!.add("@drawable/samsungs22")
                photo!!.add("@drawable/samsungs22_2")
                photo!!.add("@drawable/samsungs22_3")
            }
            "HUAWEI P50 PRO" -> {
                photo!!.add("@drawable/huaweip50pro")
                photo!!.add("@drawable/huaweip50pro_2")
                photo!!.add("@drawable/huaweip50pro_3")
            }
            "IPHONE SE 2020" -> {
                photo!!.add("@drawable/iphonese2020")
                photo!!.add("@drawable/iphonese2020_2")
                photo!!.add("@drawable/iphonese2020_3")
            }
            "IPAD 4" -> {
                photo!!.add("@drawable/ipad4")
                photo!!.add("@drawable/ipad4_2")
                photo!!.add("@drawable/ipad4_3")
            }
            "XIAOMI MI PAD 5 PRO" -> {
                photo!!.add("@drawable/mipad5pro")
                photo!!.add("@drawable/mipad5pro_2")
                photo!!.add("@drawable/mipad5pro_3")
            }
            "XIAOMI MI PAD 4" -> {
                photo!!.add("@drawable/mipad4")
                photo!!.add("@drawable/mipad4_2")
                photo!!.add("@drawable/mipad4_3")
            }
            "SAMSUNG GALAXY NOTE 8" -> {
                photo!!.add("@drawable/samsungnote8")
                photo!!.add("@drawable/samsungnote8_2")
                photo!!.add("@drawable/samsungnote8_3")
            }
            "XIAOMI POCO X3" -> {
                photo!!.add("@drawable/pocox3")
                photo!!.add("@drawable/pocox3_2")
                photo!!.add("@drawable/pocox3_3")
            }
            "XIAOMI POCO M3" -> {
                photo!!.add("@drawable/pocom3")
                photo!!.add("@drawable/pocom3_2")
                photo!!.add("@drawable/pocom3_3")
            }
            "SAMSUNG GALAXY FOLD 2" -> {
                photo!!.add("@drawable/samsungfold2")
                photo!!.add("@drawable/samsungfold2_2")
                photo!!.add("@drawable/samsungfold2_3")
            }
            "XIAOMI MI PAD 5" -> {
                photo!!.add("@drawable/mipad5")
                photo!!.add("@drawable/mipad5_2")
                photo!!.add("@drawable/mipad5_3")
            }
            "XIAOMI POCO F3 PRO" -> {
                photo!!.add("@drawable/pocof3pro")
                photo!!.add("@drawable/pocof3pro_2")
                photo!!.add("@drawable/pocof3pro_3")
            }
            "SAMSUNG GALAXY S21" -> {
                photo!!.add("@drawable/samsungs21")
                photo!!.add("@drawable/samsungs21_2")
                photo!!.add("@drawable/samsungs21_3")
            }
            "XIAOMI POCO F3 GT" -> {
                photo!!.add("@drawable/pocof3gt")
                photo!!.add("@drawable/pocof3gt_2")
                photo!!.add("@drawable/pocof3gt_3")
            }
            "SAMSUNG GALAXY TAB S7" -> {
                photo!!.add("@drawable/samsungtabs7")
                photo!!.add("@drawable/samsungtabs7_2")
                photo!!.add("@drawable/samsungtabs7_3")
            }
            "SAMSUNG GALAXY TAB A7" -> {
                photo!!.add("@drawable/samsungtaba7")
                photo!!.add("@drawable/samsungtaba7_2")
                photo!!.add("@drawable/samsungtaba7_3")
            }
            "XIAOMI MI PAD 2" -> {
                photo!!.add("@drawable/mipad2")
                photo!!.add("@drawable/mipad2_2")
                photo!!.add("@drawable/mipad2_3")
            }
            "XIAOMI NOTE 10" -> {
                photo!!.add("@drawable/note10")
                photo!!.add("@drawable/note10_2")
                photo!!.add("@drawable/note10_3")
            }
            "SAMSUNG GALAXY S10" -> {
                photo!!.add("@drawable/samsungs10")
                photo!!.add("@drawable/samsungs10_2")
                photo!!.add("@drawable/samsungs10_3")
            }
        }
    }

    companion object {
        const val CONDITION_NEW = 0
        const val CONDITION_90 = 1
        const val CONDITION_50 = 2
        const val CATEGORY_MOBILE = 0
        const val CATEGORY_TABLET = 1
    }
}