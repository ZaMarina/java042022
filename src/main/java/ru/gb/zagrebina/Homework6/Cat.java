package ru.gb.zagrebina.Homework6;

public class Cat extends Animal {
    private static final int canSwim = 0;
    private static final int canRun = 200;
    private static int count;

    public Cat(String name) {
        super(name, canRun, canSwim);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Cat.count = count;
    }

    @Override
    public void run(int distanceRun) {
        if (distanceRun <= canRun) {
            System.out.println(" Кот " + getName() + " пробежал(а) " + distanceRun + "метров");
        } else {
            System.out.println(" Кот " + getName() + " пробежал(а) 200 метров");
        }

    }

    @Override
    public void swim(int distanceRun) {
        System.out.println(" Кот не умеет плавать!");
    }
}
