package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;

public class Rocket extends  GameObject {

    private float ySpeed = 3.0f;

    public Rocket(Game game, Point point) {
        super(game, point);
        this.setup();
    }

    void setup() {
        //        this.shipImage = this.game.loadImage("ship.png");
    }

    public void draw() {
//        this.game.image(shipImage, this.point.x, this.point.y);
        this.game.fill(255, 000, 000);
        this.game.rect(this.point.x, this.point.y, 10, 10);
        this.update();
    }
    public void update(){
        this.point.y -= ySpeed;
    }

    public Point getPosition() {
        return this.point;
    }



}