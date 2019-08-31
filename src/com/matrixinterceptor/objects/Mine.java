package com.matrixinterceptor.objects;


import com.badlogic.gdx.math.Rectangle;

public class Mine {
    public float startTime=0f;
    public float hp=1f;
    public Rectangle rect = new Rectangle(0, 0, 40, 40);

    public String direction="none";

    public Mine(float st){
        startTime=st;
    }

    public Mine(float st, String dir){
        startTime=st;
        direction=dir;
    }

}
