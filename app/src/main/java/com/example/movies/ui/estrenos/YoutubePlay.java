package com.example.movies.ui.estrenos;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.movies.R;
import com.example.movies.YoutubeConfig;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubePlay extends AppCompatActivity {


    Button btn;
    YouTubePlayerView mYoutubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListerner;

    public void playVideo(String url) {

        btn = findViewById(R.id.btn);

        mOnInitializedListerner = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("t433PEQGErc");
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
