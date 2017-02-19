package com.midevilgame.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.Magic;
import com.midevilgame.map.Map;

import java.util.List;

public class Player extends LivingEntity {
    private Vector2 lastDir = Vector2.Zero;
    private float lastAngle;

    public Player(Map map, Texture texture, Vector2 position, float width, float height) {
        super(map, texture, position, width, height);
    }

    @Override
    int getHealth() {
        return 5;
    }

    @Override
    int getMaxHealth() {
        return 6;
    }

    @Override
    public void onSpawn() {
        super.onSpawn();
    }

    @Override
    public void onCollide(List<Collidable> entity) {

    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void update() {
        super.update();

        Vector2 before = getPosition();

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            addX(-Magic.PLAYER_SPEED);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            addX(Magic.PLAYER_SPEED);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            addY(-Magic.PLAYER_SPEED);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            addY(Magic.PLAYER_SPEED);
        }

        Vector2 after = getPosition();

        if (!after.equals(before)) {
            Vector2 diff = after.sub(before);

            float angle = diff.angle();

            this.lastDir = diff;
            this.lastAngle = angle;
        }

        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            Vector2 pos = getMap().getPlayer().getPosition();
            pos.add(lastDir.cpy().scl(2));
            Projectile proj = new Fireball(getMap(), pos, lastAngle, this);
            getMap().addThing(proj);
        }
    }
}
