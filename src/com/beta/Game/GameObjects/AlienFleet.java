package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.GameObject.GameObjectInterface;
import processing.core.PApplet;

public class AlienFleet implements GameObjectInterface {
    private PApplet game;
    private Alien[][] alienMatrix = new Alien[10][6];
    private Point point;

    public AlienFleet(PApplet game) {
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

    private void drawAlienMatrix() {
        int columnWidth = 30;
        int columnSizeWithSpacing = columnWidth + 20;
        int rowHeight = 20;
        int rowHeightWithSpacing = rowHeight + 20;

        for (int col = 0; col <= this.alienMatrix.length - 1; col++) {

            for (int row = 0; row <= this.alienMatrix[col].length - 1; row++) {
                this.setRowColorByIndex(row);

                float alienX = (col * columnSizeWithSpacing) + this.point.x;
                float alienY = (row * rowHeightWithSpacing) + this.point.y;

//                System.out.println("Row");
//                System.out.println(row);
//                System.out.println("Col");
//                System.out.println(col);
//
//                System.out.println(this.alienMatrix);
                this.alienMatrix[col][row] = new Alien(this.game, alienX, alienY);

//                this.game.rect(
//                    alienX,
//                    alienY,
//                    columnWidth,
//                    rowHeight
//                );
            }
        }
    }

    private void setRowColorByIndex(int row) {
        String[][] rowColors = {
                { "255", "000", "000" },
                { "000", "255", "000" },
                { "255", "123", "000" },
                { "100", "123", "000" },
                { "055", "100", "100" },
                { "123", "255", "123" },
        };

        this.game.fill(
                Integer.parseInt(rowColors[row][0]),
                Integer.parseInt(rowColors[row][1]),
                Integer.parseInt(rowColors[row][2])
        );
    }
}
