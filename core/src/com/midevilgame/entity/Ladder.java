package com.midevilgame.entity;

import com.midevilgame.assets.Textures;
import com.midevilgame.map.Map;

import java.util.List;

public class Ladder extends MapFeature {
    private final Map map;

    public Ladder(float x, float y, int width, int height, Map map) {
        super(Textures.LADDER, x, y, width, height, false, true);
        this.map = map;
    }

    @Override
    public void onCollide(List<Collidable> collisions) {
        for (Collidable collider : collisions) {
            if (collider instanceof Player) {
                Player player = (Player) collider;

                player.getMap().stop();
                this.map.addThing(player);
                player.setMap(this.map);
                player.getMap().getGame().setMap(this.map);
                player.setPosition(16, 16);
                this.map.start();
            }
        }
    }

    @Override
    public boolean isPassable() {
        return true;
    }
}
