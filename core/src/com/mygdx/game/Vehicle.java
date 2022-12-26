package com.mygdx.game;

import java.util.Arrays;
import java.util.HashMap;

public class Vehicle {
    // Fields
    static final HashMap<Direction, int[]> directionMatrix = new HashMap<Direction, int[]>();
    private MovementAxis movementAxis;
    private int[][] vehicleSegmentPositions;    

    // Constructors
    static{
        directionMatrix.put(Direction.UP, new int[]{0,1});
        directionMatrix.put(Direction.DOWN, new int[]{0,-1});
        directionMatrix.put(Direction.LEFT, new int[]{-1,0});
        directionMatrix.put(Direction.RIGHT, new int[]{1,0});
    }

    public Vehicle(int vehicleSegments, Direction direction, int[] vehicleStartPosition, MovementAxis movementAxis){
        this.vehicleSegmentPositions = new int[vehicleSegments][];
        this.vehicleSegmentPositions[0] = vehicleStartPosition;
        this.movementAxis = movementAxis;
        fillVehicleSegments(direction);
    }
    
    // Methods
    public void fillVehicleSegments(Direction direction){
        for(int i = 0; i < vehicleSegmentPositions.length - 1; i++){
            vehicleSegmentPositions[i + 1] = new int[]{
                vehicleSegmentPositions[i][0] + directionMatrix.get(direction)[0], 
                vehicleSegmentPositions[i][1] + directionMatrix.get(direction)[1]
            };
        }
    }
    
    public int[] getTranslatedPosition(Direction direction, int[] startPosition){
        return new int[] {startPosition[0] + directionMatrix.get(direction)[0], startPosition[1] + directionMatrix.get(direction)[1]};
    }

    public int[][] getSegmentPositions(){
        return vehicleSegmentPositions;
    }

    public void setSegmentPositions(int[][] positions){
        vehicleSegmentPositions = positions;
    }

    public MovementAxis getMovementAxis(){
        return movementAxis;
    }
}
