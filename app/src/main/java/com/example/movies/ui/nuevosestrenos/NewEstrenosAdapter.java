
package com.example.movies.ui.nuevosestrenos;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.TextView;

import com.example.movies.DownloadPoster;

import com.example.movies.NewMovies.NewMovies;
import com.example.movies.R;

import java.util.List;

public class NewEstrenosAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contextonew;
    List<NewMovies> data;


    public NewEstrenosAdapter (Context contextonew, List<NewMovies> data) //String [][] listanestrenos, int[] img
    {
        this.contextonew = contextonew;
        this.data = data;
        inflater = (LayoutInflater)contextonew.getSystemService(contextonew.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.new_estrenos_gridview, null);
        TextView titulo_new = (TextView)vista.findViewById(R.id.tit_newestrenos);
        ImageView poster_new = (ImageView) vista.findViewById(R.id.imgnewestrenos);

        titulo_new.setText(data.get(i).getName());
//       poster_new.setImageResource(imgNew[i]);


        new DownloadPoster(poster_new).execute(data.get(i).getPoster());

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


}
