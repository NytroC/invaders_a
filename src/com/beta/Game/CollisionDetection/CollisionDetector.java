package com.beta.Game.CollisionDetection;

import java.util.HashMap;
import com.beta.Game.Contracts.Collidable;
import com.beta.Game.GameObjects.AlienFleet;
import com.beta.Game.GameObjects.GameObject;
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
        this.checkAlienFleetBombCollision();
    }

    // if alienFleet bomb isTouching(fortress) with
    //

    public void checkAlienFleetBombCollision() {
        AlienFleet alienFleet = (AlienFleet) this.gameObjects.get("alienFleet");

        if (alienFleet.isDroppingBomb) {
            Collidable bomb = alienFleet.currentBomb;

            String[] fortresses = { "fortress", "fortress1", "fortress2", "fortress3" };

            for (String fortress: fortresses) {
                if (bomb.isTouching((GameObject) this.gameObjects.get(fortress))) {
                    alienFleet.stopDroppingBomb();
                    this.gameState.decrementScoreBy(50);
                }
            }
        }
    }

}
