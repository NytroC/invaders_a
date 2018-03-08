package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;
import com.beta.Game.Screens.PlayScreen;

public class Bomb extends GameObject {
    private float speed = 2f;

    public Bomb(Game game, Point point) {
        super(game, point);

        this.setup();
    }

    void setup() {
        this.game.fill(255, 000, 000);
    }

    public void draw() {
        this.game.rect(this.point.x, this.point.y, 5, 15);
        this.point.y += this.speed;
    }

    private void checkForCollision() {
        // check against fortress
        // check against ship
        // check against active rocket
        // check against lower boundary
    }
}
