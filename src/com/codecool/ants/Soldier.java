package com.codecool.ants;

public class Soldier extends Ant {

    private static int numberOfSoldiers = 0;

    public Soldier(Colony colony) {
        super(colony);
    }

    @Override
    public void setFirstPosition() {
        int colonyBoundary = getColony().getColonyBoundary();
        setX(Util.getRandomInt(0, colonyBoundary - 1));
        setY(Util.getRandomInt(0, colonyBoundary - 1));
    }

    @Override
    public void setName() {
        setName("Soldier " + ++numberOfSoldiers);
    }

    @Override
    public void move() {
        int nextDirectionIndex = getColony().getTime() % 4;
        Direction direction = Direction.getDirectionByIndex(nextDirectionIndex);
        moveToDirection(direction);
    }
}
