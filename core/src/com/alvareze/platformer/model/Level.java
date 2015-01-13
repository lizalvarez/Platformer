package com.alvareze.platformer.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;
    //one instance of the variable

    public Level (String mapPath){
        map = new TmxMapLoader().load(mapPath);
    }
}
