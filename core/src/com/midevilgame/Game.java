package com.midevilgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture playerTexture, enemyTexture;
	Sprite player;
	ArrayList<Projectile> projectiles;
	ArrayList<Enemy> enemies;
    int playerX, playerY;
    private int scale = 5;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		projectiles = new ArrayList<Projectile>();
        playerTexture = new Texture("Character_Right.png");
        enemyTexture = new Texture("Ghost.png");
        player = new Sprite(playerTexture, 0 , 0, playerTexture.getWidth(), playerTexture.getHeight());
        player.setScale(scale);
        enemies = new ArrayList<Enemy>();
        enemies.add(new Enemy(enemyTexture));
    }

	@Override
	public void render() {
	    update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//		batch.draw(playerTexture, playerX, playerY, playerTexture.getWidth() * scale, playerTexture.getHeight() * scale);
        player.draw(batch);
        enemies.get(0).draw(batch);
		for (Projectile p : projectiles) {
		    p.draw(batch);
        }
		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		playerTexture.dispose();
	}

	void handleInput() {
	    if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
	        player.setX(player.getX() - 2);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.setX(player.getX() + 2);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.setY(player.getY() - 2);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.setY(player.getY() + 2);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
	        // Shoot a fireball here
            Texture texture = new Texture("Fireball.png");
            Projectile fireball = new Projectile(texture, player.getX(), player.getY());
            fireball.setScale(scale);

            projectiles.add(fireball);

        }

    }
    void update() {
	    handleInput();
	    for (Projectile p : projectiles) {
	        p.setX(p.getX() + 5);
        }
    }
}
