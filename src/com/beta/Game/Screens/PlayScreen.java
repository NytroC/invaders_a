package com.beta.Game.Screens;

import com.beta.Game.Contracts.GameScreen.GameScreenInterface;
import com.beta.Game.GameObjects.AlienFleet;
import com.beta.Game.GameObjects.Point;
import com.beta.Game.GameObjects.Ship;
import com.beta.Game.GameObjects.UFO;
import processing.core.PApplet;

public class PlayScreen extends PApplet implements GameScreenInterface {

    protected AlienFleet alienFleet;
    protected Ship ship;
    protected UFO ufo;

    // this can probably move to a main screenController
    public void settings() {
        size(800, 600);
    }

    public void setup() {
        background(255);
        clear();
        frameRate(60);

        this.alienFleet = new AlienFleet(this, new Point(50, 50));
        this.ship = new Ship(this, new Point(50, this.height - 50));
        this.ufo = new UFO(this, new Point(-300,25));
    }

    public void draw() {
        alienFleet.draw();
        ship.draw();
        ufo.draw();
    }
    public void keyPressed(){
        if(key == ' '){
            ship.fireRocket();
        }
        if(key == 'a'){
            ship.moveLeft();
        }
        if(key == 'd'){
            ship.moveRight();
        }
    }
}
