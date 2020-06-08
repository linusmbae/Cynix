package com.linus.cynix.models;

public class AvailableProducts {
    public String mName;
    public String mColor;
    public String mSize;
    public String mShop_id;
    public String mCategory;
    public String mImage;

    public AvailableProducts() {
    }

    public AvailableProducts(String mName, String mColor, String mSize,String shop_id, String mCategory,String image) {
        this.mName = mName;
        this.mColor = mColor;
        this.mSize = mSize;
        this.mShop_id=shop_id;
        this.mCategory = mCategory;
        this.mImage=image;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmColor() {
        return mColor;
    }

    public void setmColor(String mColor) {
        this.mColor = mColor;
    }

    public String getmSize() {
        return mSize;
    }

    public void setmSize(String mSize) {
        this.mSize = mSize;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getmShop_id() {
        return mShop_id;
    }

    public void setmShop_id(String mShop_id) {
        this.mShop_id = mShop_id;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }
}
