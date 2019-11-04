package com.example.movies.ui.proximamente;

import android.content.Intent;
import android.os.Bundle;
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

import com.example.movies.R;

import java.util.ArrayList;

public class ProximamenteFragment extends Fragment {


    private ProximamenteModel proximamenteModel;

    ArrayList<String> lista; /*Aqui se van a pasar los datos de Retrofit*/

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        proximamenteModel =
                ViewModelProviders.of(this).get(ProximamenteModel.class);
        View root = inflater.inflate(R.layout.fragment_proximamente, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner dropdown= view.findViewById(R.id.spinner);

        String [] productores = new String[]{"Filtrar por Productores","Marvel Studios", "DC Films","Warner Bros." , "Disney Studios"};

        ArrayAdapter <String> adaptor = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, productores);
        dropdown.setAdapter(adaptor);



        final String[][]pelisproxx = {
                {"Terminator Dark Flate", "Zack Snyder", "2h", "31OCT2019", "Terminator"},
                {"Hustlers", "James Mangold", "2h:17", "28FEB2020", "Hustlers"},
                {"Donkey King", "James Mangold", "2h:17", "30MAY2020", "DONKEY"},
                {"Mr Link" , "James Mangold", "2h:17", "30JUL2020", "Mr Link"}
        };
        int [] imgprox = {R.drawable.terminator, R.drawable.hustlers, R.drawable.donkey, R.drawable.link};

        GridView gridproxpelis = view.findViewById(R.id.grid_prox);
        gridproxpelis.setAdapter(new ProxAdapter(getActivity(),pelisproxx,imgprox));

        gridproxpelis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent proxdetalle = new Intent(view.getContext(),Prox_Detalle.class);
                proxdetalle.putExtra("TET", pelisproxx[i][0]);
                proxdetalle.putExtra("RET", pelisproxx[i][4]);
                startActivity(proxdetalle);
            }
        });



    }
}