package com.midevilgame.entity;

import com.badlogic.gdx.graphics.g2d.Batch;

public class Attachment implements Something {
    private final Something base;
    private final Something attach;
    private final float offsetX;
    private final float offsetY;

    public Attachment(Something base, Something attach, float offsetX, float offsetY) {
        this.base = base;
        this.attach = attach;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    @Override
    public void update() {
        this.attach.setX(this.base.getX() + this.offsetX);
        this.attach.setY(this.base.getY() + this.offsetY);

        this.attach.update();
    }

    @Override
    public void render(Batch batch) {
        this.attach.render(batch);
    }

    @Override
    public void dispose() {
        this.attach.dispose();
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
        return this.attach.getX();
    }

    @Override
    public float getY() {
        return this.attach.getY();
    }
}
