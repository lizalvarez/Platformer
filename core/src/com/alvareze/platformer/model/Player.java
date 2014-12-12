package com.alvareze.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    //point for x and y positioning
    public Animation animation;
    public Spritesheet spriteSheet;
    private float stateTime;
    //the game time of the player, when he spawns

    public Player() {
        position = new Vector2(0, 3);
        //initializing the position of the player (bottom left corner)
        spriteSheet = new Spritesheet("img/aliens.png", 70, 100);
        animation = spriteSheet.createAnimation(9, 10, 0.1f);
        //greg says this code takes me to mexico
        // im kidding it returns an animation ^^
        animation = spriteSheet.flipAnimation(animation, true, false);
        stateTime = 0f;
    }
    public void draw(Batch spriteBatch){
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), (100 * 1/70));
        //size and position of the player
    }
    public void update(float deltaTime){

        //delta time determines the change in time
        stateTime += deltaTime;
        position.x +=  deltaTime;
    }
}
