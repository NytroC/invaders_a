package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.GameObject.GameObjectInterface;
import com.beta.Game.Screens.PlayScreen;
import processing.core.PImage;
import java.io.File;

public class Alien implements GameObjectInterface {
    private Point point;
    private PlayScreen game;
    private PImage sprite;

    public Alien(PlayScreen game, float x, float y) {
        this.game = game;
        this.point = new Point(x, y);

        this.draw();
    }

    public void draw() {
        this.game.image(this.game.alienSprite, this.point.x, this.point.y, 30, 20);
    }

    public Point getPosition() {
        return this.point;
    }

}
