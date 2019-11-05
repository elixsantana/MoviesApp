package com.example.movies.NewMovies;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewMoviesInt {
    @GET("/v2/5dc1fc32330000b00e1a5610") // endpoint
    Call<List<NewMovies>> getEstrenos();
}
