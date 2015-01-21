package com.alvareze.platformer.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;
    //one instance of the variable

    public Level (String mapPath){
        map = new TmxMapLoader().load(mapPath);
    }
    public MapLayer getMapLayer(String layerName){
        return map.getLayers().get(layerName);
    }
    public MapObjects getLayerObjects(MapLayer mapLayer){
        return mapLayer.getObjects();
    }
}
