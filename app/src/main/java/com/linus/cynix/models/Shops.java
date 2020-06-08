package com.linus.cynix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Shops {
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("buildingName")
    @Expose
    public String buildingName;
    @SerializedName("shopNumber")
    @Expose
    public String shopNumber;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("wear_id")
    @Expose
    public int wear_id;

    private String pushId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Shops() {
    }

    /**
     *
     * @param id
     * @param name
     * @param buildingName
     * @param shopNumber
     * @param email
     * @param phone
     * @param image
     * @param wear_id
     */

    public Shops(int id, String name, String buildingName, String shopNumber, String email, String phone,String image,int wear_id) {
        this.id = id;
        this.name = name;
        this.buildingName = buildingName;
        this.shopNumber = shopNumber;
        this.email = email;
        this.phone = phone;
        this.image=image;
        this.wear_id=wear_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getWear_id() {
        return wear_id;
    }

    public void setWear_id(int wear_id) {
        this.wear_id = wear_id;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
