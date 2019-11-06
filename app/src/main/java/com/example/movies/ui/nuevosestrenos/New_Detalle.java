package com.example.movies.ui.nuevosestrenos;

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

public class New_Detalle extends YouTubeBaseActivity {

    String trailer;
    Button btn3;
    YouTubePlayerView mYoutubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListerner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__detalle);

        TextView det_new_tit = findViewById(R.id.titdetallenew);
        TextView det_new_res = findViewById(R.id.resnewdet);

        Intent pasa = getIntent();
        Bundle pasado = pasa.getExtras();
        trailer = pasado.getString("TRAILER_NEW");

        if(pasado != null){
            det_new_tit.setText(pasado.getString("NTT"));
            det_new_res.setText(pasado.getString("NRT"));
        }


        btn3 = findViewById(R.id.btnEstrenos);

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

        btn3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                mYoutubePlayerView =  (YouTubePlayerView) findViewById(R.id.vidnewdet);

                mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListerner);
            }
        });

    }
}
