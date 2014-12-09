package com.alvareze.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    //point for x and y positioning
    public Texture spriteSheet;

    public TextureRegion[] spriteFrames;

    public Animation animation;
    private float stateTime;
    //the game time of the player, when he spawns

    public Player() {
        position = new Vector2(0, 3);
        //initializing the position of the player (bottom left corner)
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
        //accessing aliens and converting it into a texture
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100);
        //splits up spritesheet according to width and height to make it into 2d array
        int counter =0;
        for(int row = 0; row < spriteSheetFrames.length; row ++){
            //selecting rows that we're on
            for(int column = 0; column < spriteSheetFrames[row].length; column++){
                counter++;
                //adds one value whatever the value is of counter
            }
        }
        spriteFrames = new TextureRegion[counter]; //spritesheet is now an array of 55

        counter = 0;
        //resetting
        //split up and arrange the rows
         for(TextureRegion[] row : spriteSheetFrames) {
             for(TextureRegion sprite : row){
                 spriteFrames[counter++] = sprite;
                 //storing sprite into spriteframe array
             }

        }
        TextureRegion[] animationFrames = new TextureRegion[2];
        //create the space for animation frame, space for 2 frames
        animationFrames[0] = spriteFrames[1];
        animationFrames[1] = spriteFrames[2];
        animation = new Animation(1f, animationFrames);

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
