package com.linus.cynix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProductsListActivity extends AppCompatActivity {

    private String[] menWear=new String[]{""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
    }
}
