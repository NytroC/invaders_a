package com.beta.Game.Screens;

import com.beta.Game.GameObjects.AlienFleet;
import com.beta.Game.GameObjects.Ship;
import processing.core.PApplet;

public class PlayScreen extends PApplet {

    protected AlienFleet alienFleet;
    protected Ship ship;

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        background(255);
        clear();
        frameRate(60);

        alienFleet = new AlienFleet(this);
        ship = new Ship(this);
    }

    public void draw() {
        alienFleet.draw();
//        ship.draw();
    }
}
