package com.beta;

import processing.core.PApplet;

public class PlayScreen extends PApplet{

    public void settings() {
        fullScreen();

    }

    public void setup() {
        background(55);
    }
    public void draw() {

        //Brad
        fill(0,0,255);
        ellipse(height / 2, width / 2, 100, 100);
    }

}
