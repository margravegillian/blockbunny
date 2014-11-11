package com.arne5.blockbunny.states;

import com.arne5.blockbunny.Game;
import com.arne5.blockbunny.handlers.GameStateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import static com.arne5.blockbunny.handlers.Box2DVars.PPM;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by darneson on 9/22/2014.
 */
public class Play extends GameState
	{

		private World world;
		private Box2DDebugRenderer b2dr;
		private OrthographicCamera b2dCam;

		public Play(GameStateManager gsm)
			{
				super(gsm);
				//using box2d
				world = new World(new Vector2(0,-9.81f),true);
				b2dr = new Box2DDebugRenderer();

				//create platform
				BodyDef bdef = new BodyDef();
				bdef.position.set(160 /PPM,120/PPM);
				bdef.type = BodyDef.BodyType.StaticBody;
				Body body = world.createBody(bdef);
				//static body - dont' move, unaffected by forces = ground

				// kinematic body = dont' get affected by world forces but can change their velocities = platform

				//dynamic body alwasy get affecdted by forces= player
				PolygonShape shape = new PolygonShape();
				shape.setAsBox(50 /PPM,5/PPM);
				FixtureDef fdef = new FixtureDef();
				fdef.shape = shape;
				body.createFixture(fdef);

				// create falling box
				bdef.position.set(160/PPM,200/PPM);
				bdef.type = BodyDef.BodyType.DynamicBody;
				body = world.createBody(bdef);
				shape.setAsBox(5/PPM, 5/PPM);
				fdef.shape = shape;
				//make box bouncy if want
				//fdef.restitution= 1f;
				body.createFixture(fdef);

				//create box2d cam
				b2dCam = new OrthographicCamera();
				b2dCam.setToOrtho(false, Game.V_WIDTH / PPM,Game.V_HEIGHT /PPM);

			}
		public void handleInput()
			{

			}
		public void update(float dt)
			{
				//for box 2d
				world.step(dt,6,2);


			}
		public void render()
			{

				//clear screen
				Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
				//draw box2dworld
				b2dr.render(world,b2dCam.combined);

			}
		public void dispose()
			{

			}

	}
