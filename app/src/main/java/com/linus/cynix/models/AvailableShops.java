package com.linus.cynix.models;

public class AvailableShops {
    public String mName;
    public String mBuildingName;
    public String mShopNumber;
    public String mEmail;
    public String mPhone;

    public AvailableShops() {}

    public AvailableShops(String name, String buildingName, String shopNumber, String email, String phone) {
        this.mName = name;
        this.mBuildingName = buildingName;
        this.mShopNumber = shopNumber;
        this.mEmail = email;
        this.mPhone = phone;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmBuildingName() {
        return mBuildingName;
    }

    public void setmBuildingName(String mBuildingName) {
        this.mBuildingName = mBuildingName;
    }

    public String getmShopNumber() {
        return mShopNumber;
    }

    public void setmShopNumber(String mShopNumber) {
        this.mShopNumber = mShopNumber;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
