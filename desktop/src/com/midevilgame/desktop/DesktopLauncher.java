package com.midevilgame.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.midevilgame.MidevilGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.width = 1280;
		config.height = 720;
		config.vSyncEnabled = true;
        config.addIcon("Character_Right.png", FileType.Internal);
        config.title = "Midevil";
        config.foregroundFPS = 60;
        config.resizable = true;
	 	new LwjglApplication(new MidevilGame(), config);
	}
}
