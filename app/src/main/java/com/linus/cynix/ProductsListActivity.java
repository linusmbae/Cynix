package com.linus.cynix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class ProductsListActivity extends AppCompatActivity {
    GridView gridView;
    private String [] menWear=new String[]{"Men wear 1", "Men wear 2","Men wear 3", "Men wear 4","Men wear 5", "Men wear 6"};
    private int[]images=  new int[]{R.drawable.tyler,R.drawable.tamarcus,R.drawable.fabio,R.drawable.bruno,R.drawable.terricks,R.drawable.taylor};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list_column);
        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new ProductListsAdapter( menWear,this,images));
    }
}
