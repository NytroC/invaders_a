package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.GameObject.GameObjectInterface;
import com.beta.Game.Screens.PlayScreen;
import processing.core.PApplet;
import java.util.Timer;
import java.util.TimerTask;

public class AlienFleet implements GameObjectInterface {
    private PlayScreen game;
    private Alien[][] alienMatrix = new Alien[10][6];
    private Point point;
    private String[] rowColors = { "red", "green", "blue", "purple", "orange", "pink" };
    private String xDirection = "LEFT";

    public AlienFleet(PlayScreen game) {
        this.game = game;
        this.point = new Point(50, 50);
    }

    public Point getPosition() {
        return this.point;
    }

    public void draw() {
        this.game.clear();
        this.drawAlienMatrix();
        this.updatePosition();
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

    /**
     * Update the position of the matrix.
     * Move from left to right until our last non-empty column
     * collides with the edge. Then reverse.
     */
    private void updatePosition() {
        if (this.xDirection.equals("LEFT")) {
            if (this.getRightMostColumnPosition() <= this.game.width) {
                this.point.x += 1;
            } else {
                this.swapDirection("RIGHT");
            }
        } else {
            if (this.point.x > 0) {
                this.point.x -= 1;
            } else {
                this.swapDirection("LEFT");
            }
        }
    }

    private void swapDirection(String direction) {
        this.xDirection = direction;
        this.point.y += 5;
    }

//    private Point getLeftMostColumnPoint() {
//
//    }

    /**
     * This will find the rightmost active row with at least the top alien remaining.
     *
     * @return Point
     */
    private float getRightMostColumnPosition() {
        return this.alienMatrix[this.alienMatrix.length - 1][this.alienMatrix[0].length - 1].rightEdge();
    }
}
