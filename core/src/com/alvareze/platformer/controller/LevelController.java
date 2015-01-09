package com.alvareze.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {
    public static TiledMap map;
    //one instance of the variable
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;
    public static World gameWorld;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){
        map = new TmxMapLoader().load("map/map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        gameWorld = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();


        spriteBatch = renderer.getSpriteBatch();
        //the spritebatch that's attached to the map

    }
    //void = no return type
    public static void draw() {
        spriteBatch.begin();  //beginning of commands for player
        player.draw(spriteBatch); //drawing the player
        spriteBatch.end(); //ending of all the commands for the player

        debugRenderer.render(gameWorld, CameraController.camera.combined);
        //displays the shapes to the exact size it needs to be

    }
    public static void update(float deltaTime){
        renderer.setView(CameraController.camera);
        //setting the camera on the renderer
        renderer.render();
        //renderer the render

        gameWorld.step(1/60f, 1, 1);
        //updating our game world\
    }
}
