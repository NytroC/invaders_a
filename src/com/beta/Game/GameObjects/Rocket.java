package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;

public class Rocket extends  GameObject {

    private float ySpeed = 3.0f;

    public Rocket(Game game, Point point) {
        super(game, point);
        this.setup();
    }

    void setup() {
       this.setDimensions(10, 10);
    }

    public void draw() {
        this.game.fill(255, 000, 000);
        this.game.rect(this.point.x, this.point.y, this.width, this.height);
        this.update();
    }

    public void update() {
        this.point.y -= ySpeed;
    }

    public Point getPosition() {
        return this.point;
    }



}