package com.alvareze.platformer.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Enemy extends Sprite{
    public Enemy(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);
        //creating that body in the game world
    }
}
