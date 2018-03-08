package com.beta.Game.Screens;

import com.beta.Game.Contracts.GameScreen.GameScreenInterface;
import com.beta.Game.GameState.GameState;
import processing.core.PApplet;

public class Game extends PApplet {


    protected StartScreen startScreen;
    protected PlayScreen playScreen;
    protected PauseScreen pauseScreen;
    protected boolean startGame = false;
    protected boolean pauseGame = false;

    protected GameState gamestate;
    protected int score;
    protected int highScore;
    protected String title;

    boolean keys[] = {false, false, false};

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        startScreen = new StartScreen(this);
        playScreen = new PlayScreen(this);
        pauseScreen = new PauseScreen(this);
        this.title = "Space Invaders";
        score = 0;

    }

    public void draw() {

        clear();

        if (!startGame) {
            startScreen.draw();
        }
        if (startGame) {
            playScreen.draw();
        }
        if (pauseGame) {
            pauseScreen.draw();
        }
    }

    public void keyPressed() {
        playScreen.keyPressed();

        if(keyPressed == true){
            startGame = true;
            pauseGame = false;
        }
        if(key == 'p'){
            startGame = false;
            pauseGame = true;
        }

    }

    public void keyReleased() {
        playScreen.keyReleased();
    }
}

