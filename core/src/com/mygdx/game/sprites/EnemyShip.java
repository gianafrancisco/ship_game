package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by francisco on 10/10/16.
 */

public class EnemyShip extends Sprite {

    private Integer score;
    private float velocity = -1.0f;
    private TextureRegion[] textures = null;
    private Animation animation;
    private float stateTime = 0f;
    TextureRegion currentFrame;

    public EnemyShip(Texture texture) {
        super(texture, 0, 144, 48, 32);
        setPosition(100, 300);
        setRotation(180);
        textures = new TextureRegion[4];
        textures[0] = new TextureRegion(texture, 0, 144, 48, 32);
        textures[1] = new TextureRegion(texture, 48, 144, 48, 32);
        textures[2] = new TextureRegion(texture, 96, 144, 48, 32);
        textures[3] = new TextureRegion(texture, 144, 144, 48, 32);
        animation = new Animation(1/10f, textures);
        score = 10;
    }

    @Override
    public void draw(Batch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        setPosition(getX() + (float)Math.sin(stateTime), getY() + velocity);
        if(getY() < 0){
            setPosition(0, 600);
        }
        getVertices();
        currentFrame = animation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, getX(), getY());
    }

    public Integer getScore(){
        return score;
    }


}
