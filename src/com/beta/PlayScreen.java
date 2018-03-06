package com.beta;

import processing.core.PApplet;
import com.beta.GameObjects.Ship;

public class PlayScreen extends PApplet {
    protected Ship ship;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        ship = new Ship(this);
        background(55);
    }

    public void draw() {
        background(55);
        ship.draw();
    }

    private void drawBradCircle() {
        fill(0,0,255);
        ellipse(height / 2, width / 2, 100, 100);
    }

    private void drawKrishanCircle() {
        fill(200, 150, 54);
        ellipse(height / 2, width / 2, 50, 50);
    }

    private void drawDrewCircle() {
        fill(111, 422, 673);
        ellipse(100, 100, 100, 100);
    }

    private void drawCurtisCircle() {
        fill(100,134,25);
        ellipse(height / 4, width / 4, 25, 25);
    }
}
