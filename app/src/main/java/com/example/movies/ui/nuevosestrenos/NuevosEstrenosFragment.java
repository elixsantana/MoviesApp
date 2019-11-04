package com.example.movies.ui.nuevosestrenos;

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

public class NuevosEstrenosFragment extends Fragment {

    private NuevosEstrenosModel nuevosEstrenosModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nuevosEstrenosModel =
                ViewModelProviders.of(this).get(NuevosEstrenosModel.class);
        View root = inflater.inflate(R.layout.fragment_new_estrenos, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner dropdowncines= view.findViewById(R.id.cinespinner);

        String [] cines = new String[]{"Por Cines","Caribbean Cinema", "Palacio del Cine"};

        ArrayAdapter<String> adaptorcine = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, cines);
        dropdowncines.setAdapter(adaptorcine);

       final String [][] listanestrenos = {
                {"La Familia Adams", "An animated version of Charles Addams' series of cartoons about a peculiar, ghoulish family."},
                {"Rambo","Rambo must confront his past and unearth his ruthless combat skills to exact revenge in a final mission."}
        };

        int [] Imgnewestrenos = {R.drawable.addams, R.drawable.rambo};

        GridView gridnewpelis = view.findViewById(R.id.gridnewestrenos);
        gridnewpelis.setAdapter(new NewEstrenosAdapter(getActivity(),listanestrenos,Imgnewestrenos));

        gridnewpelis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent newdetalle = new Intent(view.getContext(),New_Detalle.class);
                newdetalle.putExtra("NTT", listanestrenos[i][0]);
                newdetalle.putExtra("NRT", listanestrenos[i][1]);
                startActivity(newdetalle);
            }
        });


    }

}