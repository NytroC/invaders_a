package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;
import com.beta.Game.Screens.PlayScreen;
import processing.core.PImage;

public class UFO extends GameObject {
    private PImage sprite;
    private float xSpeed = 1.0f;

    public UFO(Game game, Point point) {

        super(game, point);
        this.setup();
    }

    void setup() {
        this.sprite = this.game.loadImage("sprites/UFO.png");
    }

    public void draw() {
//        this.game.image(shipImage, this.point.x, this.point.y);
        moveUFO();
        this.game.image(sprite, this.point.x, this.point.y);
    }

    public Point getPosition() {
        return this.point;
    }

    private void moveUFO() {

        this.point.x += xSpeed;
    }



}
