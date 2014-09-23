package com.arne5.blockbunny;

import com.arne5.blockbunny.handlers.GameStateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

	public static final String TITLE = "Block Bunny";
	public static final int V_WIDTH = 320;
	public static final int V_HEIGHT = 240;
	public static final int SCALE =2;

	public static final float STEP = 1 /60f;
	private float accum;

	private SpriteBatch sb;
	private OrthographicCamera cam;
	private OrthographicCamera hudCam;



	private GameStateManager gsm;

	@Override
	public void create () {
		sb= new SpriteBatch();
		cam = new OrthographicCamera();
		cam.setToOrtho(false,V_WIDTH,V_HEIGHT);
		hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false,V_WIDTH,V_HEIGHT);
		gsm = new GameStateManager(this);



	}

	@Override
	public void render () {
		accum += Gdx.graphics.getDeltaTime();
		while(accum >= STEP)
			{
				accum -= STEP;
				gsm.update(STEP);
				gsm.render();
			}

	}

	public void dispose(){

	}

	public SpriteBatch getSpriteBatch(){return sb;}
	public OrthographicCamera getCamera(){return cam;}
	public OrthographicCamera getHUDCamera(){return hudCam;}
	public void resize(int w, int h){

	}
	public void pause(){

	}
	public void resume(){

	}
}

