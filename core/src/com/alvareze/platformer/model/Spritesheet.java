package com.alvareze.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;


    public Spritesheet(String pathToFile, int width, int height){
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));
        //accessing aliens and converting it into a texture
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);
        //splits up sprite sheet according to width and height to make it into 2d array
        int counter = 0;
        for (int row = 0; row < spriteSheetFrames.length; row++) {
            //selecting rows that we're on
            for (int column = 0; column < spriteSheetFrames[row].length; column++) {
                counter++;
                //adds one value whatever the value is of counter
            }
        }
        spriteFrames = new TextureRegion[counter];
        //sprite sheet is now an array of 55

        counter = 0;
        //resetting
        //split up and arrange the rows
        for (TextureRegion[] row : spriteSheetFrames) {
            for (TextureRegion sprite : row) {
                spriteFrames[counter++] = sprite;
                //storing sprite into sprite frame array
            }

        }
    }
    public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed){
        //taking starting frame and last frame
        int counter = (lastFrame + 1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[counter];
        //create the space for animation frame
        for(int index = lastFrame; index>= startFrame; index--){
            animationFrames[--counter] = spriteFrames[index];
        }

        return new Animation(animationSpeed, animationFrames);
        //every animation is one frame per
        //return animation variable

    }
    //animation that's flipped
    public Animation flipAnimation(Animation originalAnimation, boolean flipX, boolean flipY){
        int frameCount = originalAnimation.getKeyFrames().length;
        //how long the frames take
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];
        //access each space in animation
        for(int index = 0; index <= frameCount -1; index++){
            flippedFrames[index] = new TextureRegion(originalAnimation.getKeyFrames()[index]);
            flippedFrames[index].flip(flipX, flipY);
            //flipped the player
        }
        return new Animation(originalAnimation.getFrameDuration(), flippedFrames);
    }
}