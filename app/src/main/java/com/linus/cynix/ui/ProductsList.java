package com.linus.cynix.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.linus.cynix.Constants;
import com.linus.cynix.CynixApi;
import com.linus.cynix.R;
import com.linus.cynix.adapter.ProductsListAdapter;
import com.linus.cynix.models.Shops;
import com.linus.cynix.network.CynixClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsList extends AppCompatActivity {
@BindView(R.id.results)TextView mResults;
@BindView(R.id.errorTextView)TextView mError;
@BindView(R.id.progressBar)ProgressBar mProgressBar;
//@BindView(R.id.baseGridView)GridView mGidView;
@BindView(R.id.recyclerView) RecyclerView mRecyclerView;
   public List<Shops> shops;
   private ProductsListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        ButterKnife.bind(this);

        CynixApi cynixApi= CynixClient.getClient();

        Call<List<Shops>> call=cynixApi.getShops();
        call.enqueue(new Callback<List<Shops>>() {
            @Override
            public void onResponse(Call<List<Shops>> call, Response<List<Shops>> response) {
                hideProgressBar();
                if (response.isSuccessful()){
                    shops=response.body();
                    mAdapter= new ProductsListAdapter(ProductsList.this,shops);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(ProductsList.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    Toast.makeText(ProductsList.this,"Cynix products",Toast.LENGTH_LONG).show();
                    showShops();
                }else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Shops>> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    private void showShops(){
        mRecyclerView.setVisibility(View.VISIBLE);
    }
    private void showFailureMessage() {
        mError.setText("Something went wrong. Please check your Internet connection and try again later");
        mError.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mError.setText("Something went wrong. Please try again later");
        mError.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}