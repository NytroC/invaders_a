package com.beta.Game.Screens;

import com.beta.Game.CollisionDetection.CollisionDetector;
import com.beta.Game.Contracts.Drawable;
import com.beta.Game.GameObjects.*;
import java.util.HashMap;

public class PlayScreen implements Drawable {
    protected HashMap<String, GameObject> gameObjects = new HashMap<String, GameObject>();
    protected CollisionDetector collisionDetector;
    protected Game game;
    boolean keys[] = { false, false, false };
    protected String scoreText;

    public PlayScreen(Game game) {
        this.game = game;

        this.scoreText = "Score: ";
        this.gameObjects.put("alienFleet", new AlienFleet(game, new Point(50, 50)));
        this.gameObjects.put("ship", new Ship(game, new Point(50, game.height - 50)));
        this.gameObjects.put("ufo", new UFO(game, new Point(-300,25)));
        this.gameObjects.put("fortress", new Fortress(game, new Point(100, 450)));
        this.gameObjects.put("fortress1", new Fortress(game, new Point(300, 450)));
        this.gameObjects.put("fortress2", new Fortress(game, new Point(500, 450)));
        this.gameObjects.put("fortress3", new Fortress(game, new Point(700, 450)));
        this.collisionDetector = new CollisionDetector(this.gameObjects, this.game.gameState);
    }

    public void draw() {
        for (Drawable gameObject : this.gameObjects.values()) {
            gameObject.draw();
        }

        this.collisionDetector.runCollisionChecks();

        game.fill(200, 255, 2);
        game.textSize(16);

        game.text(scoreText + this.game.gameState.score(), 25, 25);
        game.text(game.title, 300, 25);

        controls();
    }

    public void keyPressed(){
        if(game.key == ' '){
            game.keys[0]= true;
        }
        if(game.key == 'a'){
            game.keys[1] = true;
        }
        if(game.key == 'd'){
            game.keys[2] = true;
        }
    }

    public void keyReleased(){
        if(game.key == ' '){
            game.keys[0] = false;
        }
        if(game.key == 'a'){
            game.keys[1] = false;
        }
        if(game.key == 'd'){
            game.keys[2] = false;
        }
    }

    public void controls(){
        Ship ship = (Ship) this.gameObjects.get("ship");

        if(game.keys[0] == true) {
            ship.fireRocket();
        }

        if(game.keys[1] == true) {
            ship.moveLeft();
        }

        if(game.keys[2] == true) {
            ship.moveRight();
        }
    }

    public void mouseClicked() {
        System.out.println("Clicked");
        AlienFleet alienFleet = (AlienFleet) this.gameObjects.get("alienFleet");
        alienFleet.killRandomAlien();
        System.out.println("EndClicked");
    }

}
