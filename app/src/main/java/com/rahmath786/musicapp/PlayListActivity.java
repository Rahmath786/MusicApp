package com.rahmath786.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import com.rahmath786.musicapp.databinding.ActivityMainBinding;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayListActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initializeViews();
        mediaPlayer = MediaPlayer.create(this, R.raw.sound1);


        scanAudio();
    }

    private void scanAudio() {
        List<MediaStore.Audio> mp3List = new ArrayList<>();

        String[] proj = {MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DISPLAY_NAME};
        ArrayList<String> audioList = new ArrayList<>();

        Cursor audioCursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, proj, null, null, null);

        if (audioCursor != null) {
            if (audioCursor.moveToFirst()) {
                do {
                    int audioIndex = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
                    audioList.add(audioCursor.getString(audioIndex));
                } while (audioCursor.moveToNext());
            }
        }
        audioCursor.close();
        Log.i("scanAudio", "scanAudio: " + audioList.toString());

    }


    private void areAllPermissionsGranted() {
        /** here we will check for the permissions required like
         * read storage etc */
    }

    private void initializeViews() {

    }
}