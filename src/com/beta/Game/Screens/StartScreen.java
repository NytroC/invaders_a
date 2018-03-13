package com.beta.Game.Screens;

import processing.core.PApplet;
import processing.core.PImage;

public class StartScreen {

    protected Game game;
    protected String highScoreText;

    public StartScreen(Game game){
        this.game = game;
        highScoreText = "High Score: ";
    }

    public void draw(){
        game.fill(200, 255, 2);
        game.textSize(75);
        game.text(game.gameState.title, 150, game.height / 2);
        game.textSize(32);
        game.text(highScoreText + game.gameState.getHighScore(), 300, 50);
        game.text("Insert Coin(s)", 300, game.height / 2 + 50);
        game.text("Credit(s): 3", 325, 600);
        if (game.frameCount % 60 < 20){
            game.fill(0, 0, 0);
        }
        game.text("Any Button To Continue", 200, 400);
    }

}