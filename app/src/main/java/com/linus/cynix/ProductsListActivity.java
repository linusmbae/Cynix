package com.linus.cynix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class ProductsListActivity extends AppCompatActivity {
    GridView gridView;
    private String[] menWear=new String[]{""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new ProductListsAdapter(this, menWear));
    }
}
