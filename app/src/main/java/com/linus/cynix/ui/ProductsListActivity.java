package com.linus.cynix.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.linus.cynix.CynixApi;
import com.linus.cynix.adapter.ProductListsAdapter;
import com.linus.cynix.R;
import com.linus.cynix.adapter.ShopListAdapter;
import com.linus.cynix.models.Products;
import com.linus.cynix.models.Shops;
import com.linus.cynix.network.CynixClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsListActivity extends AppCompatActivity  {
    @BindView(R.id.errorTextView1)TextView mError;
    @BindView(R.id.progressBar1)ProgressBar mProgressBar;
    @BindView(R.id.recyclerView1)RecyclerView mRecyclerView;
    @BindView(R.id.loading1)TextView mLoading;
    public List<Products> products;
    private ProductListsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list_column);
        ButterKnife.bind(this);

        CynixApi cynixApi= CynixClient.getClient();

        Call<List<Products>> call=cynixApi.getProducts();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                hideProgressBar();
                hideLoading();
                if (response.isSuccessful()){
                    products=response.body();
                    mAdapter= new ProductListsAdapter(ProductsListActivity.this,products);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setLayoutManager(new GridLayoutManager(ProductsListActivity.this,2));
                    mRecyclerView.setHasFixedSize(true);

                    showProducts();
                }else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                hideProgressBar();
                hideLoading();
                showFailureMessage();
            }
        });
    }

    private void showProducts(){
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

    private void hideLoading(){mLoading.setVisibility(View.GONE);}
}
