package com.midevilgame.entity;

import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public interface Collidable extends Something {
    Rectangle getBounds();

    void onCollide(List<Collidable> collisions);

    boolean isPassable();

    default boolean colliding(Collidable other) {
        return getBounds().overlaps(other.getBounds());
    }

    default boolean colliding(Rectangle other) {
        return getBounds().overlaps(other);
    }
}
