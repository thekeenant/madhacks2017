package com.midevilgame.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.midevilgame.entity.Text;

public class Textures {
    // World
    public static final Texture STONE_BG;
    public static final Texture STONE_FLOOR;
    public static final Texture WALL;

    // Misc.
    public static final Texture FIREBALL;
    public static final Texture CHARACTER_RIGHT;
    public static final Texture GHOST;

    public static final Texture HALF_HEART;
    public static final Texture FULL_HEART;

    static {
        STONE_BG = new Texture("map/Stone_Bg.png");
        STONE_FLOOR = new Texture("map/Stone_Floor.png");
        WALL = new Texture("Brick.png");
        WALL.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);

        FIREBALL = new Texture("Fireball.png");
        CHARACTER_RIGHT = new Texture("Character_Right.png");
        GHOST = new Texture("Ghost.png");

        HALF_HEART = new Texture("Half_Heart.png");
        FULL_HEART = new Texture("Full_Heart.png");
    }
}
