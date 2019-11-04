package com.example.movies;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import java.io.InputStream;

public class DownloadPoster extends AsyncTask<String, Void, Bitmap> {

    ImageView imgView;
    ImageView img;
    Bitmap bitmap;

    public DownloadPoster(ImageView imgV){
        this.imgView = imgV;
    }


    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Bitmap doInBackground(String... url) {
        String urlInfo = url[0];
        bitmap = null;

        try{
            InputStream srt = new java.net.URL(urlInfo).openStream();
            bitmap = BitmapFactory.decodeStream(srt);
        }

        catch (Exception e){
            e.printStackTrace();
        }


        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        imgView.setImageBitmap(bitmap);
    }
}
