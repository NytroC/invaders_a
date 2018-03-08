package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;
import processing.core.PImage;

public class Ship extends GameObject {
    private PImage sprite;
    private Rocket rocket;
    private float radius = 25;

    public Ship(Game game, Point point) {
        super(game, point);

        this.setup();
    }

    void setup() {
        this.sprite = this.game.loadImage("sprites/ship.png");
    }

    public void draw() {
        this.game.image(sprite, this.point.x, this.game.height - 50, this.radius * 2, this.radius* 2);
        drawRocket();
    }

    public Point getPosition() {
        return this.point;
    }


    public void moveLeft(){
        if(point.x >= 0) {
            this.point.x -= 2;
        }
    }
    public void moveRight(){
        if(point.x <= game.width - radius * 2) {
            this.point.x += 2;
        }
    }
    public void fireRocket(){
        if (rocket == null) {
            float rocketY = this.point.y;
            float rocketX = (this.point.x + radius - 5);
            this.rocket = new Rocket(this.game, new Point(rocketX, rocketY ));
        }
    }
    void drawRocket(){
        if (this.rocket != null) {
            this.rocket.draw();
            destroyRocket();
        }
    }
    void destroyRocket(){
        if(this.rocket.point.y <= 0){
            this.rocket = null;
        }
    }
}
