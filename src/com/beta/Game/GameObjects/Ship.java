package com.beta.Game.GameObjects;

import com.beta.Game.Screens.PlayScreen;
import processing.core.PImage;

public class Ship extends GameObject {
    private PImage sprite;
    private Rocket rocket;
    private float radius = 25;

    public Ship(PlayScreen game, Point point) {
        super(game, point);

        this.setup();
    }

    void setup() {
                this.sprite = this.game.loadImage("ship.png");
    }

    public void draw() {
//        this.game.image(shipImage, this.point.x, this.point.y);
        this.game.fill(255, 000, 000);
        this.game.image(sprite, this.point.x, this.game.height - 50, this.radius * 2, this.radius* 2);
        this.update();
        if (this.rocket != null) {
            this.rocket.draw();
            if(this.rocket.point.y <= 0){
                this.rocket = null;
            }
        }
    }

    public Point getPosition() {
        return this.point;
    }

    void update() {
        this.move();
        this.fire();
    }

    void move(){
        if (game.keyPressed) {
            if (game.key == 'a') {
                this.point.x -= 2;
            } else if (game.key == 'd') {
                this.point.x += 2;
            }
        }
    }
    void fire(){
        if (game.keyPressed && this.rocket == null) {
            if (game.key == ' ') {
                float rocketY = this.point.y;
                float rocketX = (this.point.x + radius - 5);
                this.rocket = new Rocket(this.game, new Point(rocketX, rocketY ));
            }
        }
    }
}
