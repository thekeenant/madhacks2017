package com.midevilgame.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Sounds {
    public static final Music MUSIC_1 = Gdx.audio.newMusic(Gdx.files.internal("audio/Music_1.mp3"));

    public static final Sound FIREBALL_LAUNCH = Gdx.audio.newSound(Gdx.files.internal("audio/Fireball_Launch.mp3"));
    public static final Sound OUCH = Gdx.audio.newSound(Gdx.files.internal("audio/Ouch.wav"));

    static {
        MUSIC_1.setLooping(true);
    }
}
