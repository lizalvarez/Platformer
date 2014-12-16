package com.alvareze.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Player {
    public Vector2 position;
    //point for x and y positioning
    public Spritesheet spriteSheet;
    public String currentAnimation;

    private float stateTime;
    //the game time of the player, when he spawns
    private HashMap<String, Animation> animations;
    // a table

    public Player() {
        position = new Vector2(0, 3);
        //initializing the position of the player (bottom left corner)
        spriteSheet = new Spritesheet("img/aliens.png", 70, 100);
        animations = new HashMap<String, Animation>();
//don"t flip: stand, climb. need to be flipped: duck, hurt, idle, jump, swim, walk
        animations.put("stand", spriteSheet.createAnimation(0, 0, 0.1f));
        animations.put("climb", spriteSheet.createAnimation(1, 1, 0.1f));
        animations.put("duck", spriteSheet.createAnimation(3, 3, 0.1f));
        animations.put("hurt", spriteSheet.createAnimation(4, 4, 0.1f));
        animations.put("idle", spriteSheet.createAnimation(6, 6, 0.1f));
        animations.put("jump", spriteSheet.createAnimation(5, 5, 0.1f));
        animations.put("swim", spriteSheet.createAnimation(8, 8, 0.1f));
        animations.put("walk", spriteSheet.createAnimation(9, 10, 0.1f));

        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walk"), true, false));


        currentAnimation = "jumpLeft";

        stateTime = 0f;
    }
    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));
        //size and position of the player & gets him to walk
    }
    public void update(float deltaTime){

        //delta time determines the change in time
        stateTime += deltaTime;
        position.x +=  deltaTime;
    }
}
