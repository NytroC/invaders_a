package com.beta.Game.GameState;


import com.beta.Game.GameObjects.GameObject;
import com.beta.Game.GameObjects.Point;
import com.beta.Game.GameObjects.Life;
import com.beta.Game.Screens.Game;

import java.util.ArrayList;

public class GameState {
    public String title;
    protected int score;
    protected int highScore;
    public ArrayList<Life> lives = new ArrayList<>();

    public GameState() {
        this.title  = "Space Invaders";
        this.score = 0;
    }

    public void incrementScoreBy(int score) {
        this.score += score;
    }

    public void decrementScoreBy(int score) {
        this.score -= score;
    }
    public void deleteLife(){
        if(lives.size() > 0) {
            lives.remove(lives.size() - 1);
        }
    }

    public void setLives(int numberOfLives, Game game){
        for(int i = 0; i < numberOfLives; i++) {
            lives.add(new Life(game, new Point((i * 50) + 20, game.height - 50)));
        }
    }

    public int getHighScore(){
        return this.highScore;
    }

    public int score() {
        return this.score;
    }
}
