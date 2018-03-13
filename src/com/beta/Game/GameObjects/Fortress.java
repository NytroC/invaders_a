package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.Collidable;
import com.beta.Game.Screens.Game;
import java.util.ArrayList;
import processing.core.PImage;

public class Fortress extends GameObject implements Collidable {
    private int lifeRemaining;
    private PImage sprite;
    private ArrayList<Fortress> fortress = new ArrayList<>();

    public Fortress(Game game, Point point) {
        super(game, point);

        this.setup();
    }

    public void setup() {
        //this.sprite = this.game.loadImage("sprites/fortress.png");

        //this.setDimensions(96, 72);
        //for(int i = 0; i < 4; i++) {
        //    fortress.add(new Fortress(this.width/4 * i + 200, this.height - 200, 100, this));
        //}
    }

    public void draw() {
        this.game.fill(0, 255, 0);
        this.game.rect(this.point.x, this.point.y, 40, 40);
        //this.game.image(this.sprite, this.point.x, this.point.y, this.width, this.height);
    }

    private void fortressDecay(int status) {
        lifeRemaining -= status;
    }

    public boolean isTouching(GameObject gameObject) {
        return false;
    }

}


