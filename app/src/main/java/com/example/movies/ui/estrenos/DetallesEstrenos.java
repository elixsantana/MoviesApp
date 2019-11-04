package com.example.movies.ui.estrenos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import android.support.v4.app.*;

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
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetallesEstrenos extends YouTubeBaseActivity {

    String trailer;
    Button btn;
    YouTubePlayerView mYoutubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListerner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_estrenos);

        TextView det_titulo = findViewById(R.id.titulo_detalle_estreno);
        TextView det_sipnosis = findViewById(R.id.descripciondetalle_es);
        TextView location = findViewById(R.id.textView5);

        Intent intent = getIntent();
        Bundle pasar = intent.getExtras();
        trailer = pasar.getString("TRAILER)");

        if (pasar != null) {
            det_titulo.setText(pasar.getString("TIT"));
            det_sipnosis.setText(pasar.getString("DET"));
            location.setText(pasar.getString("LOCATION"));

        }

//        YoutubePlay startPlaying = new YoutubePlay();
//        startPlaying.playVideo(trailer);


            btn = findViewById(R.id.btn);

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
                    mYoutubePlayerView =  (YouTubePlayerView) findViewById(R.id.youtubePlay);

                    mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListerner);
                }
            });
        }

    }

