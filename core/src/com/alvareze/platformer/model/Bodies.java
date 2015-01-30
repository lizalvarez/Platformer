package com.alvareze.platformer.model;

import com.alvareze.platformer.controller.LevelController;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Bodies {
    public static void createBody(MapObject mapObject) {
        String bodyType = mapObject.getProperties().get("type").toString();
        //converting into string
        //doesn't matter if its upper case or lower case
        if(bodyType.equalsIgnoreCase("solid")) {
            RectangleMapObject rectangleObject = (RectangleMapObject) mapObject;
            //need to know position and height
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            //static bodies don't move
            bodyDefinition.position.set(rectangleObject.getRectangle().x * LevelController.UNIT_SCALE, rectangleObject.getRectangle().y * LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);

            PolygonShape rectangleShape = new PolygonShape();
            rectangleShape.setAsBox(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2,
                rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2,
                new Vector2(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2,
                        rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2), 0 );

            FixtureDef fixtureDefinition = new FixtureDef();
            //creating properties of the shape
            fixtureDefinition.shape = rectangleShape;
            fixtureDefinition.shape = rectangleShape;

            physicsBody.createFixture(fixtureDefinition);
            rectangleShape.dispose();
        }
        else if(bodyType.equalsIgnoreCase("ground")){
            PolylineMapObject polylineObject = (PolylineMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(polylineObject.getPolyline().getX() * LevelController.UNIT_SCALE,
                   polylineObject.getPolyline().getY() * LevelController.UNIT_SCALE);
            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            ChainShape chainShape = new ChainShape();

            float[] transformedVertices = new float[polylineObject.getPolyline().getVertices().length];
            //amount of vertices on the shape

            for(int index = 0; index < transformedVertices.length; index++){
                transformedVertices[index] = polylineObject.getPolyline().getVertices()[index] * LevelController.UNIT_SCALE;
            }
            chainShape.createChain(transformedVertices);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = chainShape;
            fixtureDefinition.friction = 7f;

            physicsBody.createFixture(fixtureDefinition);
            chainShape.dispose();
            }
        else if (bodyType.equalsIgnoreCase("blocks")){

        }
    }
}
