package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;
import com.beta.Game.Screens.PlayScreen;

import java.util.ArrayList;
//import processing.core.PImage;

public class Fortress extends GameObject{

    private int lifeRemaining;
    //private PImage sprite;
    ArrayList<Fortress> fortress = new ArrayList<>();


    public Fortress(Game game, Point point) {
        super(game, point);
        this.setup();
    }

    void setup() {
        //this.sprite = this.game.loadImage("sprites.fort.png");
       //for(int i = 0; i < 4; i++) {
       //    fortress.add(new Fortress(this.width/4 * i + 200, this.height - 200, 100, this));
       //}
    }

    public void draw() {
        this.game.fill(200, 255, 2);
        this.game.rect(this.point.x, this.point.y, 40, 40);
        //this.game.image(sprite, this.point.x, this.point.y);
    }

    private void fortressDecay(int status) {
        lifeRemaining -= status;
    }

}

