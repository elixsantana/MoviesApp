package com.example.movies.ui.nuevosestrenos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.movies.R;

public class New_Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__detalle);

        TextView det_new_tit = findViewById(R.id.titdetallenew);
        TextView det_new_res = findViewById(R.id.resnewdet);

        Intent pasa = getIntent();
        Bundle pasado = pasa.getExtras();

        if(pasado != null){
            det_new_tit.setText(pasado.getString("NTT"));
            det_new_res.setText(pasado.getString("NRT"));
        }




    }
}
