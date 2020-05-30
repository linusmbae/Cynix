package com.linus.cynix;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CynixApi {
    @GET("/shops")
    Call<CynixBusinessesSearchResponse>getCynixShop(
            @Query("location") String location,
            @Query("term") String term
    );
}
