package com.midevilgame.entity;

import com.badlogic.gdx.math.Vector2;

public class MovingEntity implements Entity {
    private Vector2 position;

    public MovingEntity(Vector2 position) {
        this.position = position;
    }

    public void setX(float x) {
        this.position.x = x;
    }

    public void setY(float y) {
        this.position.y = y;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPosition(float x, float y) {
        this.position = new Vector2(x, y);
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }
}
