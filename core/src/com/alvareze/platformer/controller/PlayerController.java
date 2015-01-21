package com.alvareze.platformer.controller;

import com.alvareze.platformer.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.math.Vector2;

public class PlayerController {

    public static Player player;

    private static final float VELOCITY = 1f;
    // wont be able to be changed once it's set
    // final variables can be UPPER CASE
    private static final float MAX_VELOCITY = 5f;

    public static void initializeController(){
        player = new Player(new Vector2(4, 6), 70, 100,"img/aliens.png");
    }

    public static void update(float deltaTime) {
        handleInput();
        player.update(deltaTime);
    }
    public static void draw(Batch spriteBatch){
        player.draw(spriteBatch); //drawing the player
    }
    private static void handleInput(){
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        //a point in space that has direction and magnitude
        Vector2 position = player.physicsBody.getPosition();

        if(velocity.x > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
          player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0f, position.x, position.y, true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.physicsBody.applyLinearImpulse(VELOCITY, 1f, position.x, position.y, true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.physicsBody.applyLinearImpulse(-VELOCITY, -1f, position.x, position.y, true);
        }
    }
}
