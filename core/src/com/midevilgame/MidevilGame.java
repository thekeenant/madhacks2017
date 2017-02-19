package com.midevilgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.assets.Sounds;
import com.midevilgame.entity.*;
import com.midevilgame.assets.Fonts;
import com.midevilgame.assets.Textures;
import com.midevilgame.map.Map;

import java.util.Random;

public class MidevilGame implements ApplicationListener {
	private Map map;
	private OrthographicCamera cam;
    private SpriteBatch overlay;
    private SpriteBatch batch;

	public OrthographicCamera getCam() {
		return cam;
	}

	@Override
	public void create() {
		map = new Map(this, 1000, 1000, Sounds.MUSIC_1);



        {
            // background
            map.addThing(new MapFeature(Textures.STONE_BG, 0, 0, 500, 500, false, true));

            // top wall
            map.addThing(new MapFeature(Textures.WALL, 0, 1000, 1000, 16, true, false));
            // left wall
            map.addThing(new MapFeature(Textures.WALL, 0 - 16, 0, 16, 1016, true, false));
            // bottom wall
            map.addThing(new MapFeature(Textures.WALL, 0 - 16, 0 - 16, 1016, 16, true, false));
            // right wall
            map.addThing(new MapFeature(Textures.WALL, 1000, 0 - 16, 16, 1032, true, false));

            // right wall
            map.addThing(new MapFeature(Textures.WALL, 50, 0 - 16, 16, 200, true, false));
        }

        map.addThing(new Ghost(map, new Vector2(100, 20), 16, 16));

        map.addThing(new Ghost(map, new Vector2(20, 100), 16, 16));
        map.addThing(new Ghost(map, new Vector2(500, 500), 16, 16));

        map.addThing(new Player(map, new Vector2(1, 1), 16, 16));

		Gdx.input.setInputProcessor(new InputListener(this));

		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		// Constructs a new OrthographicCamera, using the given viewport width and height
		// Height is multiplied by aspect ratio.
		cam = new OrthographicCamera(100, 100 * (height / width));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

        overlay = new SpriteBatch();
		batch = new SpriteBatch();

		map.start();
	}

	@Override
	public void render() {
        // Update game
		map.update();

        // Update camera
		cam.position.set(map.getPlayer().getCenter(), 0);
		cam.update();

        // Clear screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render map
        batch.setProjectionMatrix(cam.combined);
		batch.begin();
		map.render(batch);
		batch.end();

        // Render overlay
        overlay.begin();
        overlay.end();
    }

	private void handleInput() {
	}

	@Override
	public void resize(int width, int height) {
		cam.viewportWidth = 100f;
		cam.viewportHeight = 100f * height/width;
		cam.update();
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		map.dispose();
		batch.dispose();
	}

	@Override
	public void pause() {
	}
}
