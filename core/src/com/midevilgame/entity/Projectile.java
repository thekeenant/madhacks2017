package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.map.Map;

public abstract class Projectile extends Entity {
    private final float angle;

    public Projectile(Map map, Texture texture, Vector2 position, float width, float height, float angle) {
        super(map, texture, position, width, height);
        this.angle = angle;
        getSprite().setRotation(this.angle);
    }

    @Override
    public void update() {
        double radians = this.angle / 180.0 * Math.PI;

        float x = (float) Math.cos(radians) * getSpeed();
        float y = (float) Math.sin(radians) * getSpeed();

        addX(x);
        addY(y);
    }

    public abstract float getSpeed();
}
