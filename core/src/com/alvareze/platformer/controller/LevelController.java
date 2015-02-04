package com.alvareze.platformer.controller;

import com.alvareze.platformer.model.Bodies;
import com.alvareze.platformer.model.CollisionListener;
import com.alvareze.platformer.model.Level;
import com.alvareze.platformer.model.Player;
import com.alvareze.platformer.model.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;
    //one unit is equal to 70 pixels

    public static Level level;

    public static OrthogonalTiledMapRenderer renderer;

    public static Batch spriteBatch;

    public static World gameWorld;

    private static Array<Body> worldBodies;


    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){
        level = new Level("map/map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);
        gameWorld = new World(new Vector2(0,-10), true);
        gameWorld.setContactListener(new CollisionListener());
        worldBodies = new Array<Body>();
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch = renderer.getSpriteBatch();
        //the spritebatch that's attached to the map

        createLevelBodies();

    }
    //void = no return type
    public static void draw() {
        spriteBatch.setProjectionMatrix(CameraController.camera.combined);
        spriteBatch.begin();  //beginning of commands for player
        PlayerController.draw(spriteBatch);
        spriteBatch.end(); //ending of all the commands for the player

        spriteBatch.setProjectionMatrix(CameraController.inputCamera.combined);
        InputController.draw(spriteBatch);

        //debugRenderer.render(gameWorld, CameraController.camera.combined);
        //displays the shapes to the exact size it needs to be

    }
    public static void update(float deltaTime){
        renderer.setView(CameraController.camera);
        //setting the camera on the renderer
        renderer.render();
        //renderer the render
        updateWorldBodies();
        gameWorld.step(1/60f, 1, 1);
        //updating our game world
    }
    private static void updateWorldBodies(){
        worldBodies.clear();
        //empties out the whole array
        gameWorld.getBodies(worldBodies);
        //access every body in worldBodies
        for(Body body: worldBodies){

            Sprite spriteBody = (Sprite)body.getUserData();
            //changing the type of variable

            if(spriteBody != null) {
                spriteBody.position = body.getPosition();
                //does all the work
            }
        }
    }
    private static void createLevelBodies(){
        MapObjects mapObjects = level.getLayerObjects(level.getMapLayer("collision"));

        for(MapObject mapObject : mapObjects){
            Bodies.createBody(mapObject);

        }

        mapObjects = level.getLayerObjects(level.getMapLayer("blocks"));

        for(MapObject mapObject : mapObjects){
            Bodies.createBody(mapObject);

        }

    }
}
