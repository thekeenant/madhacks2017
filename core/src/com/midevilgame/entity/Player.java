package com.midevilgame.entity;

import com.badlogic.gdx.math.Vector2;

public class Player extends SentientEntity {
    private final String name;

    public Player(String name, Vector2 position) {
        super(position);
        this.name = name;
    }
}
