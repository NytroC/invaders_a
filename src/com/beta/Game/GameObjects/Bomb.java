package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.Collidable;
import com.beta.Game.Screens.Game;

public class Bomb extends GameObject implements Collidable {
    private float speed = 2f;

    public Bomb(Game game, Point point) {
        super(game, point);

        this.setup();
    }

    public void setup() {
        this.setDimensions(5, 15);
    }

    public void draw() {
        this.game.fill(255, 000, 000);
        this.game.rect(this.point.x, this.point.y, this.width, this.height);
        this.point.y += this.speed;
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
