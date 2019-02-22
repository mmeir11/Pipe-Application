package com.mgy.projectv2;

import java.io.Serializable;

public class User implements Serializable {

    public String name;
    public int scoreLevelZero = 0;

    public int []scoreArray = new int[6];

    public int scoreLevelThree = 0;

    public User(String name)
    {
        this.name = name;

        for (int i=0 ; i<scoreArray.length ; i++)
            scoreArray[i] = 0;
    }



}
