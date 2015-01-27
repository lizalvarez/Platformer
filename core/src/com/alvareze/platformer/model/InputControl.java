package com.alvareze.platformer.model;

import com.alvareze.platformer.controller.CameraController;
import com.alvareze.platformer.controller.LevelController;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class InputControl {
    public String action;
    public Vector2 position;
    private TextureRegion textureRegion;
    private float width;
    private float height;

    public InputControl(Vector2 position, TextureRegion textureRegion, String action) {
        this.position = position;
        this.textureRegion = textureRegion;
        this.action = action;

        width = textureRegion.getRegionWidth();
        height = textureRegion.getRegionHeight();
    }
    public void draw (Batch spriteBatch){
        spriteBatch.draw(textureRegion, position.x, position.y, width * LevelController.UNIT_SCALE, height * LevelController.UNIT_SCALE);
    }
    public Rectangle getBoundingBox(){
        return new Rectangle(position.x / LevelController.UNIT_SCALE * CameraController.widthScale,
                position.y / LevelController.UNIT_SCALE * CameraController.heightScale,
                width * CameraController.widthScale,
                height * CameraController.heightScale);
    }
}
