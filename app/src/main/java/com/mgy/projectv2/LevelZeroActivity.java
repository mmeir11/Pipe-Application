package com.mgy.projectv2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class LevelZeroActivity extends Activity {

    GameObject gameObject = new GameObject(LevelZeroActivity.this, 0);

    ImageButton p1, p2, p3, p4, p5, p6, p7, p8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_zero);

//        gameObject.PlayMusic();

        gameObject.moveTv = findViewById(R.id.moves_TextView);
        gameObject.countDownTv = findViewById(R.id.countDown_TextView);

        Typeface face=Typeface.createFromAsset(/*context.*/getAssets(), "fonts/Sez.ttf");
        gameObject.moveTv.setTypeface(face);
        gameObject.countDownTv.setTypeface(face);

        gameObject.sp = getSharedPreferences("details", MODE_PRIVATE);
        try {
            gameObject.users = (ArrayList<User>) ObjectSerializer.deserialize(gameObject.sp.getString("users", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {e.printStackTrace();
        } catch (ClassNotFoundException e) {e.printStackTrace();}


        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);

        gameObject.AddToPipeList(new Pipe(p1, true, 0, 0));//0
        gameObject.AddToPipeList(new Pipe(p2, true, 2, 0));//1
        gameObject.AddToPipeList(new Pipe(p3, false, 4, 2));//2
        gameObject.AddToPipeList(new Pipe(p4, false, 2, 1));//3
        gameObject.AddToPipeList(new Pipe(p5, false, 4, 3));//4
        gameObject.AddToPipeList(new Pipe(p6, true, 0, 0));//5

        gameObject.pipeArrayList.get(1).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(1), view);
//                gameObject.moveTv.setText(gameObject.pipeArrayList.get(1).isConnection + "");
            }
        });
        gameObject.pipeArrayList.get(2).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(2), view);
//                gameObject.moveTv.setText(gameObject.pipeArrayList.get(2).isConnection + "");
            }
        });
        gameObject.pipeArrayList.get(3).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(3), view);
//                gameObject.moveTv.setText(gameObject.pipeArrayList.get(3).isConnection + "");
            }
        });
        gameObject.pipeArrayList.get(4).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(4), view);
