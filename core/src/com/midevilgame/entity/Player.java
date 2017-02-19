package com.midevilgame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.map.Map;

public class Player extends Entity {
    public Player(Map map, Texture texture, Vector2 position, float width, float height) {
        super(map, texture, position, width, height);
    }
}
