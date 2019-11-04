
package com.example.movies.ui.proximamente;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movies.R;

public class ProxAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contextoprox;
    String[][] datosprox;
    int [] datosImgprox;

    public ProxAdapter (Context contextoprox, String [][] datosprox, int [] imagenesprox)
    {
        this.contextoprox = contextoprox;
        this.datosprox = datosprox;
        this.datosImgprox = imagenesprox;
        inflater = (LayoutInflater)contextoprox.getSystemService(contextoprox.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.proximamente_gridview, null);
        TextView titulo_prox = (TextView)vista.findViewById(R.id.titulo_prox);
        TextView fecha_prox = (TextView)vista.findViewById(R.id.fechaProx);
        ImageView poster_prox = (ImageView) vista.findViewById(R.id.imgProx);

        titulo_prox.setText(datosprox[i][0]);
        fecha_prox.setText(datosprox[i][3]);
        poster_prox.setImageResource(datosImgprox[i]);



        return vista;
    }

    @Override
    public int getCount() {
        return datosImgprox.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
