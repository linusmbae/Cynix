package com.linus.cynix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.linus.cynix.models.AvailableShops;
import com.linus.cynix.network.CynixService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class ProductsListActivity extends AppCompatActivity  {
    GridView gridView;
    private String [] menWear=new String[]{"Men wear 1", "Men wear 2","Men wear 3", "Men wear 4","Men wear 5", "Men wear 6","Men wear 7", "Men wear 8","Men wear 9", "Men wear 10","Men wear 11", "Men wear 12","Men wear 13", "Men wear 14"};
    private int[]images=  new int[]{R.drawable.tyler,R.drawable.tamarcus,R.drawable.fabio,R.drawable.bruno,R.drawable.terricks,R.drawable.taylor,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten,R.drawable.eleven,R.drawable.twelve,R.drawable.thirteen,R.drawable.fourteen};

    public static final String TAG=ProductsListActivity.class.getSimpleName();

    public ArrayList<AvailableShops>mShops=new ArrayList<>();







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
                Log.v(TAG,"In the onItemClickListener!");
                startActivity(intent);
                        Toast.makeText(ProductsListActivity.this,"Cynix products",Toast.LENGTH_LONG).show();

            }
       });


    }

}
