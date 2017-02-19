package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.map.Map;

public class Projectile extends Entity {
    private final float angle;

    public Projectile(Map map, Texture texture, Vector2 position, float width, float height, float angle) {
        super(map, texture, position, width, height);

        this.angle = angle;
    }

    @Override
    public void update() {
        getSprite().rotate(this.angle);

        double radians = this.angle / 180.0 * Math.PI;

        float x = (float) Math.cos(radians);
        float y = (float) Math.sin(radians);

        addX(x);
        addY(y);
    }
}
