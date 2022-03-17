package com.example.proif_a01_java;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.proif_a01_java.Model.Product;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class ProductTest {
    @Test
    public void whenInputIsValid(){
        Product product = new Product("IPHONE 1", Product.CATEGORY_MOBILE, 1500, Product.CONDITION_NEW);
        boolean result = product.validateInput();
        assertTrue(result);
    }
}