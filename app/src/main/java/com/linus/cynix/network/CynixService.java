package com.linus.cynix.network;

import com.linus.cynix.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CynixService {
    public static void findShops(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder=HttpUrl.parse(Constants.CYNIX_BASE_URL).newBuilder();
    }

    public ArrayList<AvailableShops> processResults(Response response){
        ArrayList<AvailableShops> availableShops = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            JSONObject cynixsJSON = new JSONObject(jsonData);
            JSONArray cynixJSON = cynixsJSON.getJSONArray("shops");
            if (response.isSuccessful()){
                for (int i = 0; i < cynixJSON.length(); i++){
                    JSONObject shopJSON = cynixJSON.getJSONObject(i);
                    String name = shopJSON.getString("name");
                    String buildingName = shopJSON.getString("buildingName");
                    String shopNumber = shopJSON.getString("shopNumber");
                    String email = shopJSON.getString("email");
                    String phone = shopJSON.getString("phone");

                    AvailableShops availableShops1 = new AvailableShops(name, buildingName, shopNumber, email,phone);
                    availableShops.add(availableShops1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return availableShops;
    }
}
