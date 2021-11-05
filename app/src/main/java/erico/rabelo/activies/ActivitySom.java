package erico.rabelo.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import erico.rabelo.R;

public class ActivitySom extends AppCompatActivity {

    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_som);

        mySound = MediaPlayer.create(this, R.raw.satie);


    }

    public void playMusic(View view) {
        mySound.start();
    }
}