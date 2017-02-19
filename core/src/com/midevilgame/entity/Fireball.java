package com.midevilgame.entity;

import com.badlogic.gdx.math.Vector2;
import com.midevilgame.Magic;
import com.midevilgame.graphics.Textures;
import com.midevilgame.map.Map;

import java.util.List;

public class Fireball extends Projectile {
    public Fireball(Map map, Vector2 position, float angle, Entity shooter) {
        super(map, Textures.FIREBALL, position, 16, 16, angle, shooter);
        getSprite().rotate90(true);
    }

    @Override
    public float getSpeed() {
        return Magic.FIREBALL_SPEED;
    }
}
