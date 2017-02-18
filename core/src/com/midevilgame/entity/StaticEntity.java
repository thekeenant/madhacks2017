package com.midevilgame.entity;

import com.badlogic.gdx.math.Vector2;

public class StaticEntity implements Entity {
    private final Vector2 position;

    public StaticEntity(Vector2 position) {
        this.position = position;
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }
}
