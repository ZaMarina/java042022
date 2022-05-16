package ru.gb.zagrebina.Homework7;

public class Cat {
    private String name;
       private int appetite;//(сколько единиц еды он потребляет за приём пищи
    private boolean satiety;//сытость

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eat(Plate p){//в скобках (тип_переменная)
p.decreaseFood(appetite);

    }

    public int getAppetite() {
        return appetite;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}
