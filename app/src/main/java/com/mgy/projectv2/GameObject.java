package com.mgy.projectv2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameObject extends Activity {


    public ArrayList<Pipe> pipeArrayList = new ArrayList<>();
    public ImageButton[] imageButtons;

    int move = 0;
    TextView countDownTv, moveTv;
    AnimationDrawable animation;

    SharedPreferences sp;
    ArrayList<User> users = new ArrayList<>();

    int minimumMoves = 0;
    int minimumTime = 1;
    int maxTimeToFinish = 100000;
//    var score = ((minimumTime/finishedSeconds)*(minimumMoves/moveCount))*highestScorePossible)

    public void AddToPipeList(Pipe pipe){
        pipeArrayList.add(pipe);
    }

    public void CountDownTimer()
    {
        CountDownTimer countDownTimer =  new CountDownTimer(maxTimeToFinish, 1000)
        {
            public void onTick(long millisUntilFinished) {
                String v = String.format("%02d", millisUntilFinished/60000);
                int va = (int)( (millisUntilFinished%60000)/1000);
                countDownTv.setText("Time: " + v + ":" + String.format("%02d",va));
            }
            public void onFinish() {    //when finish GAME OVER alert dialong
                countDownTv.setText("done!");
            }
        };
        countDownTimer.start();
    }

    public void Rotate(View view){
        /*view.animate()
                .rotationBy(90)
                .setDuration(100)
                .start();*/

        Animation anim = new ScaleAnimation(
                1f, 1.25f, // Start and end values for the X axis scaling
                1f, 1.25f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0f); // Pivot point of Y scaling
        anim.setFillAfter(false); // Needed to keep the result of the animation
        anim.setDuration(100);
        view.startAnimation(anim);
        view.animate()
                .rotationBy(90)
                .setDuration(100)
                .start();

        moveTv.setText(++move+"" );
    }

    public void CheckPipeOneOption(Pipe pipe, View view){

        pipe.currentRotation++;
        Rotate(view);

        if((pipe.currentRotation % pipe.rotationOptions ==0 )) {
            pipe.isConnection = true;
        }else{
            pipe.isConnection = false;
        }

//        countDownTv.setText(pipe.isConnection+" ");

    }

    public void CheckPipeTwoOption(Pipe pipe, View view, int number1, int number2){

        pipe.currentRotation++;
        Rotate(view);

        if((pipe.currentRotation % pipe.rotationOptions ==number1 ||  pipe.currentRotation % pipe.rotationOptions ==number2)) {
            pipe.isConnection = true;
        }else{
            pipe.isConnection = false;
        }
//        countDownTv.setText(pipe.isConnection+" ");
    }

}
