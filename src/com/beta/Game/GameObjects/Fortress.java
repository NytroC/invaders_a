package com.beta.Game.GameObjects;

import com.beta.Game.Contracts.Collidable;
import com.beta.Game.Screens.Game;
import java.util.ArrayList;

public class Fortress extends GameObject implements Collidable {
    private int lifeRemaining;
    private ArrayList<Fortress> fortress = new ArrayList<>();

    public Fortress(Game game, Point point){
        super(game, point);
        this.setup();
    }

    public void setup() {
        this.setDimensions(40, 40);
    }

    public void draw(){
        this.game.fill(0, 255, 0);
        this.game.rect(this.point.x, this.point.y, this.width, this.height);
    }

    private void fortressDecay(int status){
        lifeRemaining -= status;
    }

    public boolean isTouching(GameObject gameObject){
        return false;
    }

    public void kill(GameObject gameObject) {
        fortressDecay(50);
        if(lifeRemaining == 0) {
            //gameObject.remove(this);
        }
    }

    public Point getPosition(){
        return this.point;
    }

}


