package com.codecool.ants;

public class Drone extends Ant {

    private int remainingMatingTime = 0;

    @Override
    public void setFirstPosition() {

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
                    flyAway();
                }
            }
        } else {
            if (remainingMatingTime == 1) {
                say("D'OH!");
                flyAway();
            }
            remainingMatingTime--;
        }
    }

    private void flyAway() {
        int x = Util.getRandomInt(0, getXBoundary());
        setX(x);
        setY(100 - x);
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
