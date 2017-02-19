package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.map.Map;

import java.util.List;

public abstract class LivingEntity extends Entity {
    private int health;

    public LivingEntity(Map map, Texture texture, Vector2 position, float width, float height) {
        super(map, texture, position, width, height);
    }

    @Override
    public void onSpawn() {
        getMap().addThing(new HealthBar(this));
        health = getMaxHealth();
    }

    abstract int getMaxHealth();

    public void setHealth(int health) {
        this.health = Math.max(0, health);
        if (health <= 0)
            remove();
    }

    public int getHealth() {
        return this.health;
    }

    public void damage(int damage) {
        setHealth(getHealth() - damage);
    }

    public void heal(int damage) {
        setHealth(getHealth() + damage);
    }

}
