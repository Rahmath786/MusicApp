package com.rahmath786.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.database.DatabaseUtils;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.rahmath786.musicapp.databinding.ActivityMainBinding;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initializeViews();
        mediaPlayer = MediaPlayer.create(this, R.raw.sound1);
        binding.musicTitle.setText("Sound1");


        binding.playPause.setOnClickListener(v -> {
            if (!mediaPlayer.isPlaying()) {
                binding.playPause.setImageResource(R.drawable.pause_new);
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            } else {
                binding.playPause.setImageResource(R.drawable.play_new);
                mediaPlayer.setLooping(false);
                mediaPlayer.pause();
            }
        });

        binding.nextSong.setOnClickListener(v -> {

        });

        binding.previousSong.setOnClickListener(v -> {

        });
    }

    private void areAllPermissionsGranted() {
        /** here we will check for the permissions required like
         * read storage etc */


    }

    private void initializeViews() {

    }
}