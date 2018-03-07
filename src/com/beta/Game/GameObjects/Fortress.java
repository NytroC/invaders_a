package com.beta.Game.GameObjects;

import com.beta.Game.Screens.PlayScreen;
//import processing.core.PImage;

public class Fortress extends GameObject{

    private int lifeRemaining;
    public int width = 40;
    public int height = 40;
    //private PImage sprite;

    public Fortress(PlayScreen game, Point point) {
        super(game, point);
        this.setup();
    }

    void setup() {
        //this.sprite = this.game.loadImage("fort.png");
    }

    public void draw() {
        //this.game.image(sprite, this.point.x, this.point.y);
        this.game.fill(200, 255, 2);
        this.game.rect(this.point.x, this.point.y, this.width, this.height);



    }

    private void fortressDecay(int status) {
        lifeRemaining -= status;
    }

}

