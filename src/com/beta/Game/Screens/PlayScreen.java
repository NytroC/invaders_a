package com.beta.Game.Screens;

import com.beta.Game.GameObjects.AlienFleet;
import com.beta.Game.GameObjects.Ship;
import processing.core.PApplet;
import processing.core.PImage;

public class PlayScreen extends PApplet {

    protected AlienFleet alienFleet;
    public PImage alienSprite;
    protected Ship ship;

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        background(255);
        clear();
        frameRate(60);

        this.alienSprite = this.loadImage("sprites/alien/alien-red.png");
        this.alienFleet = new AlienFleet(this);
        this.ship = new Ship(this);
    }

    public void draw() {
        alienFleet.draw();
//        ship.draw();
    }
}
