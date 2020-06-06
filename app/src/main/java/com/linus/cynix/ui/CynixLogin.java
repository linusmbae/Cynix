package com.linus.cynix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.linus.cynix.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CynixLogin extends AppCompatActivity implements View.OnClickListener {
@BindView(R.id.txtSignUp)
    TextView mSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cynix_login);

        ButterKnife.bind(this);
        mSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
if (v==mSignup){
    Intent intent=new Intent(CynixLogin.this,CynixSignUp.class);
    startActivity(intent);
}
    }
}