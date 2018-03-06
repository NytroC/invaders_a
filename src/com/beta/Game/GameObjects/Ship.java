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
//        this.shipImage = p.loadImage("ship.png");
        this.point = new Point(100, 200);
        this.point.x = 100;
        this.point.y = 200;
    }

    public void draw() {
        game.image(shipImage, this.point.x, this.point.y);
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
