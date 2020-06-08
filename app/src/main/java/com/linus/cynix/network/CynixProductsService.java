package com.linus.cynix.network;

import com.linus.cynix.Constants;
import com.linus.cynix.models.AvailableProducts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class CynixProductsService {
    public static void findProducts(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder=HttpUrl.parse(Constants.CYNIX_BASE_URL).newBuilder();
    }

    public ArrayList<AvailableProducts> processResults(Response response){
        ArrayList<AvailableProducts> availableProducts = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            JSONObject cynixsJSON = new JSONObject(jsonData);
            JSONArray cynixJSON = cynixsJSON.getJSONArray("fashion/men/:id");
            if (response.isSuccessful()){
                for (int i = 0; i < cynixJSON.length(); i++){
                    JSONObject shopJSON = cynixJSON.getJSONObject(i);
                    String name = shopJSON.getString("name");
                    String color = shopJSON.getString("color");
                    String size = shopJSON.getString("size");
                    String shop_id = shopJSON.getString("shop_id");
                    String category = shopJSON.getString("category");
                    String image = shopJSON.getString("image");

                    AvailableProducts availableProducts1 = new AvailableProducts(name, color, size,shop_id, category,image);
                    availableProducts.add(availableProducts1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return availableProducts;
    }
}
