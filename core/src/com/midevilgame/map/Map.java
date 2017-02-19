package com.midevilgame.map;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.midevilgame.MidevilGame;
import com.midevilgame.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private final MidevilGame game;
    private final float width;
    private final float height;
    private final List<Music> tracks;
    private boolean started = false;

    private List<Something> things;

    public Map(MidevilGame game, float width, float height, List<Music> tracks) {
        this.game = game;
        this.width = width;
        this.height = height;
        this.things = new ArrayList<>();
        this.tracks = tracks;
    }

    public Map(MidevilGame game, float width, float height, Music... tracks) {
        this(game, width, height, Arrays.asList(tracks));
    }

    public void start() {
        if (!this.tracks.isEmpty())
            this.tracks.get(0).play();

        started = true;
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
        if (entity instanceof Entity) {
            ((Entity) entity).setSpawned();
            ((Entity) entity).onSpawn();
        }
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
