package com.alvareze.platformer.controller;

import com.alvareze.platformer.model.Player;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class PlayerController {

    public static Player player;

    public static void initializeController(){
        player = new Player(new Vector2(4, 4), 70, 100);
    }

    public static void update(float deltaTime) {
        player.update(deltaTime);
    }
    public static void draw(Batch spriteBatch){
        player.draw(spriteBatch); //drawing the player
    }
}
