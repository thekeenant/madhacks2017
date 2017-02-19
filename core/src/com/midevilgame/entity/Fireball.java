package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.Magic;
import com.midevilgame.graphics.Textures;
import com.midevilgame.map.Map;

public class Fireball extends Projectile {
    public Fireball(Map map, Vector2 position, float angle) {
        super(map, Textures.FIREBALL, position, 16, 16, angle);
        getSprite().rotate90(true);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public float getSpeed() {
        return Magic.FIREBALL_SPEED;
    }
}
