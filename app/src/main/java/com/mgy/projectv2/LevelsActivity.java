package com.mgy.projectv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static maes.tech.intentanim.CustomIntent.customType;

public class LevelsActivity extends Activity implements Button.OnClickListener {

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

        }

        startActivity(intent);
        customType(this,"fadein-to-fadeout");
    }

    @Override
    public void finish() {
        super.finish();
        customType(this,"fadein-to-fadeout");
    }
}
