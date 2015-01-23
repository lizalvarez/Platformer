package com.alvareze.platformer.view;

import com.alvareze.platformer.controller.CameraController;
import com.alvareze.platformer.controller.InputController;
import com.alvareze.platformer.controller.LevelController;
import com.alvareze.platformer.controller.PlayerController;
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

import java.util.logging.Level;

import javafx.scene.Camera;

public class GameScreen implements Screen {

      public GameScreen() {
        LevelController.initializeController();
          CameraController.initializeController();
          PlayerController.initializeController();
          InputController.initializeController();
    }

    @Override
    public void render(float delta) {
      //set the color
      Gdx.gl.glClearColor(0.30f,0.80f, 0.80f, 1f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      //clears the color to the one we chose

        LevelController.update(delta);
        CameraController.update();
        PlayerController.update(delta);
        LevelController.draw();
        //drawing what ever is on the level


    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);

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
