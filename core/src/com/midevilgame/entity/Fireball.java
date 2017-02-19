package com.midevilgame.entity;

import com.badlogic.gdx.math.Vector2;
import com.midevilgame.Magic;
import com.midevilgame.assets.Sounds;
import com.midevilgame.assets.Textures;
import com.midevilgame.map.Map;

public class Fireball extends Projectile {
    public Fireball(Map map, Vector2 position, float angle, Entity shooter) {
        super(map, Textures.FIREBALL, position, 8, 7, angle, shooter);
        getSprite().rotate90(true);
    }

    @Override
    int getDamage() {
        return 1;
    }

    @Override
    void onDamage(LivingEntity target) {
        // fireball impact sound
        remove();
    }

    @Override
    public void onSpawn() {
        super.onSpawn();

        Sounds.FIREBALL_LAUNCH.play();
    }

    @Override
    public float getSpeed() {
        return Magic.FIREBALL_SPEED;
    }

    @Override
    public boolean isPassable() {
        return true;
    }
}
