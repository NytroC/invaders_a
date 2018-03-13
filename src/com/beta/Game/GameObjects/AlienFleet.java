package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;
import java.util.concurrent.ThreadLocalRandom;

public class AlienFleet extends GameObject {
    private Alien[][] alienMatrix = new Alien[10][6];
    private String[] rowColors = { "red", "green", "blue", "purple", "orange", "pink" };
    private String xDirection = "LEFT";
    private float xSpeed = 0.5f;
    public boolean isDroppingBomb = false;
    public Bomb currentBomb;

//    [
//            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//    ]

    public AlienFleet(Game game, Point point) {
        super(game, point);

        this.setup();
    }

    void setup() {
        this.buildAlienMatrix();
    }

    public void draw() {
        this.drawAlienMatrix();
        this.updateFleetPosition();
        this.dropBombFromAlien();
    }

    /**
     * Build the initial alien matrix
     */
    private void buildAlienMatrix() {
        for (int column = 0; column <= this.alienMatrix.length - 1; column++) {
            for (int row = 0; row <= this.alienMatrix[column].length - 1; row++) {
                this.alienMatrix[column][row] = new Alien(
                        this.game,
                        new Point(this.getAlienX(column), this.getAlienY(row)),
                        new GridPoint(column, row),
                        this.game.loadImage("sprites/alien/alien-" + this.rowColors[row] + ".png")
                );
            }
        }
    }

    /**
     * Update the alien position and redraw them
     */
    private void drawAlienMatrix() {
        for (int column = 0; column <= this.alienMatrix.length - 1; column++) {
            for (int row = 0; row <= this.alienMatrix[column].length - 1; row++) {
                if (this.alienMatrix[column][row] != null) {
                    this.alienMatrix[column][row].setPosition(this.getAlienX(column), this.getAlienY(row));
                    this.alienMatrix[column][row].draw();
                }
            }
        }
    }

    public void dropBombFromAlien() {
        if (this.isDroppingBomb) {
            this.currentBomb.draw();

            if (this.currentBomb.bottomEdge() > (this.game.height + this.currentBomb.height + 150)) {
                this.stopDroppingBomb();
            }

        } else {
            Alien alien = this.getAlienToDropBombFrom();

            float bombX = alien.point.x + (alien.width / 2);
            float bombY = alien.point.y + alien.height;

            this.currentBomb = new Bomb(this.game, new Point(bombX, bombY));
            this.isDroppingBomb = true;
        }

        // get last next column that has active aliens
        // get bottomMost alien
        // fire from it
    }

    public void stopDroppingBomb() {
        this.isDroppingBomb = false;
        this.currentBomb = null;
    }

    /**
     * Get the alien's new Y position based off the given row
     *
     * @param {int} col
     * @return float
     */
    private float getAlienX(int column) {
        int columnWidth = 30;
        int columnSizeWithSpacing = columnWidth + 20;

        return (column * columnSizeWithSpacing) + this.point.x;
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
            if (this.getRightColumnEdge() <= this.game.width) {
                this.point.x += this.xSpeed;
            } else {
                this.reverseFleetDirection("RIGHT");
            }
        } else {
            if (this.getLeftColumnEdge() > 0) {
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
    private int getLeftMostColumn() {
        Alien topLeftAlien = this.alienMatrix[0][0];

        int column = 0;

        while(!topLeftAlien.isAlive && column < this.alienMatrix.length) {
            column++;
        }

        return column;
    }

    private float getLeftColumnEdge() {
        return this.alienMatrix[this.getLeftMostColumn()][0].leftEdge();
    }

    /**
     * This will find the rightmost active row with at least the top alien remaining.
     * Only update this when a collision has been made
     *
     * @return Point
     */
    private int getRightMostColumn() {
        int column = this.alienMatrix.length - 1;

        Alien topRightAlien = this.alienMatrix[column][0];

        while(!topRightAlien.isAlive && column > 0) {
            column--;
        }

        return column;
    }

    private float getRightColumnEdge() {
        return this.alienMatrix[this.getRightMostColumn()][0].rightEdge();
    }

    private int getLastRowInColumn(int column) {
        int row = this.alienMatrix[column].length - 1;

        Alien bottomAlien = this.alienMatrix[column][row];

        while(!bottomAlien.isAlive && row > 0) {
            bottomAlien = this.alienMatrix[column][row];
            row--;
        }

        return row;
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

    private Alien getAlienToDropBombFrom() {
        int column = ThreadLocalRandom.current().nextInt(this.getLeftMostColumn(), this.getRightMostColumn());

        return this.alienMatrix[column][this.getLastRowInColumn(column)];
    }

    public void killRandomAlien() {
        int lastRow = this.getLastRowInColumn(0);
        this.alienMatrix[0][lastRow].kill();
    }


}
