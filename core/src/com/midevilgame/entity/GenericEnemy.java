package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.ProjectileLauncher;
import com.midevilgame.map.Map;

public class GenericEnemy extends Enemy {
    private final int damage;
    private final int health;
    private ProjectileLauncher launcher;
    private long lastLaunch;


    public GenericEnemy(Map map, Texture texture, Vector2 position, float width, float height, int damage, int health, ProjectileLauncher launcher) {
        super(map, texture, position, width, height);
        this.damage = damage;
        this.health = health;
        this.launcher = launcher;
    }

    @Override
    public void update() {
        super.update();

        Vector2 from = getPosition();
        Vector2 to = getMap().getPlayer().getCenter();
        Vector2 diff = to.sub(from);
        float angle = diff.angle();

        if (launcher != null && !getMap().getPlayer().isDead()) {
            long now = System.currentTimeMillis();
            if (now - lastLaunch > launcher.frequency()) {
                launcher.launch(this, angle);
                lastLaunch = now;
            }
        }
    }

    @Override
    int getDamage() {
        return damage;
    }

    @Override
    int getMaxHealth() {
        return health;
    }
}
