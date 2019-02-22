package com.mgy.projectv2;

import android.widget.ImageButton;

public class Pipe {

    ImageButton pipeImage;
    boolean isConnection = false;
    int rotationOptions;
    int currentRotation;

    public int left, top, right, bottom;

    public Pipe(ImageButton pipeImage, boolean isConnection, int rotationOptions, int currentRotation) {
        this.isConnection = isConnection;
        this.rotationOptions = rotationOptions;
        this.currentRotation = currentRotation;
        this.pipeImage = pipeImage;
    }

    public Pipe(ImageButton pipeImage, boolean isConnection, int rotationOptions, int currentRotation, int left, int top, int right, int bottom) {
        this.pipeImage = pipeImage;
        this.isConnection = isConnection;
        this.rotationOptions = rotationOptions;
        this.currentRotation = currentRotation;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public void changeConnection(){
        isConnection = !isConnection;
    }

    public int getRotationOptions() {
        return rotationOptions;
    }

    public void setRotationOptions(int rotationOptions) {
        this.rotationOptions = rotationOptions;
    }


}
