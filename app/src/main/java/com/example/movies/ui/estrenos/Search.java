package com.example.movies.ui.estrenos;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movies.R;
import com.example.movies.restapicall.Movie;

import java.util.List;

public class Search extends AppCompatActivity {

    public List<Movie> movies;
    EditText et1;


    public Search(){

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        et1 = findViewById(R.id.search);
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                movies.get(i).getMovie()
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

//    public List<ProxMovie> searchMovie (List<ProxMovie> moviesFragment){
//
//
//
//    }

}
