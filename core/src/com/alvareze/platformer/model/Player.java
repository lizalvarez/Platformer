package com.alvareze.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    //point for x and y positioning
    public Texture spriteSheet;

    public Player() {
        position = new Vector2(0,0);
        //initializing the position of the player (bottom left corner)
        spriteSheet = new Texture(Gdx.files.internal("img/ aliens.png"));
        //accessing aliens and converting it into a texture
    }
    public void draw(Batch spriteBatch){
    spriteBatch.draw(spriteSheet, 0, 0, 70, 100);
        //size of the player
    }
    public void update(float deltaTime){

    }
}
