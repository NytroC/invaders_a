package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.GameObject.GameObjectInterface;
import com.beta.Game.Screens.PlayScreen;

public class AlienFleet implements GameObjectInterface {
    private PlayScreen game;
    private Alien[][] alienMatrix = new Alien[10][6];
    private Point point;
    private String[] rowColors = { "red", "green", "blue", "purple", "orange", "pink" };
    private String xDirection = "LEFT";
    private float xSpeed = 0.5f;

    public AlienFleet(PlayScreen game) {
        this.game = game;
        this.point = new Point(50, 50);
        this.buildAlienMatrix();
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
     * Build the initial alien matrix
     */
    private void buildAlienMatrix() {
        for (int col = 0; col <= this.alienMatrix.length - 1; col++) {
            for (int row = 0; row <= this.alienMatrix[col].length - 1; row++) {
                this.alienMatrix[col][row] = new Alien(this.game, this.getAlienX(col), this.getAlienY(row));
            }
        }
    }

    /**
     * Update the alien position and redraw them
     */
    private void drawAlienMatrix() {
        for (int col = 0; col <= this.alienMatrix.length - 1; col++) {
            for (int row = 0; row <= this.alienMatrix[col].length - 1; row++) {
                if (this.alienMatrix[col][row] != null) {
                    this.alienMatrix[col][row].setPosition(this.getAlienX(col), this.getAlienY(row));
                    this.alienMatrix[col][row].draw();
                }
            }
        }
    }

    /**
     * Get the alien's new Y position based off the given row
     *
     * @param {int} col
     * @return float
     */
    private float getAlienX(int col) {
        int columnWidth = 30;
        int columnSizeWithSpacing = columnWidth + 20;

        return (col * columnSizeWithSpacing) + this.point.x;
    }

    /**
     * Get the alien's new Y position based off the given row
     *
     * @param {int} row
     * @return float
     */
    private float getAlienY(int row) {
        int rowHeight = 20;
        int rowHeightWithSpacing = rowHeight + 20;

        return (row * rowHeightWithSpacing) + this.point.y;
    }

    /**
     * Update the position of the matrix.
     * Move from left to right until our last non-empty column
     * collides with the edge. Then reverse.
     */
    private void updatePosition() {
        if (this.xDirection.equals("LEFT")) {
            if (this.getRightMostColumnPosition() <= this.game.width) {
                this.point.x += this.xSpeed;
            } else {
                this.reverseDirection("RIGHT");
            }
        } else {
            if (this.getLeftMostColumnPosition() > 0) {
                this.point.x -= this.xSpeed;
            } else {
                this.reverseDirection("LEFT");
            }
        }
    }

    /**
     * Reverse the direction of the matrix and bump down closer
     *
     * @param string direction
     */
    private void reverseDirection(String direction) {
        this.xDirection = direction;
        this.point.y += 5;
    }

    /**
     * This will find the rightmost active row with at least the top alien remaining.
     * Only update this when a collision has been made
     *
     * @return Point
     */
    private float getLeftMostColumnPosition() {
        Alien topLeftAlien = null;

        int column = 0;

        while(topLeftAlien == null && column < this.alienMatrix.length) {
            topLeftAlien = this.alienMatrix[column][0];
            column++;
        }

        return topLeftAlien.leftEdge();
    }

    /**
     * This will find the rightmost active row with at least the top alien remaining.
     * Only update this when a collision has been made
     *
     * @return Point
     */
    private float getRightMostColumnPosition() {
        Alien topRightAlien = null;

        int column = this.alienMatrix.length - 1;

        while(topRightAlien == null && column > 0) {
            topRightAlien = this.alienMatrix[column][0];
            column--;
        }

        return topRightAlien.rightEdge();
    }
}
