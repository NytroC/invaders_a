package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.Drawable;
import com.beta.Game.Screens.Game;
import processing.core.PImage;

/**
 * Created by drewjbartlett on 3/6/18.
 */
abstract public class GameObject implements Drawable {
    protected Point point;
    protected Game game;
    protected PImage sprite;

    public GameObject(Game game, Point point) {
        this.game = game;
        this.point = point;
    }

    abstract void setup();

    public Point getPosition() {
        return this.point;
    }

    public void setPosition(float x, float y) {
        this.point.x = x;
        this.point.y = y;
    }
}
