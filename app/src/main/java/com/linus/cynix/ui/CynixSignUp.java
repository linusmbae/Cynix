package com.linus.cynix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.linus.cynix.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CynixSignUp extends AppCompatActivity implements View.OnClickListener{
@BindView(R.id.txtLogin)
    TextView mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cynix_sign_up);
        ButterKnife.bind(this);
        mLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
if (v==mLogin){
    Intent intent=new Intent(CynixSignUp.this,CynixLogin.class);
    startActivity(intent);
}
    }
}