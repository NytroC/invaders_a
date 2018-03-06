package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.GameObject.GameObjectInterface;
import com.beta.Game.Screens.PlayScreen;
import processing.core.PApplet;

public class AlienFleet implements GameObjectInterface {
    private PlayScreen game;
    private Alien[][] alienMatrix = new Alien[10][6];
    private Point point;
    private String[] rowColors = { "red", "green", "blue", "purple", "orange", "pink" };

    public AlienFleet(PlayScreen game) {
        this.game = game;
        this.point = new Point(100, 100);
    }

    public void draw() {
        this.drawAlienMatrix();
        this.updatePosition();
    }

    public Point getPosition() {
        return this.point;
    }

    /**
     * Update the position of the matrix.
     * Move from left to right until our last non-empty column
     * collides with the edge. Then reverse.
     */
    public void updatePosition() {

        if (this.point.x <= this.game.width) {
            this.point.x += 1;
        } else {
            System.out.println("reverse");
            this.point.x--;
        }

        // if this.lastColumn.x < this.game.width
        // if this.firstColumn.x > 0
    }

    /**
     * Draw the alien matrix.
     */
    private void drawAlienMatrix() {
        int columnWidth = 30;
        int columnSizeWithSpacing = columnWidth + 20;
        int rowHeight = 20;
        int rowHeightWithSpacing = rowHeight + 20;

        for (int col = 0; col <= this.alienMatrix.length - 1; col++) {
            for (int row = 0; row <= this.alienMatrix[col].length - 1; row++) {
                float alienX = (col * columnSizeWithSpacing) + this.point.x;
                float alienY = (row * rowHeightWithSpacing) + this.point.y;
                this.alienMatrix[col][row] = new Alien(this.game, alienX, alienY);
            }
        }
    }
}
