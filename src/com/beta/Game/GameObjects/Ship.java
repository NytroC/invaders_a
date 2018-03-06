package com.beta.Game.GameObjects;
import com.beta.Game.Contracts.GameObject.GameObjectInterface;
import processing.core.PApplet;
import processing.core.PImage;

public class Ship implements GameObjectInterface {
    private Point point;    
    PImage shipImage;
    PApplet game;

    public Ship(PApplet game) {
        this.game = game;
//        this.shipImage = this.game.loadImage("ship.png");
        this.point = new Point(100, 200);
    }

    public void draw() {
//        this.game.image(shipImage, this.point.x, this.point.y);
        this.game.fill(255, 000, 000);
        this.game.rect(this.point.x, this.point.y, 100, 100);
        this.update();
    }

    public Point getPosition() {
        return this.point;
    }

    void update() {
        if (game.keyPressed) {
            if (game.key == 'a') {
                this.point.x -= 2;
            } else if (game.key == 'd') {
                this.point.y += 2;
            }
        }
    }
}
