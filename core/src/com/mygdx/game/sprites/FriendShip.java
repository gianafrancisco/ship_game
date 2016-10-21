package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;


/**
 * Created by francisco on 10/10/16.
 */

public class FriendShip extends Sprite {
    TextureRegion textureRegion;

    public FriendShip(Texture texture) {
        super(texture, 0, 144, 32, 42);
        textureRegion = new TextureRegion(new Texture("android/assets/ships_human.png"), 0, 144, 32, 42);
        setPosition(10, 10);
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        batch.draw(textureRegion, getX(), getY(), getWidth(), getHeight());
    }
}
