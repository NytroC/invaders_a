package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;
import com.beta.Game.Screens.PlayScreen;
import processing.core.PImage;

public class Alien extends GameObject {
    public int width = 35;
    public int height = 25;
    private Point gridCoordinates;
    public boolean isAlive = true;


    public Alien(Game game, Point point, Point gridCoordinates, PImage sprite) { // reference to grid
        super(game, point);

        this.sprite = sprite;
        this.gridCoordinates = gridCoordinates;
        this.setup();
    }

    void setup() {
        this.game.image(this.sprite, this.point.x, this.point.y, this.height, this.width);
    }

    public void draw() {
        game.fill(000, 255, 000);
        this.game.image(this.sprite, this.point.x, this.point.y, this.width, this.height);
    }

    /**
     * Get the right edge coordinate of the alien
     *
     * @return float
     */
    public float rightEdge() {
        return this.point.x + this.width;
    }

    /**
     * Get the left edge coordinate of the alien
     *
     * @return float
     */
    public float leftEdge() {
        return this.point.x;
    }

    public void kill() {
        this.isAlive = false;
    }
}
