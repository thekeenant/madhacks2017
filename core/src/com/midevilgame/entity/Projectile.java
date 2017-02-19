package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.map.Map;

import java.util.List;

public abstract class Projectile extends Entity {
    private final Entity shooter;
    private final float angle;

    public Projectile(Map map, Texture texture, Vector2 position, float width, float height, float angle, Entity shooter) {
        super(map, texture, position, width, height);
        this.angle = angle;
        this.shooter = shooter;
        getSprite().setRotation(this.angle);
    }

    @Override
    public void onSpawn() {

    }

    @Override
    public void onCollide(List<Entity> entities) {
        entities.remove(this.shooter);
        for (Entity entity : entities) {
            entity.remove();
        }
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
