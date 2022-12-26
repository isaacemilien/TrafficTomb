package com.mygdx.game;

import java.util.HashMap;

public enum MovementAxis{
    X(0),
    Y(1);

    private int value;
    private static HashMap map = new HashMap<>();

    private MovementAxis(int value) {
        this.value = value;
    }

    static {
        for (MovementAxis MovementAxis : MovementAxis.values()) {
            map.put(MovementAxis.value, MovementAxis);
        }
    }

    public static MovementAxis valueOf(int MovementAxis) {
        return (MovementAxis) map.get(MovementAxis);
    }

    public int getValue() {
        return value;
    }
}
