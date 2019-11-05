package com.example.movies.ProximamenteApiCall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProxMovieEndpoint {

    @GET("/v2/5dc08e44310000810bbe41b3") // endpoint
    Call<List<ProxMovie>> getPosts();
}
