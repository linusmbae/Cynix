package com.linus.cynix.models;

public class AvailableProducts {
    public String mName;
    public String mColor;
    public String mSize;
    public String mCategory;

    public AvailableProducts() {
    }

    public AvailableProducts(String mName, String mColor, String mSize, String mCategory) {
        this.mName = mName;
        this.mColor = mColor;
        this.mSize = mSize;
        this.mCategory = mCategory;
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
}
