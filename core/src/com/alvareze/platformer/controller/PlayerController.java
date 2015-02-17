package com.alvareze.platformer.controller;

import com.alvareze.platformer.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.math.Vector2;

public class PlayerController {

    public static Player player;
    public static String movementAction;
    public static String specialAction;
    public static boolean grounded;

    private enum State{
        Idle, Walk, Jump, Duck, Climb, Hurt, Swim
    }
    private static State playerState;

    private static final float VELOCITY = 1f;
    // wont be able to be changed once it's set
    // final variables can be UPPER CASE
    private static final float MAX_VELOCITY = 5f;

    public static void initializeController(){
        player = new Player(new Vector2(4, 6), 70, 100,"img/aliens.png");
        playerState = State.Idle;
        movementAction = "";
        specialAction = "";
        grounded = false;
        //initialize
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

        if(Math.abs(velocity.x) > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(movementAction.equalsIgnoreCase("right")){
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
            player.direction = "right";
        }
        else if(movementAction.equalsIgnoreCase("left")) {
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0f, position.x, position.y, true);
            player.direction = "left";
        }
        else if(specialAction.equalsIgnoreCase("jump")) {
            player.physicsBody.applyLinearImpulse(0f, VELOCITY, position.x, position.y, true);
            player.direction = "jump";
        }
        else if(specialAction.equalsIgnoreCase("duck")) {
            player.physicsBody.applyLinearImpulse(0f, VELOCITY, position.x, position.y, true);
            player.direction = "duck";
        }
        if(Math.abs(velocity.x) > 0){
            playerState = State.Walk;
        }
        else {
            playerState = State.Idle;
        }

       if(Math.abs(velocity.y) > 0){
            playerState = State.Jump;
        }
        if(Math.abs(velocity.y) > 0){
            playerState = State.Duck;
        }

        setCurrentAnimation();

    }
    private static void setCurrentAnimation(){
        if(player.direction.equals("right")){
            setRightAnimation();
        }
        else if(player.direction.equals("left")){
            setLeftAnimation();

        }
    }
    private static void setLeftAnimation(){
        if(playerState == State.Walk){
            player.currentAnimation = "walkLeft";
        }
        else if(playerState == State.Idle) {
            player.currentAnimation = "idleLeft";
        }
    }
    private static void setRightAnimation(){
        if(playerState == State.Walk){
            player.currentAnimation = "walkRight";
        }
        else if(playerState == State.Idle) {
            player.currentAnimation = "idleRight";
        }
    }

    }