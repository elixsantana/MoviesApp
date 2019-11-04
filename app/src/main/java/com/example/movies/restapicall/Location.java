package com.example.movies.restapicall;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Location {

    @SerializedName("location")
    private String[] location;


    public Location(String loc) {
        this.location = location;
    }

    //GETTERS
    public String[] getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return Arrays.toString(location);
    }
}
