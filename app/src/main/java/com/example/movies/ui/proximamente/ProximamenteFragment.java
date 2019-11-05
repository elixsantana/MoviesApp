package com.example.movies.ui.proximamente;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.ProximamenteApiCall.ProxMovie;
import com.example.movies.ProximamenteApiCall.ProxMovieEndpoint;
import com.example.movies.R;
import com.example.movies.restapicall.Movie;
import com.example.movies.restapicall.MoviesApi;
import com.example.movies.ui.estrenos.DetallesEstrenos;
import com.example.movies.ui.estrenos.EstrenosAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProximamenteFragment extends Fragment {


    private ProximamenteModel proximamenteModel;

    public List<ProxMovie> proxMovies; /*Aqui se van a pasar los datos de Retrofit*/

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        proximamenteModel =
                ViewModelProviders.of(this).get(ProximamenteModel.class);
        View root = inflater.inflate(R.layout.fragment_proximamente, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner dropdown= view.findViewById(R.id.spinner);

        String [] productores = new String[]{"Filtrar por Productores","Marvel Studios", "DC Films","Warner Bros." , "Disney Studios"};

        ArrayAdapter <String> adaptor = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, productores);
        dropdown.setAdapter(adaptor);

//        int [] imgprox = {R.drawable.terminator, R.drawable.hustlers, R.drawable.donkey, R.drawable.link};
//
//        final String[][]pelisproxx = {
//                {"Terminator Dark Flate", "Zack Snyder", "2h", "31OCT2019", "Terminator"},
//                {"Hustlers", "James Mangold", "2h:17", "28FEB2020", "Hustlers"},
//                {"Donkey King", "James Mangold", "2h:17", "30MAY2020", "DONKEY"},
//                {"Mr Link" , "James Mangold", "2h:17", "30JUL2020", "Mr Link"}
//        };


        final Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProxMovieEndpoint moviesApi = retrofit2.create(ProxMovieEndpoint.class);

        Call<List<ProxMovie>> call  = moviesApi.getPosts();

        call.enqueue(new Callback<List<ProxMovie>>() {
            @Override
            public void onResponse(Call<List<ProxMovie>> call, Response<List<ProxMovie>> response) {

                if (!response.isSuccessful()){
//                    textViewResult.setText("Code: " + response.code());
                    Log.i("API_MESSAGE\"", "Fallo");

                    return;
                }

                proxMovies = response.body();


                GridView gridproxpelis = view.findViewById(R.id.grid_prox);
                gridproxpelis.setAdapter(new ProxAdapter(getActivity(),proxMovies));

                gridproxpelis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent proxdetalle = new Intent(view.getContext(),Prox_Detalle.class);

//                        proxdetalle.putExtra("TET", pelisproxx[i][0]);
//                        proxdetalle.putExtra("RET", pelisproxx[i][4]);

                        proxdetalle.putExtra("TET", proxMovies.get(i).getName());
                        proxdetalle.putExtra("RET", proxMovies.get(i).getDate());
                        proxdetalle.putExtra("TRAILER", proxMovies.get(i).getTrailer());
                        proxdetalle.putExtra("SYNOPSIS", proxMovies.get(i).getSynopsis());


                        startActivity(proxdetalle);
                    }
                });
//
//
//
            }
//
            @Override
            public void onFailure(Call<List<ProxMovie>> call, Throwable t) {

                Log.i("API_MESSAGE", "on Failure");
            }
        });










}

}
