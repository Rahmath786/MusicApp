package com.rahmath786.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.rahmath786.musicapp.databinding.ActivityPlayerBinding;

public class PlayerActivity extends AppCompatActivity {

    private ActivityPlayerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_player);
        binding.musicTitle.setText("Sound1");

        binding.playPause.setOnClickListener(v -> {

        });

        binding.nextSong.setOnClickListener(v -> {

        });

        binding.previousSong.setOnClickListener(v -> {

        });
    }
}