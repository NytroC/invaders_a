package com.beta.GameObjects;
import processing.core.PApplet;
import processing.core.PImage;

public class Ship {

    PImage shipImage;
    PApplet p;

    float posX;
    float posY;

    public Ship(PApplet p){
        this.p = p;
        this.shipImage = p.loadImage("ship.png");
        this.posX = 100;
        this.posY = 200;
    }

    public void draw(){
        p.image(shipImage, this.posX, this.posY);
        this.update();

    }

    void update(){
        if (p.keyPressed){
            if (p.key == 'a') {
                posX -= 2;

            }
            else if (p.key == 'd'){
                posX += 2;
            }
        }
    }
}
