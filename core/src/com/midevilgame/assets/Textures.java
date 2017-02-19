package com.midevilgame.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class Textures {
    // World
    public static final Texture STONE_BG;
    public static final Texture STONE_FLOOR;
    public static final Texture WALL;
    public static final Texture LADDER;

    // Misc.
    public static final Texture FIREBALL;
    public static final Texture PLAYER_RIGHT;
    public static final Texture PLAYER_LEFT;
    public static final Texture GHOST;
    public static final Texture RED_DRAGON;

    public static final Texture HALF_HEART;
    public static final Texture FULL_HEART;

    static {
        STONE_BG = new Texture("map/Stone_Bg.png");
        STONE_FLOOR = new Texture("map/Stone_Floor.png");
        WALL = new Texture("Brick.png");
        WALL.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
        LADDER = new Texture("map/Ladder.png");

        FIREBALL = new Texture("Fireball.png");
        PLAYER_LEFT = new Texture("Player_Left.png");
        PLAYER_RIGHT = new Texture("Player_Right.png");
        GHOST = new Texture("Ghost.png");
        RED_DRAGON = new Texture("Red_Dragon.png");

        HALF_HEART = new Texture("Half_Heart.png");
        FULL_HEART = new Texture("Full_Heart.png");
    }
}
