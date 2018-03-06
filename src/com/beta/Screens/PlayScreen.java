package com.beta.Screens;

import com.beta.GameObjects.AlienFleet;
import com.beta.GameObjects.Ship;
import processing.core.PApplet;

public class PlayScreen extends PApplet {

    protected AlienFleet alienFleet;
    protected Ship ship;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(55);

        alienFleet = new AlienFleet(this);
        ship = new Ship(this);        
    }

    public void draw() {
        alienFleet.draw();
        ship.draw();
    }
}
