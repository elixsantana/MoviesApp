package com.example.movies.ui.proximamente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.movies.R;

public class Prox_Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prox__detalle);

        TextView det_prox_tit = findViewById(R.id.titproxdet);
        TextView det_prox_res = findViewById(R.id.resproxdetalle);

        Intent obten = getIntent();
        Bundle obtenido = obten.getExtras();

        if(obtenido != null){
            det_prox_tit.setText(obtenido.getString("TET"));
            det_prox_res.setText(obtenido.getString("RET"));
        }


    }
}
