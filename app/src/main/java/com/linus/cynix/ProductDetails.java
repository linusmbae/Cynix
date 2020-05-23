package com.linus.cynix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetails extends AppCompatActivity  {

   @BindView(R.id.dataText)TextView mDataText;
   @BindView(R.id.myImage)ImageView mMyImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ButterKnife.bind(this);

        Intent intent=getIntent();
        mDataText.setText(intent.getStringExtra("wearName"));
        mMyImage.setImageResource(intent.getIntExtra("product",0));

    }


}
