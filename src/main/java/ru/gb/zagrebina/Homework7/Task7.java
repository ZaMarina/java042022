package ru.gb.zagrebina.Homework7;

public class Task7 {
    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Борис", 15, false),
                new Cat("Юрик", 30, false),
                new Cat("Семен", 45, false),
                new Cat("Тася",5, false),
                new Cat("Полкан", 10, false)
                        };

        Plate plate = new Plate(100);
        plate.info();


        for (Cat cat : cats) {
            if (cat.getAppetite() < plate.getFood()) {
                cat.setSatiety(true);
            }
            cat.eat(plate);
            System.out.println(cat.toString());
            plate.info();
        }
        plate.inPutFood(60);
        plate.info();
    }
}
