package com.example.movies.ui.estrenos;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.movies.R;
import com.example.movies.restapicall.Movie;
import com.example.movies.restapicall.MoviesApi;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EstrenosFragment extends Fragment implements TextWatcher {

    private EstrenosModel estrenosModel;
    public List<Movie> movies;
    EstrenosAdapter filtrarEstrenos = new EstrenosAdapter();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        estrenosModel =
                ViewModelProviders.of(this).get(EstrenosModel.class);
        View root = inflater.inflate(R.layout.fragment_estrenos, container, false);
        return root;

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        final int[] Imgestrenos = {R.drawable.liga, R.drawable.logan};

        final Retrofit retrofit = new Retrofit.Builder()
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

                movies = response.body();
                final EstrenosAdapter myAdapter = new EstrenosAdapter(getActivity(),movies,Imgestrenos);
                filtrarEstrenos = myAdapter;

                ListView listaestrenos = view.findViewById(R.id.estrenoslista);
                listaestrenos.setAdapter(myAdapter);


                listaestrenos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent verDetalles = new Intent(view.getContext(), DetallesEstrenos.class);

                        verDetalles.putExtra("TIT", movies.get(i).getMovie());
                        verDetalles.putExtra("DET", movies.get(i).getSynopsis());
                        verDetalles.putExtra("TRAILER", movies.get(i).getTrailer());
                        verDetalles.putExtra("LOCATION", Arrays.toString(movies.get(i).getLocation()));
                        startActivity(verDetalles);
                    }
                });

            }


            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

                Log.i("API_MESSAGE", "on Failure");
            }
        });


        /**** END OF REST API CALL ****/

        EditText buscar = (EditText)view.findViewById(R.id.search);
        buscar.addTextChangedListener(this);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        this.filtrarEstrenos.getFilter().filter(charSequence);


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}