package com.alvareze.platformer;

import com.alvareze.platformer.view.GameScreen;
import com.badlogic.gdx.Game;

public class Platformer extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
