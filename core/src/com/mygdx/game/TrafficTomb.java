package com.mygdx.game;

import java.util.Arrays;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class TrafficTomb extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int[] gridSize = {6, 6};
	
	int[][] grid = new int[gridSize[0]][gridSize[1]];
	Vehicle[] vehicles = new Vehicle[2];

	Vehicle truckVehicle = new Vehicle(3, Direction.RIGHT, new int[] {0, 0});
	Vehicle carVehicle = new Vehicle(2, Direction.RIGHT, new int[] {0, 1});

	int[][] restrictedPositions = new int[gridSize[0]][gridSize[1]];

	public void updateRestrictedPositions(Vehicle[] vehicles){
		int restrictedPositionCount = 0;
		for (Vehicle vehicle : vehicles) {
			for(int[] position : vehicle.vehicleSegmentPositions){
				restrictedPositions[restrictedPositionCount] = position;
				restrictedPositionCount++;
			}
		}
	}

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

		vehicles[0] = truckVehicle;
		vehicles[1] = carVehicle;
		
		System.out.println(Arrays.toString(restrictedPositions));

		updateRestrictedPositions(vehicles);		
		System.out.println(Arrays.toString(restrictedPositions[4]));

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
