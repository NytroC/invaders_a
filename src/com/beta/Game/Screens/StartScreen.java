package com.beta.Game.Screens;

import processing.core.PApplet;
import processing.core.PImage;

public class StartScreen {

    protected PImage startImage;
    protected Game game;
    protected String highScoreText;

    public StartScreen(Game game){
        this.game = game;
        highScoreText = "High Score: ";
        this.startImage = game.loadImage("sprites/start.png");

    }

    public void draw(){
        game.text(highScoreText + game.highScore, 300, 50);
        game.image(startImage, 300, 300);
    }

}
