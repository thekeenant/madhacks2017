package com.midevilgame;

import com.midevilgame.entity.Entity;

public interface ProjectileLauncher {
    void launch(Entity entity, float angle);

    int frequency();
}
