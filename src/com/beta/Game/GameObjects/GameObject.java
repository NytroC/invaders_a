package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.Collidable;
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
    public int height, width;

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

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Get the topEdge edge coordinate of the object
     *
     * @return float
     */
    public float topEdge() {
        return this.point.y;
    }

    /**
     * Get the bottomEdge edge coordinate of the object
     *
     * @return float
     */
    public float bottomEdge() {
        return this.point.y + this.height;
    }

    /**
     * Get the right edge coordinate of the object
     *
     * @return float
     */
    public float rightEdge() {
        return this.point.x + this.width;
    }

    /**
     * Get the left edge coordinate of the object
     *
     * @return float
     */
    public float leftEdge() {
        return this.point.x;
    }

    public boolean isTouching(GameObject gameObject) {
        return this.leftEdge() >= gameObject.leftEdge() &&
                this.rightEdge() <= gameObject.rightEdge() &&
                this.bottomEdge() >= gameObject.topEdge();
    }

}
