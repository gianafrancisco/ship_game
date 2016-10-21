package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

/**
 * Created by francisco on 10/10/16.
 */

public class Beam extends Sprite {

    private Vector2 velocity = new Vector2(0, 5);
    //private Rectangle rectangle;

    public Beam(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);

    }

    @Override
    public void draw(Batch batch) {
        float y = getY() + velocity.y;
        setPosition(getX(), y);
        //rectangle.setPosition(getX(), y);
        super.draw(batch);
    }

    public boolean collisione(Sprite enemyShip){
        return Intersector.overlaps(getBoundingRectangle(), enemyShip.getBoundingRectangle());
    }

}
