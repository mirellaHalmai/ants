package com.codecool.ants;

public abstract class Ant {

    private int x;
    private int y;

    private Colony colony;

    public Ant() {
        colony = new Colony();
    }

    public Ant(Colony colony) {
        this.colony = colony;
        setFirstPosition();
    }


    public abstract void setFirstPosition();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXBoundary() {
        return colony.getColonyBoundary();
    }

    public int getYBoundary() {
        return getXBoundary();
    }

    public Colony getColony() {
        return colony;
    }

    public int distanceToQueen() {
        return x + y;
    }

    public abstract void move();

    public void moveToRandomDirection() {
        while (true) {
            Direction direction = Direction.randomDirection();
            if (canMoveToDirection(direction)) {
                moveToDirection(direction);
                break;
            }
        }
    }

    public void moveToDirection(Direction direction) {
        if (direction.getAxis() == 'y') {
            setY(getY() + direction.getStep());
        } else {
            setX(getX() + direction.getStep());
        }
    }

    public boolean canMoveToDirection(Direction direction) {
        int newCoordinate = direction.getStep();
        if (direction.getAxis() == 'x') {
            newCoordinate += x;
        } else {
            newCoordinate += y;
        }
        return newCoordinate >= 0 && newCoordinate <= colony.getColonyBoundary();

    }
}
