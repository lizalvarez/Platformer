package com.alvareze.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen {
   public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        map = new TmxMapLoader().load("map/map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f + (height / width));
        //telling how much to show on the screen when you run it
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        //sets camera position so we could see the whole screen
    }

    @Override
    public void render(float delta) {
        //updating the camera
        camera.update();
        renderer.setView(camera);
        //setting the camera on the renderer
        renderer.render();
        //renderer the render
    }

    @Override
    public void resize(int width, int height) {

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
