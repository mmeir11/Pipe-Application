package com.mgy.projectv2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static maes.tech.intentanim.CustomIntent.customType;

public class LevelsActivity extends Activity implements Button.OnClickListener {

    private MediaPlayer mediaPlayer;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        Button levelZero_Btn = findViewById(R.id.levelZero_Btn);
        Button levelOne_Btn = findViewById(R.id.levelOne_Btn);
        Button levelTwo_Btn = findViewById(R.id.levelTwo_Btn);
        Button levelThree_Btn = findViewById(R.id.levelThree_Btn);
        Button levelFour_Btn = findViewById(R.id.levelFour_Btn);
        Button levelFive_Btn = findViewById(R.id.levelFive_Btn);

        levelZero_Btn.setOnClickListener(this);
        levelOne_Btn.setOnClickListener(this);
        levelTwo_Btn.setOnClickListener(this);
        levelFour_Btn.setOnClickListener(this);
        levelThree_Btn.setOnClickListener(this);


        sp = getSharedPreferences("details", MODE_PRIVATE);
        mediaPlayer = MediaPlayer.create(this, R.raw.bubbling_water);
        mediaPlayer.setLooping(true);
        PlayMusic();


    }

    private void PlayMusic()
    {
        mediaPlayer.setLooping(true);

        if(sp.getBoolean("music", true)){
            mediaPlayer.start();
        }
        else{
            if(mediaPlayer.isPlaying())
                mediaPlayer.pause();
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId())
        {
            case R.id.levelZero_Btn:
                intent = new Intent(this, LevelZeroActivity.class);
                break;
            case R.id.levelOne_Btn:
                intent = new Intent(this, LevelOneActivity.class);
                break;
            case R.id.levelTwo_Btn:
                intent = new Intent(this, LevelTwoActivity.class);
                break;
            case R.id.levelFour_Btn:
                intent = new Intent(this, LevelFourActivity.class);
                break;
            case R.id.levelThree_Btn:
                intent = new Intent(this, LevelThreeActivity.class);
                break;


        }

        finish();
        startActivity(intent);
        customType(this,"fadein-to-fadeout");
    }

    @Override
    public void finish() {
        super.finish();

        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        }

    @Override
    protected void onPause() {
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        PlayMusic();
    }
}
