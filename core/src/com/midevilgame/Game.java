package com.midevilgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.midevilgame.entity.*;
import com.midevilgame.graphics.Textures;
import com.midevilgame.map.Map;

public class Game implements ApplicationListener {
	private Map currentMap;
	private OrthographicCamera cam;
	private SpriteBatch batch;

	public OrthographicCamera getCam() {
		return cam;
	}

	@Override
	public void create() {
		currentMap = new Map(1000, 1000);

		currentMap.addThing(new StaticEntity(currentMap, Textures.STONE_BG, new Vector2(), 1000, 1000));
		currentMap.addThing(new Player(currentMap, Textures.CHARACTER_RIGHT, new Vector2(), 16, 16));

		Attachment attachment = new Attachment(currentMap.getPlayer(), new Text("abcdefg", 0, 0), -5, 24);
		currentMap.addThing(attachment);

		Gdx.input.setInputProcessor(new InputListener(this));

		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		// Constructs a new OrthographicCamera, using the given viewport width and height
		// Height is multiplied by aspect ratio.
		cam = new OrthographicCamera(100, 100 * (height / width));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		batch = new SpriteBatch();
	}

	@Override
	public void render() {
		currentMap.update();
		cam.position.set(currentMap.getPlayer().getCenter(), 0);
		cam.update();

		batch.setProjectionMatrix(cam.combined);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		currentMap.render(batch);

		batch.end();
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
		currentMap.dispose();
		batch.dispose();
	}

	@Override
	public void pause() {
	}
}
