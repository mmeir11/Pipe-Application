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

import static java.lang.Thread.sleep;
import static maes.tech.intentanim.CustomIntent.customType;

public class LevelOneActivity extends Activity implements ImageButton.OnClickListener {


    int move = 0;
    AnimationDrawable animation;

    private ArrayList<Pipe> arrayListToCheck;
    GameObject gameObject = new GameObject(this, 1);

    ImageButton p1, p2, p3, p4, p5, p6, p7,
            p8, p9, p10, p11, p12, p13, p14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);


        gameObject.moveTv = findViewById(R.id.moves_TextView);
        gameObject.countDownTv = findViewById(R.id.countDown_TextView);
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
        p7 = findViewById(R.id.p7);
        p8 = findViewById(R.id.p8);
        p9 = findViewById(R.id.p9);
        p10 = findViewById(R.id.p10);
        p11 = findViewById(R.id.p11);
        p12 = findViewById(R.id.p12);
        p13 = findViewById(R.id.p13);
        p14 = findViewById(R.id.p14);


        gameObject.AddToPipeList(new Pipe(p1, true, 0, 0));//0
        gameObject.AddToPipeList(new Pipe(p2, false, 2, 1));//1
        gameObject.AddToPipeList(new Pipe(p3, false, 4, 2));//2
        gameObject.AddToPipeList(new Pipe(p4, true, 0, 0));//3
        gameObject.AddToPipeList(new Pipe(p7, false, 4, 1));//4
        gameObject.AddToPipeList(new Pipe(p6, false, 4, 0));//5
        gameObject.AddToPipeList( new Pipe(p5, true, 0, 0));//6
        gameObject.AddToPipeList(new Pipe(p8, false, 4, 3));//7
        gameObject.AddToPipeList(new Pipe(p9, false, 2, 1));//8
        gameObject.AddToPipeList(new Pipe(p10, true, 0, 0));//9
        gameObject.AddToPipeList(new Pipe(p11, true, 2, 0));//10
        gameObject.AddToPipeList(new Pipe(p13, false, 4, 2));//11
        gameObject.AddToPipeList(new Pipe(p14, true, 2, 0));//12
        gameObject.AddToPipeList(new Pipe(p12, true, 0, 0));//13



        gameObject.pipeArrayList.get(1).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(1), view);
            }
        });
        gameObject.pipeArrayList.get(2).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(2), view);
            }
        });
        gameObject.pipeArrayList.get(4).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(4), view);
            }
        });
        gameObject.pipeArrayList.get(5).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeTwoOption(gameObject.pipeArrayList.get(5), view,1, 2 );

            }
        });
        gameObject.pipeArrayList.get(8).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(8), view);
            }
        });
        gameObject.pipeArrayList.get(11).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(11), view);
            }
        });
        gameObject.pipeArrayList.get(12).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(12), view);
            }
        });


        gameObject.pipeArrayList.get(3).pipeImage.setOnClickListener(this);
        gameObject.pipeArrayList.get(6).pipeImage.setOnClickListener(this);
        gameObject.pipeArrayList.get(7).pipeImage.setOnClickListener(this);
        gameObject.pipeArrayList.get(9).pipeImage.setOnClickListener(this);
        gameObject.pipeArrayList.get(10).pipeImage.setOnClickListener(this);
        gameObject.pipeArrayList.get(13).pipeImage.setOnClickListener(this);



        //Thread to check when the user finish
        arrayListToCheck = new ArrayList<>();
        arrayListToCheck.add(gameObject.pipeArrayList.get(0));
        arrayListToCheck.add(gameObject.pipeArrayList.get(1));
        arrayListToCheck.add(gameObject.pipeArrayList.get(2));
        arrayListToCheck.add(gameObject.pipeArrayList.get(4));
        arrayListToCheck.add(gameObject.pipeArrayList.get(5));
        arrayListToCheck.add(gameObject.pipeArrayList.get(8));
        arrayListToCheck.add(gameObject.pipeArrayList.get(11));
        arrayListToCheck.add(gameObject.pipeArrayList.get(12));
        CheckIfFinishThread(arrayListToCheck);


        gameObject.minimumMoves = 10;
        gameObject.minimumTime = 10000;
        gameObject.maxTimeToFinish = 25000;//25 sec
        gameObject.CountDownTimer();   //Count Down Timer






    }



    @Override
    public void onClick(View view)  //just rotate
    {
        gameObject.Rotate(view);
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
                            sleep(300);
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

        p1.setEnabled(false);
        p2.setEnabled(false);
        p3.setEnabled(false);
        p4.setEnabled(false);
        p5.setEnabled(false);
        p6.setEnabled(false);
        p7.setEnabled(false);
        p8.setEnabled(false);
        p9.setEnabled(false);
        p10.setEnabled(false);
        p11.setEnabled(false);
        p12.setEnabled(false);
        p13.setEnabled(false);
        p14.setEnabled(false);

        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            p2.setImageResource(R.drawable.pipe_vertical_fill_new);
                            animation = (AnimationDrawable) p2.getDrawable();
                            animation.start();
                        }catch (Exception e) { e.printStackTrace(); }
                    }
                });
                try {
                    sleep(800);
                }catch (Exception e) {}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        p3.setImageResource(R.drawable.pipe_borders_righttop_fill_new);
                        animation = (AnimationDrawable) p3.getDrawable();
                        animation.start();
                    }
                });
                try {
                    sleep(800);
                }catch (Exception e) {}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        p7.setImageResource(R.drawable.pipe_borders_righttop_fill_new);
                        animation = (AnimationDrawable) p7.getDrawable();
                        animation.start();
                    }
                });
                try {
                    sleep(800);
                }catch (Exception e) {}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        p6.setImageResource(R.drawable.pipe_fork_top_fill_new);
                        animation = (AnimationDrawable) p6.getDrawable();
                        animation.start();
                    }
                });
                try {
                    sleep(800);
                }catch (Exception e) {}

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        p9.setImageResource(R.drawable.pipe_straight_fill_new);
                        animation = (AnimationDrawable) p9.getDrawable();
                        animation.start();
                    }
                });
                try {
                    sleep(800);
                }catch (Exception e) {}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        p13.setImageResource(R.drawable.pipe_borders_bot_left_fill_new);
                        animation = (AnimationDrawable) p13.getDrawable();
                        animation.start();
                    }
                });
                try {
                    sleep(800);
                }catch (Exception e) {}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        p14.setImageResource(R.drawable.pipe_straight_fill_new);
                        animation = (AnimationDrawable) p14.getDrawable();
                        animation.start();
                    }
                });
            }
        }).start();



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {        //pop Finish Dialog
            @Override
            public void run()
            {
                PopFinishDialog();
            }
        }, 5600);


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

        levelTitleTv.setText("Level 2");
        timeTv.setText(gameObject.countDownTv.getText());
        movesTv.setText("Moves: " + gameObject.moveTv.getText());

        int lastScore = 100 - (  Integer.parseInt(gameObject.moveTv.getText().toString()) / gameObject.minimumMoves  )*10;

        int usersArrayListSize = gameObject.users.size()-1;
        User currentUser = gameObject.users.get(usersArrayListSize);
        final int current_level = 1;

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


        Dialog dialog = new Dialog(LevelOneActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(finishDialog_Layout);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        if(!isFinishing())
            dialog.show();


        //Next to level Two
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelOneActivity.this, LevelTwoActivity.class);
                finish();
                startActivity(intent);
                customType(LevelOneActivity.this,"left-to-right");

            }
        });

        //Restart
        restartBtn.setOnClickListener(new View.OnClickListener() {
            // Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelOneActivity.this, LevelOneActivity.class);
                finish();
                startActivity(intent);
                customType(LevelOneActivity.this,"fadein-to-fadeout");

            }
        });

        //all Levels
        levelsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelOneActivity.this, LevelsActivity.class);
                finish();
                startActivity(intent);
                customType(LevelOneActivity.this,"up-to-bottom");

            }
        });

        //Score Table
        scoreTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(LevelOneActivity.this, TableScoreActivity.class);

                intent.putExtra("level", current_level);

                startActivity(intent);
                customType(LevelOneActivity.this,"fadein-to-fadeout");

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
        customType(this, "up-to-bottom");
    }


}
