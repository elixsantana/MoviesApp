
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

import com.example.movies.DownloadPoster;
import com.example.movies.ProximamenteApiCall.ProxMovie;
import com.example.movies.R;

import java.util.List;

public class ProxAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contextoprox;
//    String[][] datosprox;
//    int [] datosImgprox;

    List<ProxMovie> data;

    public ProxAdapter (Context contextoprox, List<ProxMovie> data) //String[][] datosprox, int[] datosImgprox
    {
        this.contextoprox = contextoprox;
        this.data = data;
//        this.datosprox = datosprox;
//        this.datosImgprox = datosImgprox;
        inflater = (LayoutInflater)contextoprox.getSystemService(contextoprox.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.proximamente_gridview, null);
        TextView titulo_prox = (TextView)vista.findViewById(R.id.titulo_prox);
        TextView fecha_prox = (TextView)vista.findViewById(R.id.fechaProx);
        ImageView poster_prox = (ImageView) vista.findViewById(R.id.imgProx);

//        titulo_prox.setText(datosprox[i][0] );
//        fecha_prox.setText(datosprox[i][4]);

        titulo_prox.setText(data.get(i).getName());
        fecha_prox.setText(data.get(i).getDate());

//        poster_prox.setImageResource(data.get(i).ge);

        new DownloadPoster(poster_prox).execute(data.get(i).getPoster());


        return vista;
    }

    @Override
    public int getCount() {
        return data.size();  // datosImgprox.length
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
