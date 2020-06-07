package com.linus.cynix.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.linus.cynix.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CynixSignUp extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = CynixSignUp.class.getSimpleName();
@BindView(R.id.txtLogin)TextView mLogin;
@BindView(R.id.txtName)TextView mName;
@BindView(R.id.txtEmail)TextView mEmail;
@BindView(R.id.txtPass)TextView mPass;
@BindView(R.id.txtConfirmPass)TextView mConfirmPass;
@BindView(R.id.btnRegister)Button mRegister;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cynix_sign_up);
        ButterKnife.bind(this);
        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        createAuthStateListener();

    }

    @Override
    public void onClick(View v) {
    if (v==mLogin){
        Intent intent=new Intent(CynixSignUp.this,CynixLogin.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
        if (v == mRegister){
            createNewUser();
        }
    }

    private void createNewUser() {
        final String name = mName.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        String password = mPass.getText().toString().trim();
        String confirmPass = mConfirmPass.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d(TAG, "Authentication successful");
                }else {
                    Toast.makeText(CynixSignUp.this,"Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createAuthStateListener(){
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(CynixSignUp.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}