package com.beta.GameObjects;

import com.beta.GameObjects.Point;
import processing.core.PApplet;

public class Alien {
    private Point point;

    public Alien(PApplet game, Point p) {
        this.point = p;
//        this.game.rect(this.point.x, this.point.y);
    }

    public Point getPosition() {
        return this.point;
    }

}
