package com.midevilgame.map;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.midevilgame.entity.Player;
import com.midevilgame.entity.Something;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final float width;
    private final float height;

    private List<Something> entities;

    public Map(float width, float height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
    }

    public Player getPlayer() {
        for (Something entity : entities) {
            if (entity instanceof Player) {
                return (Player) entity;
            }
        }
        throw new RuntimeException("unable to find player");
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public void update() {
        for (Something entity : entities) {
            entity.update();
        }
    }

    public void render(Batch batch) {
        for (Something entity : entities) {
            entity.render(batch);
        }
    }

    public void addEntity(Something entity) {
        this.entities.add(entity);
    }

    public void removeEntity(Something entity) {
        this.entities.remove(entity);
    }

    public void clearEntities() {
        this.entities.clear();
    }

    public void dispose() {
        for (Something entity : this.entities) {
            entity.dispose();
        }
    }
}
