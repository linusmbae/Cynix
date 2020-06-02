package com.linus.cynix;

import com.linus.cynix.models.Products;
import com.linus.cynix.models.Shops;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CynixApi {

    @GET("shops")
    Call<List<Shops>> getShops();

    @GET("shops/:id")
    Call<List<Products>>getProducts();
}
