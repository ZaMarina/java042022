package ru.gb.zagrebina.Homework6;

import java.util.Random;

public class Task6 {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Борис"),
                new Dog("Полкан"),
                new Cat("Юрик"),
                new Dog("Семен"),
                new Cat("Тася")
        };
        for (Animal animal : animals) {
            animal.run(new Random().nextInt(300));
            animal.swim(new Random().nextInt(20));


        }

        System.out.println("У нас записано: " + Dog.getCount() + " собак и " + Cat.getCount() + " кошек.");
        System.out.println("Всего животных - " + Animal.getCount());
    }
}





