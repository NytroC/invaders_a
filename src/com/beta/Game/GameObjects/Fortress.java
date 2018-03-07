package com.beta.Game.GameObjects;

import processing.core.PApplet;

public class Fortress {

    private int x;
    private int y;
    private int lifeRemaining;
    private PApplet p;

    public Fortress(int x, int y, int lifeRemaining, PApplet p) {
        this.x = x;
        this.y = y;
        this.lifeRemaining = lifeRemaining;
        this.p = p;
    }

    private void fortressDecay(int status) {
        lifeRemaining -= status;
    }

    public void draw() {
        p.fill(125, 0, 0);
        p.ellipse(x, y, 2, 3);
    }
}

