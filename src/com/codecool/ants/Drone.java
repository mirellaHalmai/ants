package com.codecool.ants;

public class Drone extends Ant {

    private int remainingMatingTime = 0;
    private static int numberOfDrones = 0;

    public Drone(Colony colony) {
        super(colony);
    }

    @Override
    public void setFirstPosition() {
        int colonyBoundary = getColony().getColonyBoundary();
        int x = Util.getRandomInt(0, colonyBoundary);
        int y = Util.getRandomInt(0, colonyBoundary);
        setX(x);
        setY(Math.max(y, 4 - x));
    }

    @Override
    public void setName() {
        setName("Drone " + ++numberOfDrones);
    }

    @Override
    public void move() {
        if (remainingMatingTime == 0) {
            moveTowardsQueen();
            if (distanceToQueen() == 3) {
                Queen queen = getColony().getQueen();
                if (queen.inMatingMood()) {
                    mate();
                    queen.mate();
                } else {
                    say("D'OH!");
                    flyAway();
                }
            }
        } else {
            say("drone mating time: " + remainingMatingTime);
            if (remainingMatingTime == 1) {
                flyAway();
            }
            remainingMatingTime--;
        }
    }

    private void flyAway() {
        int x = Util.getRandomInt(0, getXBoundary());
        setX(x);
        setY(Math.min(100, getXBoundary()) - x);
    }

    private void moveTowardsQueen() {
        if (canMoveToDirection(Direction.SOUTH)) {
            moveToDirection(Direction.SOUTH);
        } else if (canMoveToDirection(Direction.WEST)) {
            moveToDirection(Direction.WEST);
        }
    }

    private void mate() {
        say("HALLELUJAH!");
        remainingMatingTime = 10;
    }

    private void say(String toSay) {
        System.out.println(toSay);
    }
}
