package com.example.movies.NuevosEstrenosApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewMoviesEndpoint {

    @GET("/v2/5dc0d8b033000099001a4d42") // endpoint
    Call<List<NewMovies>> getPosts();
}
