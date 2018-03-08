package com.beta.Game.Screens;

import com.beta.Game.Contracts.GameScreen.GameScreenInterface;
import processing.core.PApplet;

public class Game extends PApplet {

    protected StartScreen startScreen;
    protected PlayScreen playScreen;

    boolean keys[] = { false, false, false };

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        startScreen = new StartScreen(this);
        playScreen = new PlayScreen(this);
    }

    public void draw() {
        playScreen.draw();

    }

    public void keyPressed() {
        playScreen.keyPressed();
    }

    public void keyReleased(){
        playScreen.keyReleased();
    }

}
