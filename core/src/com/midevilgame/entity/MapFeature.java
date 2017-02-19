package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MapFeature implements Something {
    private final Texture texture;
    private final float x;
    private final float y;
    private final float width;
    private final float height;

    public MapFeature(Texture texture, float x, float y, float width, float height) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isRemoved() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Batch batch) {
        batch.draw(texture, x, y, width, height);
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
}
