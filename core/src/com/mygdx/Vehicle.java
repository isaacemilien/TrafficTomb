package com.mygdx;

import java.util.Arrays;
import java.util.HashMap;

enum Direction{
    UP,
    DOWN,
    LEFT,
    RIGHT
}

public class Vehicle {
    HashMap<Direction, int[]> directionMatrix = new HashMap<Direction, int[]>();
    
    int[][] vehicleSegmentPositions;    
    Direction direction;
    int[] vehicleStartPosition;

    public Vehicle(int vehicleSegments, Direction direction, int[] vehicleStartPosition){
        this.vehicleSegmentPositions = new int[vehicleSegments][];
        this.direction = direction;
        this.vehicleStartPosition = vehicleStartPosition;

        vehicleSegmentPositions[0] = vehicleStartPosition;

        directionMatrix.put(Direction.UP, new int[]{0,1});
        directionMatrix.put(Direction.DOWN, new int[]{0,-1});
        directionMatrix.put(Direction.LEFT, new int[]{-1,0});
        directionMatrix.put(Direction.RIGHT, new int[]{1,0});

        fillVehicleSegments(direction);
    }
    
    public void fillVehicleSegments(Direction direction){
        for(int i = 0; i < vehicleSegmentPositions.length - 1; i++){
            vehicleSegmentPositions[i + 1] = new int[]{
                vehicleSegmentPositions[i][0] + directionMatrix.get(direction)[0], 
                vehicleSegmentPositions[i][1] + directionMatrix.get(direction)[1]
            };
        }
        // System.out.println(directionMatrix.get(direction)[0]);
        System.out.println(Arrays.toString(vehicleSegmentPositions[2]));
    }

    
    public void run(){
        // System.out.println(Arrays.toString(vehicleSegmentPositions));
        // System.out.println(vehicleSegmentPositions.length);
    }
    
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(3, Direction.RIGHT, new int[]{0,0});
        vehicle.run();
    }
}
