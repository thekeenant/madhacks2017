package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class MapFeature implements Something, Collidable {
    private Sprite sprite;

    private final Texture texture;
    private final float x;
    private final float y;
    private final int width;
    private final int height;
    private final boolean repeating;
    private final boolean passable;

    public MapFeature(Texture texture, float x, float y, int width, int height, boolean repeating, boolean passable) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.repeating = repeating;
        this.passable = passable;
        if (!repeating) {
            this.sprite = new Sprite(texture);
            this.sprite.setPosition(x, y);
            this.sprite.setSize(width, height);
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isRemoved() {
        return false;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Batch batch) {
        if (this.repeating) {
            batch.draw(texture, x, y, 0, 0, width, height);
        }
        else {
            sprite.draw(batch);
        }
    }

    @Override
    public void dispose() {

    }

    @Override
    public void setX(float x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setY(float y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void onCollide(List<Collidable> collisions) {
        // Nothing matters.
    }

    @Override
    public boolean isPassable() {
        return passable;
    }
}
