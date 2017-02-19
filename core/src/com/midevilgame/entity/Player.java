package com.midevilgame.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.Magic;
import com.midevilgame.assets.Textures;
import com.midevilgame.map.Map;

import java.util.Collection;
import java.util.List;

public class Player extends LivingEntity {
    private Vector2 lastDir = Vector2.Zero;
    private float lastAngle;

    public Player(Map map, Vector2 position, float width, float height) {
        super(map, Textures.PLAYER_RIGHT, position, width, height);
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
    public void remove() {
        // no you didn't hah.
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
        for (Something thing : getMap().getThings()) {
            if (thing instanceof Collidable) {
                Collidable col = (Collidable) thing;
                if (col.colliding(this) && !col.isPassable()) {
                    this.setPosition(before);
                }
            }
        }

        if (!after.equals(before)) {
            Vector2 diff = after.sub(before);

            float angle = diff.angle();

            this.lastDir = diff;
            this.lastAngle = angle;
        }

        if (this.lastAngle < 90 || this.lastAngle > 270) {
            getSprite().setTexture(Textures.PLAYER_RIGHT);
        }
        else {
            getSprite().setTexture(Textures.PLAYER_LEFT);
        }

        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            Vector2 pos = getMap().getPlayer().getPosition();
            pos.add(lastDir.cpy().scl(2));
            Projectile proj = new Fireball(getMap(), pos, lastAngle, this);
            getMap().addThing(proj);
        }
    }
}
