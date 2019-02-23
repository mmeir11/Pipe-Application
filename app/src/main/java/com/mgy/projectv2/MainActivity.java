package com.mgy.projectv2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;


public class MainActivity extends AppCompatActivity {

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
        TextView welcome_TextView = findViewById(R.id.welcome_Tv);
      /*  Typeface face=Typeface.createFromAsset(this.getAssets(), "fonts/Onick.otf");
        name_TextView.setTypeface(face);
        welcome_TextView.setTypeface(face);*/



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
    protected void onResume() {
        super.onResume();
        PlayMusic();
    }

    @Override
    protected void onPause() {

        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        super.onPause();

        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("notFirstRun", false);


        try {   //save the names and score ArrayList
            editor.putString("users", ObjectSerializer.serialize(users));
        } catch (IOException e) {e.printStackTrace(); }

        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.soundOn){
            sp.edit().putBoolean("music", true).commit();
            PlayMusic();
            Toast.makeText(MainActivity.this, getResources().getString(R.string.soundOn) + "", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.soundOff){
            sp.edit().putBoolean("music", false).commit();
            PlayMusic();
            Toast.makeText(MainActivity.this, getResources().getString(R.string.soundOff) + "", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.changeName){

            View menuDialog_Layout = getLayoutInflater().inflate(R.layout.change_name_dialog, null);



          /* Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.setContentView(menuDialog_Layout);
                if(!isFinishing())
                dialog.show();*/



            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

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

        }
        return super.onOptionsItemSelected(item);
    }
}

