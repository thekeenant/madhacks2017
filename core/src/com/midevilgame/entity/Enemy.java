package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.map.Map;

import java.util.List;

public abstract class Enemy extends LivingEntity {
    private long lastDamageTime;

    public Enemy(Map map, Texture texture, Vector2 position, float width, float height) {
        super(map, texture, position, width, height);
    }

    abstract int getDamage();

    long getDamageInterval() {
        return 500;
    }

    @Override
    public void onSpawn() {
        super.onSpawn();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void onCollide(List<Collidable> collisions) {
        long now = System.currentTimeMillis();

        long diff = now - lastDamageTime;

        if (diff >= getDamageInterval()) {
            lastDamageTime = now;
            for (Collidable collidable : collisions) {
                if (collidable instanceof Player) {
                    Player player = (Player) collidable;
                    player.damage(getDamage());
                }
            }
        }
    }

    @Override
    public boolean isPassable() {
        return false;
    }
}
