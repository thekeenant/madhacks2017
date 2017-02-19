package com.midevilgame.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class Textures {
    // World
    public static final Texture STONE_BG;
    public static final Texture STONE_FLOOR;

    // Misc.
    public static final Texture FIREBALL;
    public static final Texture CHARACTER_RIGHT;
    public static final Texture GHOST;

    static {
        STONE_BG = new Texture("map/Stone_Bg.png");
        STONE_FLOOR = new Texture("map/Stone_Floor.png");

        FIREBALL = new Texture("Fireball.png");
        CHARACTER_RIGHT = new Texture("Character_Right.png");
        GHOST = new Texture("Ghost.png");
    }
}
