package com.midevilgame.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Fonts {
    private static final FileHandle DEF_32_FILE = Gdx.files.internal("fonts/2P-32.fnt");

    public static final BitmapFont DEF_32;

    static {
        DEF_32 = new BitmapFont(DEF_32_FILE);
    }
}
