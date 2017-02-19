package com.midevilgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by jon on 18/02/17.
 */
public class Projectile extends Sprite {

    private float x, y;
    public Projectile(Texture texture, float x, float y) {
        super(texture);
        this.setX(x);
        this.setY(y);
        this.rotate90(true);
    }
}
