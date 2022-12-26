package com.mygdx.game;

import java.util.Arrays;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class TrafficTomb extends ApplicationAdapter {
	// Fields
	SpriteBatch batch;
	Texture img;
	int[] gridSize = {6, 6};
	
	int[][] grid = new int[gridSize[0]][gridSize[1]];
	Vehicle[] vehicles = new Vehicle[1];

	Vehicle carVehicle = new Vehicle(2, Direction.RIGHT, new int[] {0, 0}, MovementAxis.X);

	int[][] restrictedPositions = new int[gridSize[0]][gridSize[1]];

	// Methods
	public boolean isPositionOffGrid(int[] gridSize, int[] position){
		for(int axis : position){
			if(axis < 0 || axis > gridSize[0] * gridSize[1]){
				return true;
			}
		}

		return false;
	}

	public boolean isPositionOccupied(Vehicle[] vehicles, int[] position, Vehicle currentVehicle){
		for(Vehicle vehicle : vehicles){
			if(vehicle == currentVehicle){
				continue;
			}

			for(int[] vehiclePosition : vehicle.getSegmentPositions()){
				if(Arrays.equals(vehiclePosition, position)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean isPositionOutOfVehicleLane(Vehicle vehicle, int[] position){
		int invertedVehicleAxis = 1 - vehicle.getMovementAxis().getValue();

		if(position[invertedVehicleAxis] != vehicle.getSegmentPositions()[0][invertedVehicleAxis]){
			return true;
		}

		return false;
	}


	public boolean isRestrictedPosition(int[] position, int[][] restrictedPositions){
		for(int[] restrictedPosition : restrictedPositions){
			if(Arrays.equals(restrictedPosition, position)){
				return true;
			}
			for(int axis : position){
				if(axis < 0 || axis > gridSize[0] * gridSize[1]){
					return true;
				}
			}
		}
		return false;
	}

	public void updateRestrictedPositions(Vehicle[] vehicles){
		int restrictedPositionCount = 0;
		for (Vehicle vehicle : vehicles) {
			for(int[] position : vehicle.getSegmentPositions()){
				restrictedPositions[restrictedPositionCount] = position;
				restrictedPositionCount++;
			}
		}
	}

	// Move vehcicle
	public void moveVehicle(){

	}
	// Get move position
	// Is valid move
	// Move vehicle to position 

	// GDX Methods
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

		vehicles[0] = carVehicle;

		updateRestrictedPositions(vehicles);		

		System.out.println(isPositionOutOfVehicleLane(carVehicle, new int[]{8,1}));
		// System.out.println(carVehicle.getMovementAxis().getValue());4
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
