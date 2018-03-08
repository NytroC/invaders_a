package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;
import com.beta.Game.Screens.PlayScreen;

public class Bomb extends GameObject {
    private float speed = 2f;
    public int width = 5;
    public int height = 15;

    public Bomb(Game game, Point point) {
        super(game, point);

        this.setup();
    }

    void setup() {
        this.game.fill(255, 000, 000);
    }

    public void draw() {
        this.game.rect(this.point.x, this.point.y, this.width, this.height);
        this.point.y += this.speed;
    }

    public float bottomEdge() {
        return this.point.y + this.height;
    }

    private void checkForCollision() {
        // check against fortress
        // check against ship
        // check against active rocket
        // check against lower boundary
        // this.game.collisionDetection.collisionMade(this.game.COLLISIONS.BOMB_HIT_FORTESS, this)
        // this.game.collisionDetection.collisionMade(COLLISIONS.BOMB_HIT_SHIP, this)
        // this.game.collisionDetection.collisionMade(COLLISIONS.BOMB_HIT_ROCKET, this)
    }
}
