package com.alvareze.platformer.view;

import com.alvareze.platformer.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen implements Screen {
   public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public Batch spriteBatch;
    public Player player;

    public static World gameWorld;
    private Box2DDebugRenderer debugRenderer;

      public GameScreen() {
        map = new TmxMapLoader().load("map/map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        gameWorld = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f + (height / width));
        //telling how much to show on the screen when you run it
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        //sets camera position so we could see the whole screen

        spriteBatch = renderer.getSpriteBatch();
        //the spritebatch that's attached to the map
        player = new Player();
    }

    @Override
    public void render(float delta) {
      //set the color
      Gdx.gl.glClearColor(0.30f,0.80f, 0.80f, 1f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      //clears the color to the one we chose

        //updating the camera
        camera.update();
        renderer.setView(camera);
        //setting the camera on the renderer
        renderer.render();
        //renderer the render

        player.update(delta);

        spriteBatch.begin();  //beginning of commands for player
        player.draw(spriteBatch); //drawing the player
        spriteBatch.end(); //ending of all the commands for the player

        debugRenderer.render(gameWorld, camera.combined);
        //displays the shapes to the exact size it needs to be
    }

    @Override
    public void resize(int width, int height) {
        //setting the width of the camera again
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        //modify the height so it doesn't look stretchy
        camera.update();

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
