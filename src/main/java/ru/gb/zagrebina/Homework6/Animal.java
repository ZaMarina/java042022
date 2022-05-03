package ru.gb.zagrebina.Homework6;

public abstract class Animal {
    private String name;

    private static int count = 0;//для метода подсчета...

    public Animal(String name, int canRun, int canSwim) {
        this.name = name;
//        this.canSwim = canSwim;
//        this.canRun = canRun;
        count++;

    }
    public abstract void run(int distanceRun);

    public abstract void swim(int distanceRun);

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Animal.count = count;
    }
}

