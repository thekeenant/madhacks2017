package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Text implements Something {
    private final BitmapFont font;
    private Color color;
    private float scale;
    private final String text;
    private float x;
    private float y;
    private boolean removed;

    public Text(String text, float x, float y, BitmapFont font, Color color, float scale) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.font = font;
//        this.font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
        this.color = color;
        this.scale = scale;
    }

    public Text(String text, float x, float y, BitmapFont font, Color color) {
        this(text, x, y, font, color, 1.0f);
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
        this.font.getData().setScale(this.scale);
        this.font.setColor(color);
        this.font.draw(batch, text, x, y);
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
}
