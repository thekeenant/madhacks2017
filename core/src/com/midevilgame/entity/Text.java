package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Text implements Something {
    private final BitmapFont font;
    private final String str;
    private float x;
    private float y;
    private boolean removed;

    public Text(String str, float x, float y) {
        this.x = x;
        this.y = y;
        this.font = new BitmapFont();
        this.font.getData().setScale(0.5f, 0.5f);
        this.font.setColor(Color.RED);
        this.str = str;
    }

    @Override
    public void remove() {
        this.removed = true;
    }

    @Override
    public boolean isRemoved() {
        return this.removed;
    }

    @Override
    public void update() {
        // nothing to do here.
    }

    @Override
    public void render(Batch batch) {
        this.font.draw(batch, str, x, y);
    }

    @Override
    public void dispose() {
        this.font.dispose();
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
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
    public boolean canCollide() {
        return false;
    }
}
