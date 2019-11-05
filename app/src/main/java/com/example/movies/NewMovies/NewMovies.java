package com.example.movies.NewMovies;

import com.google.gson.annotations.SerializedName;

public class NewMovies {


        @SerializedName("name")
        private String name;

        @SerializedName("trailer")
        private String trailer;

        @SerializedName("poster")
        private String poster;

        @SerializedName("synopsis")
        private String synopsis;


        @SerializedName("location")
        private String[] location;


        public NewMovies(String name, String trailer, String poster, String synopsis, String[] location) {
            this.name = name;
            this.trailer = trailer;
            this.poster = poster;
            this.synopsis = synopsis;
            this.location = location;
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

        public String[] getLocation() {
            return location;
        }

        public void setLocation(String[] location) {
            this.location = location;
        }


}
