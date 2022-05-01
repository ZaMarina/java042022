package ru.gb.zagrebina.Homework6;

public abstract class Animal {
    private String name;
    private int distanceRun;
    private int distanceSwim;

    public Animal(String name, int distanceRun, int distanceSwim) {
        this.name = name;
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;

    }
    public abstract void run(int distanceRun);

    public abstract void swim(int distanceRun);

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getDistanceRun() {
        return distanceRun;
    }

    public void setDistanceRun() {
               this.distanceRun = distanceRun;
            }


    public int getDistanceSwim() {
            return distanceSwim;
    }

    public void setDistanceSwim() {
        this.distanceSwim = distanceSwim;
    }
}

