package com.mgy.projectv2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class LevelThreeActivity extends Activity {

    GameObject gameObject = new GameObject(this, 4);

    ImageButton p00, p01, p02, p03, p10, p11, p12, p13, p20, p21, p22, p23,
            p30, p31, p32, p33, p40, p41, p42, p43;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);



        gameObject.countDownTv = findViewById(R.id.countDown_TextView);
        gameObject.moveTv = findViewById(R.id.moves_TextView);
        gameObject.sp = getSharedPreferences("details", MODE_PRIVATE);
        try {
            gameObject.users = (ArrayList<User>) ObjectSerializer.deserialize(gameObject.sp.getString("users", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {e.printStackTrace();
        } catch (ClassNotFoundException e) {e.printStackTrace();}

        p00 = findViewById(R.id.p00);
        p01 = findViewById(R.id.p01);
        p02 = findViewById(R.id.p02);
        p03 = findViewById(R.id.p03);
        p10 = findViewById(R.id.p10);
        p11 = findViewById(R.id.p11);
        p12 = findViewById(R.id.p12);
        p13 = findViewById(R.id.p13);
        p20 = findViewById(R.id.p20);
        p21 = findViewById(R.id.p21);
        p22 = findViewById(R.id.p22);
        p23 = findViewById(R.id.p23);
        p30 = findViewById(R.id.p30);
        p31 = findViewById(R.id.p31);
        p32 = findViewById(R.id.p32);
        p33 = findViewById(R.id.p33);
        p40 = findViewById(R.id.p40);
        p41 = findViewById(R.id.p41);
        p42 = findViewById(R.id.p42);
        p43 = findViewById(R.id.p43);

        gameObject.AddToPipeList(new Pipe(p00, true, 0, 0));//0 - start
        gameObject.AddToPipeList(new Pipe(p01, false, 4, 1)); //1
        gameObject.AddToPipeList(new Pipe(p02, true, 4, 0));//2
        gameObject.AddToPipeList(new Pipe(p03, true, 0, 0));//3   - end
        gameObject.AddToPipeList(new Pipe(p10, true, 0, 0));//4
        gameObject.AddToPipeList(new Pipe(p11, false, 2, 1));//5
        gameObject.AddToPipeList(new Pipe(p12, false, 4, 2));//6
        gameObject.AddToPipeList(new Pipe(p13, false, 4, 3));//7
        gameObject.AddToPipeList(new Pipe(p20, false, 4, 1));//8
        gameObject.AddToPipeList(new Pipe(p21, false, 4, 1));//9
        gameObject.AddToPipeList(new Pipe(p22, true, 0, 0));//10
        gameObject.AddToPipeList(new Pipe(p23, true, 2, 0));//11
        gameObject.AddToPipeList(new Pipe(p30, true, 4, 0));//12
        gameObject.AddToPipeList(new Pipe(p31, false, 2, 1));//13
        gameObject.AddToPipeList(new Pipe(p32, true, 2, 0));//14
        gameObject.AddToPipeList(new Pipe(p33, true, 4, 1));//15




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
        gameObject.pipeArrayList.get(5).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(5), view);

            }
        });
        gameObject.pipeArrayList.get(6).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(6), view);
            }
        });
        gameObject.pipeArrayList.get(7).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(7), view);
            }
        });
        gameObject.pipeArrayList.get(8).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(8), view);

            }
        });
        gameObject.pipeArrayList.get(9).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(9), view);

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
        gameObject.pipeArrayList.get(13).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(13), view);

            }
        });
        gameObject.pipeArrayList.get(14).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(14), view);

            }
        });
        gameObject.pipeArrayList.get(15).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.CheckPipeOneOption(gameObject.pipeArrayList.get(15), view);

            }
        });


        gameObject.pipeArrayList.get(4).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);
            }
        });
        gameObject.pipeArrayList.get(10).pipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameObject.Rotate(view);
            }
        });


        ArrayList<Pipe> arrayListToCheck = new ArrayList<>();   //Pipe Array to Check
        arrayListToCheck.add(gameObject.pipeArrayList.get(1));
        arrayListToCheck.add(gameObject.pipeArrayList.get(2));
        arrayListToCheck.add(gameObject.pipeArrayList.get(5));
        arrayListToCheck.add(gameObject.pipeArrayList.get(6));
        arrayListToCheck.add(gameObject.pipeArrayList.get(7));
        arrayListToCheck.add(gameObject.pipeArrayList.get(8));
        arrayListToCheck.add(gameObject.pipeArrayList.get(9));
        arrayListToCheck.add(gameObject.pipeArrayList.get(11));
        arrayListToCheck.add(gameObject.pipeArrayList.get(12));
        arrayListToCheck.add(gameObject.pipeArrayList.get(13));
        arrayListToCheck.add(gameObject.pipeArrayList.get(14));
        CheckIfFinishThread(arrayListToCheck);   //Thread to check when the user finish


        gameObject.minimumMoves = 14;
        gameObject.minimumTime = 10000;
        gameObject.maxTimeToFinish = 20000;//20 sec
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
                                    SetAnim(pipeArray);
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

    private void SetAnim(final ArrayList<Pipe> pipeArray)
    {

        gameObject.countDownTimer.cancel();

        for (Pipe pipe : gameObject.pipeArrayList)
            pipe.pipeImage.setEnabled(false);


        gameObject.pipeArrayList.get(1).pipeImage.setImageResource(R.drawable.pipe_borders_lefttop_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(1).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(2).pipeImage.setImageResource(R.drawable.pipe_borders_rightbottom_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(2).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(5).pipeImage.setImageResource(R.drawable.pipe_straight_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(5).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(6).pipeImage.setImageResource(R.drawable.pipe_borders_leftbottom_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(6).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(7).pipeImage.setImageResource(R.drawable.pipe_borders_rightbottom_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(7).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(8).pipeImage.setImageResource(R.drawable.pipe_borders_leftbottom_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(8).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(9).pipeImage.setImageResource(R.drawable.pipe_borders_righttop_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(9).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(11).pipeImage.setImageResource(R.drawable.pipe_vertical_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(11).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(12).pipeImage.setImageResource(R.drawable.pipe_borders_righttop_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(12).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(13).pipeImage.setImageResource(R.drawable.pipe_vertical_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(13).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(14).pipeImage.setImageResource(R.drawable.pipe_straight_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(14).pipeImage.getDrawable();
        gameObject.animation.start();
        gameObject.pipeArrayList.get(15).pipeImage.setImageResource(R.drawable.pipe_borders_righttop_fill_new);
        gameObject.animation = (AnimationDrawable) gameObject.pipeArrayList.get(15).pipeImage.getDrawable();
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

        final int current_level = 3;
        levelTitleTv.setText("Level " + current_level);
        timeTv.setText(gameObject.countDownTv.getText());
        movesTv.setText("Moves: " + gameObject.moveTv.getText());

        int lastScore = 100 - (  Integer.parseInt(gameObject.moveTv.getText().toString()) / gameObject.minimumMoves  )*10;

        int usersArrayListSize = gameObject.users.size()-1;
        User currentUser = gameObject.users.get(usersArrayListSize);

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


        Dialog dialog = new Dialog(LevelThreeActivity.this);
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
                Intent intent = new Intent(LevelThreeActivity.this, LevelFourActivity.class);
                finish();
                startActivity(intent);
                customType(LevelThreeActivity.this,"left-to-right");

            }
        });

        //Restart
        restartBtn.setOnClickListener(new View.OnClickListener() {
            // Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelThreeActivity.this, LevelThreeActivity.class);
                finish();
                startActivity(intent);
                customType(LevelThreeActivity.this,"fadein-to-fadeout");

            }
        });

        //all Levels
        levelsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelThreeActivity.this, LevelsActivity.class);
                finish();
                startActivity(intent);
                customType(LevelThreeActivity.this,"up-to-bottom");

            }
        });

        //Score Table
        scoreTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(LevelThreeActivity.this, TableScoreActivity.class);

                intent.putExtra("level", current_level);

                startActivity(intent);
                customType(LevelThreeActivity.this,"fadein-to-fadeout");
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
