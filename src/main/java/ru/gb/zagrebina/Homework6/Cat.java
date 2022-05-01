package ru.gb.zagrebina.Homework6;

public class Cat extends Animal {

    private static String canNotSwim = "Кот не умеет плавать!";
    public Cat(String name, int distanceRun, int distanceSwim) {
        super(name, distanceRun, distanceSwim);
      }


    @Override
    public void run(int distanceRun) {
        if (distanceRun <= 200) {
            System.out.println("Кот " + getName() + " пробежал(а) " + super.getDistanceRun() + "метров");
        }else {
            System.out.println("Кот " + getName() + " пробежал(а) 200 метров");
        }
    }

    @Override
    public void swim(int distanceSwim) {
        System.out.println(canNotSwim);
    }

}
