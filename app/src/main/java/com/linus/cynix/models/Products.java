package com.linus.cynix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Products {
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("size")
    @Expose
    public int size;
    @SerializedName("category")
    @Expose
    public String category;


    /**
     * No args constructor for use in serialization
     *
     */
    public Products() {
    }

    /**
     *
     * @param id
     * @param name
     * @param color
     * @param size
     * @param category
     */

    public Products(int id, String name, String color, int size, String category) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
        this.category = category;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
