package com.linus.cynix.models;

public class AvailableShops {
    public String mName;
    public String mBuildingName;
    public String mShopNumber;
    public String mEmail;
    public String mPhone;
    public String mImage;
    public int mWear_id;

    public AvailableShops() {}

    public AvailableShops(String name, String buildingName, String shopNumber, String email, String phone,String image, int wear_id) {
        this.mName = name;
        this.mBuildingName = buildingName;
        this.mShopNumber = shopNumber;
        this.mEmail = email;
        this.mPhone = phone;
        this.mImage=image;
        this.mWear_id=wear_id;
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

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public int getmWear_id() {
        return mWear_id;
    }

    public void setmWear_id(int mWear_id) {
        this.mWear_id = mWear_id;
    }
}
