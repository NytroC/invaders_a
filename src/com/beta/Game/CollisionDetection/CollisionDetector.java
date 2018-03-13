package com.beta.Game.CollisionDetection;

import java.util.HashMap;

/**
 * Created by drewbartlett on 3/7/18.
 */
public class CollisionDetector {
    protected HashMap gameObjects;

    public CollisionDetector(HashMap gameObjects) {
        this.gameObjects = gameObjects;
    }

    // if alienFleet bomb isTouching(fortress) with
    //

//    public void checkAlienFleetBombCollision() {
//        AlienFleet alienFleet = this.gameObjects.get("alienFleet");
//
//        if (alienFleet.isDroppingBomb) {
//            Collidable bomb = this.gameObjects.get("alienFleet").currentBomb;
//
//            String[] fortresses = { "fortress", "fortress1", "fortress2", "fortress3" };
//
//            for (String fortress: fortresses) {
//                if (bomb.isTouching(this.gameObjects.get(fortress))) {
//                    alienFleet.stopDroppingBomb();
//                }
//            }
//        }
//    }

}
