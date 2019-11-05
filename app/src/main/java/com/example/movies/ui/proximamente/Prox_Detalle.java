package com.example.movies.ui.proximamente;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.movies.R;
import com.example.movies.YoutubeConfig;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Prox_Detalle extends YouTubeBaseActivity {
    String trailer;
    Button btn;
    YouTubePlayerView mYoutubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListerner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prox__detalle);

        TextView det_prox_tit = findViewById(R.id.titproxdet);
        TextView det_prox_res = findViewById(R.id.resproxdetalle);

        Intent obten = getIntent();
        Bundle obtenido = obten.getExtras();
        trailer = obtenido.getString("TRAILER");

        if(obtenido != null){
            det_prox_tit.setText(obtenido.getString("TET"));
            det_prox_res.setText(obtenido.getString("SYNOPSIS"));

        }


        btn = findViewById(R.id.btnProx);

        mOnInitializedListerner = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(trailer);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult
                    youTubeInitializationResult) {

            }


        };

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                mYoutubePlayerView =  (YouTubePlayerView) findViewById(R.id.videoProxdetalle);

                mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListerner);
            }
        });
    }

    }
