package com.midevilgame;

public class Magic {
    public static float BASE_SPEED = 0.5f;

    public static float PLAYER_SPEED = BASE_SPEED * 1.3f;
    public static float FIREBALL_SPEED = BASE_SPEED * 4.0f;
    public static float GHOST_SPEED = BASE_SPEED * 0.8f;


    static {
        // Dev Mode
//        PLAYER_SPEED *= 5;
    }
}
