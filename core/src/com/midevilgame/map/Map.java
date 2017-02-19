package com.midevilgame.map;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.MidevilGame;
import com.midevilgame.entity.*;
import org.xguzm.pathfinding.grid.GridCell;
import org.xguzm.pathfinding.grid.NavigationGrid;
import org.xguzm.pathfinding.grid.finders.AStarGridFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private final MidevilGame game;
    private final float width;
    private final float height;
    private final List<Music> tracks;
    private boolean started = false;
    private final int cellsWide;
    private final int cellsHigh;
    private final GridCell[][] cells;
    private NavigationGrid<GridCell> navigation;
    private AStarGridFinder<GridCell> finder;

    private List<Something> things;

    public Map(MidevilGame game, float width, float height, List<Music> tracks) {
        this.game = game;
        this.width = width;
        this.height = height;
        this.things = new ArrayList<>();
        this.tracks = tracks;
        this.cellsWide = (int) Math.floor(width / 16.0f);
        this.cellsHigh = (int) Math.floor(height / 16.0f);
        this.cells = new GridCell[cellsWide][cellsHigh];
    }

    public Map(MidevilGame game, float width, float height, Music... tracks) {
        this(game, width, height, Arrays.asList(tracks));
    }

    public void start() {
        if (!this.tracks.isEmpty())
            this.tracks.get(0).play();

        started = true;

        for (int x = 0; x < cellsWide; x += 1) {
            for (int y = 0; y < cellsHigh; y += 1) {
                Vector2 point = new Vector2(x * 16, y * 16);
                Rectangle area = new Rectangle(point.x, point.y, 16, 16);
                for (Something thing : things) {
                    if (thing instanceof Collidable) {
                        Collidable collider = (Collidable) thing;
                        if (collider.colliding(area)) {
                            cells[x][y] = new GridCell(x, y, false);
                        }
                        else {
                            cells[x][y] = new GridCell(x, y, true);
                        }
                    }
                }
            }
        }
        navigation = new NavigationGrid<>(cells, true);
        finder = new AStarGridFinder<>(GridCell.class);
    }

    public Vector2 findNextPathPoint(Vector2 pos, Vector2 target) {
        List<GridCell> path = findPath(pos, target);
        if (path.isEmpty())
            return pos.cpy();
        return new Vector2(path.get(0).x * 16, path.get(0).y * 16);
    }

    public List<GridCell> findPath(Vector2 pos, Vector2 target) {
        int fromX = (int) Math.floor(pos.x / 16.0f);
        int fromY = (int) Math.floor(pos.y / 16.0f);
        int toX = (int) Math.floor(target.x / 16.0f);
        int toY = (int) Math.floor(target.y / 16.0f);
        System.out.println(fromX + "," + fromY + " to " + toX + "," + toY);
        return finder.findPath(fromX, fromY, toX, toY, navigation);
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
