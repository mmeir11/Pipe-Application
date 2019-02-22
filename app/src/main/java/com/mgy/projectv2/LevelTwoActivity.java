package com.mgy.projectv2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class LevelTwoActivity extends Activity {


    GameObject gameObject = new GameObject();

    ImageButton pS, p1, p2, p3, p4, p5, p6, p7,
            p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);

        gameObject.countDownTv = findViewById(R.id.countDown_TextView);
        gameObject.moveTv = findViewById(R.id.moves_TextView);
        gameObject.sp = getSharedPreferences("details", MODE_PRIVATE);
        try {
            gameObject.users = (ArrayList<User>) ObjectSerializer.deserialize(gameObject.sp.getString("users", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {e.printStackTrace();
        } catch (ClassNotFoundException e) {e.printStackTrace();}

        pS = findViewById(R.id.pT);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        p7 = findViewById(R.id.p7);
        p8 = findViewById(R.id.p8);
        p9 = findViewById(R.id.p9);
        p10 = findViewById(R.id.p10);
        p11 = findViewById(R.id.p11);
        p12 = findViewById(R.id.p12);
        p13 = findViewById(R.id.p13);
        p14 = findViewById(R.id.p14);
        p15 = findViewById(R.id.p15);
        p16 = findViewById(R.id.p16);
        p17 = findViewById(R.id.p17);
        p18 = findViewById(R.id.p18);
        p19 = findViewById(R.id.p19);
        p20 = findViewById(R.id.p20);

        gameObject.AddToPipeList(new Pipe(pS, true, 0, 0));
        gameObject.AddToPipeList(new Pipe(p1, true, 0, 0));
        gameObject.AddToPipeList(new Pipe(p2, false, 4, 3));
        gameObject.AddToPipeList(new Pipe(p3, false, 4, 2));
        gameObject.AddToPipeList(new Pipe(p4, true, 0, 0));
        gameObject.AddToPipeList(new Pipe(p5, false, 4, 1));
        gameObject.AddToPipeList(new Pipe(p6, false, 4, 3));
        gameObject.AddToPipeList(new Pipe(p7, true, 4, 0));
        gameObject.AddToPipeList(new Pipe(p8, true, 4, 0));
        gameObject.AddToPipeList(new Pipe(p9, true, 4, 0));
        gameObject.AddToPipeList(new Pipe(p10, false, 2, 1));
        gameObject.AddToPipeList(new Pipe(p11, true, 4, 0));
        gameObject.AddToPipeList(new Pipe(p12, true, 4, 0));
        gameObject.AddToPipeList(new Pipe(p13, true, 4, 0));
        gameObject.AddToPipeList(new Pipe(p14, true, 4, 0));
        gameObject.AddToPipeList(new Pipe(p15, false, 4, 2));
        gameObject.AddToPipeList(new Pipe(p16, false, 0, 0));
        gameObject.AddToPipeList(new Pipe(p17, true, 4, 0));
        gameObject.AddToPipeList(new Pipe(p18, false, 4, 3));
        gameObject.AddToPipeList(new Pipe(p19, true, 2, 0));
        gameObject.AddToPipeList(new Pipe(p20, true, 2, 0));




        gameObject.pipeArrayList.get(1).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameObject.Rotate(view);

            }
        });
        gameObject.pipeArrayList.get(6).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(6), view);
            }
        });
        gameObject.pipeArrayList.get(5).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(5), view);

            }
        });
        gameObject.pipeArrayList.get(10).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(10), view);

            }
        });
        gameObject.pipeArrayList.get(14).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeTwoOption(gameObject.pipeArrayList.get(14), view, 0 ,1);
            }
        });
        gameObject.pipeArrayList.get(15).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(15), view);

            }
        });
        gameObject.pipeArrayList.get(18).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(18), view);
            }
        });
        gameObject.pipeArrayList.get(19).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(19), view);

            }
        });
        gameObject.pipeArrayList.get(20).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(20), view);
            }
        });


        gameObject.pipeArrayList.get(2).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);
            }
        });
        gameObject.pipeArrayList.get(3).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameObject.Rotate(view);
            }
        });
        gameObject.pipeArrayList.get(7).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);

            }
        });
        gameObject.pipeArrayList.get(8).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);

            }
        });
        gameObject.pipeArrayList.get(11).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);

            }
        });
        gameObject.pipeArrayList.get(12).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);
            }
        });
        gameObject.pipeArrayList.get(13).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);

            }
        });
        gameObject.pipeArrayList.get(17).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);

            }
        });

        gameObject.pipeArrayList.get(4).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);

            }
        });



        //Thread to check when the user finish
        ArrayList<Pipe> arrayListToCheck = new ArrayList<>();
        arrayListToCheck.add(gameObject.pipeArrayList.get(1));
        arrayListToCheck.add(gameObject.pipeArrayList.get(6));
        arrayListToCheck.add(gameObject.pipeArrayList.get(5));
        arrayListToCheck.add(gameObject.pipeArrayList.get(10));
        arrayListToCheck.add(gameObject.pipeArrayList.get(14));
        arrayListToCheck.add(gameObject.pipeArrayList.get(15));
        arrayListToCheck.add(gameObject.pipeArrayList.get(18));
        arrayListToCheck.add(gameObject.pipeArrayList.get(19));
        arrayListToCheck.add(gameObject.pipeArrayList.get(20));
        CheckIfFinishThread(arrayListToCheck);


        gameObject.minimumMoves = 8;
        gameObject.minimumTime = 10000;
        gameObject.maxTimeToFinish = 25000;//25 sec
        gameObject.CountDownTimer();   //Count Down Timer

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

        for (Pipe pipe : gameObject.pipeArrayList)
            pipe.pipeImage.setEnabled(false);


        p1.setImageResource(R.drawable.pipe_four_fill_new);
        p6.setImageResource(R.drawable.pipe_borders_leftbottom_fill_new);
        p5.setImageResource(R.drawable.pipe_borders_leftbottom_fill_new);
        p10.setImageResource(R.drawable.pipe_straight_fill_new);           //need to change!!!!
        p14.setImageResource(R.drawable.pipe_fork_top_fill_new);
        p15.setImageResource(R.drawable.pipe_borders_righttop_fill_new);
        p18.setImageResource(R.drawable.pipe_borders_lefttop_fill_new);
        p19.setImageResource(R.drawable.pipe_fork_top_fill_new);
        p20.setImageResource(R.drawable.pipe_straight_fill_new);           //need to change!!!!


        gameObject.animation = (AnimationDrawable) p1.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p6.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p5.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p10.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p14.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p15.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p18.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p19.getDrawable();
        gameObject.animation.start();
        gameObject.animation = (AnimationDrawable) p20.getDrawable();
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

        levelTitleTv.setText("Level 3");
        timeTv.setText(gameObject.countDownTv.getText());
        movesTv.setText(gameObject.moveTv.getText());

        int lastScore = 100 - (  Integer.parseInt(movesTv.getText().toString()) / gameObject.minimumMoves  )*10;

        int usersArrayListSize = gameObject.users.size()-1;
        User currentUser = gameObject.users.get(usersArrayListSize);
        final int current_level = 2;

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
        highscoreTv.setText("Your High Score: " + currentUser.scoreArray[current_level]);

        try {   //save the score ArrayList
            gameObject.sp.edit().putString("users", ObjectSerializer.serialize(gameObject.users)).commit();
        } catch (IOException e) {e.printStackTrace(); }


        Dialog dialog = new Dialog(LevelTwoActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(finishDialog_Layout);
        dialog.setCanceledOnTouchOutside(false);
        if(!isFinishing())
            dialog.show();

        //Next to level Two
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelTwoActivity.this, LevelTwoActivity.class);
                finish();
                startActivity(intent);
                customType(LevelTwoActivity.this,"left-to-right");

            }
        });

        //Restart
        restartBtn.setOnClickListener(new View.OnClickListener() {
            // Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelTwoActivity.this, LevelTwoActivity.class);
                finish();
                startActivity(intent);
                customType(LevelTwoActivity.this,"fadein-to-fadeout");

            }
        });

        //all Levels
        levelsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelTwoActivity.this, LevelsActivity.class);
                finish();
                startActivity(intent);
                customType(LevelTwoActivity.this,"up-to-bottom");

            }
        });

        //Score Table
        scoreTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(LevelTwoActivity.this, TableScoreActivity.class);

                intent.putExtra("level", current_level);

                finish();
                startActivity(intent);
                customType(LevelTwoActivity.this,"fadein-to-fadeout");
            }
        });


    }

    @Override
    public void finish() {
        super.finish();
        customType(this,"up-to-bottom");
    }

}
