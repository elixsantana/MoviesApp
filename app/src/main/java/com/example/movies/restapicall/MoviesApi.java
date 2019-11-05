package com.example.movies.restapicall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {

    @GET("v2/5dc04c9a310000d1d3be402b") // endpoint
    Call<List<Movie>> getPosts();
}
