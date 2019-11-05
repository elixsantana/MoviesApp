package com.example.movies.ui.nuevosestrenos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.NewMovies.NewMovies;
import com.example.movies.NewMovies.NewMoviesInt;

import com.example.movies.R;
import com.example.movies.ui.proximamente.ProxAdapter;
import com.example.movies.ui.proximamente.Prox_Detalle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NuevosEstrenosFragment extends Fragment {

    private NuevosEstrenosModel nuevosEstrenosModel;
    public List<NewMovies> newMovies;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nuevosEstrenosModel =
                ViewModelProviders.of(this).get(NuevosEstrenosModel.class);
        View root = inflater.inflate(R.layout.fragment_new_estrenos, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner dropdowncines= view.findViewById(R.id.cinespinner);

        String [] cines = new String[]{"Por Cines","Caribbean Cinema", "Palacio del Cine"};

        ArrayAdapter<String> adaptorcine = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, cines);
        dropdowncines.setAdapter(adaptorcine);


//        final int [] Imgnewestrenos = {R.drawable.addams, R.drawable.rambo};


        final Retrofit retrofit3 = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewMoviesInt moviesApi3 = retrofit3.create(NewMoviesInt.class);

        Call<List<NewMovies>> call3  = moviesApi3.getEstrenos();

        call3.enqueue(new Callback<List<NewMovies>>() {
            @Override
            public void onResponse(Call<List<NewMovies>> call, Response<List<NewMovies>> response) {

                if (!response.isSuccessful()){
//                    Log.d("API" , String.valueOf(response.code()) );
                    Log.i("API_MESSAGE\"", "Fallo");

                    return;
                }

                newMovies = response.body();


                GridView gridnewpelis = view.findViewById(R.id.gridnewestrenos);
                gridnewpelis.setAdapter(new NewEstrenosAdapter(getActivity(), newMovies));

                gridnewpelis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent newdetalle = new Intent(view.getContext(),New_Detalle.class);
                        newdetalle.putExtra("NTT",newMovies.get(i).getName());
                        newdetalle.putExtra("NRT", newMovies.get(i).getSynopsis());
                        newdetalle.putExtra("TRAILER3", newMovies.get(i).getTrailer());
                        startActivity(newdetalle);
                    }
                });


            }

            @Override
            public void onFailure(Call<List<NewMovies>> call, Throwable t) {

                Log.i("API_MESSAGE", "on Failure");


            }
        });











    }

}