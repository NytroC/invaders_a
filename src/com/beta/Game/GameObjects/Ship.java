package com.beta.Game.GameObjects;

import com.beta.Game.Screens.PlayScreen;

public class Ship extends GameObject {

    public Ship(PlayScreen game, Point point) {
        super(game, point);

        this.setup();
    }

    void setup() {
        //        this.shipImage = this.game.loadImage("ship.png");
    }

    public void draw() {
//        this.game.image(shipImage, this.point.x, this.point.y);
        this.game.fill(255, 000, 000);
        this.game.rect(this.point.x, this.point.y, 50, 50);
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
                this.point.x += 2;
            }
        }
    }
}
