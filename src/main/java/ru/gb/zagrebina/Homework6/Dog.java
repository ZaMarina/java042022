package ru.gb.zagrebina.Homework6;

public class Dog extends Animal {
    private static final int canSwim = 10;
    private static final int canRun = 500;
    private static int count;

    public Dog(String name) {
        super(name, canSwim, canRun);
        count++;
    }
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Dog.count = count;
    }
    @Override
    public void run(int distanceRun) {
        if (distanceRun <= canRun) {
            System.out.println(" Собака " + getName() + " пробежал(а) " + distanceRun + "метров");
        } else {
            System.out.println(" Собака " + getName() + " пробежал(а) 500 метров");
        }
    }

    @Override
    public void swim(int distanceRun) {
        if (distanceRun <= canSwim) {
            System.out.println(" Собака " + getName() + " проплыл(а) " + distanceRun + "метров");
        } else {
            System.out.println(" Собака " + getName() + " проплыл(а) 10 метров");
        }
    }
}
