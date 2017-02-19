package com.midevilgame.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.midevilgame.assets.Textures;

public class HealthBar implements Something {
    private final LivingEntity entity;

    public HealthBar(LivingEntity entity) {
        this.entity = entity;
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean isRemoved() {
        return entity.isRemoved();
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Batch batch) {
        int hearts = entity.getHealth() / 2;
        boolean halfHeart = entity.getHealth() % 2 != 0;

        float offsetX = 0;
        float offsetY = entity.getBounds().getHeight();
        for (int i = 0; i < hearts; i++) {
            Sprite sprite = new Sprite(Textures.FULL_HEART);
            sprite.setSize(4, 4);
            sprite.setX(getX() + offsetX);
            sprite.setY(getY() + offsetY);
            sprite.draw(batch);

            offsetX += 5;
        }

        if (halfHeart) {
            Sprite sprite = new Sprite(Textures.HALF_HEART);
            sprite.setSize(4, 4);
            sprite.setX(getX() + offsetX);
            sprite.setY(getY() + offsetY);
            sprite.draw(batch);
        }
    }

    @Override
    public void dispose() {

    }

    @Override
    public void setX(float x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setY(float y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getX() {
        return entity.getX();
    }

    @Override
    public float getY() {
        return entity.getY();
    }
}
