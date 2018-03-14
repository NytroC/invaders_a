package com.beta.Game.GameObjects;

import com.beta.Game.Screens.Game;
import processing.core.PImage;

import java.util.ArrayList;

public class Ship extends GameObject {
    private PImage sprite;
    private Rocket rocket;
    public ArrayList<Rocket> rockets = new ArrayList<>();
    private int radius = 25;
    private float speed = 2;
    private int counter = 0;
    private boolean reloading = false;
    private int reloadTime = 180;


    public Ship(Game game, Point point) {
        super(game, point);
        this.setup();
    }

    void setup() {
        this.sprite = this.game.loadImage("sprites/ship.png");
        this.setDimensions(this.radius * 2, this.radius * 2);
    }

    public void draw() {
        this.game.image(sprite, this.point.x, this.point.y, this.radius * 2, this.radius* 2);
        drawRocket();
        setReloadTime();
    }

    public Point getPosition() {
        return this.point;
    }


    public void moveLeft(){
        if(point.x >= 0) {
            this.point.x -= speed;
        }
    }
    public void moveRight(){
        if(point.x <= game.width - radius * 2) {
            this.point.x += speed;
        }
    }
    public void fireRocket(){
        if(reloading == false) {
            float rocketY = this.point.y;
            float rocketX = (this.point.x + radius - 5);
            rockets.add(new Rocket(this.game, new Point(rocketX, rocketY)));
            reloading = true;
        }
    }
    void drawRocket(){
        if (this.rocket != null) {
            this.rocket.draw();
        }
        for (Rocket rocket:rockets)
        {
            rocket.draw();
            destroyRocket(rocket);
        }
    }
    void destroyRocket(Rocket rocket){
        if(rocket.point.y <= 0){
            rocket = null;
        }
    }
    void setReloadTime(){
        if(reloading){
            counter++;
        }
        if(counter % reloadTime == 0){
            reloading = false;
        }
    }
    public ArrayList<Rocket> getRockets() {
        return rockets;
    }
}
