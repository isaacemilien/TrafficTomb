package com.mygdx.game;

import java.util.Arrays;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class TrafficTomb extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	int[][] grid = new int[6][6];

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		int posCount = 1;
		for(int[] axis : grid){
			for(int i = 0; i < axis.length; i++){
				axis[i] = posCount;
				posCount++;
			}
			System.out.println(Arrays.toString(axis));
		}
	}

	@Override
	public void render () {
		// ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
