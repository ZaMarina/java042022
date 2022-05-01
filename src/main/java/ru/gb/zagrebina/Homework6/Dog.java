package ru.gb.zagrebina.Homework6;

public class Dog extends Animal {
    public static int canRun = 500;
    public static int canSwim = 10;
    public Dog(String name, int distanceRun, int distanceSwim) {
        super(name, distanceRun, distanceSwim);
          }


    @Override
    public void run(int distanceRun) {
        if (getDistanceRun()<=500) {
            System.out.println("Собака " + getName() + " пробежал(а) " + super.getDistanceRun() + "метров");
        }else {
            System.out.println("Собака не пробежала");
        }
    }

    @Override
    public void swim(int distanceRun) {
        if (getDistanceSwim()<=10) {
            System.out.println("Собака " + getName() + " проплыла(а) " + super.getDistanceSwim() + "метров");
        }
    }
}
