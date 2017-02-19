package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
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
        if (this.getPosition().x > playerVector.x + 2) {
            this.addX(-2);
        } else if (this.getX() < playerVector.x){
            this.addX(2);
        }

        if (this.getY() > playerVector.y + 2) {
            this.addY(-2);
        } else if (this.getY() < playerVector.y){
            this.addY( 2);
        }

    }
}
