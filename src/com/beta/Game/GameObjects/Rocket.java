package com.beta.Game.GameObjects;

import com.beta.Game.Screens.PlayScreen;

public class Rocket extends  GameObject {
    public Rocket(PlayScreen game, Point point) {
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
        this.point.y--;
    }

    public Point getPosition() {
        return this.point;
    }



}