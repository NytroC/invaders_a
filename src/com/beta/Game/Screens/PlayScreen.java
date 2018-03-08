package com.beta.Game.Screens;

import com.beta.Game.Contracts.GameScreen.GameScreenInterface;
import com.beta.Game.GameObjects.AlienFleet;
import com.beta.Game.GameObjects.Point;
import com.beta.Game.GameObjects.Ship;
import com.beta.Game.GameObjects.UFO;
import com.beta.Game.GameObjects.Fortress;




public class PlayScreen implements GameScreenInterface {

    protected AlienFleet alienFleet;
    protected Ship ship;
    protected UFO ufo;
    protected Fortress fortress;
    protected Fortress fortress1;
    protected Fortress fortress2;
    protected Fortress fortress3;
    protected Game game;
    protected String scoreText;

    public PlayScreen(Game game){
        this.game = game;
        scoreText = "Score: ";
        alienFleet = new AlienFleet(game, new Point(50, 50));
        ship = new Ship(game, new Point(50, game.height - 50));
        ufo = new UFO(game, new Point(-300,25));
        /*
        for (int i = 0; i < 4; i++) {
            fortress = new Fortress(game, new Point(this.width/4 * i + 200, this.height - 200, 100, this));
        }
        */
        fortress = new Fortress(game, new Point(80, 450));
        fortress1 = new Fortress(game, new Point(280, 450));
        fortress2 = new Fortress(game, new Point(480, 450));
        fortress3 = new Fortress(game, new Point(680, 450));
    }

    public void draw() {

        alienFleet.draw();
        ship.draw();
        ufo.draw();
        game.fill(200, 255, 2);
        game.textSize(32);

        game.text(scoreText + game.score, 20, 25);
        game.text(game.title, 300, 25);
        /*
        for(int i = 0; i < this.fortress.size(); i++) {
            this.fortress.get(i).draw();
        }
        */
        fortress.draw();
        fortress1.draw();
        fortress2.draw();
        fortress3.draw();
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
        if(game.keys[0] == true){
            ship.fireRocket();
        }
        if(game.keys[1] == true){
            ship.moveLeft();
        }
        if(game.keys[2] == true){
            ship.moveRight();
        }
    }

}