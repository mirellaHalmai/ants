package com.codecool.ants;

public class Worker extends Ant {

    private static int numberOfWorkers = 0;

    public Worker(Colony colony) {
        super(colony);
    }

    @Override
    public void setFirstPosition() {
        int colonyBoundary = getColony().getColonyBoundary();
        setX(Util.getRandomInt(0, colonyBoundary));
        setY(Util.getRandomInt(0, colonyBoundary));
    }


    @Override
    public void setName() {
        setName("Worker " + ++numberOfWorkers);
    }

    @Override
    public void move() {
        moveToRandomDirection();
    }
}
