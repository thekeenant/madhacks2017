package com.midevilgame.entity;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface Something {
    void remove();

    boolean isRemoved();

    void update();

    void render(Batch batch);

    void dispose();

    void setX(float x);

    void setY(float y);

    float getX();

    float getY();
}
