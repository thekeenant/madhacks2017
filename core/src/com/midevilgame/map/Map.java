package com.midevilgame.map;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.midevilgame.entity.Player;
import com.midevilgame.entity.Something;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final float width;
    private final float height;

    private List<Something> things;

    public Map(float width, float height) {
        this.width = width;
        this.height = height;
        this.things = new ArrayList<>();
    }

    public Player getPlayer() {
        for (Something entity : things) {
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
        List<Something> things = new ArrayList<>(this.things);
        for (Something entity : things) {
            entity.update();
        }
    }

    public void render(Batch batch) {
        List<Something> things = new ArrayList<>(this.things);
        for (Something entity : things) {
            entity.render(batch);
        }
    }

    public void addThing(Something entity) {
        this.things.add(entity);
    }

    public void removeThing(Something entity) {
        this.things.remove(entity);
    }

    public void clearThings() {
        this.things.clear();
    }

    public List<Something> getThings() {
        return this.things;
    }

    public void dispose() {
        for (Something entity : this.things) {
            entity.dispose();
        }
    }
}
