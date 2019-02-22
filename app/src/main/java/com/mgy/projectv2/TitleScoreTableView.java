package com.mgy.projectv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

@SuppressLint("AppCompatCustomView")
public class TitleScoreTableView extends TextView {

//    Context context;

    public TitleScoreTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        this.context = context;
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/y2k.ttf");
        this.setTypeface(face);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(16);

//=========================
        /*AssetManager am = context.getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "y2k.ttf"));

//        setTypeface(typeface);
        paint.setTypeface(typeface);*/

//=========================


        canvas.drawLine(90, getHeight(), getWidth()-90 , getHeight(), paint);
    }
}
