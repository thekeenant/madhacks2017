package com.midevilgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.entity.*;
import com.midevilgame.graphics.Fonts;
import com.midevilgame.graphics.Textures;
import com.midevilgame.map.Map;

import java.util.Random;

public class Game implements ApplicationListener {
	private Map map;
	private OrthographicCamera cam;
    private SpriteBatch overlay;
    private SpriteBatch batch;

	public OrthographicCamera getCam() {
		return cam;
	}

	@Override
	public void create() {
		map = new Map(1000, 1000);

		map.addThing(new MapFeature(Textures.STONE_BG, 0, 0, 1000, 1000, false));
		map.addThing(new Player(map, Textures.CHARACTER_RIGHT, new Vector2(), 16, 16));
		Attachment attachment = new Attachment(map.getPlayer(), new Text("keenan", 0, 0, Fonts.DEF_32, Color.WHITE, 0.2f), -5, 24);
		map.addThing(new Ghost(map, new Vector2(750, 750), 16, 16));
		// top wall
        map.addThing(new MapFeature(Textures.WALL, 0, 1000, 1000, 16, true));
        // left wall
        map.addThing(new MapFeature(Textures.WALL, 0 - 16, 0, 16, 1016, true));
        // bottom wall
        map.addThing(new MapFeature(Textures.WALL, 0 - 16, 0 - 16, 1016, 16, true));
        // right wall
        map.addThing(new MapFeature(Textures.WALL, 1000, 0 - 16, 16, 1032, true));
		map.addThing(attachment);


        for (int x = 100; x < 1000; x += new Random().nextInt(100)) {
            for (int y = 100; y < 1000; y += new Random().nextInt(100)) {
                Ghost ghost = new Ghost(map, new Vector2(x, y), 16, 16);
                map.addThing(ghost);
            }
        }

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
        Text text = new Text("Health: 0/100", 100, 100, Fonts.DEF_32, Color.WHITE);
        text.render(overlay);
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
