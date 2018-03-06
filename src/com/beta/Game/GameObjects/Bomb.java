package com.beta.Game.GameObjects;

import com.beta.Game.Screens.PlayScreen;

public class Bomb extends GameObject {
    private float speed = 2f;

    public Bomb(PlayScreen game, Point point) {
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
}
