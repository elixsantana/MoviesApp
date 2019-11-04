package com.example.movies.restapicall;

import com.google.gson.annotations.SerializedName;

public class Movie  {

    @SerializedName("movie")
    private String movie;

    @SerializedName("trailer")
    private String trailer;

    @SerializedName("poster")
    private String poster;

    @SerializedName("genre")
    private String genre;

    @SerializedName("length")
    private String length;

    @SerializedName("mainCharacters")
    private String mainCharacters;

    @SerializedName("written")
    private String written;

    @SerializedName("producer")
    private String producer;

    @SerializedName("rating")
    private String rating;

    @SerializedName("synopsis")
    private String synopsis;


// Injecting location

    @SerializedName("location")
    private String[] location;

    public Movie() {
        this.movie = "test";
        this.poster = "test";
        this.trailer = "test";
        this.genre = "test";
        this.length = "test";
        this.mainCharacters = "test";
        this.written = "test";
        this.producer = "test";
        this.rating = "test";
        this.synopsis = "test";
        this.location = new String[50];


    }

    //GETTERS

    public String getMovie() {
        return movie;
    }

    public String getTrailer() {
        return trailer;
    }

    public String getPoster() {
        return poster;
    }

    public String getGenre() {
        return genre;
    }

    public String getLength() {
        return length;
    }

    public String getMainCharacters() {
        return mainCharacters;
    }

    public String getWritten() {
        return written;
    }

    public String getProducer() {
        return producer;
    }

    public String getRating() {
        return rating;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String[] getLocation() {
        return location;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setMainCharacters(String mainCharacters) {
        this.mainCharacters = mainCharacters;
    }

    public void setWritten(String written) {
        this.written = written;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setLocation(String[] location) {
        this.location = location;
    }


}
