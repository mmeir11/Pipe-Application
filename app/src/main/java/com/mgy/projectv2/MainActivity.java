package com.mgy.projectv2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static maes.tech.intentanim.CustomIntent.customType;


public class MainActivity extends Activity {

    private MediaPlayer mediaPlayer;
    private SharedPreferences sp;
    private TextView name_TextView;
    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sp = getSharedPreferences("details", MODE_PRIVATE);
        name_TextView = findViewById(R.id.name_TextView);


            if(sp.contains("notFirstRun"))   //if not first run set save name
            {
                try     //initialize the users ArrayList for score table
                {
                    users = (ArrayList<User>) ObjectSerializer.deserialize(sp.getString("users", ObjectSerializer.serialize(new ArrayList<String>())));
                    name_TextView.setText( users.get(users.size()-1).name );  //initialize the last user name

                }catch (IOException e) { e.printStackTrace(); }
                catch (ClassNotFoundException e) { e.printStackTrace(); }
            }
            else{
                String current_name = name_TextView.getText().toString();
                users.add(new User(sp.getString(current_name, null)));    //need to add the name to table
            }


        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bubbling_water);
        mediaPlayer.setLooping(true);
        PlayMusic();


        //PLAY
        ImageButton playBtn = findViewById(R.id.play_btn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LevelsActivity.class);
                startActivity(intent);
                customType(MainActivity.this,"fadein-to-fadeout");
            }
        });


        //Setting
        ImageButton settingBtn = findViewById(R.id.setting_Ib);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                View menuDialog_Layout = getLayoutInflater().inflate(R.layout.setting_dialog, null);

                LinearLayout volume_Layout = menuDialog_Layout.findViewById(R.id.volume_Layout);
                LinearLayout mute_Layout = menuDialog_Layout.findViewById(R.id.mute_Layout);
                LinearLayout howToPlay_Layout = menuDialog_Layout.findViewById(R.id.howToPlay_Layout);
                final EditText editNameEt = menuDialog_Layout.findViewById(R.id.editName_EditText);
                final ImageButton editNameBtn = menuDialog_Layout.findViewById(R.id.editName_ImageButton);

                builder.setView(menuDialog_Layout).show();

                //Edit Name
                editNameBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!editNameEt.getText().toString().isEmpty())
                        {
                            String newName = editNameEt.getText().toString();

                            name_TextView.setText(newName);
                            editNameEt.setText("");
                            Toast.makeText(MainActivity.this, "The Edit was succsses", Toast.LENGTH_SHORT).show();

                            users.add(new User(newName));   //save the new player in last index in ArrayList
                            try {   //save the names and score ArrayList
                                sp.edit().putString("users", ObjectSerializer.serialize(users));
                            } catch (IOException e) {e.printStackTrace(); }


                        }
                    }
                });

                //set volume On
                volume_Layout.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        sp.edit().putBoolean("music", true).commit();
                        PlayMusic();
                        Toast.makeText(MainActivity.this, "Sound On!", Toast.LENGTH_SHORT).show();
                    }
                });

                //set volume Off
                mute_Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sp.edit().putBoolean("music", false).commit();
                        PlayMusic();
                        Toast.makeText(MainActivity.this, "Sound Off!", Toast.LENGTH_SHORT).show();
                    }
                });

                //explain how to play
                howToPlay_Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "howToPlay....", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //Table Record
        ImageButton tableRecordBtn = findViewById(R.id.tableRecord_ImageButton);
        tableRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TableScoreActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed()     //Open Dialog before Exit       --need to design
    {
//        mediaPlayer.pause();

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);

        builder.setMessage(R.string.exit_dialog)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
                    }   })

                .setNegativeButton(R.string.no, null)
                .setCancelable(false)
                .show();

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
    protected void onPause() {

//        mediaPlayer.pause();
        super.onPause();

        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("current_name", name_TextView.getText().toString());
        editor.putBoolean("notFirstRun", false);


        try {   //save the names and score ArrayList
            editor.putString("users", ObjectSerializer.serialize(users));
        } catch (IOException e) {e.printStackTrace(); }

        editor.commit();
    }


}

