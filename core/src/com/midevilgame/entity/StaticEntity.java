package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.map.Map;

import java.util.List;

public class StaticEntity extends Entity {
    public StaticEntity(Map map, Texture texture, Vector2 position, float width, float height) {
        super(map, texture, position, width, height);
    }

    @Override
    public void onSpawn() {

    }

    @Override
    public void onCollide(List<Entity> entity) {

    }

    @Override
    public void update() {

    }
}
