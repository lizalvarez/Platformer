package com.alvareze.platformer.model;

import com.alvareze.platformer.controller.LevelController;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Sprite {
    public Vector2 position;
    //point for x and y positioning
    public float width;
    public float height;
    public Spritesheet spriteSheet;
    public String currentAnimation;

    protected float stateTime;
    //the game time of the player, when he spawns
    protected HashMap<String, Animation> animations;
    // protected means its in the middle of private and public
    public Sprite(Vector2 position, int width, int height){
        this.position = position;
        //initializing the position of the player (bottom left corner)
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();

        stateTime = 0f;

    }
    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);
        //size and position of the player & gets him to walk
    }
    public void update(float deltaTime){

        //delta time determines the change in time
        stateTime += deltaTime;
    }
}