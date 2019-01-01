package com.codecool.ants;

public class lifeOfAnts {
    public static void main(String[] args) {
        Colony colony = new Colony(3, 2, 2, 10);
        for (int i = 0; i < 50; i++) {
            colony.increaseTime();
        }
    }
}
