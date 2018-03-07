package com.beta.Game.GameObjects;

import com.beta.Game.Screens.PlayScreen;

public class Alien extends GameObject {
    public int width = 30;
    public int height = 20;
    private Bomb currentBomb;
    private Point gridCoordinates;

    public Alien(PlayScreen game, Point point, Point gridCoordinates) { // reference to grid
        super(game, point);

        this.gridCoordinates = gridCoordinates;
        this.setup();
    }

    void setup() {
//        this.game.image(this.game.alienSprite, this.point.x, this.point.y, 30, 20);
    }

    public void draw() {
        this.game.fill(000, 255, 000);
        this.game.rect(this.point.x, this.point.y, this.width, this.height);
    }

    /**
     * Get the right edge coordinate of the alien
     *
     * @return float
     */
    public float rightEdge() {
        return this.point.x + this.width;
    }

    /**
     * Get the left edge coordinate of the alien
     *
     * @return float
     */
    public float leftEdge() {
        return this.point.x;
    }

    public void dropBomb() {
        float bombX = this.point.x + (this.width / 2);
        float bombY = this.point.y + this.height;

        if (this.currentBomb != null) {
            this.currentBomb.draw();
        } else {
            this.currentBomb = new Bomb(this.game, new Point(bombX, bombY));
        }
    }
}
