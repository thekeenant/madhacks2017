package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.map.Map;

import java.util.List;

public abstract class LivingEntity extends Entity {
    public LivingEntity(Map map, Texture texture, Vector2 position, float width, float height) {
        super(map, texture, position, width, height);
    }

    @Override
    public void onSpawn() {
        getMap().addThing(new HealthBar(this));
        System.out.println("test");
    }

    abstract int getHealth();

    abstract int getMaxHealth();
}
