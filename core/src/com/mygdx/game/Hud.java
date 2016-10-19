package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by francisco on 10/18/16.
 */

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private Integer intScore;

    Label labelScore;
    Label labelScoreText;

    public Hud(SpriteBatch spriteBatch){
        intScore = 0;
        viewport = new FitViewport(ShipGame.WORLD_WIDTH, ShipGame.WORLD_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, spriteBatch);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        labelScore = new Label(String.format("%05d", intScore), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        labelScoreText = new Label("Score", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(labelScoreText).expandX().padTop(10);
        table.row();
        table.add(labelScore).expandX().padTop(5);

        stage.addActor(table);
    }

    public void increaseScore(int inc){
        intScore += inc;
        //labelScore = new Label(String.format("%03d", intScore), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        labelScore.setText(String.format("%05d", intScore));

    }

}
