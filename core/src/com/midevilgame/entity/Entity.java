package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.map.Map;

import java.util.ArrayList;
import java.util.List;

/**
 * Something that has a position that can change.
 */
public abstract class Entity implements Something, Collidable {
    private final Map map;
    private final Sprite sprite;
    private boolean removed;
    private boolean spawned;

    public Entity(Map map, Texture texture, Vector2 position, float width, float height) {
        this.map = map;
        this.sprite = new Sprite(texture);
        this.sprite.setSize(width, height);
        setPosition(position);
    }

    public abstract void onSpawn();

    @Override
    public void update() {

    }

    public void setSpawned() {
        this.spawned = true;
    }

    public boolean isSpawned() {
        return this.spawned;
    }

    @Override
    public void remove() {
        this.removed = true;
    }

    @Override
    public boolean isRemoved() {
        return this.removed;
    }

    public Rectangle getBounds() {
        return getSprite().getBoundingRectangle();
    }

    @Override
    public void render(Batch batch) {
        this.sprite.draw(batch);
    }

    public Map getMap() {
        return this.map;
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void dispose() {
        this.sprite.getTexture().dispose();
    }

    /**
     * Set the x position.
     * @param x
     */
    public void setX(float x) {
        getSprite().setX(x);
    }

    /**
     * Set the y position.
     * @param y
     */
    public void setY(float y) {
        getSprite().setY(y);
    }

    @Override
    public float getX() {
        return getSprite().getX();
    }

    @Override
    public float getY() {
        return getSprite().getY();
    }

    public Vector2 getPosition() {
        return new Vector2(getX(), getY());
    }

    public Vector2 getCenter() {
        float w = getSprite().getWidth();
        float h = getSprite().getHeight();
        return getPosition().cpy().add(w / 2.0f, h / 2.0f);
    }

    /**
     * Set the position of this entity, update the sprite.
     * @param position
     */
    public void setPosition(Vector2 position) {
        setPosition(position.x, position.y);
    }

    /**
     * Set the position of this entity, update the sprite.
     * @param x
     * @param y
     */
    public void setPosition(float x, float y) {
        getSprite().setPosition(x, y);
    }

    public void addX(float x) {
        setX(getX() + x);
    }

    public void addY(float y) {
        setY(getY() + y);
    }

    public void add(Vector2 movement) {
        setPosition(getPosition().cpy().add(movement));
    }
}
