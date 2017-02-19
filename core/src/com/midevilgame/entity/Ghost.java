package com.midevilgame.entity;

import com.badlogic.gdx.math.Vector2;
import com.midevilgame.Magic;
import com.midevilgame.graphics.Textures;
import com.midevilgame.map.Map;

/**
 * Created by jon on 18/02/17.
 */
public class Ghost extends Enemy {
    public Ghost(Map map, Vector2 position, float width, float height) {
        super(map, Textures.GHOST, position, width, height);
    }

    @Override
    public void update() {
        Vector2 playerVector = getMap().getPlayer().getPosition();

        Vector2 movement = new Vector2();

        // +2 so it doesn't jitter when directly in line with player (constantly switching between pos and neg)
        if (this.getPosition().x > playerVector.x + 2) {
            movement.x = -1;
        } else if (this.getX() < playerVector.x){
            movement.x = 1;
        }

        if (this.getY() > playerVector.y + 2) {
            movement.y = -1;
        } else if (this.getY() < playerVector.y){
            movement.y = 1;
        }

        movement.scl(Magic.GHOST_SPEED);

        add(movement);
    }
}
