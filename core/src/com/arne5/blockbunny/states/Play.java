package com.arne5.blockbunny.states;

import com.arne5.blockbunny.handlers.GameStateManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by darneson on 9/22/2014.
 */
public class Play extends GameState
	{

		private World world;
		public Play(GameStateManager gsm)
			{
				super(gsm);
				//using box2d
				world = new World(new Vector2(0,-9.81f),true);

			}
		public void handleInput()
			{

			}
		public void update(float dt)
			{

			}
		public void render()
			{


			}
		public void dispose()
			{

			}

	}
