package com.example.movies.restapicall;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiCall {

    public static List<Movie> movies;

    public void callMyApi(){

        /*********** REST API CODE *******/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MoviesApi moviesApi = retrofit.create(MoviesApi.class);

        Call<List<Movie>> call  = moviesApi.getPosts();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {

                if (!response.isSuccessful()){
//                    textViewResult.setText("Code: " + response.code());
                    Log.i("API_MESSAGE\"", "Fallo");

                    return;
                }

                setMovies(response.body());

            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

                Log.i("API_MESSAGE", "on Failure");
            }
        });


        /**** END OF REST API CALL ****/
    }


    public  List<Movie> getTheMoviesResponse(){
        return this.movies;
    }

    public void setMovies (List<Movie> theMovie){
        this.movies = theMovie;
    }
}
