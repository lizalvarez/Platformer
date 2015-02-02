
package com.alvareze.platformer.controller;

import com.alvareze.platformer.model.InputControl;
import com.alvareze.platformer.model.Spritesheet;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class InputController {
    private static ArrayList<InputControl> inputControls;
    private static Spritesheet spritesheet;
    private static InputControl left;
    private static InputControl right;


    public static void initializeController(){
        inputControls = new ArrayList<InputControl>();
        spritesheet = new Spritesheet("img/touch-controls.png", 80, 80);
        left = new InputControl(new Vector2(0, 0), spritesheet.spriteFrames[0], "left");
        right = new InputControl(new Vector2(3, 0), spritesheet.spriteFrames[1], "right");
        inputControls.add(right);
        inputControls.add(left);
        //creating an array where we store the input controls

        //creating an array for input controls
        Gdx.input.setInputProcessor(createInputAdapter());
    }
    public static void draw (Batch spriteBatch) {
        spriteBatch.begin();
        for(InputControl input : inputControls) {
            input.draw(spriteBatch);

        }
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter(){
        return new InputAdapter(){
            @Override
            public boolean keyDown(int keycode) {
                if(keycode == Input.Keys.RIGHT){
                    PlayerController.movementAction = "right";

                }
               return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                if(keycode == Input.Keys.RIGHT){
                    PlayerController.movementAction = "";
                    //clear the action

                }
                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                for(InputControl input : inputControls) {
                    if (input.getBoundingBox().contains(screenX, screenY)) {
                        if(input.action.equalsIgnoreCase("right")) {
                            PlayerController.movementAction = "right";
                        }
                        }
                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                for(InputControl input : inputControls) {
                    if (input.getBoundingBox().contains(screenX, screenY)) {
                        if(input.action.equalsIgnoreCase("right")) {
                            //checking if we let go of that button
                            PlayerController.movementAction = "";
                        }
                    }
                }
                return true;
            }
        };
    }

}
