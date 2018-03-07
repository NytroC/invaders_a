package com.beta.Game.GameObjects;

import com.beta.Game.Screens.PlayScreen;
import processing.core.PImage;

/**
 * Created by drewjbartlett on 3/6/18.
 */
abstract public class GameObject {
    protected Point point;
    protected PlayScreen game;
    protected PImage sprite;

    public GameObject(PlayScreen game, Point point) {
        this.game = game;
        this.point = point;
    }

    abstract void setup();

    abstract public void draw();

    public Point getPosition() {
        return this.point;
    }

    public void setPosition(float x, float y) {
        this.point.x = x;
        this.point.y = y;
    }
}
