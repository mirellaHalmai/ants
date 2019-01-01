package com.codecool.ants;

public class Worker extends Ant {

    @Override
    public void setFirstPosition() {
        int colonyBoundary = getColony().getColonyBoundary();
        setX(Util.getRandomInt(1, colonyBoundary));
        setY(Util.getRandomInt(1, colonyBoundary));
    }


    @Override
    public void move() {
        moveToRandomDirection();
    }
}
