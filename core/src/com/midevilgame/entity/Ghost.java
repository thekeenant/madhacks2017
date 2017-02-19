package com.midevilgame.entity;

import com.badlogic.gdx.math.Vector2;
import com.midevilgame.Magic;
import com.midevilgame.graphics.Textures;
import com.midevilgame.map.Map;

/**
 * Created by jon on 18/02/17.
 */
public class Ghost extends Enemy {
    public Ghost(Map map, Vector2 position, float width, float height) {
        super(map, Textures.GHOST, position, width, height);
    }

    @Override
    public void update() {
        Vector2 target = getMap().getPlayer().getPosition();

        Vector2 movement = target.sub(getCenter());
        movement.nor().scl(Magic.GHOST_SPEED);

        add(movement);
    }

    @Override
    int getHealth() {
        return 10;
    }

    @Override
    int getMaxHealth() {
        return 10;
    }
}
