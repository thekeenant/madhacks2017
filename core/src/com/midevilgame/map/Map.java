package com.midevilgame.map;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.midevilgame.entity.Collidable;
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
        // Remove removed things
        List<Something> toRemove = new ArrayList<>();
        for (Something thing : things) {
            if (thing.isRemoved()) {
                toRemove.add(thing);
            }
        }
        things.removeAll(toRemove);

        // Update things
        List<Something> things = new ArrayList<>(this.things);
        List<Collidable> collidables = new ArrayList<>();
        for (Something thing : things) {
            thing.update();
            if (thing instanceof Collidable) {
                collidables.add((Collidable) thing);
            }
        }


        for (Collidable collidable : collidables) {
            List<Collidable> list = new ArrayList<>();
            for (Collidable other : collidables) {
                if (collidable.equals(other))
                    continue;

                if (collidable.colliding(other)) {
                    list.add(other);
                }
            }

            collidable.onCollide(list);
        }
    }

    public void render(Batch batch) {
        for (Something entity : things) {
            entity.render(batch);
        }
    }

    public void addThing(Something entity) {
        things.add(entity);
    }

    public void removeThing(Something entity) {
        entity.remove();
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
