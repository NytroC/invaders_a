package com.beta.Game.Screens;

import processing.core.PImage;

public class PauseScreen {
    protected PImage startImage;
    protected Game game;

    public PauseScreen(Game game){
        this.game = game;
        this.startImage = game.loadImage("sprites/start.png");

    }

    public void draw(){
        game.image(startImage, 300, 300);
    }

}
