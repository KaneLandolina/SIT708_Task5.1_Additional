package com.example.task51additional;

import java.io.Serializable;
import java.util.ArrayList;

public class PropertyItem implements Serializable{

    String address, description, imageUrl, cost, bedrooms, carparks, bathrooms;

    public PropertyItem(String address, String description, String imageUrl, String cost, String bedrooms, String carparks, String bathrooms) {
        this.address = address;
        this.description = description;
        this.imageUrl = imageUrl;
        this.cost = cost;
        this.bedrooms = bedrooms;
        this.carparks = carparks;
        this.bathrooms = bathrooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCost() {
        return cost;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public String getCarparks() {
        return carparks;
    }


}
