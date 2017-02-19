package com.midevilgame.entity;

import com.badlogic.gdx.graphics.g2d.Batch;

public class Attachment implements Something {
    private final Something base;
    private final Something attached;
    private final float offsetX;
    private final float offsetY;

    public Attachment(Something base, Something attached, float offsetX, float offsetY) {
        this.base = base;
        this.attached = attached;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    @Override
    public void remove() {
        this.attached.remove();
    }

    @Override
    public boolean isRemoved() {
        return this.base.isRemoved() || this.attached.isRemoved();
    }

    @Override
    public void update() {
        this.attached.setX(this.base.getX() + this.offsetX);
        this.attached.setY(this.base.getY() + this.offsetY);

        this.attached.update();
    }

    @Override
    public void render(Batch batch) {
        this.attached.render(batch);
    }

    @Override
    public void dispose() {
        this.attached.dispose();
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
        return this.attached.getX();
    }

    @Override
    public float getY() {
        return this.attached.getY();
    }
}
