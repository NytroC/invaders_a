package com.beta.Game.Screens;

import com.beta.Game.Contracts.GameScreen.GameScreenInterface;
import com.beta.Game.GameObjects.AlienFleet;
import com.beta.Game.GameObjects.Ship;
import processing.core.PApplet;
import processing.core.PImage;

public class PlayScreen extends PApplet implements GameScreenInterface {

    protected AlienFleet alienFleet;
    protected Ship ship;

    // this can probably move to a main screenController
    public void settings() {
        size(800, 600);
    }

    public void setup() {
        background(255);
        clear();
        frameRate(60);

        this.alienFleet = new AlienFleet(this);
        this.ship = new Ship(this);
    }

    public void draw() {
        alienFleet.draw();
//        ship.draw();
    }
}
