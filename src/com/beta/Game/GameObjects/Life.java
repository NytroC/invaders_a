package com.beta.Game.GameObjects;

import processing.core.PImage;
import com.beta.Game.Screens.Game;

public class Life extends GameObject {
    private PImage sprite;

    public Life(Game game, Point point) {
        super(game, point);
        this.setup();
    }

    void setup() {
        this.sprite = this.game.loadImage("sprites/ship.png");
    }

    public void draw() {
        this.game.image(sprite, this.point.x, this.point.y, 30, 30);
    }
}
