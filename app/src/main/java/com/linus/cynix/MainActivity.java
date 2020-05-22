package com.linus.cynix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
@BindView(R.id.SignUpButton)Button mSignUpButton;
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
            Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_LONG).show();
        }
    }
}
