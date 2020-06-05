package com.linus.cynix.models;

public class AvailableShops {
    public String name;
    public String buildingName;
    public String shopNumber;
    public String email;
    public String phone;
    public String image;
    public int wear_id;

    public AvailableShops() {}

    public AvailableShops(String name, String buildingName, String shopNumber, String email, String phone,String image, int wear_id) {
        this.name = name;
        this.buildingName = buildingName;
        this.shopNumber = shopNumber;
        this.email = email;
        this.phone = phone;
        this.image=image;
        this.wear_id=wear_id;
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

    public void setwear_id(int wear_id) {
        this.wear_id = wear_id;
    }
}
