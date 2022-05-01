package ru.gb.zagrebina.Homework6;

public class Task6 {
    public static void main(String[] args) {
        Cat[] cat = new Cat[]{
                new Cat("Борис", 100, 5),
                new Cat("Полкан", 400, 5),
                new Cat("Юрик", 150, 5)
        };
        for (Cat cat1 : cat) {
cat1.run(400);

        }

    }
}
