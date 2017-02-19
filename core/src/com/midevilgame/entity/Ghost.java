package com.midevilgame.entity;

import com.badlogic.gdx.math.Vector2;
import com.midevilgame.Magic;
import com.midevilgame.assets.Textures;
import com.midevilgame.map.Map;

public class Ghost extends Enemy {
    public Ghost(Map map, Vector2 position, float width, float height) {
        super(map, Textures.GHOST, position, width, height);
    }

    @Override
    int getDamage() {
        return 1;
    }

    @Override
    public void update() {
        Vector2 target = getMap().getPlayer().getPosition();

        Vector2 movement = target.sub(getCenter());
        movement.nor().scl(Magic.GHOST_SPEED);

        add(movement);
    }

    @Override
    int getMaxHealth() {
        return 2;
    }
}
