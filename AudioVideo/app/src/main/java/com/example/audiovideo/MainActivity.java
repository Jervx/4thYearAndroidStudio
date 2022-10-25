package com.example.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoPlayer = findViewById(R.id.videoView);
        videoPlayer.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.beed_cover_vid);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoPlayer);
        videoPlayer.setMediaController(mediaController);

        mediaPlayer = null;
    }

    private void stopMusic(){
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public void music(View view){
        int viewId = view.getId();
        if(viewId == R.id.btnPlay){
            if(mediaPlayer == null) mediaPlayer = MediaPlayer.create(this, R.raw.beer_cover);
            mediaPlayer.setOnCompletionListener(e -> stopMusic());
            mediaPlayer.start();
        }
        if(viewId == R.id.btnPause) mediaPlayer.pause();
        if(viewId == R.id.btnStop) if(mediaPlayer != null) mediaPlayer.stop();
    }

    @Override
    protected void onStop(){
        super.onStop();
        stopMusic();
    }
}