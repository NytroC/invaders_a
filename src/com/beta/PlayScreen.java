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
        drawBradCircle();
        drawKrishanCircle();

    }
    private void drawBradCircle(){
        fill(0,0,255);
        ellipse(height / 2, width / 2, 100, 100);
    }

    private void drawKrishanCircle(){
        fill(200, 150, 54);
        ellipse(a: height / 2, b: width / 2, c: 50, d: 50);
    }

}
