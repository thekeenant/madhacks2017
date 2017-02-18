package com.midevilgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.midevilgame.ControlsListener;

public class Game implements ApplicationListener {

	static final int WORLD_WIDTH = 1000;
	static final int WORLD_HEIGHT = 1000;

	private OrthographicCamera cam;
	private SpriteBatch batch;

	private Sprite mapSprite;
	private Sprite characterSprite;

	public OrthographicCamera getCam() {
		return cam;
	}

	@Override
	public void create() {
		Gdx.input.setInputProcessor(new ControlsListener(this));

		Texture texture = new Texture("stone-bg.png");
		mapSprite = new Sprite(texture);
		mapSprite.setSize(WORLD_WIDTH, WORLD_HEIGHT);
		mapSprite.setPosition(0, 0);

		Texture charTexture = new Texture("character.png");
		characterSprite = new Sprite(charTexture);
		characterSprite.setPosition(50, 50);
		characterSprite.setSize(32, 32);

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		// Constructs a new OrthographicCamera, using the given viewport width and height
		// Height is multiplied by aspect ratio.
		cam = new OrthographicCamera(30, 30 * (h / w));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		batch = new SpriteBatch();
	}

	@Override
	public void render() {
		handleInput();
		cam.update();
		batch.setProjectionMatrix(cam.combined);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		mapSprite.draw(batch);
		characterSprite.draw(batch);
		batch.end();
	}

	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			characterSprite.setX(characterSprite.getX() - 3.0f);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			characterSprite.setX(characterSprite.getX() + 3.0f);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			characterSprite.setY(characterSprite.getY() - 3.0f);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			characterSprite.setY(characterSprite.getY() + 3.0f);
		}
		cam.position.set(characterSprite.getX() + characterSprite.getWidth() / 2, characterSprite.getY() + characterSprite.getHeight() / 2, 0);
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
		mapSprite.getTexture().dispose();
		batch.dispose();
	}

	@Override
	public void pause() {
	}
}