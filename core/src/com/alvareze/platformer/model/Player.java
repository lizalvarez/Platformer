package com.alvareze.platformer.model;

import com.alvareze.platformer.controller.LevelController;
import com.alvareze.platformer.view.GameScreen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import java.util.HashMap;

public class Player extends Sprite {

    public Player(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);
            //creating that body in the game world
        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsBody.setUserData(this);
        //this = whole player class
        //attaching it to a specific body

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f );
        //creating shape
        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        physicsBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

//don't flip: stand, climb. need to be flipped: duck, hurt, idle, jump, swim, walk
        animations.put("standRight", spriteSheet.createAnimation(0, 0, 0.1f));
        animations.put("climbRight", spriteSheet.createAnimation(1, 1, 0.1f));
        animations.put("duckRight", spriteSheet.createAnimation(3, 3, 0.1f));
        animations.put("hurtRight", spriteSheet.createAnimation(4, 4, 0.1f));
        animations.put("idleRight", spriteSheet.createAnimation(6, 6, 0.1f));
        animations.put("jumpRight", spriteSheet.createAnimation(5, 5, 0.1f));
        animations.put("swimRight", spriteSheet.createAnimation(8, 8, 0.1f));
        animations.put("walkRight", spriteSheet.createAnimation(9, 10, 0.1f));

        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duckRight"), true, false));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurtRight"), true, false));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idleRight"), true, false));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swimRight"), true, false));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));


        currentAnimation = "walkLeft";

    }
    public void draw(Batch spriteBatch){
        super.draw(spriteBatch);
        //calling the parent

    }
    public void update(float deltaTime){
        super.update(deltaTime);

    }
}
