package com.beta.Game.Contracts;

import com.beta.Game.GameObjects.GameObject;

public interface Collidable {
    public boolean isTouching(GameObject gameObject);
}
