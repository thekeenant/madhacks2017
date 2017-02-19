package com.midevilgame.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.Magic;
import com.midevilgame.map.Map;

import java.util.List;

public class Player extends Entity {
    private float lastDir;

    public Player(Map map, Texture texture, Vector2 position, float width, float height) {
        super(map, texture, position, width, height);
    }

    @Override
    public void onSpawn() {

    }

    @Override
    public void onCollide(List<Entity> entity) {

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

        Vector2 diff = after.sub(before);

        float angle = diff.angle();
        lastDir = angle;

        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            Vector2 pos = getMap().getPlayer().getPosition();
            pos.add(diff.scl(4));
            Projectile proj = new Fireball(getMap(), pos, angle, this);
            getMap().addThing(proj);
        }
    }
}
