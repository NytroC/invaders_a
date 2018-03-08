package com.beta.Game.Screens;

import processing.core.PApplet;
import processing.core.PImage;

public class StartScreen {

    protected PImage startImage;
    protected Game game;

    public StartScreen(Game game){
        this.game = game;
        this.startImage = game.loadImage("sprites/start.png");

    }

    public void draw(){
        game.image(startImage, 300, 300);
    }

}
