package com.codecool.ants;

import java.util.Random;

public enum Direction {
    NORTH (1, 'y'),
    EAST (1, 'x'),
    SOUTH (-1, 'y'),
    WEST (-1, 'x');

    private final int step;
    private final char axis;
    private static final Direction[] VALUES = values();
    private static final Random RANDOM = new Random();

    Direction(int step, char axis) {
        this.step = step;
        this.axis = axis;
    }

    public static Direction randomDirection() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }

    public int getStep() {
        return step;
    }

    public char getAxis() {
        return axis;
    }

    public static Direction getDirectionByIndex(int index) {
        return VALUES[index];
    }
}