//                gameObject.moveTv.setText(gameObject.pipeArrayList.get(4).isConnection + "");
            }
        });



        //Thread to check when the user finish good
        CheckIfFinishThread(gameObject.pipeArrayList);


        gameObject.minimumMoves = 4;
        gameObject.minimumTime = 5000;
        gameObject.maxTimeToFinish = 10000; //10 sec
        gameObject.CountDownTimer(); //Count Down Timer

    }



    //Thread to check when the user finish
    private void CheckIfFinishThread(final ArrayList<Pipe> pipeArray) {

        new Thread() {
            boolean notFinish = true;
            public void run() {

                while (notFinish)
                {
                    int i=0;
                    for (i=0 ; i<pipeArray.size() ; i++)
                    {
                        if( !pipeArray.get(i).isConnection )
                        {
                            break;
                        }
                    }
                    if(i == pipeArray.size()){
                        notFinish = false;
                        try {
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    SetAnim();
                                }
                            });
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

    private void SetAnim()
    {
        gameObject.countDownTimer.cancel();

        MediaPlayer mediaPlayerWin = MediaPlayer.create(this, R.raw.win_sound);
        if(gameObject.sp.getBoolean("music", true))
        {
            mediaPlayerWin.start();
        }

        p1.setEnabled(false);
        p2.setEnabled(false);
        p3.setEnabled(false);
        p4.setEnabled(false);
        p5.setEnabled(false);
        p6.setEnabled(false);


        p2.setImageResource(R.drawable.pipe_straight_fill_new);
        p3.setImageResource(R.drawable.pipe_borders_righttop_fill_new);
        p4.setImageResource(R.drawable.pipe_fork_top_fill_new);
        p5.setImageResource(R.drawable.pipe_borders_lefttop_fill_new);


        gameObject.animation = (AnimationDrawable) p2.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p3.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p4.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p5.getDrawable();
        gameObject.animation.start();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {        //pop Finish Dialog
            @Override
            public void run()
            {
                PopFinishDialog();
            }
        }, 2000);


    }

    //pop Finish Dialog
    private void PopFinishDialog(){

        View finishDialog_Layout = getLayoutInflater().inflate(R.layout.after_finish_dialog, null);
        finishDialog_Layout.animate().rotationY(360).setDuration(1500).start();

        TextView levelTitleTv = finishDialog_Layout.findViewById(R.id.level_title_Tv);
        TextView timeTv = finishDialog_Layout.findViewById(R.id.time_Tv);
        TextView movesTv = finishDialog_Layout.findViewById(R.id.moves_Tv);
        TextView scoreTv = finishDialog_Layout.findViewById(R.id.score_Tv);
        TextView highscoreTv = finishDialog_Layout.findViewById(R.id.Highscore_Tv);

        Button levelsBtn = finishDialog_Layout.findViewById(R.id.levels_Btn);
        Button nextBtn = finishDialog_Layout.findViewById(R.id.nextLevel_Btn);
        Button restartBtn = finishDialog_Layout.findViewById(R.id.restart_Btn);
        Button scoreTableBtn = finishDialog_Layout.findViewById(R.id.scoreTable_Btn);

        levelTitleTv.setText("Level 1");
        timeTv.setText(gameObject.countDownTv.getText());
        movesTv.setText("Moves: " + gameObject.moveTv.getText());

        int lastScore = 100 - (  Integer.parseInt(gameObject.moveTv.getText().toString()) / gameObject.minimumMoves  )*10;

        int usersArrayListSize = gameObject.users.size()-1;
        User currentUser = gameObject.users.get(usersArrayListSize);
        int current_level = 0;

        if(currentUser.scoreArray[current_level] < lastScore)   //if the last score lower update
            currentUser.scoreArray[current_level] = lastScore;

        for(int i=0 ; i<usersArrayListSize ; i++)
        {
            User user = gameObject.users.get(i);
            if( currentUser.name.equals(user.name) )     //if same player - update the high score to player and remove it
            {
                if(currentUser.scoreArray[current_level] < user.scoreArray[current_level])
                {
                    currentUser.scoreArray[current_level] = user.scoreArray[current_level];
                }
                gameObject.users.remove(user);
            }
        }
        scoreTv.setText("Score: "+ lastScore);
        highscoreTv.setText("Your High Score: " + currentUser.scoreArray[0]);

        try {   //save the score ArrayList
            gameObject.sp.edit().putString("users", ObjectSerializer.serialize(gameObject.users)).commit();
        } catch (IOException e) {e.printStackTrace(); }


        Dialog dialog = new Dialog(LevelZeroActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(finishDialog_Layout);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        if(!isFinishing())
            dialog.show();


        nextBtn.setOnClickListener(new View.OnClickListener() { //Next to level One
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelZeroActivity.this, LevelOneActivity.class);
                finish();
                startActivity(intent);
                customType(LevelZeroActivity.this,"left-to-right");
            }
        });

        restartBtn.setOnClickListener(new View.OnClickListener() { //Restart
            // Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelZeroActivity.this, LevelZeroActivity.class);
                finish();
                startActivity(intent);
                customType(LevelZeroActivity.this,"fadein-to-fadeout");

            }
        });

        levelsBtn.setOnClickListener(new View.OnClickListener() { //Next to level One
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelZeroActivity.this, LevelsActivity.class);
                finish();
                startActivity(intent);
                customType(LevelZeroActivity.this,"up-to-bottom");

            }
        });

        scoreTableBtn.setOnClickListener(new View.OnClickListener() { //Score Table
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelZeroActivity.this, TableScoreActivity.class);

                intent.putExtra("level", 0);

                startActivity(intent);
                customType(LevelZeroActivity.this,"fadein-to-fadeout");

            }
        });


    }

    @Override
    public void finish() {
        super.finish();

        customType(this,"up-to-bottom");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, LevelsActivity.class);

        startActivity(intent);
        customType(this,"up-to-bottom");

    }

}
