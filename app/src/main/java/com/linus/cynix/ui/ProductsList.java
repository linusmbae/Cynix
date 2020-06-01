package com.linus.cynix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.linus.cynix.Constants;
import com.linus.cynix.CynixApi;
import com.linus.cynix.R;
import com.linus.cynix.Shops;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        ButterKnife.bind(this);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.CYNIX_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CynixApi cynixApi=retrofit.create(CynixApi.class);

        Call<List<Shops>> call=cynixApi.getShops();
        call.enqueue(new Callback<List<Shops>>() {
            @Override
            public void onResponse(Call<List<Shops>> call, Response<List<Shops>> response) {
                hideProgressBar();
                if (!response.isSuccessful()){
                    mResults.setText("Code:"+response.code());
                    return;
                }
                List<Shops> shops=response.body();
                for (Shops shop:shops){
                    String content="";
                    content+="ID: "+shop.getId()+"\n";
                    content+="Name: "+shop.getName()+"\n";
                    content+="BuildingName: "+shop.getBuildingName()+"\n\n";

                    mResults.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Shops>> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    private void showFailureMessage() {
        mError.setText("Something went wrong. Please check your Internet connection and try again later");
        mError.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}