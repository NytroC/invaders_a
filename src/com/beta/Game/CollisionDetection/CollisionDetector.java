package com.beta.Game.CollisionDetection;

import java.util.ArrayList;
import java.util.HashMap;
import com.beta.Game.Contracts.Collidable;
import com.beta.Game.GameObjects.*;
import com.beta.Game.GameState.GameState;

/**
 * Created by drewbartlett on 3/7/18.
 */
public class CollisionDetector {
    private HashMap gameObjects;
    private GameState gameState;

    public CollisionDetector(HashMap gameObjects, GameState gameState) {
        this.gameObjects = gameObjects;
        this.gameState = gameState;
    }

    public void runCollisionChecks() {
        this.checkAlienFleetBombCollisions();
        this.checkRocketCollideWithAlienFleetCollision();
    }

    public void checkAlienFleetBombCollisions() {
        AlienFleet alienFleet = (AlienFleet) this.gameObjects.get("alienFleet");

        if (alienFleet.isDroppingBomb) {
            Collidable bomb = alienFleet.currentBomb;

            String[] fortresses = { "fortress", "fortress1", "fortress2", "fortress3" };

            for (String fortress: fortresses) {
                if (bomb.isTouching((GameObject) this.gameObjects.get(fortress))) {
                    alienFleet.stopDroppingBomb();
                }
            }

            if (bomb.isTouching((GameObject) this.gameObjects.get("ship"))) {
                alienFleet.stopDroppingBomb();
                this.gameState.decrementScoreBy(50);
                this.gameState.deleteLife();
            }

            Ship ship = (Ship) this.gameObjects.get("ship");

            for (Rocket rocket: ship.rockets) {
                if (bomb.isTouching(rocket)) {
                    alienFleet.stopDroppingBomb();
                }
            }
        }
    }

    public void checkRocketCollideWithAlienFleetCollision() {
        Ship ship = (Ship) this.gameObjects.get("ship");
        ArrayList<Rocket> rockets = ship.getRockets();
        AlienFleet alienFleet = (AlienFleet) this.gameObjects.get("alienFleet");
        ArrayList<Alien> aliens = alienFleet.getAliens();

        for(Rocket rocket: rockets){
            for(Alien alien: aliens)
            if(rocket.isTouching(alien)){
                alien.kill();
            }
        }
    }

}
