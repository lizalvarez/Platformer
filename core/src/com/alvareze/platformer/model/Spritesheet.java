package com.alvareze.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;
    public Animation animation;


    public Spritesheet(String pathToFile) {
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));
        //accessing aliens and converting it into a texture
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100);
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

    public Animation createAnimation(){
        TextureRegion[] animationFrames = new TextureRegion[2];
        //create the space for animation frame, space for 2 frames
        animationFrames[0] = spriteFrames[1];
        animationFrames[1] = spriteFrames[2];
        animation = new Animation(1f, animationFrames);
        return animation;

    }
}