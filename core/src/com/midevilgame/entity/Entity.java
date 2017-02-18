package com.midevilgame.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Represents a thing in the world.
 */
public interface Entity {
    Sprite getSprite();

    /**
     * @return  The vector position of the entity.
     */
    Vector2 getPosition();

    /**
     * @return The x position of the entity.
     */
    default float getX() {
        return getPosition().x;
    }

    /**
     * @return The y position of the entity.
     */
    default float getY() {
        return getPosition().y;
    }
}
