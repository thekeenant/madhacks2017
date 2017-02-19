package com.midevilgame.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class Textures {
    // World
    public static final Texture STONE_BG;
    public static final Texture STONE_FLOOR;

    // Misc.
    public static final Texture CHARACTER;

    static {
        STONE_BG = new Texture("map/stone-bg.png");
        STONE_FLOOR = new Texture("map/stone-floor.png");

        CHARACTER = new Texture("character.png");
    }
}
