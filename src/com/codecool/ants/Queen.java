package com.codecool.ants;

public class Queen extends Ant {

    private int timeTillMating = 0;

    public Queen(Colony colony) {
        super(colony);
    }

    @Override
    public void setFirstPosition() {
        super.setX(0);
        super.setY(0);
    }

    @Override
    public void setName() {
        setName("Queen");
    }

    @Override
    public void move() {
        if (timeTillMating > 0) {
            System.out.println("queen time till mating: " + timeTillMating);
            timeTillMating--;
        }
    }

    public boolean inMatingMood() {
        return timeTillMating == 0;
    }

    public void mate() {
        timeTillMating = Util.getRandomInt(100, 200);
    }
}
