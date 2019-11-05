package com.example.movies.ProximamenteApiCall;

import com.google.gson.annotations.SerializedName;

public class ProxMovie {

    @SerializedName("name")
    private String name;

    @SerializedName("trailer")
    private String trailer;

    @SerializedName("date")
    private String date;

    @SerializedName("poster")
    private String poster;

    @SerializedName("synopsis")
    private String synopsis;

    @SerializedName("state")
    private String state;

    public ProxMovie(String name, String trailer, String date, String poster, String synopsis, String state) {
        this.name = name;
        this.trailer = trailer;
        this.date = date;
        this.poster = poster;
        this.synopsis = synopsis;
        this.state = state;
    }


    //GETTERS


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
