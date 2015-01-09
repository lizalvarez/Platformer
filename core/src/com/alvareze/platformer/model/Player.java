package com.alvareze.platformer.model;

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

public class Player {
    public Vector2 position;
    //point for x and y positioning
    public float width;
    public float height;
    public Spritesheet spriteSheet;
    public String currentAnimation;

    private float stateTime;
    //the game time of the player, when he spawns
    private HashMap<String, Animation> animations;
    // a table

    public Player(int width, int height) {
        position = new Vector2(0, 3);
        //initializing the position of the player (bottom left corner)
        this.width = width * (1/70f);
        this.height = height * (1/70f);
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);
            //creating that body in the game world
        Body playerBody = GameScreen.gameWorld.createBody(bodyDefinition);
        playerBody.setUserData(this);
        //this = whole player class
        //attaching it to a specific body

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f );
        //creating shape
        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        playerBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

//don't flip: stand, climb. need to be flipped: duck, hurt, idle, jump, swim, walk
        animations.put("stand", spriteSheet.createAnimation(0, 0, 0.1f));
        animations.put("climb", spriteSheet.createAnimation(1, 1, 0.1f));
        animations.put("duck", spriteSheet.createAnimation(3, 3, 0.1f));
        animations.put("hurt", spriteSheet.createAnimation(4, 4, 0.1f));
        animations.put("idle", spriteSheet.createAnimation(6, 6, 0.1f));
        animations.put("jump", spriteSheet.createAnimation(5, 5, 0.1f));
        animations.put("swim", spriteSheet.createAnimation(8, 8, 0.1f));
        animations.put("walk", spriteSheet.createAnimation(9, 10, 0.1f));

        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walk"), true, false));


        currentAnimation = "walkLeft";

        stateTime = 0f;
    }
    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);
        //size and position of the player & gets him to walk
    }
    public void update(float deltaTime){

        //delta time determines the change in time
        stateTime += deltaTime;
    }
}
