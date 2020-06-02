package com.linus.cynix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.linus.cynix.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
@BindView(R.id.FindButton)Button mSignUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v==mSignUpButton)
        {
            Intent intent= new Intent(MainActivity.this, ShopList.class);
            startActivity(intent);
        }
    }
}
