package com.codecool.ants;

public class Soldier extends Ant {

    @Override
    public void setFirstPosition() {
        int colonyBoundary = getColony().getColonyBoundary();
        setX(Util.getRandomInt(2, colonyBoundary - 1));
        setY(Util.getRandomInt(2, colonyBoundary - 1));
    }

    @Override
    public void move() {
        int nextDirectionIndex = getColony().getTime() % 4;
        Direction direction = Direction.getDirectionByIndex(nextDirectionIndex);
        moveToDirection(direction);
    }
}
