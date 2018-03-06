package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.GameObject.GameObjectInterface;
import com.beta.Game.Screens.PlayScreen;
import processing.core.PImage;

public class Alien implements GameObjectInterface {
    private Point point;
    private PlayScreen game;
    private PImage sprite;
    public int width = 30;
    public int height = 20;
    private Bomb currentBomb;

    public Alien(PlayScreen game, float x, float y) { // reference to grid
        this.game = game;
        this.point = new Point(x, y);
    }

    public void draw() {
        this.game.fill(000, 255, 000);
        this.game.rect(this.point.x, this.point.y, this.width, this.height);
//        this.game.image(this.game.alienSprite, this.point.x, this.point.y, 30, 20);
    }

    public Point getPosition() {
        return this.point;
    }

    public void setPosition(float x, float y) {
        this.point.x = x;
        this.point.y = y;
    }

    public float rightEdge() {
        return this.point.x + this.width;
    }

    public float leftEdge() {
        return this.point.x;
    }

    public void dropBomb() {
        float bombX = this.point.x + (this.width / 2);
        float bombY = this.point.y + this.height;

        if (this.currentBomb != null) {
            this.currentBomb.draw();
        } else {
            this.currentBomb = new Bomb(this.game, new Point(bombX, bombY));
        }
    }
}
