package com.beta.Game.GameObjects;

import processing.core.PApplet;

public class Alien {
    private Point point;
    private PApplet game;

    public Alien(PApplet game, float x, float y) {
        this.game = game;
        this.point = new Point(x, y);
        this.game.rect(this.point.x, this.point.y, 50, 40);
    }

    public Point getPosition() {
        return this.point;
    }

}
