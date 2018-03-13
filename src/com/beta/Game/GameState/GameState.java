package com.beta.Game.GameState;

public class GameState {
    public String title;
    protected int score;
    protected int highScore;

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

    public int score() {
        return this.score;
    }
}
