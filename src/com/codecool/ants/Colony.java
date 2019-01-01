package com.codecool.ants;

import java.util.ArrayList;
import java.util.List;

public class Colony {

    private Queen queen;
    private List<Worker> workers = new ArrayList<>();
    private List<Soldier> soldiers = new ArrayList<>();
    private List<Drone> drones = new ArrayList<>();
    private List<Ant> allAnts = new ArrayList<>();

    private int time = 0;
    private int colonyBoundary = 100;

    public Colony() {
        queen = new Queen();
        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            if (i < 5) {
                Soldier soldier = new Soldier();
                soldiers.add(soldier);
                if (i < 4) {
                    Drone drone = new Drone();
                    drones.add(drone);
                }
            }
        }
        allAnts.add(queen);
        allAnts.addAll(workers);
        allAnts.addAll(soldiers);
        allAnts.addAll(drones);
    }

    public Colony(int colonyBoundary) {
        this.colonyBoundary = colonyBoundary;
    }

    public int getTime() {
        return time;
    }

    public int getColonyBoundary() {
        return colonyBoundary;
    }

    public Queen getQueen() {
        return queen;
    }

    public void increaseTime() {
        for (Ant ant : allAnts
             ) {
            ant.move();
        }
        time++;
    }
}
