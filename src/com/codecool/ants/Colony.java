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
    private int colonyBoundary;

    public Colony() {
        this(20, 10, 5, 100);
    }


    public Colony(int colonyBoundary) {
        this(20, 10, 5, colonyBoundary);

    }

    public Colony(int numberOfWorkers, int numberOfSoldiers, int numberOfDrones) {
        this(numberOfWorkers, numberOfSoldiers, numberOfDrones, 100);

    }

    public Colony(int numberOfWorkers, int numberOfSoldiers, int numberOfDrones, int colonyBoundary) {
        this.colonyBoundary = Math.max(colonyBoundary, 4);
        queen = new Queen(this);
        int maxNumber = Math.max(Math.max(numberOfWorkers, numberOfSoldiers), numberOfDrones);
        for (int i = 0; i < maxNumber; i++) {
            if (i < numberOfWorkers) {
                Worker worker = new Worker(this);
                workers.add(worker);
                System.out.println(worker.getName() + " " + worker.getX() + " " + worker.getY());
            }
            if (i < numberOfSoldiers) {
                Soldier soldier = new Soldier(this);
                soldiers.add(soldier);
                System.out.println(soldier.getName() + " " + soldier.getX() + " " + soldier.getY());
            }
            if (i < numberOfDrones) {
                Drone drone = new Drone(this);
                drones.add(drone);
                System.out.println(drone.getName() + " " + drone.getX() + " " + drone.getY());
            }
        }
        allAnts.add(queen);
        allAnts.addAll(workers);
        allAnts.addAll(soldiers);
        allAnts.addAll(drones);
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
            System.out.println(ant.getName() + " " + ant.getX() + " " + ant.getY());
        }
        time++;
    }
}
