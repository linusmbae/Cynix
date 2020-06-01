package com.linus.cynix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.linus.cynix.models.Shops;

import java.util.List;

public class CynixBusinessesSearchResponse {
    @SerializedName("shops")
    @Expose
    private List<Shops> shops = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public CynixBusinessesSearchResponse() {
    }

    /**
     *
     * @param shops
     */

    public CynixBusinessesSearchResponse(List<Shops> shops) {
        this.shops = shops;
    }

    public List<Shops> getShops() {
        return shops;
    }

    public void setShops(List<Shops> shops) {
        this.shops = shops;
    }
}
