package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.Collidable;
import com.beta.Game.Screens.Game;
import processing.core.PImage;

public class Alien extends GameObject {
    public int width = 35;
    public int height = 25;
    private GridPoint gridCoordinates;
    public boolean isAlive = true;


    public Alien(Game game, Point point, GridPoint gridCoordinates, PImage sprite) {
        super(game, point);

        this.sprite = sprite;
        this.gridCoordinates = gridCoordinates;
        this.setup();
    }

    void setup() {
        this.game.image(this.sprite, this.point.x, this.point.y, this.height, this.width);
    }

    public void draw() {
        if (this.isAlive) {
            this.game.image(this.sprite, this.point.x, this.point.y, this.width, this.height);
            this.detectCollision();
        }
    }

    public void kill() {
        this.isAlive = false;
        System.out.println("Killing " + this.gridCoordinates.x + ", " + this.gridCoordinates.y);
        System.out.println(this.isAlive);
    }

    private void detectCollision() {
//        System.out.println(this.game.c);
    }
}
