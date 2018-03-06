package com.beta.GameObjects;

import com.beta.Contracts.GameObject.GameObjectInterface;
import processing.core.PApplet;

public class AlienFleet implements GameObjectInterface {
    private PApplet game;
    private int[][] alienMatrix = new int[10][3];
    private String[] colors = { "900", "090", "009" };

    public AlienFleet(PApplet game) {
        this.game = game;
    }

    public void draw() {
        this.drawAlienMatrix();
    }

    private void drawAlienMatrix() {
        int columnWidth = 30;
        int columnSizeWithSpacing = columnWidth + 20;
        int rowHeight = 20;

        for (int col = 0; col < alienMatrix.length; col++) {
            for (int row = alienMatrix[col][0]; row < alienMatrix[col].length; row++) {
                this.game.fill(Integer.parseInt(this.colors[row]));
                this.game.rect(col * columnSizeWithSpacing, row * rowHeight + 100, columnWidth, rowHeight);
            }
        }
    }
}
