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
    boolean keys[] = {false, false, false};

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
        controls();
    }
    public void keyPressed(){
        if(key == ' '){
            keys[0]= true;
        }
        if(key == 'a'){
            keys[1] = true;
        }
        if(key == 'd'){
            keys[2] = true;
        }
    }
    public void keyReleased(){
        if(key == ' '){
            keys[0] = false;
        }
        if(key == 'a'){
            keys[1] = false;
        }
        if(key == 'd'){
            keys[2] = false;
        }
    }
    public void controls(){
        if(keys[0] == true){
            ship.fireRocket();
        }
        if(keys[1] == true){
            ship.moveLeft();
        }
        if(keys[2] == true){
            ship.moveRight();
        }
    }

}
