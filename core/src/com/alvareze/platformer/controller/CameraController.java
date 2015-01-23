package com.alvareze.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;
    public static OrthographicCamera inputCamera;

    public static void initializeController(){
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(14f, 14f * (height / width));
        //telling how much to show on the screen when you run it
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        //sets camera position so we could see the whole screen

        inputCamera = new OrthographicCamera(14f, 14f * (height / width));
        inputCamera.position.set(inputCamera.viewportWidth/ 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();
    }
    public static void update(){
        camera.position.set(PlayerController.player.position.x, PlayerController.player.position.y, 0 );
        camera.update();
        //update the camera
    }
    public static void resize(int width, int height){
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        //modify the height so it doesn't look stretchy
        camera.update();

        inputCamera.viewportWidth = 14f;
        inputCamera.viewportHeight = 14f * height / width;
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();
    }
}

