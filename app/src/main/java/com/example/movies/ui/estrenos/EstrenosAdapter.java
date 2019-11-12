package com.example.movies.ui.estrenos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movies.DownloadPoster;
import com.example.movies.R;
import com.example.movies.restapicall.Movie;

import java.util.ArrayList;
import java.util.List;

public class EstrenosAdapter extends BaseAdapter implements Filterable {


    private static LayoutInflater inflater = null;
    Context contexto;
    List<Movie> data, datostemp;
    int [] datosImg;
    CustomFilter cs;
    public EstrenosAdapter (){

    }

    public EstrenosAdapter (Context contexto, List<Movie> data, int[] imagenes)
    {
        this.contexto = contexto;
        this.data = data;
        this.datostemp = data;
        this.datosImg = imagenes;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.estrenos_listview, null);
        TextView titulo = (TextView)vista.findViewById(R.id.titulopeli);
        TextView duracion = (TextView) vista.findViewById(R.id.duracion);
        TextView director = (TextView) vista.findViewById(R.id.director);
        ImageView poster = (ImageView) vista.findViewById(R.id.imgpeli);
        RatingBar puntuacion = (RatingBar) vista.findViewById(R.id.ratingBar);

        titulo.setText(data.get(i).getMovie());
        director.setText(data.get(i).getWritten());
        duracion.setText("Duracion" +" "+ data.get(i).getLength() );
        // poster.setImageResource(datosImg[0]);
        puntuacion.setProgress(Integer.valueOf(data.get(i).getRating()));

        new DownloadPoster(poster).execute(data.get(i).getPoster());


        return vista;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public Filter getFilter() {
        if (cs == null)
        {
            cs = new CustomFilter();
        }

        return cs;
    }
    class CustomFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering (CharSequence constraint){
            FilterResults results = new FilterResults();
            List<Movie> filtrado = new ArrayList<Movie>();


            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();


                for (int i = 0; i < datostemp.size(); i++) {
                    if (datostemp.get(i).getMovie().toUpperCase().contains(constraint)) {
                        filtrado.add(datostemp.get(i));
                    }
                }

                results.count = filtrado.size();
                results.values = filtrado;

            }
            else
            {
                results.count = datostemp.size();
                results.values = datostemp;

            }

            return results;
        }
        @Override
        protected void publishResults (CharSequence charSequence, FilterResults filterResults){
            data = (ArrayList<Movie>)filterResults.values;
            notifyDataSetChanged();

        }


    }


}