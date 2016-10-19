package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Hud;
import com.mygdx.game.sprites.Beam;
import com.mygdx.game.sprites.EnemyShip;
import com.mygdx.game.sprites.FriendShip;
import com.mygdx.game.ShipGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francisco on 10/18/16.
 */

public class PlayScreen implements Screen {

    private Texture human;
    private Texture enemy;
    private Texture tbeam;
    private FriendShip humanShip = null;
    private EnemyShip enemyShip = null;
    private Beam beam = null;
    private List<Sprite> spriteList;
    private List<Sprite> beamList;

    private ShipGame game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Hud hud;
    private TmxMapLoader tmxMapLoader;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;



    public PlayScreen(ShipGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(ShipGame.WORLD_WIDTH, ShipGame.WORLD_HEIGHT, camera);
        camera.position.set(ShipGame.WORLD_WIDTH / 2, ShipGame.WORLD_HEIGHT / 2, 0);
        camera.update();

        tmxMapLoader = new TmxMapLoader();
        tiledMap = tmxMapLoader.load("android/assets/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);

		human = new Texture("android/assets/ships_human.png");
		enemy = new Texture("android/assets/ships_biomech.png");
		tbeam = new Texture("android/assets/beams.png");

		enemyShip = new EnemyShip(enemy);
		humanShip = new FriendShip(human);
		spriteList = new ArrayList<Sprite>();
		beamList = new ArrayList<Sprite>();
		spriteList.add(humanShip);
		spriteList.add(enemyShip);

        hud = new Hud(game.batch);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        renderer.setView(camera);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

        renderer.render();
        hud.stage.draw();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
		for(Sprite s: spriteList){
			s.draw(game.batch);
		}
		for(Sprite b: beamList){
			b.draw(game.batch);
		}
        game.batch.end();

		float x = humanShip.getX(), y = humanShip.getY();
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			if(x > 0){
				x -= 200* delta;
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if(x < ShipGame.WORLD_WIDTH - humanShip.getWidth()){
				x += 200 * delta;
			}
		}/*
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            camera.position.y += 100 * delta;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            camera.position.y -= 100 * delta;
        }*/
        y += 50 * delta;
        camera.position.y += 50 * delta;
        humanShip.setPosition(x, y);
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			beam = new Beam(tbeam, 0, 0, 30, 94);
			beam.setPosition(humanShip.getX(), humanShip.getY() + humanShip.getHeight() / 2);
			beamList.add(beam);
            hud.increaseScore(10);
		}
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
