
package com.example.movies.ui.nuevosestrenos;

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

public class NewEstrenosAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contextonew;
    String[][] datosnew;
    int [] datosImgnew;

    public NewEstrenosAdapter (Context contextonew, String [][] datosnew, int [] imagenesnew)
    {
        this.contextonew = contextonew;
        this.datosnew = datosnew;
        this.datosImgnew = imagenesnew;
        inflater = (LayoutInflater)contextonew.getSystemService(contextonew.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.new_estrenos_gridview, null);
        TextView titulo_new = (TextView)vista.findViewById(R.id.tit_newestrenos);
        ImageView poster_new = (ImageView) vista.findViewById(R.id.imgnewestrenos);

        titulo_new.setText(datosnew[i][0]);
        poster_new.setImageResource(datosImgnew[i]);



        return vista;
    }

    @Override
    public int getCount() {
        return datosImgnew.length;
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
