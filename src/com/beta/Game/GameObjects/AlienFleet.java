package com.beta.Game.GameObjects;

import com.beta.Game.Screens.PlayScreen;

public class AlienFleet extends GameObject {
    private Alien[][] alienMatrix = new Alien[10][6];
    private String[] rowColors = { "red", "green", "blue", "purple", "orange", "pink" };
    private String xDirection = "LEFT";
    private float xSpeed = 0.5f;
    private boolean isDroppingBomb = false;

    public AlienFleet(PlayScreen game, Point point) {
        super(game, point);

        this.setup();
    }

    void setup() {
        this.buildAlienMatrix();
    }

    public void draw() {
        this.game.clear();
        this.drawAlienMatrix();
        this.updateFleetPosition();
        this.dropBombFromAlien();
    }

    /**
     * Build the initial alien matrix
     */
    private void buildAlienMatrix() {
        for (int col = 0; col <= this.alienMatrix.length - 1; col++) {
            for (int row = 0; row <= this.alienMatrix[col].length - 1; row++) {
                this.alienMatrix[col][row] = new Alien(
                        this.game,
                        new Point(this.getAlienX(col), this.getAlienY(row)),
                        new Point(col, row)
                );
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

    public void dropBombFromAlien() {
//        if (this.isDroppingBomb) {
////            this.
//        } else {
            this.isDroppingBomb = true;
            this.alienMatrix[0][5].dropBomb();
//        }
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
    private void updateFleetPosition() {
        if (this.xDirection.equals("LEFT")) {
            if (this.getRightMostColumnPosition() <= this.game.width) {
                this.point.x += this.xSpeed;
            } else {
                this.reverseFleetDirection("RIGHT");
            }
        } else {
            if (this.getLeftMostColumnPosition() > 0) {
                this.point.x -= this.xSpeed;
            } else {
                this.reverseFleetDirection("LEFT");
            }
        }
    }

    /**
     * This will find the rightmost active row with at least the top alien remaining.
     *
     * ******* Only update this when a collision has been made *******
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

    /**
     * Reverse the direction of the matrix and bump down closer
     *
     * @param direction
     */
    private void reverseFleetDirection(String direction) {
        this.xDirection = direction;
        this.point.y += 5;
        this.xSpeed += 0.1f;
    }


}
