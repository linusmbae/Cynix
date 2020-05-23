package com.linus.cynix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsListActivity extends AppCompatActivity  {
    GridView gridView;
    private String [] menWear=new String[]{"Men wear 1", "Men wear 2","Men wear 3", "Men wear 4","Men wear 5", "Men wear 6"};
    private int[]images=  new int[]{R.drawable.tyler,R.drawable.tamarcus,R.drawable.fabio,R.drawable.bruno,R.drawable.terricks,R.drawable.taylor};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list_column);


        gridView = findViewById(R.id.baseGridView);
        gridView.setAdapter(new ProductListsAdapter( menWear,this,images));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            @Override
            public void onItemClick(AdapterView<?>adapterView, View v,int i,long l)
            {
                Intent intent = new Intent(getApplicationContext(),ProductDetails.class);
                intent.putExtra("wearName",menWear[i]);
                intent.putExtra("product",images[i]);
                startActivity(intent);
//                        Toast.makeText(ProductsListActivity.this,"Clicked",Toast.LENGTH_LONG).show();

            }
       });


    }

}
